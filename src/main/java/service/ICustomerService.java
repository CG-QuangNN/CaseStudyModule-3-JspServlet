package service;

import dto.CustomerListDto;
import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerListDto> findAll();

    int create(Customer customer);
}
