package io.thirdplanet.demo_user_resgistration.Exception;
import java.util.HashMap;
import java.util.List ;
import java.util.Map ;
/**
 * Created by mdb on 12/19/18.
 */
public class FieldValidationErrorDetails {
    private String error_title ;
    private int error_status ;
    private String error_detail ;
    private long error_timeStamp ;
    private String error_path ;
    private String error_developer_Message ;

    private Map<String, List<FieldValidationError>> errors =
            new HashMap<String,List<FieldValidationError>>();


    public void setError_title(String error_title){
        this.error_title = error_title ;
    }

    public String getError_title() {
        return error_title;
    }

    public void setError_status(int error_status){
        this.error_status = error_status ;
    }

    public int setError_status() {
        return error_status;
    }

    public void setError_timeStamp(long timeStamp){
        this.error_timeStamp = timeStamp ;
    }

    public long getError_timeStamp() {
        return error_timeStamp;
    }

    public void setError_path(String error_path){
        this.error_path = error_detail ;
    }

    public String getError_path() {
        return error_path;
    }

    public void setError_developer_Message(String error_developer_Message){
        this.error_developer_Message = error_developer_Message ;
    }

    public String getError_developer_Message() {
        return error_developer_Message;
    }
}
