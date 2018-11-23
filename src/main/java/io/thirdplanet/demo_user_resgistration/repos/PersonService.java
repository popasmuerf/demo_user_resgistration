package io.thirdplanet.demo_user_resgistration.repos;

import io.thirdplanet.demo_user_resgistration.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdb on 10/14/18.
 */
@Service
public class PersonService implements IPersonService {
    private List<Person> personList ;
    public PersonService(){}
    @Override
    public List<Person> findAll() {

        personList = new ArrayList<Person>();
        Person p = new Person("m","brown","7-9-22","delta",50.00);
        personList.add(p);
        p = new Person("k","robinson","3-6-24","beta",60.00);
        personList.add(p);
        p = new Person("p","boissierre","8-6-78","alpha",70.00);
        personList.add(p);
        return personList ;
    }
    @Override
    public void save(Person person){
        personList.add(person);
    }
}
