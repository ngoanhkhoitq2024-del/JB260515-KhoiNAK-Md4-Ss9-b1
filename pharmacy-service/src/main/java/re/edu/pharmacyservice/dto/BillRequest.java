package re.edu.pharmacyservice.dto;

import java.math.BigDecimal;

public class BillRequest {
    private BigDecimal totalMedicineAmount;

    public BigDecimal getTotalMedicineAmount() {
        return totalMedicineAmount;
    }

    public void setTotalMedicineAmount(BigDecimal totalMedicineAmount) {
        this.totalMedicineAmount = totalMedicineAmount;
    }
}
