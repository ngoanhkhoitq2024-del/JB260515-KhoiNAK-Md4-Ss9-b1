package re.edu.pharmacyservice.controller;

import re.edu.pharmacyservice.dto.BillRequest;
import re.edu.pharmacyservice.dto.BillResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/api/v1/bill")
@RefreshScope
public class BillController {
    @Value("${pharmacy.vat-rate}")
    private BigDecimal vatRate;

    @PostMapping
    public BillResponse calculateBill(@RequestBody BillRequest request) {
        BigDecimal totalMedicineAmount = request.getTotalMedicineAmount();

        BigDecimal vatAmount = totalMedicineAmount
                .multiply(vatRate)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal finalAmount = totalMedicineAmount.add(vatAmount);

        return new BillResponse(
                totalMedicineAmount,
                vatRate,
                vatAmount,
                finalAmount
        );
    }
}