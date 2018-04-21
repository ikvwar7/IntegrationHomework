package ru.liga.dao.suv.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.liga.domain.Suv;

import java.util.List;

@Component
public class SuvDaoJdbc implements SuvDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Suv getSuvByVin(String vin) {
        return jdbcTemplate.queryForObject("SELECT * FROM Suv Where vin=?", new SuvRowMapper(), vin);
    }

    @Override
    public List<Suv> getAll() {
        return jdbcTemplate.query("SELECT * FROM Suv", new SuvRowMapper());
    }

    @Override
    public Suv insert(Suv suv) {
        jdbcTemplate.update("Insert into Suv (vin,milage,location,price) VALUES (?,?,?,?)",
                suv.getVin(), suv.getMilage(), suv.getLocation(), suv.getPrice());
        return suv;
    }

    @Override
    public Suv update(Suv suv) {
        jdbcTemplate.update("UPDATE Suv SET milage = ?, location=?,price=? WHERE vin = ?",
                suv.getMilage(), suv.getLocation(), suv.getPrice(), suv.getVin());
        return suv;
    }

}
