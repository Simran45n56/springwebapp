/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.serviceimpl;

import com.mycompany.springwebapp.dao.CourseDao;
import com.mycompany.springwebapp.model.Course;
import com.mycompany.springwebapp.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Siron
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseDao courseDao;

    @Override
    public void addCourse(Course cm) {
        
        courseDao.insert(cm);
       
    }

    @Override
    public List<Course> getAllCourse() {
        
        return courseDao.selectAll();
       
    }

    @Override
    public Course getCourseById(int id) {
        
      return courseDao.selectById(id);
      
       
    }

    @Override
    public void updateCourse(Course cm) {
       courseDao.update(cm);
    }

    @Override
    public void deleteCourse(int id) {
        courseDao.delete(id);
    }
    
}
