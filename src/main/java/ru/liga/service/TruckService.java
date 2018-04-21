package ru.liga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import ru.liga.dao.truck.dao.TruckDao;
import ru.liga.domain.Truck;

import java.util.List;

@Component
public class TruckService {

    @Autowired
    private TruckDao truckDao;

    public Truck getTruckByVin(String vin) {
        return truckDao.getTruckByVin(vin);
    }

    public Truck save(Truck truck) {
        try {
            Truck suvSaved = truckDao.getTruckByVin(truck.getVin());
            truckDao.update(truck);
        } catch (EmptyResultDataAccessException e) {
            truckDao.insert(truck);
        }
        return truck;
    }

    public List<Truck> getAll() {
        return truckDao.getAll();
    }
}
