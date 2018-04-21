package ru.liga.dao.truck.dao;

import ru.liga.domain.Truck;

import java.util.List;

public interface TruckDao {
    Truck getTruckByVin(String vin);

    List<Truck> getAll();

    Truck insert(Truck truck);

    Truck update(Truck truck);
}
