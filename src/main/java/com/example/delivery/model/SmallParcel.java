package com.example.delivery.model;

public class SmallParcel extends Parcel {
    public SmallParcel(Double weight, Double height, Double width, Double length) {
        super(weight, height, width, length);
    }

    @Override
    public Double calculateCost() {
        return getVolume() * 0.03;
    }
}
