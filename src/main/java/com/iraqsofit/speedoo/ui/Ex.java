package com.iraqsofit.speedoo.ui;

public class Ex {
    private String massage;

    public Ex(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        if (massage.contains("JDBCConnectionException")) {
            return "Failed to connect to the database Check the connection settings";
        }else {
            return massage;
        }
    }
}
