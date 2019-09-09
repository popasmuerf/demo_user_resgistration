Sending an authorization header with eaach request in AngularJS
=============================================================
-   Basic Authentication allows a client to send its Base64-encoded credentials using an authorazation header in each HTTP request

-   That means each request is independent of other requests, and the server doesn't maintain any
stte information for the client


Why might we need a HTTP interceptor ?
============================================================

    -   When a request/response cmmunicate over an http call and you want to inject some custom logic, then an 
    http interceptor comes into thepicture.

    -   http intercpetors always executes custom logic for
        *   authentications
        *   authorizing
        *   managing session state
        *   logging
        *   modifying responses
        *   rewriting URLs
        *   handling errors
        *   caching
        *   adding custom headers
        *   adding a timestamp
        *   encrypting
        *   decryption




A simple example of an HTTP interceptor
====================================================
AngularJS supports four kinds of http interceptors:

    -   request:
        *   is called before 'http sends the request to the server.  The rquest function takes the 
        config object as an input parameter and returns a 
        config objet after adding, modifying, or removing data to or from this object
    -   response:
        *   is called after 'http sends the response to from the server.  The response function takes a response object as a parameter and modifies the response data data or adds a new set of values, calling another module or service call before returning a response object.
    -   requestError:
        *   gets called when any error is thrown by the rquest interceptor
    -   responseError:
        *   gets called when any error is thrown by the
            response interceptor.


Example : Creating an interceptor named AuthInterceptor in the authInterceptor.js file
============================================================
```
app.factory('AuthInterceptor', [function() {
    return {
        'request': function(config) {
            config.headers = config.headers || {};
            var encodedString = btoa("admin:password");
            config.headers.Authorization = 'Basic' + encodedString;
            return config;
        }
    };
}]);
```

Summary
=========================================================================
An interceptor is simply a factory() service that returns an object with
4 properties that map to functions

*   request: called before a request  is sent, capable of mutating the request object
*   response: called when an $http request succeds, is passed the results object,

This object is the registerd as an interceptor with the $httpProvider in a config()
block.

The way to think about interceptor functions is a promise callback function that are called for 
all http rquests