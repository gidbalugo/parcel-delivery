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

    private final VoucherService voucherService;

    public Double calculateDeliveryCost(ParcelSpecificationDto dto) throws ParcelExceedsWeightLimitException {
        Parcel parcel = new Parcel(dto.getWeight(),
                dto.getHeight(),
                dto.getWidth(),
                dto.getLength(),
                dto.getVoucher());

        Double deliveryCost = determineCostByType(parcel);
        if (parcel.getVoucher() == null ||parcel.getVoucher().isBlank()) {
            return deliveryCost;
        }

        return applyDiscount(deliveryCost, dto.getVoucher());
    }

    private Double determineCostByType(Parcel parcel) throws ParcelExceedsWeightLimitException {
        if (parcel.getWeight() > parcelConfig.getMaxWeightLimit()) throw new ParcelExceedsWeightLimitException("Parcel is over max weight limit.");
        if (parcel.getWeight() > parcelConfig.getWeightLimitForHeavyParcel()) return heavyParcelService.calculateCost(parcel);

        Double volume = parcel.getVolume();
        if (volume < parcelConfig.getVolumeLimitForSmallParcel()) return smallParcelService.calculateCost(parcel);
        if (volume < parcelConfig.getVolumeLimitForMediumParcel()) return mediumParcelService.calculateCost(parcel);

        return largeParcelService.calculateCost(parcel);
    }

    private Double applyDiscount(Double originalCost, String voucherCode) {
        Voucher voucher = voucherService.fetchVoucher(voucherCode);

        if (voucher.getDiscount() >= originalCost) return Double.valueOf(0);

        return originalCost - voucher.getDiscount();
    }
}
