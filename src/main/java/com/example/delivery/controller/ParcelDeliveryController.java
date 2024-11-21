package com.example.delivery.controller;

import com.example.delivery.dto.ParcelDeliveryCostDto;
import com.example.delivery.dto.ParcelSpecificationDto;
import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import com.example.delivery.service.ParcelDeliveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/delivery")
public class ParcelDeliveryController {

    private final ParcelDeliveryService parcelDeliveryService;

    @PostMapping("/calculate")
    public ResponseEntity<ParcelDeliveryCostDto> calculate(@Valid @RequestBody ParcelSpecificationDto parcelSpecificationDto) throws ParcelExceedsWeightLimitException {
        Double deliveryCost = parcelDeliveryService.calculateDeliveryCost(parcelSpecificationDto);

        return ResponseEntity.ok(convert(deliveryCost, parcelSpecificationDto));
    }

    private ParcelDeliveryCostDto convert(Double deliveryCost, ParcelSpecificationDto parcelSpecificationDto) {
        String voucher = parcelSpecificationDto.getVoucher();
        boolean isDiscounted = voucher != null && !voucher.isBlank();
        return new ParcelDeliveryCostDto(deliveryCost, isDiscounted);
    }

}
