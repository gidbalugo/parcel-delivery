package com.example.delivery.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class ParcelSpecificationDto {

    @Min(value = 1, message = "Weight should be greater than 0")
    private Double weight;
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double height;
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double width;
    @Min(value = 1, message = "Weight should be greater than 0")
    private Double length;
}
