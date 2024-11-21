package com.example.delivery.model;

import com.example.delivery.config.ParcelConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmallParcelService {

    private final ParcelConfig parcelConfig;

    public Double calculateCost(DeliveryParcel parcel) {
        return  parcelConfig.getSmallParcelRate() * parcel.getVolume();
    }
}
