package repository.impl;

import model.ContractDetail;
import repository.IContractDetailRepository;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    private static final String SELECT_ALL = "select contract_detail_id, contract_id, attach_service_id, quantity from contract_detail;";
    private static final String INSERT = "INSERT INTO contract_detail (contract_id, attach_service_id, quantity) VALUES (?, ?, ?);";

    @Override
    public int create(ContractDetail contractDetail) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, contractDetail.getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachServiceId());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                contractDetailList.add(ContractDetail.builder()
                        .contractDetailId(rs.getInt("contract_detail_id"))
                        .contractId(rs.getInt("contract_id"))
                        .attachServiceId(rs.getInt("attach_service_id"))
                        .quantity(rs.getInt("quantity"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailList;
    }
}
