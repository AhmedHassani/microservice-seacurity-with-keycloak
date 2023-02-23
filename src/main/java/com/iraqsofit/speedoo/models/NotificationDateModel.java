package com.iraqsofit.speedoo.models;

import java.util.List;

public class NotificationDateModel {
    private String date;
    private List<NotificationModel> notificationModel;

    public NotificationDateModel(String date, List<NotificationModel> notificationModel) {
        this.date = date;
        this.notificationModel = notificationModel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<NotificationModel> getNotificationModel() {
        return notificationModel;
    }

    public void setNotificationModel(List<NotificationModel> notificationModel) {
        this.notificationModel = notificationModel;
    }
}
