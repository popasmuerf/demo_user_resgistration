package io.thirdplanet.demo_user_resgistration.Exception;
import java.awt.TrayIcon.MessageType ;
/**
 * Created by mdb on 12/19/18.
 */
public class FieldValidationError {
    private String filed ;
    private String message ;
    private MessageType type ;


    public void setFiled(String filed){
        this.filed = filed ;
    }
    public String getFiled(){
        return filed ;
    }

    public void setMessage(String message){
        this.message = message ;
    }
    public String getMessage(){
        return message ;
    }

    public void setType(MessageType type){
        this.type = type ;
    }
    public MessageType getType(){
        return type ;
    }

    /*
     * public enum MessageType{
      *     SUCCESS,
      *     INFO,
      *     WARNING,
      *     ERROR
      * }
     */





}
