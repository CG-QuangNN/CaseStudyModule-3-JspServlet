package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ContractDetail {
    private int contractDetailId;
    private Integer contractId;
    private Integer attachServiceId;
    private Integer quantity;
}
