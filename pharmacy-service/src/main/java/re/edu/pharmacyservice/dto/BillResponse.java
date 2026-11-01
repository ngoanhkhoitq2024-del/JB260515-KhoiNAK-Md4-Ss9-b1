package re.edu.pharmacyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class BillResponse {
    private BigDecimal totalMedicineAmount;
    private BigDecimal vatRate;
    private BigDecimal vatAmount;
    private BigDecimal finalAmount;
}