
package com.jsousa.lda.yahoofinance.histquotes2;

/**
 *
 * @author Stijn Strickx
 */
public enum QueryInterval {
    
    DAILY("1d"),
    WEEKLY("5d"),
    PROPER_WEEK("7d"),
    MONTHLY("1mo");
    
    private final String tag;
    
    QueryInterval(String tag) {
        this.tag = tag;
    }
    
    public String getTag() {
        return this.tag;
    }
    
}
