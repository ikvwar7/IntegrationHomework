package ru.liga.dao.suv.dao;

import ru.liga.domain.Suv;

import java.util.List;

public interface SuvDao {
    Suv getSuvByVin(String vin);

    List<Suv> getAll();

    Suv insert(Suv suv);

    Suv update(Suv suv);
}
