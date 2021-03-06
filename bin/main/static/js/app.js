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



app.controller("listUserController", function ($scope,$http,$location,$route) {
           
    $http({
        method:'GET',
        url:"http://localhost:8080/api/user/users",
    })
    .then(function(response){
        $scope.users = response.data ;
    });
    $scope.editUser = function(userId){
        $location.path("/update-user/"+userId);
    }
    $scope.deleteUser = function(userId){
        $http({
            method:'DELETE',
            url: 'http://localhost:8080/api/user/' + userId
        })
        .then(function(response){
            $location.path("/list-all-users");
            $route.reload() ;
        });
    }

});

app.controller("registerUserController", function ($scope,$http,$location,$route) {
    $scope.submitUserForm = function(){
        $http({
            method:"POST",
            url:"http://localhost:8080/api/user/",
            data:$scope.user,
        })
        .then(function(response){
            $location.path("/list-all-users");
            $route.reload() ;
        },function(errResponse){
            $scope.errorMessage = errResponse.data.errorMessage;
        });
    }
    $scope.resetForm = function(){
        $scope.user = null ;
    };
});



app.controller("userDetailsController", function ($scope,$http,$location,$routeParams,$route){
    $scope.userId = $routeParams.id ;
    $http({
        method:"GET",
        url:"http://localhost:8080/api/user/" + $scope.userId,
    })
    .then(function(response){
        $scope.user = response.data ;
    });
    $scope.submitUserForm = function(){
        $http({
            method:"POST",
            url:"http://localhost:8080/api/user/",
            data:$scope.user,
        })
        .then(function(response){
            $location.path("/list-all-users");
            $route.reload() ;
        },function(errResponse){
            $scope.errorMessage = errResponse.data.errorMessage;
        });
    }
});


app.factory('AuthInterceptor', [ function() {
	return {
		'request' : function(config) {
			config.headers = config.headers || {};
			var encodedString = btoa("admin:password");
			config.headers.Authorization = 'Basic ' + encodedString;
			return config;
		}
	};
} ]);




app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('AuthInterceptor');
  }]);

