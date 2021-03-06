/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Siron
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.mycompany.springwebapp"})
public class WebMVCConfig implements WebMvcConfigurer {
    
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver vr=
                new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        return vr;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        
        registry
                .addResourceHandler("/resources/**")
                 .addResourceLocations("/resources/","/other-resouces/")
                 .setCachePeriod(3600)
                  .resourceChain(true)
                  .addResolver(new PathResourceResolver());
                
                
    }
//    <bean id="multipartResolver" class="org.spring"
    
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver mr= new CommonsMultipartResolver();
        mr.setMaxUploadSize(100000000L);
        return mr;
       
    }
    
    @Bean
    public PasswordEncoder bcryptEncoder(){
        
        return new BCryptPasswordEncoder();
        
    }
    
}
