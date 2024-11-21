package com.example.delivery.dto;

import lombok.Getter;

@Getter
public class ParcelDeliveryCostDto {

    private double deliveryCost;
    private boolean voucherApplied;

    public ParcelDeliveryCostDto(Double deliveryCost, boolean isDiscounted) {
        this.deliveryCost = deliveryCost;
        this.voucherApplied = isDiscounted;
    }
}
