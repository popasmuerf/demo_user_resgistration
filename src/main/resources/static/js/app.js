//var app = angular.module('dur',['ngRoute','ngResource']);


var app = angular.module('dur',['ngRoute']);
app.config(function($routeProvider){

    $routeProvider.when(
        '/list-all-users',{
            templateUrl:'template/listuser.html',
            controller:'listUserController'
            }
        ).when(
             '/register-new-user',{
                 templateUrl:'template/userregistration.html',
                 controller:'registerUserController'
                 }
        ).when(
               '/update-user/:id',{
                templateUrl:'template/userupdation.html',
                controller:'userDetailsController'
                }
        ).otherwise({
                redirectTo:'/home',
                templateUrl:'template/home.html',
                }
        );
    }
);



app.controller("listUserController", function ($scope) {
           
    $scope.message = "listUserController";

});

app.controller("registerUserController", function ($scope) {
    $scope.message = "registerUserController";
});



app.controller("userDetailsController", function ($scope) {
    $scope.message = "userDetailsController";
});

