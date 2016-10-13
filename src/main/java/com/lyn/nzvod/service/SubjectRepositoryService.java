/** Created on 2016年10月12日 上午10:21:17 By lyn*/

package com.lyn.nzvod.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyn.nzvod.model.Subject;
import com.lyn.nzvod.repository.GradeRepository;
import com.lyn.nzvod.repository.SubjectRepository;
import com.lyn.nzvod.repository.VideoRepository;

/**
 * @author lyn
 *
 */
@Service
public class SubjectRepositoryService implements SubjectService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoRepositoryService.class);
	private VideoRepository videoRepo;
	private GradeRepository gradeRepo;
	private SubjectRepository subjectRepo;
	
    @Autowired
    public SubjectRepositoryService(VideoRepository videoRepo,GradeRepository gradeRepo, SubjectRepository subjectRepo)
    {
    	this.videoRepo = videoRepo;
    	this.gradeRepo = gradeRepo;
    	this.subjectRepo = subjectRepo;
    }
    

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.SubjectService#add(com.lyn.nzvod.model.Subject)
	 */
	@Override
	public Subject add(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.SubjectService#date(java.lang.Long)
	 */
	@Override
	public Subject date(Long SubjectID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.SubjectService#findById(java.lang.Long)
	 */
	@Override
	public Subject findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.SubjectService#deleteById(java.lang.Long)
	 */
	@Override
	public Subject deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.SubjectService#findAll()
	 */
	@Override
	public List<Subject> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
