package com.iraqsofit.speedoo.exception;

import java.util.Date;

public class ErrorMassage {
    private String massage;
    private String uri;
    private Date date;

    public ErrorMassage() {
        this.date=new Date();
    }

    public ErrorMassage(String massage, String uri) {
        this();
        this.massage = massage;
        this.uri = uri;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
