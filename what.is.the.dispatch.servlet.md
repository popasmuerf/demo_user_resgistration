url = https://www.baeldung.com/spring-dispatcherservlet

DispatchServlet Introduction
=====================================
Simply put, in the Front Controller design 
pattern, a single controller is
responisble for directing incoming 
HttpRequests to all of an application's osther
controllers and handlers.


Spring's DispatcherServlet implemnts this pattern and is, therefore, responsible
for correctly coordinating the HttpRequests to their right handlers(So basically...
DispatchServlet is like Go's mux/router....gotcha...)



Spring's DispatchServlet implements this pattern and is, therefore, responsbile
for correctly coordinating the HttpRequests to their right handlers.




DispatchServlet Request Processing
=============================================
Essentially , a DispatcherServelt handles :

    1. Incomming http req
    2. delegates the request
        2.1. routes to correct controller
        2.2. routes to correct handler
        
        
        
        



DispatcherServlet Request Processing
==============================================
Essentially, a DispatcherServlet handles an incoming HttpRequest, delegaes the
request, and processes that request according HandlerAdapter interfaces that have been
implemented with the Spring application along with accompanying annotations  specifying
handlers, controller endpoints, and response objects


Getting in-depth with how the DispatcherServlet works...
--------------------------------------------------------
    1.  WebApplicationContext associated to a DispatcherServlet under the
        key DispatcherServerlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE
        is searched for and made available to all the elements of the process
        
    2. The DispatcherServlet finds all implementations of the HandlerAdapter
       of the HandlerAdapter interface configured for your dispatcher using
            getHandler()
       each found and configured implementation handles the request via 
       handle() through the remainder of the process.
       
       
     3. The LocalResolver is optionally bound to the request to enable 
        elements in the process to resolve the local
     
     4. ThemeResolver is optionally bound to the request to let elements,
        such as views, determine which theme to use
        
     5. If a Multipart resolver is specifed, the request is insspeted for 
        MultipartFiles, any found are wrapped in a MultipartHttpServletRequest for further 
        processi.
        
     6. HandlerExceptionRsolver implementations declared inthe 
        WebApplicationContext pick up exceptions that are thrown during
        processing of the request
        
        
HanderAdatper Interfaces
========================================
Each HandlerAdapter interace facilitates the user of contorllers,
servlets, HttpRequests, and HTTP paths  through sveral specific
interfaces.


The HandlerAdapter interface thus plays an essential role
through themany stages of the DispatcherServlet request processing
workflow.

    1. All HandlerAdapter implementations are placed
       into the HandlerExcecutionChain
       from the dispatcher's getHander() mehod.


