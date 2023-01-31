package com.iraqsofit.speedoo.exception;


import org.springframework.http.HttpStatus;

public class Unauthorized extends ApiBaseException {


    public Unauthorized(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UNAUTHORIZED;
    }
}
