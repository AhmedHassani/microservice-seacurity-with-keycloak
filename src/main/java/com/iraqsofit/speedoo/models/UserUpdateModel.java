package com.iraqsofit.speedoo.models;

public class UserUpdateModel {
    private String username;
    private String name;
    private String address;

    public UserUpdateModel(String username, String name, String address) {
        this.username = username;
        this.name = name;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
