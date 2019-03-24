/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.controller;

import com.mycompany.springwebapp.model.Course;
import com.mycompany.springwebapp.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Siron
 */
@Controller
@RequestMapping("/admin/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    
    
    @GetMapping("/add")
    public String addCoursePage(){
        return "admin/addcourse";
    }
    
    @PostMapping("/add")
    public String saveCourse(@RequestParam("ctitle")String title,
            @RequestParam("cduration")String duration,
            @RequestParam("cprice")double fee){
        Course cm= new Course();
        cm.setTitle(title);
        cm.setDuration(duration);
        cm.setFee(fee);
        
        System.out.println("title: "+title);
         System.out.println("duration: "+duration);
          System.out.println("fee: "+fee);
        
        //save this object into database
        courseService.addCourse(cm);
        return "redirect:/admin/course/display";
        
    }
    
    @GetMapping("/display")
    public String showCourse(Model model){
        List<Course> cl= courseService.getAllCourse();
        model.addAttribute("courselist", cl);
        return "admin/addcourse";
    }
    
    @GetMapping("/edit/{id}")
    public String editCourse( @PathVariable("id") int id,Model model){
        Course c= courseService.getCourseById(id);
        System.out.println(c.getId()+""+c.getTitle());
        model.addAttribute("course",c);
        model.addAttribute("edit","true");
        return showPage(model);
      
    }
    
     @PostMapping("/update")
    public String updateCourse( 
            @RequestParam("cid")int id,
            @RequestParam("ctitle") String title,
            @RequestParam("cduration") String duration,
            @RequestParam("cprice") double price){
        
        Course cm = new Course(id,title,duration,price);
        courseService.updateCourse(cm);
        return "redirect:/admin/course/display#showCourse";
    }
    
    private String showPage(Model model){
        model.addAttribute("courselist", courseService.getAllCourse());
        return "admin/addcourse";
    }
    
    @GetMapping("/delete/{id}")
    public String hbsha(@PathVariable("id") int id){
        courseService.deleteCourse(id);
        return "redirect:/admin/course/display#showCourse";
    }
    
    
}
