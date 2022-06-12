package repository.impl;

import model.CustomerType;
import repository.IFindAllRepository;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements IFindAllRepository<CustomerType> {
    private static final String SELECT_ALL = "select customer_type_id, customer_type_name from customer_type;";

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customerTypeList.add(CustomerType.builder()
                        .customerTypeId(rs.getInt("customer_type_id"))
                        .customerTypeName(rs.getString("customer_type_name"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }
}
