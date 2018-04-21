package ru.liga.dao.suv.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.domain.Suv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuvRowMapper implements RowMapper<Suv> {
    @Override
    public Suv mapRow(ResultSet resultSet, int i) throws SQLException {

        String vin = resultSet.getString("vin");
        Integer milage = resultSet.getInt("milage");
        String location = resultSet.getString("location");
        Integer price = resultSet.getInt("price");
        return new Suv(vin, milage, location, price);
    }
}
