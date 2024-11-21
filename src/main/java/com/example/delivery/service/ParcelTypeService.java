package com.example.delivery.service;

import com.example.delivery.dto.ParcelSpecificationDto;
import com.example.delivery.exception.ParcelExceedsWeightLimitException;
import com.example.delivery.model.*;
import org.springframework.stereotype.Service;

@Service
public class ParcelTypeService {

    public final static long MAX_WEIGHT_LIMIT = 50;
    public final static long WEIGHT_LIMIT_FOR_HEAVY_PARCEL = 10;
    public final static long VOLUME_LIMIT_FOR_SMALL_PARCEL= 1500;
    public final static long VOLUME_LIMIT_FOR_MEDIUM_PARCEL = 2500;

    public Parcel determineParcelType(ParcelSpecificationDto dto) throws ParcelExceedsWeightLimitException {
        if (dto.getWeight() > MAX_WEIGHT_LIMIT) throw new ParcelExceedsWeightLimitException("Parcel is over max weight limit.");
        if (dto.getWeight() > WEIGHT_LIMIT_FOR_HEAVY_PARCEL) return new HeavyParcel(dto.getWeight(),
                dto.getHeight(),
                dto.getWidth(),
                dto.getLength());

        Double volume = determineVolume(dto.getHeight(), dto.getWidth(), dto.getLength());
        if (volume < VOLUME_LIMIT_FOR_SMALL_PARCEL) return new SmallParcel(dto.getWeight(),
                dto.getHeight(),
                dto.getWidth(),
                dto.getLength());
        if (volume < VOLUME_LIMIT_FOR_MEDIUM_PARCEL) return new MediumParcel(dto.getWeight(),
                dto.getHeight(),
                dto.getWidth(),
                dto.getLength());

        return new LargeParcel(dto.getWeight(), dto.getHeight(), dto.getWidth(), dto.getLength());
    }

    private Double determineVolume(Double height, Double width, Double length) {
        return height * width * length;
    }

}
