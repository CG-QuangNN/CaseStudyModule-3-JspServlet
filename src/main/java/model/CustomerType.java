package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerType {
    private int customerTypeId;
    private String customerTypeName;
}
