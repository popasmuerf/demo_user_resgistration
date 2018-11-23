package io.thirdplanet.demo_user_resgistration.dto;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by mdb on 10/1/18.
 */
@Entity
@Table(name="Users")

public class UserDTO {
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id ;

    @Column(name = "NAME")
    private String name ;

    @Column(name="ADDRESS")
    private String address ;

    @Column(name = "EMAIL")
    private String email ;

    /*
    public void UserDTO(//Long id,
                        String name,
                        String address,
                        String email){
        //this.id = id ;
        this.name = name ;
        this.address = address ;
        this.email = email ;

    }
    */

    public Long getId(){return id ;}
    public void setId(Long id){this.id = id ;}
    public String getName(){return name ;}
    public void setName(String name){this.name = name ;}
    public String  getAddress(){return address ;}
    public void setAddress(String address){this.address = address;}
    public String getEmail(){return email;}
    public void setEmail(String email ){this.email = email ;}


}
