
method:         GET
API endpoint:   /api/user/user
user role:      user


method:         GET
API endpoint:   /api/user/users
user role:      user


method:         POST
API endpoint:   /api/user/user
user role:      user



method:         PUT
API endpoint:   /api/user/{id}
user role:      user


method:         DELETE
API endpoint:   /api/user/{id}
user role:      admin




Spring Security supports multiple ways to authenticate users such as user
authentication using:
    *   in memory definitions
    *   definitions against a user repository(relational database)
        that stores user details 



Authentication Customizations with an In-Memory Definitions
===============================================================
Useful in this context:
    *   If there are only a few users for your app
    *   You may define their details in a Spring configuration file
    *   We implement using a class that extends the WebSecurityConfigurerAdapter
        interface....


url : https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/WebSecurityConfigurer.html


Interface WebSecurityConfiguerer<T extends SecurityBuilder<javax.servlet.Filter>>

All known implementing Classes:

WebSecurityConfiguererAdapter


Allows customization to the WebSecurity. In most instances users will use EnableWebSecurity and a create Configuration that extends WebSecurityConfigurerAdapter which will automatically be applied to the WebSecurity by the EnableWebSecurity annotation.







