package ru.liga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.domain.Suv;
import ru.liga.domain.Truck;
import ru.liga.service.SuvService;
import ru.liga.service.TruckService;

import java.util.List;

@RestController
public class IntegrationController {

    @Autowired
    private SuvService suvService;

    @Autowired
    private TruckService truckService;

    @GetMapping("/suv/{vin}")
    Suv getSuvByVin(@PathVariable("vin") String vin){
        return suvService.getSuvByVin(vin);
    }

    @GetMapping("/suv/")
    List<Suv> getSuvAll(){
        return suvService.getAll();
    }

    @GetMapping("/truck/{vin}")
    Truck getTruckByVin(@PathVariable("vin") String vin){
        return truckService.getTruckByVin(vin);
    }

    @GetMapping("/truck/")
    List<Truck> getTruckAll(){
        return truckService.getAll();
    }
}
