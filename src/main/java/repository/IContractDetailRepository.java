package repository;

import model.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    int create(ContractDetail contractDetail);

    List<ContractDetail> findAll();
}
