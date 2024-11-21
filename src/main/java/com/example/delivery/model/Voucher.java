package com.example.delivery.model;

import lombok.Getter;

@Getter
public class Voucher {
    private String code;
    private Double discount;
    private String expiry;

    public Voucher(String code, Double discount, String expiry) {
        this.code = code;
        this.discount = discount;
        this.expiry = expiry;
    }
}
