package io.thirdplanet.demo_user_resgistration.validation_handlers;

import io.thirdplanet.demo_user_resgistration.Exception.FieldValidationError;
import io.thirdplanet.demo_user_resgistration.Exception.FieldValidationErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mdb on 12/19/18.
 *
 * This class "intercepts and proccesses"
 * The "MethodArgumentNotValidException" exception.
 *
 * The @ControllerAdvice annotation is used to
 *define a global exception handler for an
 * exception handler mehtod annotated using
 * the @ExectionHandler annotation....so for exsample..
 *
 *  @Controller Advise
 *  class RestValidationHandler{
 *
 *      @ExceptionHandler(MethodArgumentNotValidException.class)
 *      @ResponseStatus(HttpStatus.BAD_REQEST)
 *      public method(){..}
 *  }
 *
 *
 * A class annotated with the @ControllerAdvice annotation will
 * be applicable to all conrollers in the application.
 * So, any exception thrown by any controller class in that
 * appliation will be handled by this annotatied class having a method
 * a method annotated with the @ExceptionHandler annotation.
 *
 * This method will be exectued  only if any controller classes
 * throw an exception mathcing the configured Exception class
 *
 *
 * This class intercepts the exception "MethodArgumentNotValidException"
 * and then creates a new instance of FieldValidationErrorDetails....replete
 * with all the pertenant info....to be returned by the controller method endpoit
 * that makes used of this exception.......BOOM...
 *
 *
 *
 *  Take notice that the the class that is annotated with
 *  @ExceptionHandler(MethodArgumentNotValidException.class)
 *  @ResponseStatus(HttpStatus.BAD_REQUEST
 *  public ResponseEntity <FieldValidationErrorDetails> handleValidation(){
 *      ....
 *  }
 *
 * ^^^ returns an object of ResponseStatus<...>
 *     just like the object returned from normal requests
 *     handled by our endpoints....
 *
 *     Steps...
 *     1. Exception of type MethodArgumentNotValidException.class
 *
 *
 *
 *
 */
@ControllerAdvice
public class RestValidationHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<FieldValidationErrorDetails> handleValidationError(
            MethodArgumentNotValidException mNotValidException,
            HttpServletRequest request){
        FieldValidationErrorDetails fErrorDetails = new FieldValidationErrorDetails();
        fErrorDetails.setError_timeStamp(new Date().getTime());
        fErrorDetails.setError_status(HttpStatus.BAD_REQUEST.value());
        fErrorDetails.setError_title("Field Validation Error");
        fErrorDetails.setError_developerMessage(mNotValidException.getClass().getName());
        fErrorDetails.setError_path(request.getRequestURI());

        BindingResult result = mNotValidException.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        for(FieldError error: fieldErrors){
            FieldValidationError fError = processFieldError(error);
            List<FieldValidationError> fValidationErrorsList = fErrorDetails.getErrorsList();

            if(fValidationErrorsList == null){
                fValidationErrorsList = new ArrayList<FieldValidationError>();
            }

            fValidationErrorsList.add(fError);
            fErrorDetails.getErrors().put(error.getField(),fValidationErrorsList);
        }
        return new ResponseEntity<FieldValidationErrorDetails>(fErrorDetails,HttpStatus.BAD_REQUEST) ;
    }//end method

    private FieldValidationError processFieldError(final FieldError fieldErrors){
                FieldValidationError fieldValidationError = new FieldValidationError();
                if(fieldErrors !=null ){
                    fieldValidationError.setFiled(fieldErrors.getField());
                    fieldValidationError.setType(TrayIcon.MessageType.ERROR);
                    fieldValidationError.setMessage(fieldErrors.getDefaultMessage());
                }
                return fieldValidationError ;
    }//end method



}//end class
