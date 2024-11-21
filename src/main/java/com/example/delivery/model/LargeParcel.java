package com.example.delivery.model;

public class LargeParcel extends Parcel {
    public LargeParcel(Double weight, Double height, Double width, Double length) {
        super(weight, height, width, length);
    }

    @Override
    public Double calculateCost() {
        return 1 * getVolume();
    }
}
