Bootstrapping AngularJS 
====================================

<!--entry point of html-->
<div ng-app>...</div>

//endtry point of appliction 
var app = angular.module('userregistrationsystem',['ngRoute','ngResource']);



Dependency Injection
====================================
    *   Seperates the process of creating dependencies and thier consumption
    *   Users will only need to worry about how to use the dependency
    *   Makes apps more testable
    
    *   We define dependencies in app.js as follows
    
    
//entry point of application
var app = angular.module('userregistration',['ngRoute','ngResource']

    *ngRoute
        -The first dependency is the AngularJS ngRoute module,
         which provides routing to the application.  The ngRoute module
         is used for deep-linking URLs to controllers and views (HTML partials)
    *ngResource
        -The second dependency is the AngularJS ngResource module, which provides
         interaction support with RESTful services.
         
         
Angular routes 
=================================================
AngularJS routes are configured using the $routeProvider API
are dependent on the ngRoute module,which is why its dependency is
defined in an array in the module definition

// defining routes

    app.config(function($routProvider){
        $routeProvider
            .when('/list-all-users',{
              templateUrl:'template/listuser.html',
              controller:'listUserController'  
            }).when('/register-new-user',{
                     templateUrl:'template/userresgistration.html',
                     controller:'registerUserController'  
            }).when('/register-new-user',{
                                   templateUrl:'template/userupdation.html',
                                   controller:'usersDetailsController'  
            }).otherwise({'redirectTo:'/home',
                           templateUrl:'/template/home.html'  
            });
    });
    
    
 Defining templateUrl(partials) Routes
 ===================================================
    *   listuser.html
    *   userregistration.html
    *   userupdation.html
    *   home.html
    
  Where does SpringBoot automatically serve static content ?
  ===========================================================
  * classpath:/META-INF/resources
  * classpath:/resources
  * classpath:/static
  * classpath:/public