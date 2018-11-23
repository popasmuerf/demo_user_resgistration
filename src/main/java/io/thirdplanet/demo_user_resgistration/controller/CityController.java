package io.thirdplanet.demo_user_resgistration.controller;

import io.thirdplanet.demo_user_resgistration.domain.City;
import io.thirdplanet.demo_user_resgistration.repos.CityService;
import io.thirdplanet.demo_user_resgistration.repos.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mdb on 10/8/18.
 */
@RestController
public class CityController {
    @Autowired
    ICityService cityService ;

    @RequestMapping(value = "/getCities")
    public List<City> getCities(){
        return cityService.findAll() ;
    }
}
