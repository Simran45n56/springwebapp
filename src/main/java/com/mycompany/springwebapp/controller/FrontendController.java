/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.controller;

import com.mycompany.springwebapp.model.UserDto;
import com.mycompany.springwebapp.service.UserService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Siron
 */
@Controller
public class FrontendController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UserService userService;
    
      @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return "login" ;
    }
    
   
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
        return "home" ;
    }
    
    @RequestMapping(value="/aboutus",method=RequestMethod.GET)
    public String abPage(){
        return "aboutus";
    }
    @RequestMapping(value="/contactus",method=RequestMethod.GET)
    public String conPage(){
        return "contactus";
    }
     @RequestMapping(value="/service",method=RequestMethod.GET)
    public String serPage(){
        return "service";
    }
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String regUser(){
        return "user_registration";
    }
       @RequestMapping(value="/register",method=RequestMethod.POST)
    public String regNewUser(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastName,
            @RequestParam("dob") String dob,
            @RequestParam("image") MultipartFile image,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword,
            @RequestParam("authority") String authority ){
            
            if(!password.equals(cpassword)){
                return "redirect:/register?PasswordMismatch";
    }
    
    //upload image here
    //return boolean
    
    
    
   // userService.uploadImage(image);
    
            UserDto user= new UserDto();
            user.setFirstName(firstname);
            user.setLastName(lastName);
            user.setDob(LocalDate.parse(dob));
            user.setImage(image.getOriginalFilename());
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setAuthority(authority);
            
            System.out.println("image: "+user.getImage());
              System.out.println("pass: "+user.getPassword());
            userService.saveUser(user);
            
            
           
    
 
        
        return "user_registration";
    }
    
}
