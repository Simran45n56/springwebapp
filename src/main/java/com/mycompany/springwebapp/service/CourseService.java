/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.service;

import com.mycompany.springwebapp.model.Course;
import java.util.List;

/**
 *
 * @author Siron
 */
public interface CourseService {
     public void addCourse(Course cm);
     public List<Course> getAllCourse();
     public Course getCourseById(int id);
     public void updateCourse(Course cm);
     public void deleteCourse(int id);
    
}
