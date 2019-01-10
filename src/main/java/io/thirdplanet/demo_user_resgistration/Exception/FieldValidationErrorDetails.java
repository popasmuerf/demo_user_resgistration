package io.thirdplanet.demo_user_resgistration.Exception;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List ;
import java.util.Map ;
/**
 * Created by mdb on 12/19/18.
 *
 *
 * The Deal with this class.....
 * ---------------------------------
 * The FieldValidationErrorDetails class..or rather it's insance
 * will be crated to generate an error response...i.e. the JSON
 * response regarding input validation errors...
 *
 *
 *     {
         "error_title": "",
         "error_status": "",
         "error_detail": "",
         "error_timestamp": "",
         "error_path" : "",
         "error_developerMessage: "",
             "errors": {
                "field1" :[{
                    "field" : "",
                    "message" : "",
                    "type" : ""
                }],
                 "field2" :[{
                     "field" : "",
                     "message" : "",
                     "type" : ""
                 }],
             ...
             ...
             }

        }



 Again...this class is responsible for being the data abstraction
 for the above JSON response....

 So the question I currently have...is this going to be marshalled
 *
 *
 *
 */
public class FieldValidationErrorDetails {
    private String error_title ;
    private int error_status ;
    private String error_detail ;
    private long error_timeStamp ;
    private String error_path ;
    private String error_developerMessage ;

    private List<FieldValidationError> errorsList = new ArrayList<FieldValidationError>();
    private Map<String, List<FieldValidationError>> errors =
            new HashMap<String,List<FieldValidationError>>();

    /*Setters and Getters for Validation error meta-data */

    //error_title
    public void setError_title(String error_title){
        this.error_title = error_title ;
    }
    public String getError_title() {
        return error_title;
    }

    //error_status
    public void setError_status(int error_status){
        this.error_status = error_status ;
    }
    public int setError_status() {
        return error_status;
    }

    //error_detail
    public void setError_detail(String error_detail){this.error_detail = error_detail ;}
    public String getError_detail(){return error_detail;}

    //error_timestamp
    public void setError_timeStamp(long timeStamp){
        this.error_timeStamp = timeStamp ;
    }
    public long getError_timeStamp() {
        return error_timeStamp;
    }

    //error_path
    public void setError_path(String error_path){
        this.error_path = error_detail ;
    }
    public String getError_path() {
        return error_path;
    }

    //error_developerMessage
    public void setError_developerMessage(String error_developer_Message){
        this.error_developerMessage = error_developer_Message ;
    }
    public String getError_developerMessage() {
        return error_developerMessage;
    }

    public void setErrors(Map<String, List<FieldValidationError>> errors){
        this.errors = errors ;
    }
    public Map<String, List<FieldValidationError>> getErrors(){
        return errors ;
    }


    //??
    //public void setErrors(List<FieldValidationError> errorsList){this.errorsList = errorsList ;}
    //public List<FieldValidationError> getErrors(){return errorsList ;}


}
