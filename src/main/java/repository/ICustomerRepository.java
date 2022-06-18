package repository;

import dto.CustomerListDto;
import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    List<CustomerListDto> findAllListDto();


    int create(Customer customer);
}
