package com.lyn.nzvod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lyn.nzvod.common.model.AbstractEntity;

@Entity
@Table(name="grade")
public class Grade extends AbstractEntity{
	
	public static final int MAX_LENGTH_NAME = 100;
	
    @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	public Grade(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
    
    
}
