package io.thirdplanet.demo_user_resgistration.repos;

import io.thirdplanet.demo_user_resgistration.domain.City;

import java.util.List;

/**
 * Created by mdb on 10/8/18.
 */
public interface ICityService {
    public List<City> findAll();
}
