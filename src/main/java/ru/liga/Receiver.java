package ru.liga;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.domain.Suv;
import ru.liga.domain.Truck;
import ru.liga.service.SuvService;
import ru.liga.service.TruckService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

@Component
public class Receiver {

    @Autowired
    private SuvService suvService;
    @Autowired
    private TruckService truckService;

    private final String jsonTrucks = "C:\\Users\\123\\Documents\\JavaLige\\day_14\\dz_1\\src\\main\\resources\\trucks";
    private final String jsonSuvs = "C:\\Users\\123\\Documents\\JavaLige\\day_14\\dz_1\\src\\main\\resources\\suvs";
    private ObjectMapper objectMapper = new ObjectMapper();

    public void receiveMessage(String message) {
        messageAnaliz(message);
        System.out.println(LocalDate.now() + " " + message);
    }

    private void messageAnaliz(String message) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Stream<Path> stream1 = null;
        if (message.equals("Suvs done")) {
            try {
                stream1 = Files.walk(Paths.get(jsonSuvs));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stream1.filter(Files::isRegularFile).forEach(path ->
            {
                try {
                    Suv suv = objectMapper.readValue(path.toFile(), Suv.class);
                    suvService.save(suv);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            });
        } else if (message.equals("Trucks done")) {
            try {
                stream1 = Files.walk(Paths.get(jsonTrucks));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stream1.filter(Files::isRegularFile).forEach(path ->
            {
                try {
                    Truck truck = objectMapper.readValue(path.toFile(), Truck.class);
                    truckService.save(truck);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            });
        }
    }
}
