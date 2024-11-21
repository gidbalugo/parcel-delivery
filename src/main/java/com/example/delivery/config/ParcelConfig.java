package com.example.delivery.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
@Getter
public class ParcelConfig {


    @Value("${parcel.max.weight.limit}")
    private Double maxWeightLimit;

    @Value("${parcel.weight.heavy.limit}")
    private Double weightLimitForHeavyParcel;

    @Value("${parcel.volume.small.limit}")
    private Double volumeLimitForSmallParcel;

    @Value("${parcel.volume.medium.limit}")
    private Double volumeLimitForMediumParcel;

    @Value("${parcel.rate.heavy}")
    private Double heavyParcelRate;

    @Value("${parcel.rate.small}")
    private Double smallParcelRate;

    @Value("${parcel.rate.medium}")
    private Double mediumParcelRate;

    @Value("${parcel.rate.large}")
    private Double largeParcelRate;

}
