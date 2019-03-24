/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springwebapp.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author pc
 */
@Entity
@Table (name="user_role")
public class UserRole implements Serializable{
    private static final long serialVersionUID = 10103242L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_role_id")
    private int id;
    private String role;
    
    @OneToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
    @JoinColumn(name="user_detail_id", nullable=false)       
    
    private UserDetail userDetail;

    public UserRole() {
    }

    public UserRole(int id, String role, UserDetail userDetail) {
        this.id = id;
        this.role = role;
        this.userDetail = userDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
    
    
    
    
}
