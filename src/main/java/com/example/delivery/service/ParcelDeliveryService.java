package com.example.delivery.service;

import com.example.delivery.config.ParcelConfig;
import com.example.delivery.dto.ParcelSpecificationDto;
import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import com.example.delivery.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelDeliveryService {

    private final ParcelConfig parcelConfig;
    private final HeavyParcelService heavyParcelService;
    private final LargeParcelService largeParcelService;
    private final SmallParcelService smallParcelService;
    private final MediumParcelService mediumParcelService;

    public Double calculateDeliveryCost(ParcelSpecificationDto dto) throws ParcelExceedsWeightLimitException {
        Parcel parcel = new Parcel(dto.getWeight(),
                dto.getHeight(),
                dto.getWidth(),
                dto.getLength());
        return calculateDeliveryCost(parcel);
    }

    public Double calculateDeliveryCost(Parcel parcel) throws ParcelExceedsWeightLimitException {
        if (parcel.getWeight() > parcelConfig.getMaxWeightLimit()) throw new ParcelExceedsWeightLimitException("Parcel is over max weight limit.");
        if (parcel.getWeight() > parcelConfig.getWeightLimitForHeavyParcel()) return heavyParcelService.calculateCost(parcel);

        Double volume = parcel.getVolume();
        if (volume < parcelConfig.getVolumeLimitForSmallParcel()) return smallParcelService.calculateCost(parcel);
        if (volume < parcelConfig.getVolumeLimitForMediumParcel()) return mediumParcelService.calculateCost(parcel);

        return largeParcelService.calculateCost(parcel);
    }
}
