package service;

import model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    List<Integer> findAllContractIdList();

    List<Integer> findAllAttachServiceIdList();

    int create(ContractDetail contractDetail);
}
