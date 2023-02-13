package com.iraqsofit.speedoo.models;

public class OTP {
    private  int otp = 123456;
    private  String  username;

    public OTP(int otp, String username) {
        this.otp = otp;
        this.username = username;
    }

    public OTP() {
    }

    public int getCode() {
        return otp;
    }

    public void setCode(int code) {
        this.otp = code;
    }

    public String getUserID() {
        return username;
    }
    public void setUserID(String username) {
        this.username = username;
    }

}
