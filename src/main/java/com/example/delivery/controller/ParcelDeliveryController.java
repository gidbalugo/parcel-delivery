package com.example.delivery.controller;

import com.example.delivery.dto.ParcelDeliveryCostDto;
import com.example.delivery.dto.ParcelSpecificationDto;
import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import com.example.delivery.model.Voucher;
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

    @GetMapping("/voucher/{voucherCode}")
    public ResponseEntity<Voucher> mockVoucher(@RequestParam String key, @PathVariable("voucherCode") String voucherCode) {
        Voucher voucher = new Voucher(voucherCode, 100.00, "2024-11-21");
        return ResponseEntity.ok(voucher);
    }

    private ParcelDeliveryCostDto convert(Double deliveryCost, ParcelSpecificationDto parcelSpecificationDto) {
        String voucher = parcelSpecificationDto.getVoucher();
        boolean isDiscounted = (voucher == null || voucher.isBlank()) ? false: true;
        return new ParcelDeliveryCostDto(deliveryCost, isDiscounted);
    }

}
