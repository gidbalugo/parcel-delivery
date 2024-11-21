package com.example.delivery.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
@Getter
public class VoucherConfig {

    @Value("${voucher.host.uri}")
    private String host;

    @Value("${voucher.endpoint}")
    private String endpoint;

    @Value("${voucher.api.key}")
    private String apiKey;
}
