There is a thing known as the Bean Validation API that comes with Spring 2
=======================================================
url: https://www.baeldung.com/javax-validation


Validating  user input is, of course a super common requirement
in most applications, and the Java Bean Validation framework
has become the de-factor standard for handling this 
kind of logic.



JSR 380
========================
JSR 380 is a specification of the Java API for bean validation, part
of JavaEE and JavaSE, which ensures that
the properties of a bean meet specific criteria, using
annotations suh as 

    @NotNull
    @Min
    @Max
    @NotEmpty
    @Size
    @Lenght
    
For more information on JSR 380 : https://jcp.org/en/jsr/detail?id=380


Validation API Reference Implementation
===========================================
A quick note here.....

    *   Hibernate Validator is the referene implementtion 
        of the validation API
        
    *   hibernate-validator is entirely sperate from the persistence
        aspects of Hibernate...by adding this depenedency...
        we are not adding these persistence appects
        into the project




@Valid on @RequestBody in our controllers
===========================================

Add the @Valid annotation to your controller method's
parameters...for example...the userAdd() endpoint modified:

    @PostMapping(value ="/", consumes = MediaType.APPLICATION+_JSON_VALUE)
    public ResponseEntity<UsrsDTO> createUser(@Valid @RequestBody fina usrDT){
     
     ......
     }
     
     
The @Valid annotation will instruct Spring to perform request
data validation after binding incoming POST parameters with
an object.

The @RequestBody method argument can be annotated with
@Valid to invoke automatic validation similar to the 
support for @ModelAttribute method arguments.  A resulting
MethodArgumentNotValidException is handled
in the DefaultHandlerExceptionResolver and
results in a 400 response code.

       Michaels-MacBook-Pro:~ mdb$ 
       Michaels-MacBook-Pro:~ mdb$ curl -k -i -X POST -H 'Content-Type: application/json'                 -d '{ "name":"Fuck Nigga", "email":"phillboss.edu" }'                 https://localhost:4443
       HTTP/1.1 400 
       Content-Length: 0
       Date: Tue, 08 Jan 2019 01:04:17 GMT
       Connection: close
       
       Michaels-MacBook-Pro:~ mdb$ 
       
       
       #what I get back using a browser:
       
       {
           "timestamp": "2019-01-08T01:24:57.722+0000",
           "status": 415,
           "error": "Unsupported Media Type",
           "message": "Content type 'text/plain;charset=UTF-8' not supported",
           "path": "/"
       }


Validators
==============================================
By using the @Valid annotation, Spring delegates
the validation to a registered validator.


On repeating the Postman request with malformed or missing data,
the operation should fail....and the return the following information:


    *   status 400
    *   Error: Bad request
    *   Exception: org.springframework.web.bind.MethodArgumentNotValidException
    
    
    
From this error response, you can understand that Spring MVC validated the input data
and and threw the exception :

    MethodArgmentNotValidException
    
when it did not find the required address field.

Even though the error message returned from Spring Boot is helpful, it is not that
informative to whatever is consuming your REST service....


We should present an error message that more informative....as JSON of course...
for example:

    {
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


^^^ to represent this JSOn format for an error message, it is required that we 
intercept the exception:

    MethodArgumentNotValidExcepton 
    
    
and return the appropiate message....so....we need to create some 
corresponding classes for our planned JSON error message format....




ValidationError and Updated ErrorDetail
=================================================
to add the previous validaton error feature in 
our app, we need to create two classes....

    *   FieldValidationError
    
    *   FieldValidationDetails
    
    


    //errors json sub-object
    "errors": {
         "field1" :[{
             "field" : "",
             "message" : "",
             "type" : ""
            }],
            
    //corresponding class FieldValidationError
    
    public class FieldValidationError {
        private String field  ;
        private String message ;
        private Message messageType ;
        public void  setField(String field){
            this.field = field  ;
        }
        pubic String  getField(){
            return field ;
        }
        public void  setMessage(String message){
            this.message = message  ;
         }
        pubic String  getMessage(){
            return message ;
        }
        public void  setMessageType(MessageType messageType){
            this.messageType = messageType  ;
        }
        pubic MessageType  getMessageType(){
           return messageType ;
        }
    }
    
    
    
The FieldValidationError class has three properties:

    -   String field
    -   String message
    -   MessageType messageType
    
    
messagType is an enumeration containing the possible
message types....

    public enum MessageType{
        SUCCESS,
        INFO,
        WARNING,
        ERROR
    }
   
   

Handling Exceptions Using the @ControllerAdvice Annotation
==========================================================
The  annnotation:

    @ControllerAdvice
    
is used to define a global exception handler for an exception
handler method annotated using :

    @ExceptionHander
    

A class annotated with the annotation:

    @ControllerAdvice
    
will be applicable to all cotrollers in the application.
So, any exception thrown by an controller class in that application
will be handled by this annotated class having a method annotated with 
the annotation:


    @ExceptionHandler
    
This method will be executed only if any controller classes
throw an exception matching the configured Exception class.


So, let's create the controller advice class 

    RestValidationHandler
    
    
@ControllerAdvice 
=================================
Promotes a unified exception handling thoughout a whole
application.

Spring brings support for a global @ExceptionHandler with 
the @ControllerAdvice annotation.  This enables a
mechanism that breaks away from the older MVC model
and makes use of the ResponseEntity along with the type safety
and flexibility of @ExceptionHandler



The @ControllerAdivce annotation allows us to consolidate our multiple,
scattered @ExceptionHandlers from before into a single, global error
handling component.

    *   Full control over the body of the response as well as the status code
    *   Mapping of several exceptions to the same method, to be
        handled together,
    *   Makes good use of the newer RESTful ResponseEntity response
