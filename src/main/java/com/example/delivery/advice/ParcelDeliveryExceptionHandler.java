package com.example.delivery.advice;

import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ParcelDeliveryExceptionHandler {

    @ExceptionHandler(value = ParcelExceedsWeightLimitException.class)
    public ResponseEntity<ErrorResponse> handleParcelExceedsWeightLimitException(ParcelExceedsWeightLimitException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}

