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



/**
 * 
 * http interceptor with Request Function
 * =============================================
 * here we confgured security authentication 
 * credientials with the usernames :
 *  -admin
 *  -password
 * 
 * We call :
 *  btoa()
 * 
 * to get the Base64-encoded string from the user's credentials
 * you called  a request interceptor function that takes a 
 * config object as a parameter.  You updted
 * c
 *  config.headers.Authoriazation wit Basic Authentication
 * data and returned this updated config object.
 * this is sufficent to enable basic authenticaion.
 * 
 * we also need to register the AuthInterceptor interceoptor with the
 * AngularJS application, you need to update th app.js file as
 * sh
 * 
 * 
 */