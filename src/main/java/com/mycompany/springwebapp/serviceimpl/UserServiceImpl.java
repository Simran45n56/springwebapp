/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.serviceimpl;

import com.mycompany.springwebapp.dao.UserDao;
import com.mycompany.springwebapp.model.UserDetail;
import com.mycompany.springwebapp.model.UserDto;
import com.mycompany.springwebapp.service.UserService;
import java.io.File;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author test
 */

//dependency management can handel the the object so thats why we make interfaces.....
@Service
//we did notmade ittransactionalsince it does not 
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;
    
    private static final String UPLOAD_DIR = "C:\\Users\\Siron\\Desktop\\springwebappImages";

    @Override
    public boolean uploadImage(MultipartFile image) {
         boolean status = false;//this does not have to go to the Dao.... the work is done here to upload the image
         
         File dir = new File(UPLOAD_DIR + File.separator + "users");
         if(!dir.exists()){
             dir.mkdirs();
         }
         
         String filename = image.getOriginalFilename();
         File uploaddir = new File(dir+File.separator+filename);
         
         try{
             image.transferTo(uploaddir);
             status = true;
         }catch(Exception e){
             System.out.println(e);
         }
         
         return status;
    }

  

    @Override
    public ArrayList<UserDetail> getAllUsers() {
        return userDao.selectAll();
    }

    @Override
    public boolean saveUser(UserDto user) {
        return userDao.insert(user);
    }
    
}
