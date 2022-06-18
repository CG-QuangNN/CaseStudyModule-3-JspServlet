package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Contract {
    private int contractId;
    private LocalDateTime contractStartDate;
    private LocalDateTime contractEndDate;
    private Double contractDeposit;
    private Double contractTotalMoney;
    private Integer employeeId;
    private Integer customerId;
    private Integer serviceId;
}
