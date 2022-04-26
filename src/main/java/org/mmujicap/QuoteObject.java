package org.mmujicap;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

class QuoteObject {
    int id;
    String quote;

    public QuoteObject() {
        super();
    }

    public QuoteObject(int i, String s) {
        super();
        this.id = i;
        this.quote = s;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuote() {
        return quote;
    }
    public void setQuote(String quote) {
        this.quote = quote;
    }

}
