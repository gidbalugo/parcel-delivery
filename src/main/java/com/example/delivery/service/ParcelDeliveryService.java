package com.example.delivery.service;

import com.example.delivery.dto.ParcelSpecificationDto;
import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import com.example.delivery.model.Parcel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelDeliveryService {

    private final ParcelTypeService parcelTypeService;
    public Double calculateDeliveryCost(ParcelSpecificationDto dto) throws ParcelExceedsWeightLimitException {
        Parcel parcel = parcelTypeService.determineParcelType(dto);
        return parcel.calculateCost();
    }

}
