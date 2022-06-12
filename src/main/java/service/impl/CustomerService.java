package service.impl;

import dto.CustomerListDto;
import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<CustomerListDto> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public int create(Customer customer) {
        return customerRepository.create(customer);
    }
}
