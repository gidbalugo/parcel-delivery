package com.example.delivery.model;

public class MediumParcel extends Parcel {
    public MediumParcel(Double weight, Double height, Double width, Double length) {
        super(weight, height, width, length);
    }

    @Override
    public Double calculateCost() {
        return null;
    }
}
