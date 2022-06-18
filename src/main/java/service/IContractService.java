package service;

import dto.ServiceIdCodeDto;
import model.Contract;

import java.util.List;

public interface IContractService {
    List<Integer> findAllEmployeeId();

    List<Integer> findAllCustomerId();

    List<ServiceIdCodeDto> findAllServiceIdCode();

    int create(Contract contract);
}
