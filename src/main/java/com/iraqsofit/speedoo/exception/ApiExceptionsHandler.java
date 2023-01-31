package com.iraqsofit.speedoo.exception;


import com.iraqsofit.speedoo.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<Response> handelApiException(ApiBaseException exception, WebRequest webRequest) {
        //(boolean success, List<T> body, String message, int code)
        List<String> empty = new ArrayList<>();
        Response errorMassage = new Response(false,empty,exception.getMessage(),exception.getStatusCode().value());
        return new ResponseEntity<>(errorMassage, exception.getStatusCode());
    }


}
