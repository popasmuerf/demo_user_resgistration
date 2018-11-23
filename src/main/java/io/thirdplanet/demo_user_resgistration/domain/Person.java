package io.thirdplanet.demo_user_resgistration.domain;

/**
 * Created by mdb on 10/14/18.
 */

public class Person {

    private Long id ;
    private String firstName ;
    private String lastName ;
    private String dateOfBirth ;
    private String profession ;
    private double salary ;

    public Person(){}
    public Person(String firstName,
                  String lastName,
                  String dateOfBirth,
                  String profession,
                  double salary){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.dateOfBirth = dateOfBirth ;
        this.profession = profession ;
        this.salary = salary ;
    }
    public void setFirstName(String name){
        this.firstName = name ;
    }
    public String getFirstName(){
        return firstName ;
    }
    public void setLastName(String name){
        this.firstName = name ;
    }
    public String getLastName(){
        return firstName ;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth ;
    }
    public String getDateOfBirth(){
        return dateOfBirth ;
    }
    public void setProfession(String profession){
        this.profession = profession ;
    }
    public String getProfession(){
        return profession ;
    }
    public void setSalary(double salary){
        this.salary= salary ;
    }
    public double getSalary(){
        return salary ;
    }
    @Override
    public String toString(){
        return firstName + " "+ lastName;
    }
}
