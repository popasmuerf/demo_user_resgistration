package io.thirdplanet.demo_user_resgistration.controller;

import io.thirdplanet.demo_user_resgistration.domain.Person;
import io.thirdplanet.demo_user_resgistration.repos.IPersonService;
import io.thirdplanet.demo_user_resgistration.repos.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by mdb on 10/14/18.
 */
@RestController
public class PersonController {
    @Autowired
    IPersonService personService ;

    @RequestMapping(value="/getPersons",method = RequestMethod.GET)
    public List<Person> getPersons(){
        return  personService.findAll() ;
    }

    /*
    @PostMapping("/students")
    public ResponseEntity<Object> createPerson(@RequestBody Person person){
        //person = personService.save(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();
    }
    */




}
