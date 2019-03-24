/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.dao;

import com.mycompany.springwebapp.model.UserDetail;
import com.mycompany.springwebapp.model.UserDto;
import java.util.ArrayList;

/**
 *
 * @author Siron
 */
public interface UserDao {
    
    public boolean insert(UserDto user);
    
    public ArrayList<UserDetail> selectAll();
    
}
