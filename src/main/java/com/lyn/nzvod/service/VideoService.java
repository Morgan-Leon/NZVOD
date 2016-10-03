package com.lyn.nzvod.service;

import com.lyn.nzvod.model.Video;

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

//	    Page<Video> findAll(Pageable pageable);

}
