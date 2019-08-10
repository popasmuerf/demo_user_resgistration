package io.thirdplanet.demo_user_resgistration.security;



import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod ;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder ;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity ;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter ;

import org.springframework.boot.autoconfigure.security.SecurityProperties;


/**
 * Here we crated a class named SpringSecurityConfiguration_InMemory and 
 * annotated this class with the 
 * @Configuration annotation, which is a Spring annotationc and makes this
 * class a configration class.  We extended this class with the
 * WebSecurityConfigurerAapter class, which allows you to configure 
 * Spring Security and override the default methods for our application.
 * 
 * We have authentication of two users (user and admin) and their roles
 * of USER an ADMIN roles, whereas user has only the USER role.
 * 
 * 
 * To configure in-memmory authentication, you use the configureGlobal method.
 * You annotated this method with the @Autowired annotation.  This method has an
 * argument of tyhpe AuthenticationManagerBuilder
 */





@Configuration 
public class SpringSecurityConfiguration_InMemory extends WebSecurityConfigurerAdapter{

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
        .withUser("user")
        .password("{noop}password")
        .roles("USER");

        auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}password")
        .roles("USER","ADMIN");
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        /*
        httpSecurity.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET,"/api/user/users")
        .hasRole("USER")
        .antMatchers(HttpMethod.POST,"/api/user")
        .hasRole("USER")
        .antMatchers(HttpMethod.PUT,"/api/user/**")
        .hasRole("USER")
        .antMatchers(HttpMethod.DELETE,"/api/user/**")
        .hasRole("ADMIN")
        .and()
        .csrf()
        .disable() ;
        */
        httpSecurity.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/api/user/users").hasRole("USER")
        .antMatchers("/api/user/**").hasRole("USER")
        .and()
        .csrf()
        .disable();

    }
    


}