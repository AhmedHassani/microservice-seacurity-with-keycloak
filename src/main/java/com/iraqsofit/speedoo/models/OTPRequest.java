package com.iraqsofit.speedoo.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OTPRequest {
    private  int otp;
    private  String username;

    public OTPRequest(int otp, String username) {
        this.otp = otp;
        this.username = username;
    }

    public OTPRequest() {
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
