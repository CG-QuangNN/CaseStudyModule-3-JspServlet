package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CustomerListDto {
    private String customerCode;
    private String customerTypeName;
    private String customerName;
    private LocalDate customerBirthday;
    private boolean customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
}
