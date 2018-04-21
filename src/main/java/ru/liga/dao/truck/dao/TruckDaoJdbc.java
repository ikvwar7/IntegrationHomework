package ru.liga.dao.truck.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.liga.domain.Truck;

import java.util.List;

@Component
public class TruckDaoJdbc implements TruckDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Truck getTruckByVin(String vin) {
        return jdbcTemplate.queryForObject("SELECT * FROM Truck Where vin=?", new TruckRowMapper(), vin);
    }

    @Override
    public List<Truck> getAll() {
        return jdbcTemplate.query("SELECT * FROM Truck", new TruckRowMapper());
    }

    @Override
    public Truck insert(Truck truck) {
        jdbcTemplate.update("Insert into Truck (vin,milage,location,price,maxWeight) VALUES (?,?,?,?,?)",
                truck.getVin(), truck.getMilage(), truck.getLocation(), truck.getPrice(), truck.getMaxWeight());
        return truck;
    }

    @Override
    public Truck update(Truck truck) {
        jdbcTemplate.update("UPDATE Truck SET milage = ?, location=?,price=?,maxWeight=?, WHERE vin = ?",
                truck.getMilage(), truck.getLocation(), truck.getPrice(), truck.getMaxWeight(), truck.getVin());
        return truck;
    }
}
