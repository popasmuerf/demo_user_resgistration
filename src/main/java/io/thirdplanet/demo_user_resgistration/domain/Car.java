package io.thirdplanet.demo_user_resgistration.domain;
//https://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
/**
 * Created by mdb on 10/21/18.
 */
public class Car {
    private String vin ;
    private String color ;
    private Integer miles ;

    public void setVin(String vin ){
        this.vin = vin ;
    }
    public String getVin(){return vin ;}

    public void setColor(String color ){
        this.color = color ;
    }
    public String getColor(){
        return  color ;
    }

    public void setMiles(Integer miles){
        this.miles = miles ;
    }
    public Integer getMiles(){
        return miles ;
    }

}
