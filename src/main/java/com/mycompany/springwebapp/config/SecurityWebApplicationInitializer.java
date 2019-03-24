/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Siron
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    
    //Default Configuration
   //
  //  protected void configure(HttpSecurity http) throws Exception{
//        http
//                .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                    .and()
//                .httpBasic();
//    }

//        protected void configure(HttpSecurity http) throws Exception{
//            http
//                      .authorizeRequests()
//                   .anyRequest().authenticated()
//                   .and()
//                .formLogin()
//                   .loginPage("/login").permitAll()
//                    
//                    .and()
//                    .httpBasic();
//                    
//                    
//                }
   }

//The updated configuration specifies the location of the log in page.
//We must grant all the users (ie unauthenticated users) access to our login Page.
// The formLogin().permitAll( )method allows granting access to all the users for all URLs.
    

