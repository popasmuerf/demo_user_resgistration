var app = angular.module('dur',
    ['ngRoute','ngResource']
);


app.config(function($routerProvider){

    $routeProvider.when(
        '/list-all-users',{
            templateUrl:'/template/listuser.html',
            controller:'listUserController'
            }
        ).when(
             '/register-new-user',{
                 templateUrl:'/template/userregistration.html',
                 controller:'registerUserController'
                 }
        ).when(
               '/update-user/:id',{
                templateUrl:'/template/userupdation.html',
                controller:'userDetailsController'
                }
        ).otherwise({
                redirectTo:'/home',
                templateUrl:'/template/home.html',
                }
        );
    }
);
