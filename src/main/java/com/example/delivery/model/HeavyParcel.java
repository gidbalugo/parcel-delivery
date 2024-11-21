package com.example.delivery.model;


public class HeavyParcel extends Parcel {

//    private Double ratePerWeight;

    public HeavyParcel(Double weight, Double height, Double width, Double length) {
        super(weight, height, width, length);
    }

    @Override
    public Double calculateCost() {
        return  1* getWeight();
    }
}