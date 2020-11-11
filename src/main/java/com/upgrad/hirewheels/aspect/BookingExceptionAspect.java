package com.upgrad.hirewheels.aspect;

import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BookingExceptionAspect {
    @ExceptionHandler(BookingDetailsNotFoundException.class)
    public ResponseEntity<CustomResponse> handleBookingDetailsNotFoundException(Exception e){
        CustomResponse response = new CustomResponse(LocalDateTime.MAX,e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
