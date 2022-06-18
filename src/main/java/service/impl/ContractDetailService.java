package service.impl;

import model.AttachService;
import model.Contract;
import model.ContractDetail;
import repository.IContractDetailRepository;
import repository.IContractRepository;
import repository.impl.ContractDetailRepository;
import repository.impl.ContractRepository;
import service.IContractDetailService;
import service.IFindAllService;

import java.util.List;
import java.util.stream.Collectors;

public class ContractDetailService implements IContractDetailService {
    private final IContractDetailRepository iContractDetailRepository = new ContractDetailRepository();
    private final IContractRepository iContractRepository = new ContractRepository();
    private final IFindAllService<AttachService> attachServiceService = new AttachServiceService();

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public List<Integer> findAllContractIdList() {
        return iContractRepository.findAll().stream().map(Contract::getContractId).collect(Collectors.toList());
    }

    @Override
    public List<Integer> findAllAttachServiceIdList() {
        return attachServiceService.findAll().stream().map(AttachService::getAttachServiceId).collect(Collectors.toList());
    }

    @Override
    public int create(ContractDetail contractDetail) {
        return iContractDetailRepository.create(contractDetail);
    }
}
