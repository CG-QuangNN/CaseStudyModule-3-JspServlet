package repository.impl;

import model.Contract;
import repository.IContractRepository;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private static final String SELECT_ALL = "select contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id from contract;";
    private static final String INSERT = "INSERT INTO contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id) VALUES (?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                contractList.add(Contract.builder()
                        .contractId(rs.getInt("contract_id"))
                        .contractStartDate(rs.getTimestamp("contract_start_date").toLocalDateTime())
                        .contractEndDate(rs.getTimestamp("contract_end_date").toLocalDateTime())
                        .contractDeposit(rs.getDouble("contract_deposit"))
                        .contractTotalMoney(rs.getDouble("contract_total_money"))
                        .employeeId(rs.getInt("employee_id"))
                        .customerId(rs.getInt("customer_id"))
                        .serviceId(rs.getInt("service_id"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public int create(Contract contract) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(contract.getContractStartDate()));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(contract.getContractEndDate()));
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4, contract.getContractTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
