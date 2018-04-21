package ru.liga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import ru.liga.dao.suv.dao.SuvDao;
import ru.liga.domain.Suv;

import java.util.List;

@Component
public class SuvService {

    @Autowired
    private SuvDao suvDao;

    public Suv getSuvByVin(String vin) {
        return suvDao.getSuvByVin(vin);
    }

    public Suv save(Suv suv) {
        try {
            Suv suvSaved = suvDao.getSuvByVin(suv.getVin());
            suvDao.update(suv);
        } catch (EmptyResultDataAccessException e) {
            suvDao.insert(suv);
        }
        return suv;
    }

    public List<Suv> getAll() {
        return suvDao.getAll();
    }
}
