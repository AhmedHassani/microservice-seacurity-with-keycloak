package com.iraqsofit.speedoo.models;

public class ForgetPassword {
    private String username;
    private String otp;
    private String password;

    public ForgetPassword(String username, String otp, String password) {
        this.username = username;
        this.otp = otp;
        this.password = password;
    }

    public ForgetPassword() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
