package io.thirdplanet.demo_user_resgistration.validation;

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
import java.util.Date;
import java.util.List;

/**
 * Created by mdb on 12/19/18.
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
            //List<FieldValidationError> fieldValidationErrorsList = fErrorDetails.getErrors();
        }
        return null ;
    }

    private FieldValidationError processFieldError(final FieldError fieldErrors){
                FieldValidationError fieldValidationError = new FieldValidationError();
                if(fieldErrors !=null ){
                    fieldValidationError.setFiled(fieldErrors.getField());
                   // fieldValidationError.setType(TrayIcon.MessageType.ERROR) ;
                    fieldValidationError.setMessage(fieldErrors.getDefaultMessage());
                }
                return fieldValidationError ;
    }

}
