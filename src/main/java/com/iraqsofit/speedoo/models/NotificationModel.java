package com.iraqsofit.speedoo.models;

import javax.persistence.*;

@Entity
@Table(name = "notification")
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,name = "id")
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private int state;

    @Column(nullable = false)
    private String playerID;


    public NotificationModel() {
    }

    public NotificationModel(String title, String subtitle, String date, int state,String playerID) {
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.state = state;
        this.playerID= playerID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
}
