package ru.liga.dao.truck.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.domain.Truck;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TruckRowMapper implements RowMapper<Truck> {
    @Override
    public Truck mapRow(ResultSet resultSet, int i) throws SQLException {
        String vin = resultSet.getString("vin");
        Integer milage = resultSet.getInt("milage");
        String location = resultSet.getString("location");
        Integer price = resultSet.getInt("price");
        Integer maxWeight = resultSet.getInt("maxWeight");
        return new Truck(vin, milage, location, price, maxWeight);
    }
}
