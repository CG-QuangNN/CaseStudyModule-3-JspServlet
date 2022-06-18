package service.impl;

import model.Service;
import repository.IFindAllRepository;
import repository.impl.ServiceRepository;
import service.IFindAllService;

import java.util.List;

public class ServiceService implements IFindAllService<Service> {
    private final IFindAllRepository<Service> iFindAllRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return iFindAllRepository.findAll();
    }
}
