package com.example.delivery.service;

import com.example.delivery.config.ParcelConfig;
import com.example.delivery.model.Parcel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediumParcelService {
    private final ParcelConfig parcelConfig;

    public Double calculateCost(Parcel parcel) {
        return  parcelConfig.getMediumParcelRate() * parcel.getVolume();
    }
}
