/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author test
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        
        auth.jdbcAuthentication().dataSource(dataSource)//authenacation....
                .usersByUsernameQuery("select email, password, active from user_detail where email=?")
            .authoritiesByUsernameQuery("select email, role from user_role where email=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN") //ROLE_ADMIN
                .antMatchers("/**").hasAnyRole("ADMIN","USER") //ROLE_ADMIN / ROLE_USER
                .and()
            .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
            .csrf()
                .disable()
            .httpBasic(); //Authenticate users with http basics authentacitation....
                
    }
    
//    @Bean
//    public UserDetailsService userDetailsService(){//this will validate and authorize  user name and password .....
//        
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); 
//        
//        manager.createUser(
//                            User
//                                .withDefaultPasswordEncoder()
//                                .username("admin")
//                                .password("admin")
//                                .roles("USER")
//                                .build()
//                            );
//
//       return manager; 
//    }
    
    
    
}
