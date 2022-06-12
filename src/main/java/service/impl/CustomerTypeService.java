package service.impl;

import model.CustomerType;
import repository.IFindAllRepository;
import repository.impl.CustomerTypeRepository;
import service.IFindAllService;

import java.util.List;

public class CustomerTypeService implements IFindAllService<CustomerType> {
    private final IFindAllRepository<CustomerType> findAllService = new CustomerTypeRepository();

    @Override
    public List<CustomerType> findAll() {
        return findAllService.findAll();
    }
}
