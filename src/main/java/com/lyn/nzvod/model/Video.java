package com.lyn.nzvod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lyn.nzvod.common.model.AbstractEntity;

@Entity
@Table(name="video")
public class Video extends AbstractEntity{

	public static final int MAX_LENGTH_URL = 1000;
	public static final int MAX_LENGTH_NAME = 100;
	
    @Column(name = "name", nullable = false, length = MAX_LENGTH_NAME)
    private String name;
    
    @Column(name = "url", nullable = false, length = MAX_LENGTH_NAME)
    private String url;
    
    @Column(name = "author", nullable = true, length = MAX_LENGTH_NAME)
    private String author;
    
    @Column(name = "uploadUser", nullable = true, length = MAX_LENGTH_NAME)
    private String uploadUser;
    	
    @Column(name = "views", nullable = true)
    private int views;
    
    
}
