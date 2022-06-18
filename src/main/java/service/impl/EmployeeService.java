package service.impl;

import model.Employee;
import repository.IFindAllRepository;
import repository.impl.EmployeeRepository;
import service.IFindAllService;

import java.util.List;

public class EmployeeService implements IFindAllService<Employee> {
    private final IFindAllRepository<Employee> iFindAllRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return iFindAllRepository.findAll();
    }
}
