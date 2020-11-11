package com.upgrad.hirewheels.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfigurerAdapter {
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    }

    protected void configure(HttpSecurity http) throws Exception{

    }
}
