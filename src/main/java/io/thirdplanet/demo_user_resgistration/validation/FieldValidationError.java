package io.thirdplanet.demo_user_resgistration.validation;

import Messages.MessageType;

/**
 * Created by mdb on 1/6/19.
 */
public class FieldValidationError {
        private String field  ;
        private String message ;
        private MessageType messageType ;
        public void  setField(String field){
            this.field = field  ;
        }
        public String  getField(){
            return field ;
        }
        public void  setMessage(String message){
            this.message = message  ;
        }
        public String  getMessage(){
        return message ;
        }
        public void  setMessageType(MessageType messageType){
            this.messageType = messageType  ;
        }
        public MessageType getMessageType(){
                return messageType ;
        }
}
