package com.example.delivery.exception;

public class ParcelExceedsWeightLimitException extends Throwable {
    public ParcelExceedsWeightLimitException(String s) {
        super(s);
    }
}
