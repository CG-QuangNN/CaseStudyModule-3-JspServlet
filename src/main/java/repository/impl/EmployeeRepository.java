package repository.impl;

import model.Employee;
import repository.IFindAllRepository;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IFindAllRepository<Employee> {
    //private static final String SELECT_ALL = "select service_id, service_code, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, free_service_included from service";
    private static final String SELECT_ALL = "select employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username from employee";
    //private static final String INSERT = "INSERT INTO customer (customer_code, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employeeList.add(Employee.builder()
                        .employeeId(rs.getInt("employee_id"))
                        .employeeName(rs.getString("employee_name"))
                        .employeeBirthday(rs.getDate("employee_birthday").toLocalDate())
                        .employeeIdCard(rs.getString("employee_id_card"))
                        .employeeSalary(rs.getDouble("employee_salary"))
                        .employeePhone(rs.getString("employee_phone"))
                        .employeeEmail(rs.getString("employee_email"))
                        .employeeAddress(rs.getString("employee_address"))
                        .positionId(rs.getInt("position_id"))
                        .educationDegreeId(rs.getInt("education_degree_id"))
                        .divisionId(rs.getInt("division_id"))
                        .username(rs.getString("username"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
