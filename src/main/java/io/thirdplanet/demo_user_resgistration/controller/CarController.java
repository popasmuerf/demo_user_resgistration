package io.thirdplanet.demo_user_resgistration.controller;

import io.thirdplanet.demo_user_resgistration.domain.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mdb on 10/21/18.
 * https://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
 */
@RestController
public class CarController {
    @RequestMapping(value = "/getCar")
    public ResponseEntity<Car> getCar(){
        Car car = new Car() ;
        car.setColor("Blue");
        car.setMiles(100 );
        car.setVin("1234");
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/setCar")
    public ResponseEntity<Car> setCar(Car car){
        if(car == null){
            car.setColor("red");
            car.setMiles(500);
            car.setVin("4321");
        }else{
            car.setColor("red");
            car.setMiles(500);
            car.setVin("4321");
        }
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/setCarPost",method = RequestMethod.POST)
    public ResponseEntity<Car> update(@RequestBody Car car){
        if(car != null){
            car.setColor("Oblivion" + car.getColor());
            car.setMiles(222222222 + car.getMiles());
        }
        return new ResponseEntity<Car>(car,HttpStatus.OK) ;
    }
}
