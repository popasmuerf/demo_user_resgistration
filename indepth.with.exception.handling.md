url = https://www.baeldung.com/exception-handling-for-rest-with-spring

Solution-1 The Controller level @ExceptionHandler
==================================================
The first solution works at the @Controller level -- we will define a method
to handle exceptions and annotate that with @ExceptionHandler



    //code
    
    public class FooController{
        //...
        @ExceptionHandler({CustomException1.class, CustomException2.class})
        
        public void handleException(){
            //
        }
    }
    
    
    
    
This appriach has a major drawback...the @ExceptionHandler annotated method
is only active for that particular Controller, not globally for the entire application.
We could add this to every extant controller....but that isn't very elegant....

This limitation could be remedied by having all Controllers extend a 
Base Controller class...however this can be a problem for applications where, for
whatever reason, the Controllers cannot be made to extend from such a class.


Solution 2 -- The HandlerExceptionResolver
======================================================
The second solution is to define an 

    HandlerExceptionResolver
    
this will resolve any exception thrown  by the applicaion,
It will also allow us to implment a uniform exception
handling mechanism in our REST API 



Before we go any further....let's go over the existing implementations..


ExceptinHandlerExceptionResolver
-----------------------------------------------------
This resolver was introduced in Spring 3.1 and is enabled by
default in the DispatcherServlet.
This is actually the core component of how the 

    @ExceptionHandler 

mechanism presented  earlier works



ExceptionHandlerExceptionResolver
---------------------------------------
This resolver was introdued in Spring 3.1 and is enabled
by default in the DispatcherServlet



DefaultHandlerExceptionResolver
---------------------------------------
This resolver was introduced in Spring 3.0 and it's enabled by
default in theDispatchServlet

It is used to resolve standard Spring exceptions to their corresponding
HTTP Status Codes 



