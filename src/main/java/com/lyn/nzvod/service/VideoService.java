package com.lyn.nzvod.service;

import java.util.List;

import com.lyn.nzvod.dto.VideoDTO;
import com.lyn.nzvod.model.Video;
import com.lyn.nzvod.todo.model.Todo;

/**
 * @author Morgan-Leon
 * @Date 2016年10月3日
 * 
 */
public interface VideoService {

		
    public Video add(VideoDTO videoDto);

    public Video date(long videoID);

    public Video findById(long id);

    public Video deleteById(long id);
    
    /**
     * Returns a list of to-do entries.
     * @return
     */
    public List<Video> findAll();
    
    public List<Video> findBySubjectAndGrade(long subjectId,long  gradeId);
    
    public List<Video> searchByName(String name, long subjectId, long gradeId);


//	Page<Video> findAll(Pageable pageable);

}
