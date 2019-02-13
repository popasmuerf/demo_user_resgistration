package io.thirdplanet.demo_user_resgistration.domain;

import javax.persistence.Entity;

/**
 * Created by mikeyb on 2/13/19.
 */

public class MarathonParams {
    private Long id ;
    private String COMPANY_NAME ;
    private String  OBSERVED_SYSTEM_NAME;
    private String OBSERVED_SYSTEM_API ;
    private String OBSERVED_SYSTEM_SECRET ;

    public MarathonParams(){
        //EMPTY CONSTRUCTOR
        //PASS
    }

    public MarathonParams(Long id,
                          String company_name,
                          String observed_system_name,
                          String observed_system_api,
                          String observed_system_secret){
        this.id = id ;
        this.COMPANY_NAME = company_name ;
        this.OBSERVED_SYSTEM_NAME = observed_system_name ;
        this.OBSERVED_SYSTEM_API = observed_system_api ;
        this.OBSERVED_SYSTEM_SECRET = observed_system_secret ;
    }


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


    @Override
    public String toString(){
        StringBuffer returnStr = new StringBuffer("{") ;
        returnStr.append(COMPANY_NAME) ;
        returnStr.append(":");
        returnStr.append(COMPANY_NAME);
        returnStr.append(",");

        returnStr.append("OBSERVED_SYSTEM_NAME") ;
        returnStr.append(":");
        returnStr.append(OBSERVED_SYSTEM_NAME);
        returnStr.append(",");

        returnStr.append("OBSERVED_SYSTEM_API") ;
        returnStr.append(":");
        returnStr.append(OBSERVED_SYSTEM_API);
        returnStr.append(",");

        returnStr.append("OBSERVED_SYSTEM_SECRET") ;
        returnStr.append(":");
        returnStr.append(OBSERVED_SYSTEM_SECRET);
        returnStr.append(",");

        returnStr.append("}");

        return returnStr.toString();

    }

}
