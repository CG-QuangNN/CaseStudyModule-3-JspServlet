package repository.impl;

import model.AttachService;
import repository.IFindAllRepository;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository implements IFindAllRepository<AttachService> {
    private static final String SELECT_ALL = "select attach_service_id, attach_service_name, attach_service_cost, attach_service_unit, attach_service_status from attach_service;";

    @Override
    public List<AttachService> findAll() {
        List<AttachService> contractDetailList = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                contractDetailList.add(AttachService.builder()
                        .attachServiceId(rs.getInt("attach_service_id"))
                        .attachServiceName(rs.getString("attach_service_name"))
                        .attachServiceCost(rs.getDouble("attach_service_cost"))
                        .attachServiceUnit(rs.getInt("attach_service_unit"))
                        .attachServiceStatus(rs.getString("attach_service_status"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailList;
    }
}
