UserRegistrationRestController.java
=====================================

Annotations
-------------------------------------
@RestController which is actually 
an amalgamation of @Controller and @ResponseBody, which
eliminates the need of annotating each method with 
@responseBody

This annotation is used to defie an API endpoint.  This 
annotation lets Spring render the result back to the caller.

To build restful web services in Spring , create a controller
class using the @RestController annotation to 
handle HTTP requests......



@Target(value=TYPE)
@Retention(value=RUNTIME)
@Documented
@Controller
@Responsebody
public @interfce RestController


@RequestMapping:  This annotation isused to provide routing information.
The HTTP request in Spring is mapped to the corresponding handler method.
This annotation can



@ResponseEntity
This class extends HttpEntity and is used in the controller
method to add the HTTP status to the response.
It can conatin HTTTP status codes, headers, and the body





@PathVariable
This annotation is used to bind a method parameter
to a URI template variable (the one in {}).


@MediaType: This is a subclass of MimeType.
While using the @RequestMapping annotation, you 
can slaso specify the MediaType to 
be produced or consumed by the controller 
method.



@GetMapping : Retrieve All Users
This is a composed annotation that is a
short-cut for : @RequestMapping(value="/", method = RequestMethod.GET)


@PostMapping: Create a New User
The @PostMapping annotation is a composed 
annotation that is a shortcut for
@RequestMapping(value="/",RequestMethod.POST)


The Post request on teh /api/user/
endpoint creates a new user using the enclosed
body of request.

    @PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
 
^^^ We provided the parameter 

    consumes = MediaType.APPLICATION_JSON_VALUE
    
To specify that the method  will only accept JSON data from 
the request body.

The attributes :

    produces
      //and
    consumes
    
are used to narrow the mapping types.
We actually don't need this because

    @RequestBody
    
uses HtttpMessageConverters to determine the right
converter to use and to convert the body of the
HTTP request to the domain objectc.

The message converters in Spring boot support JSON and XML resources
representations.


About that whole POSTing to our service thing.....
========================================================
After making a GET request to a REST service the 
natural progression is to POsT information back to the 
server.  In this episode we will look at how to post
json to a spring controller and have it automaticallly
convert JSON to an arraylist, object or multiple objects...



Underestanding @RequestBody
========================================================
The first thing to understand is how json binds to a jaa object.
The @RequestBody method paramter annotation should bind
the json value in the HTTP rquest body to the java object by using
an

        HttpMessageConverter
        
It is worth mentioning that HttpMessageConverter is overloaded
such that it can bind xml or json( and likely other payload types)
within the body of some POST request that will map to the appropiate
Entity class....


Spring will look for the specific HttpMessageConverter associated to
the mime type to perform the conversion.  Since spring boot
configures it automatically if jackson is on your class path...
the converter:

        MappingJackson2MessageConverter
        
is used.  Alternatively...we can configure 

        GsonHttpMessageConverter
        
based on the  google gson library which was offcially released in
spring version 4.1



Json to java object
============================================
You might want to update the Car object by posting json to a URL.
A more detailed user story would be, as a user I wnt to be
able to update attributes of my car.  We will create 
@RequestMapping and specify 
            
            method = RequestMethod.POST 
            
            
   
CURL example of POST/PUT new user...
==================================
        curl -k -i -X POST -H 'Content-Type: application/json' \
        -d '{ "name":"Kevin Robinson", "address":"77777 Carbon LN Langford MD 30874", "email":"kevgrob@umd.edu" }'\
         https://localhost:4443
         
         
         curl -k -i -X POST -H 'Content-Type: application/json' \
                 -d '{ "id":100,"name":"Kevin Robinson", "address":"77777 Carbon LN Langford MD 30874", "email":"kevgrob@umd.edu" }'\
                  https://localhost:4443
        
        curl -k -i -X POST -H 'Content-Type: application/json' \
                -d '{ "name":"Phil Bossierre", "address":"88888 Mangnese Rd Fanlmord MD 50874", "email":"phillboss.edu" }'\
                 https://localhost:4443
        
        
        
       curl -k -i -X POST -H 'Content-Type: application/json' \
                        -d '{  "address":"77777 Carbon LN Langford MD 30874", "email":"kevgrob@umd.edu" }'\
                         https://localhost:4443 
        
        curl -k -i -X PUT -H 'Content-Type: application/json' \
          --data  '{ "name":"Phil Bossierre", "address":"99999 Iodine Ave Bethesda MD 99874", "email":"phillboss.edu" }' \
          https://localhost:4443/4
        
        
        

CURL example of DELETE current user by id...
=======================================================
        curl --insecure  -X DELETE https://localhost:4443/4



CURL example of PUT modify existing user by id
========================================
         curl -i -X POST -H 'Content-Type: application/json' -d '{ "name":"Charles Quarles", "address":"12121 Flag Harbor Driver Germantown MD 20874", "email":"CQuarels@Gmail.com" }' http://localhost:8080
^^^ remember.....we have to specify th MIME type whenever we are 
commiting a POST or PUT or any other HTTP method that is not GET


About these controller methods......
============================================================
So I think this pretty much goes for any web application under the
hood......

request <---> router  <---> controller.method
 
 ^^^ thsi is pretty simple and powerful.  Your controller
 method/function will do something.  If it returns a value...
 that value will of course be used by the whomever called that method....be it view components or simply returned as a stream of bytes that is intercepted as a response by some browser(like a simple json or xml, text response)....Spring of course helps us out via the desirialization/serialization of requests and responses.....so there's that.....
 
 
 
 