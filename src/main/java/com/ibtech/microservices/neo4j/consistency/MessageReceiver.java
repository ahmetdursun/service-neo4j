package com.ibtech.microservices.neo4j.consistency;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibtech.microservices.neo4j.data.model.Brand;
import com.ibtech.microservices.neo4j.data.model.Car;
import com.ibtech.microservices.neo4j.data.repo.BrandRepository;
import com.ibtech.microservices.neo4j.data.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class MessageReceiver {



    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CarRepository carRepository;



    public void receiveMessage(String message) {

        System.out.println("Received <" + message + ">");
        if(StaticBuffer.oldJpaCar == null){
            JPACar jpaCar = deserializeJson(message);
            StaticBuffer.oldJpaCar = new JPACar(jpaCar.getMake(), jpaCar.getModel(), jpaCar.getYear());
        }else{
            JPACar jpaCar = deserializeJson(message);
            Iterable<Car> cars =  carRepository.findCarByName(StaticBuffer.oldJpaCar.getModel());
            Iterable<Brand> brands =  brandRepository.findBrandByName(jpaCar.getMake());
            Iterator<Car> carItr = cars.iterator();
            Brand brand = brands.iterator().hasNext() ? brands.iterator().next() : null;
            if(brand != null){
                while (carItr.hasNext()){
                    Car car = carItr.next();
                    car.setBrand(brand);
                    carRepository.save(car);
                }
            }
            StaticBuffer.oldJpaCar = null;
        }


    }


    private JPACar deserializeJson(String objectReceived) {
        ObjectMapper mapper = new ObjectMapper();
        JPACar jpaCar = null;

        try {
            jpaCar = mapper.readValue(objectReceived, JPACar.class);
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }

        System.out.println("Deserialized message payload: {}" + jpaCar);

        return jpaCar;
    }
}
