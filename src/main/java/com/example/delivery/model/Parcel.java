package com.example.delivery.model;

import lombok.Getter;

@Getter
public class Parcel {

    private final Double weight;
    private final Double height;
    private final Double width;
    private final Double length;

    private final String voucher;
    private final Double volume;

    public Parcel(Double weight, Double height, Double width, Double length, String voucher) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.voucher = voucher;
        this.volume = height * width * length;
    }
}
