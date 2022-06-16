package com.jsousa.lda.mail;

import com.jsousa.lda.stock.StockProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {

    private static final Logger log = LoggerFactory.getLogger(MailSender.class);

    final String username = "jlgsousa@hotmail.com";
    final String password = "Guilmon22Hotmail";

    public void send(String report) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(StockProperties.getWatcherEmails())
            );

            LocalDateTime ldt = LocalDateTime.now().minusDays(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String subject = "Bot Trader Report " + formatter.format(ldt);
            message.setSubject(subject);

            report += "\n\nYours sincerely,\nThe Turtle Bot Trader";
            message.setText(report);

            log.info("Sending report to emails: {}", StockProperties.getWatcherEmails());
            //Transport.send(message);
            System.out.println(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}