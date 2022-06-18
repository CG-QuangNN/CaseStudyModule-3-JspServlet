package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ContractDetailCreateResponseDto {
    private List<Integer> contractIdList;
    private List<Integer> attachServiceIdList;
}
