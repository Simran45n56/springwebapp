/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Siron
 */
@Entity
@Table(name="course_table")
public class Course implements Serializable {
    
    private static final long serialVersionUID = 10003L;
    
    
    @Id //primary key
    @GeneratedValue(strategy=GenerationType.AUTO) //Auto increment
    @Column (name="course_id")
    private int id;
    @Column (name="course_title")
    private String title;
    @Column (name="course_duration")
    private String duration;
    @Column (name="course_fee")
    private double fee;

    public Course() {
    }

    public Course(int id, String title, String duration, double fee) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
    
    
    
}
