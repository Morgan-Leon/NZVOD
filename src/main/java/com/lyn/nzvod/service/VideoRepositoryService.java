/** Created on 2016年10月11日 下午8:34:22 By lyn*/

package com.lyn.nzvod.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lyn.nzvod.model.Grade;
import com.lyn.nzvod.model.Subject;
import com.lyn.nzvod.model.Video;
import com.lyn.nzvod.repository.GradeRepository;
import com.lyn.nzvod.repository.SubjectRepository;
import com.lyn.nzvod.repository.VideoRepository;

/**
 * @author lyn
 *
 */
public class VideoRepositoryService implements VideoService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoRepositoryService.class);
	private VideoRepository videoRepo;
	private GradeRepository gradeRepo;
	private SubjectRepository subjectRepo;
	
    @Autowired
    public VideoRepositoryService(VideoRepository movingInfoRepo)
    {
    	this.videoRepo = videoRepo;
    }
    

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#add(com.lyn.nzvod.model.Video)
	 */
	@Override
	public Video add(Video Video) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#date(java.lang.Long)
	 */
	@Override
	public Video date(Long VideoID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#findById(java.lang.Long)
	 */
	@Override
	public Video findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#deleteById(java.lang.Long)
	 */
	@Override
	public Video deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
