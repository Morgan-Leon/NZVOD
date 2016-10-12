/** Created on 2016年10月12日 上午10:20:45 By lyn*/

package com.lyn.nzvod.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyn.nzvod.model.Grade;
import com.lyn.nzvod.repository.GradeRepository;
import com.lyn.nzvod.repository.SubjectRepository;
import com.lyn.nzvod.repository.VideoRepository;
//
/**
 * @author lyn
 *
 */
@Service
public class GradeRepositoryService implements GradeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoRepositoryService.class);
	private VideoRepository videoRepo;
	private GradeRepository gradeRepo;
	private SubjectRepository subjectRepo;
	
    @Autowired
    public GradeRepositoryService(VideoRepository videoRepo,GradeRepository gradeRepo, SubjectRepository subjectRepo)
    {
    	this.videoRepo = videoRepo;
    	this.gradeRepo = gradeRepo;
    	this.subjectRepo = subjectRepo;
    }
    

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.GradeService#add(com.lyn.nzvod.model.Grade)
	 */
	@Override
	public Grade add(String name) {
		// TODO Auto-generated method stub
		Grade grade = new Grade(name);
		
		return gradeRepo.saveAndFlush(grade);
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.GradeService#date(java.lang.Long)
	 */
	@Override
	public Grade date(Long GradeID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.GradeService#findById(java.lang.Long)
	 */
	@Override
	public Grade findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.GradeService#deleteById(java.lang.Long)
	 */
	@Override
	public Grade deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.GradeService#findAll()
	 */
    @Transactional(readOnly = true)
    @Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		
		return gradeRepo.findAll();
	}
	

}
