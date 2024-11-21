package com.example.delivery.service;

import com.example.delivery.config.VoucherConfig;
import com.example.delivery.model.Voucher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class VoucherService {

    private final VoucherConfig voucherConfig;

    public Voucher fetchVoucher(String code) {

        RestTemplate restTemplate = new RestTemplate();

        String fullEndpoint = voucherConfig.getHost()+voucherConfig.getEndpoint()+"/"+code+"?key="+voucherConfig.getApiKey();
        Voucher voucher = restTemplate.getForObject(fullEndpoint, Voucher.class);

        return voucher;
    }
}
