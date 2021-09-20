//package com.RNubla.HelloSpringBoot.HelloSpringBoot.oauthConfig

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//
//@Configuration
//class SecurityConfig : WebSecurityConfigurerAdapter() {
//    override fun configure(httpSecurity: HttpSecurity){
//        httpSecurity.antMatcher("/**/**").authorizeRequests()
//            .antMatchers("/").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .oauth2Login();
//    }
//}