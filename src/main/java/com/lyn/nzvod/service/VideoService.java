package com.lyn.nzvod.service;

import java.util.List;

import com.lyn.nzvod.model.Video;
import com.lyn.nzvod.todo.model.Todo;

/**
 * @author Morgan-Leon
 * @Date 2016年10月3日
 * 
 */
public interface VideoService {

		
    public Video add(Video Video);

    public Video date(Long VideoID);

    public Video findById(Long id);

    public Video deleteById(Long id);
    
    /**
     * Returns a list of to-do entries.
     * @return
     */
    public List<Video> findAll();


//	Page<Video> findAll(Pageable pageable);

}
