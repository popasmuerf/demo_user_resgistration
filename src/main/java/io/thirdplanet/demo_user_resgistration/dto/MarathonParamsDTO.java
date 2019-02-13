package io.thirdplanet.demo_user_resgistration.dto;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name="MarathonParams")
public class MarathonParamsDTO {
    @Id
    @GeneratedValue
    @Column(name="INPUT_ID")
    private Long id ;

    @javax.validation.constraints.NotEmpty
    @Length(max=50)
    @Column(name = "COMPANY_NAME")
    private String COMPANY_NAME ;



    @javax.validation.constraints.NotEmpty
    @Length(max=50)
    @Column(name = "OBSERVED_SYSTEM_NAME")
    private String  OBSERVED_SYSTEM_NAME;

    @javax.validation.constraints.NotEmpty
    @Length(max=50)
    @Column(name = "OBSERVED_SYSTEM_API")
    private String OBSERVED_SYSTEM_API ;


    @javax.validation.constraints.NotEmpty
    @Length(max=50)
    @Column(name = "OBSERVED_SYSTEM_SECRET")
    private String OBSERVED_SYSTEM_SECRET ;



    public Long getId(){return id ;}
    public void setId(Long id){this.id = id ;}

    public void setCOMPANY_NAME(String company_name){
        this.COMPANY_NAME = company_name ;
    }
    public String getCOMPANY_NAME(){
        return COMPANY_NAME  ;
    }

    public void setOBSERVED_SYSTEM_NAME(String observed_system_name){
        this.OBSERVED_SYSTEM_NAME = observed_system_name ;
    }
    public String getOBSERVED_SYSTEM_NAME(){
        return OBSERVED_SYSTEM_NAME  ;
    }

    public void setOBSERVED_SYSTEM_API(String observed_system_api){
        this.OBSERVED_SYSTEM_API = observed_system_api ;
    }
    public String  getOBSERVED_SYSTEM_API(){
        return OBSERVED_SYSTEM_API ;
    }

    public void setOBSERVED_SYSTEM_SECRET(String observed_system_secret){
        this.OBSERVED_SYSTEM_API = observed_system_secret ;
    }
    public String  getOBSERVED_SYSTEM_SECRET(){
        return OBSERVED_SYSTEM_API ;
    }





}//END OF CLASS
