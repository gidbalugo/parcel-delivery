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

    /**
     * This fetching of voucher will fetch the voucher from the same host of this project.
     * It will always apply the hardcoded discount of 100 to the original delivery cost of voucher.
     * This is the workaround I can think of due to provided endpoint(https://mynt-exam.mocklab.io/voucher/) only returns 504
     */
    public Voucher fetchVoucher(String code) {

        RestTemplate restTemplate = new RestTemplate();

        String fullEndpoint = voucherConfig.getHost()+voucherConfig.getEndpoint()+"/"+code+"?key="+voucherConfig.getApiKey();
        Voucher voucher = restTemplate.getForObject(fullEndpoint, Voucher.class);

        return voucher;
    }
}
