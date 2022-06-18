package service.impl;

import dto.ServiceIdCodeDto;
import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;
import service.ICustomerService;
import service.IFindAllService;

import java.util.List;
import java.util.stream.Collectors;

public class ContractService implements IContractService {
    private final IContractRepository iContractRepository = new ContractRepository();
    private final IFindAllService<Employee> employeeService = new EmployeeService();
    private final ICustomerService customerService = new CustomerService();
    private final IFindAllService<Service> serviceService = new ServiceService();

    @Override
    public List<Integer> findAllEmployeeId() {
        return employeeService.findAll().stream().map(Employee::getEmployeeId).collect(Collectors.toList());
    }

    @Override
    public List<Integer> findAllCustomerId() {
        return customerService.findAll().stream().map(Customer::getCustomerId).collect(Collectors.toList());
    }

    @Override
    public List<ServiceIdCodeDto> findAllServiceIdCode() {
        return serviceService.findAll().stream().map(Service::mapToServiceIdCodeDto).collect(Collectors.toList());
    }

    @Override
    public int create(Contract contract) {
        return iContractRepository.create(contract);
    }
}
