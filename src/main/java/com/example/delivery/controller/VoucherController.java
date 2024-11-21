package com.example.delivery.controller;

import com.example.delivery.model.Voucher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {

    @GetMapping("/voucher/{voucherCode}")
    public ResponseEntity<Voucher> mockVoucher(@RequestParam String key, @PathVariable("voucherCode") String voucherCode) {
        Voucher voucher = new Voucher(voucherCode, 100.00, "2024-11-21");
        return ResponseEntity.ok(voucher);
    }
}
