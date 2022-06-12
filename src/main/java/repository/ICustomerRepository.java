package repository;

import dto.CustomerListDto;
import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<CustomerListDto> findAll();

    int create(Customer customer);
}
