package service.impl;

import model.AttachService;
import repository.IFindAllRepository;
import repository.impl.AttachServiceRepository;
import service.IFindAllService;

import java.util.List;

public class AttachServiceService implements IFindAllService<AttachService> {
    private final IFindAllRepository<AttachService> contractDetailRepository = new AttachServiceRepository();

    @Override
    public List<AttachService> findAll() {
        return contractDetailRepository.findAll();
    }
}
