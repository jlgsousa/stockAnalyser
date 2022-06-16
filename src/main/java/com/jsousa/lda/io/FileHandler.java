package com.jsousa.lda.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    private static final Logger log = LoggerFactory.getLogger(FileHandler.class);
    private static final String BASE_DIRECTORY = System.getProperty("user.dir");
    private static final String FOLDER = "stockAnalysis";


    public static String readFile(String fileName) {
        Path path = Paths.get(BASE_DIRECTORY, FOLDER, fileName);

        String content = "";
        try {
            content = Files.readString(path);
            log.debug("Successfully read file {}", path.toAbsolutePath());
        } catch (IOException e) {
            log.error("Problem while reading file {}", path.toAbsolutePath());
        }
        return content;
    }

    public static void writeFile(String fileName, String content) {
        Path path = Paths.get(BASE_DIRECTORY, FOLDER, fileName);

        try {
            if (!path.toFile().exists()) {
                log.info("Creating file {}", fileName);
                path.toFile().createNewFile();
            }
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            log.error("Problem while writing in file {}", path.toAbsolutePath());
        }

    }
}