package io.thirdplanet.demo_user_resgistration.Exception;

import io.thirdplanet.demo_user_resgistration.dto.UserDTO;

/**
 * Created by mdb on 11/22/18.
 */
public class CustomErrorType extends UserDTO{
    private String errorMsg ;

    public CustomErrorType(final String errorMsg){
        this.errorMsg = errorMsg ;
    }


    public String getErrorMsg(){
        return errorMsg ;
    }


}
