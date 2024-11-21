package com.example.delivery.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ParcelSpecificationDto {

    @NotNull
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double weight;

    @NotNull
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double height;

    @NotNull
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double width;

    @NotNull
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double length;

    private String voucher;
}
