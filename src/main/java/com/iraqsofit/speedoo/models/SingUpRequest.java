package com.iraqsofit.speedoo.models;

public class SingUpRequest {
    private String name;
    private boolean isActive = false;
    private String phoneNumber;
    private String password;
    private String location;
    private String city;
    private String address;

    public SingUpRequest(String name, String phoneNumber, String password, String location, String city, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.location = location;
        this.city = city;
        this.address = address;
    }

    public SingUpRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
