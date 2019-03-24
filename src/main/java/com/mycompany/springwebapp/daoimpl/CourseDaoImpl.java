/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.daoimpl;

import com.mycompany.springwebapp.dao.CourseDao;
import com.mycompany.springwebapp.model.Course;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Siron
 */
@Repository
public class CourseDaoImpl implements CourseDao {
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(Course cm) {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.persist(cm);
        session.getTransaction().commit();
        session.close();
    }

    

    @Override
    public void update(Course cm) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(cm);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public void delete(int id) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course cm = new Course();
        cm.setId(id);
        session.delete(cm);
        session.getTransaction().commit();
        session.close();
       
    }

    @Override
    public List<Course> selectAll() {
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        List<Course> cl= session.createQuery("FROM Course").list();
        session.close();
        return cl;
    }

        @Override
    public Course selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
  //      Course cm = session.find(Course.class, id);
  
  //      Course cm = (Course) session.createCriteria(Course.class)
   //             . add(Restrictions.eq("id", id)). list(). get(0);
   
   // Course cm = session.get(Course.class, id);
   
        Course cm =  session.byId(Course.class).getReference(id);
        if(!Hibernate.isInitialized(cm)){
            System.out.println("loading course object..");
            Hibernate.initialize(cm);
        }
   //    System.out.println(cm.getTitle()); 
        session.close();
        return cm;
        
    }
    
}
