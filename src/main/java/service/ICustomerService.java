package service;

import dto.CustomerListDto;
import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    List<CustomerListDto> findAllListDto();

    int create(Customer customer);
}
