package repository.impl;

import model.Service;
import repository.IFindAllRepository;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IFindAllRepository<Service> {
    private static final String SELECT_ALL = "select service_id, service_code, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, free_service_included from service";

    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                serviceList.add(Service.builder()
                        .serviceId(rs.getInt("service_id"))
                        .serviceCode(rs.getString("service_code"))
                        .serviceName(rs.getString("service_name"))
                        .serviceArea(rs.getInt("service_area"))
                        .serviceCost(rs.getDouble("service_cost"))
                        .serviceMaxPeople(rs.getInt("service_max_people"))
                        .rentTypeId(rs.getInt("rent_type_id"))
                        .serviceTypeId(rs.getInt("service_type_id"))
                        .standardRoom(rs.getString("standard_room"))
                        .descriptionOtherConvenience(rs.getString("description_other_convenience"))
                        .poolArea(rs.getDouble("pool_area"))
                        .numberOfFloors(rs.getInt("number_of_floors"))
                        .freeServiceIncluded(rs.getString("free_service_included"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }
}
