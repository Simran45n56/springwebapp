/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.service;

import com.mycompany.springwebapp.model.UserDetail;
import com.mycompany.springwebapp.model.UserDto;
import java.util.ArrayList;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Siron
 */
public interface UserService {
    
    public boolean uploadImage(MultipartFile file);
    
    public boolean saveUser(UserDto user);
    
    public ArrayList<UserDetail> getAllUsers();
    
    
    
}
