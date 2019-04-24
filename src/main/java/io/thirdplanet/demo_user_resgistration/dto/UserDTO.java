package io.thirdplanet.demo_user_resgistration.dto;

//import javax.persistence.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

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

    @javax.validation.constraints.NotEmpty
    @Length(max=50)
    @Column(name = "NAME")
    private String name ;

    @javax.validation.constraints.NotEmpty
    @javax.validation.constraints.NotNull
    @Column(name = "ADDRESS")
    private String address ;


    @Column(name = "EMAIL")
    private String email ;





    public Long getId(){return id ;}
    public void setId(Long id){this.id = id ;}
    public String getName(){return name ;}
    public void setName(String name){this.name = name ;}
    public String  getAddress(){return address ;}
    public void setAddress(String address){this.address = address;}
    public String getEmail(){return email;}
    public void setEmail(String email ){this.email = email ;}






}//END OF CLASS
