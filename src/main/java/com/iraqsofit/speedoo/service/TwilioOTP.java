package com.iraqsofit.speedoo.service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@RestController
public class TwilioOTP {

    public  final String ACCOUNT_SID = "AC80558c35951bdce79b5b497eec148c6f";
    public  final String AUTH_TOKEN = "d3f39783c12baa82df39d081c61825e9";


    public String sms(String username){
        int otp = (int)(Math.random() * 900000) + 100000;
        String otpDb = otp + "," + System.currentTimeMillis();
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+9647831403506"),
                new com.twilio.type.PhoneNumber("+15673131803"),
                "Your OTP code is  : "+otp)
                .create();
        return otpDb;
    }
}
