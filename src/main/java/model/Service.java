package model;

import dto.ServiceIdCodeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Service {
    private int serviceId;
    private String serviceCode;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    private String freeServiceIncluded;

    public ServiceIdCodeDto mapToServiceIdCodeDto() {
        return ServiceIdCodeDto.builder()
                .serviceId(this.getServiceId())
                .serviceCode(this.getServiceCode())
                .build();
    }
}
