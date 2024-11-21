package com.example.delivery.controller;

import com.example.delivery.model.Voucher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {

    /** Created a mock voucher endpoint since provided test endpoint keeps on returning 504
     * Please note that voucher is hardcoded to always return the same discount
     * and allows any code to successfully simulate application of discount.
     */
    @GetMapping("/voucher/{voucherCode}")
    public ResponseEntity<Voucher> mockVoucher(@RequestParam String key, @PathVariable("voucherCode") String voucherCode) {
        Voucher voucher = new Voucher(voucherCode, 100.00, "2024-11-21");
        return ResponseEntity.ok(voucher);
    }
}
