package com.example.delivery.model;

import lombok.Getter;

@Getter
public abstract class Parcel {

    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private Double volume;

    Parcel(Double weight, Double height, Double width, Double length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.volume = height * width * length;
    }

    public abstract Double calculateCost();
}
