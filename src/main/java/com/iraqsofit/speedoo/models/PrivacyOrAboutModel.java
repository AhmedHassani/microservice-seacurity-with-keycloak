package com.iraqsofit.speedoo.models;

public class PrivacyOrAboutModel {
    private  String lastUpdate;
    private  String text;

    public PrivacyOrAboutModel(String lastUpdate, String text) {
        this.lastUpdate = lastUpdate;
        this.text = text;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
