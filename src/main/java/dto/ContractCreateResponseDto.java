package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ContractCreateResponseDto {
    private List<Integer> employeeIdList;
    private List<Integer> customerIdList;
    private List<ServiceIdCodeDto> serviceIdCodeDtoList;
}
