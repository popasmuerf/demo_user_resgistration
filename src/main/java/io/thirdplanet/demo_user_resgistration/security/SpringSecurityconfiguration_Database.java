package io.thirdplanet.demo_user_resgistration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import io.thirdplanet.demo_user_resgistration.service.UserInfoDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityconfiguration_Database extends WebSecurityConfigurerAdapter{


        @Autowired
        private UserInfoDetailsService userInfoDetailsService ;

        @Override
        protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
            authenticationManagerBuilder.userDetailsService(userInfoDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/user/**")
            .authenticated()
            .and()
            .httpBasic()
            .realmName("User Registration System")
            .and()
            .csrf()
            .disable();
        }


}