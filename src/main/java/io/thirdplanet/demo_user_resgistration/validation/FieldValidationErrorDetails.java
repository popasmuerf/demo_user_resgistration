package io.thirdplanet.demo_user_resgistration.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mdb on 1/6/19.
 */
public class FieldValidationErrorDetails {
    private String error_title ;
    private int error_status ;
    private String error_detail ;
    private long error_timeStamp ;
    private String error_path ;
    private String  error_developer_Message ;
    private Map <String,List<FieldValidationError>> errors =
            new HashMap<String,List<FieldValidationError>>();

    public void setError_title(String error_title){
        this.error_title = error_title ;
    }
    public String getError_title(){
        return error_title ;
    }

    public void setError_detail(String error_detail){
        this.error_detail = error_detail ;
    }
    public String getError_detail(){
        return error_detail ;
    }

    public void setError_timeStamp(long error_timeStamp){
        this.error_timeStamp = error_timeStamp ;
    }
    public long getError_timeStamp(){
        return error_timeStamp ;
    }

    public void setError_developer_Message(String error_developer_Message){
        this.error_developer_Message = error_developer_Message ;
    }
    public String getError_developer_Message(){
        return error_developer_Message ;
    }

    public void setErrors(Map <String,List<FieldValidationError>> errors){
        this.errors = errors ;
    }
    public Map <String,List<FieldValidationError>> getErrors(){
        return errors ;
    }

}
