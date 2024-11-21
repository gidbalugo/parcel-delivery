package com.example.delivery.controller;

import com.example.delivery.dto.ParcelSpecificationDto;
import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import com.example.delivery.service.ParcelDeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/delivery")
public class ParcelDeliveryController {

    private final ParcelDeliveryService parcelDeliveryService;

    @PostMapping("/calculate")
    public ResponseEntity<Double > calculate(@Valid  @RequestBody ParcelSpecificationDto parcelSpecificationDto) throws ParcelExceedsWeightLimitException {
        Double deliveryCost = parcelDeliveryService.calculateDeliveryCost(parcelSpecificationDto);

        System.out.println("THIS IS THE COST");
        System.out.println(deliveryCost);
        System.out.println("THIS IS THE COST");
        return ResponseEntity.ok(deliveryCost);
    }

}
