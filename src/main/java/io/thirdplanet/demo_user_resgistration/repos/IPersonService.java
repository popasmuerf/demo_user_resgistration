package io.thirdplanet.demo_user_resgistration.repos;

import io.thirdplanet.demo_user_resgistration.domain.Person;

import java.util.List;

/**
 * Created by mdb on 10/14/18.
 */
public interface IPersonService {
    public List<Person> findAll() ;
    public void save(Person person) ;
}
