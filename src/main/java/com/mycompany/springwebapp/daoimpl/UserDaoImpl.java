/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.daoimpl;

import com.mycompany.springwebapp.dao.UserDao;
import com.mycompany.springwebapp.model.UserDetail;
import com.mycompany.springwebapp.model.UserDto;
import com.mycompany.springwebapp.model.UserRole;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Siron
 */

@Repository
@Transactional

public class UserDaoImpl implements UserDao {
    
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public boolean insert(UserDto user) {
        
        boolean status = false;
         try(Session session = sessionFactory.openSession()){
             
             session.beginTransaction();
        
        UserDetail ud= new UserDetail();
        UserRole ur= new UserRole();
        
        //prepare userDetail
        
        ud.setFirstName(user.getFirstName());
        ud.setLastName(user.getLastName());
        ud.setDob(java.sql.Date.valueOf(user.getDob()));
        ud.setEmail(user.getEmail());
        ud.setPassword(user.getPassword());
        ud.setPassword(user.getPassword());
        ud.setImage(user.getImage());
        
        
        if(user.getAuthority().equals("ROLE_USER")){
            ud.setActive("1");
        }else{
            ud.setActive("0");
        }
        
        //prepare userRole
        
        ur.setRole(user.getAuthority());
        
        //make a bidirectional relation
        ud.setUserRole(ur);
        ur.setUserDetail(ud);
        
        //save both in database
        
        session.persist(ud);
        session.getTransaction().commit();
       // session.close();
        status=true;
    }
    return status;
    }

    @Override
    public ArrayList<UserDetail> selectAll() {
        return null;
    }
    
}
