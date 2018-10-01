package io.thirdplanet.demo_user_resgistration.domain;

/**
 * Created by mdb on 10/1/18.
 */
public class User {
    Long id ;
    String name ;
    String address ;
    String email ;

    public Long getId(){return id ;}
    public void setId(Long id){this.id = id ;}
    public String getName(){return name ;}
    public void setName(String name){this.name = name ;}
    public String  getAddress(){return address ;}
    public void setAddress(String address){this.address = address;}
    public String getEmail(){return email;}
    public void setEmail(String name ){this.name = name ;}


}
