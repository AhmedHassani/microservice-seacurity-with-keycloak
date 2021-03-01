package com.iraqsofit.speedoo.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMassage> handelApiException(NotFoundException notFoundException, WebRequest webRequest){
        ErrorMassage errorMassage =new ErrorMassage(notFoundException.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorMassage,notFoundException.getHttpStatus());
    }


}
