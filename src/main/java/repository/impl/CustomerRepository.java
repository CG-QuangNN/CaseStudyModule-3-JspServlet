package repository.impl;

import dto.CustomerListDto;
import model.Customer;
import repository.ICustomerRepository;
import repository.IFindAllRepository;
import util.MySQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL = "select c.customer_code, ct.customer_type_name, c.customer_name, c.customer_birthday, c.customer_gender, c.customer_id_card, c.customer_phone, c.customer_email, c.customer_address from customer c inner join customer_type ct on c.customer_type_id = ct.customer_type_id;";
    private static final String INSERT = "INSERT INTO customer (customer_code, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<CustomerListDto> findAll() {
        List<CustomerListDto> CustomerListDtoList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CustomerListDtoList.add(CustomerListDto.builder()
                        .customerCode(rs.getString("customer_code"))
                        .customerTypeName(rs.getString("customer_type_name"))
                        .customerName(rs.getString("customer_name"))
                        .customerBirthday(rs.getDate("customer_birthday").toLocalDate())
                        .customerGender(rs.getBoolean("customer_gender"))
                        .customerIdCard(rs.getString("customer_id_card"))
                        .customerPhone(rs.getString("customer_phone"))
                        .customerEmail(rs.getString("customer_email"))
                        .customerAddress(rs.getString("customer_address"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CustomerListDtoList;
    }

    @Override
    public int create(Customer customer) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setInt(2, customer.getCustomerTypeId());
            preparedStatement.setString(3, customer.getCustomerName());
            preparedStatement.setDate(4, Date.valueOf(customer.getCustomerBirthday()));
            preparedStatement.setBoolean(5, customer.isCustomerGender());
            preparedStatement.setString(6, customer.getCustomerIdCard());
            preparedStatement.setString(7, customer.getCustomerPhone());
            preparedStatement.setString(8, customer.getCustomerEmail());
            preparedStatement.setString(9, customer.getCustomerAddress());
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
