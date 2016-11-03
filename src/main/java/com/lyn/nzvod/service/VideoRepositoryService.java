/** Created on 2016年10月11日 下午8:34:22 By lyn*/

package com.lyn.nzvod.service;

import java.awt.image.BandedSampleModel;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyn.nzvod.dto.VideoDTO;
import com.lyn.nzvod.model.Grade;
import com.lyn.nzvod.model.Subject;
import com.lyn.nzvod.model.Video;
import com.lyn.nzvod.repository.GradeRepository;
import com.lyn.nzvod.repository.SubjectRepository;
import com.lyn.nzvod.repository.VideoRepository;
import com.lyn.nzvod.todo.exception.TodoNotFoundException;
import com.lyn.nzvod.todo.model.Todo;

import javassist.NotFoundException;

/**
 * @author lyn
 *
 */
@Service
public class VideoRepositoryService implements VideoService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoRepositoryService.class);
	private VideoRepository videoRepo;
	private GradeRepository gradeRepo;
	private SubjectRepository subjectRepo;
	
    @Autowired
    public VideoRepositoryService(VideoRepository videoRepo,GradeRepository gradeRepo, SubjectRepository subjectRepo)
    {
    	this.videoRepo = videoRepo;
    	this.gradeRepo = gradeRepo;
    	this.subjectRepo = subjectRepo;
    }
    

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#add(com.lyn.nzvod.model.Video)
	 */
	@Override
	public Video add(VideoDTO dto) {
		// TODO Auto-generated method stub
		Video video = Video.getBuilder(dto.getName(), dto.getUrl(), dto.getGradeId(),
				dto.getSubjectId(), dto.getAuthor(), dto.getUploadUser())
				.description(dto.getDescription()).build();
		
		return videoRepo.saveAndFlush(video);
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#date(java.lang.Long)
	 */
	@Override
	public Video date(long VideoID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#findById(java.lang.Long)
	 */
	@Override
	public Video findById(long id) {
		// TODO Auto-generated method stub
		return videoRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#deleteById(java.lang.Long)
	 */
	@Override
	public Video deleteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#findAll()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return videoRepo.findAll();
	}


	/* (non-Javadoc)
	 * @see com.lyn.nzvod.service.VideoService#findBySubjectAndGrade(long, long)
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Video> findBySubjectAndGrade(long subjectId, long gradeId) {
		// TODO Auto-generated method stub
		List<Video> vList;
		if (subjectId == 0 && gradeId == 0) {
			vList = videoRepo.findAll();
		}
		else if (subjectId == 0) {
			vList = videoRepo.findByGradeId(gradeId);
		}
		else if (gradeId == 0) {
			vList = videoRepo.findBySubjectId(subjectId);
		}
		else {
			vList = videoRepo.findBySubjectIdAndGradeId(subjectId, gradeId);
		}
		return vList;
	}


	@Override
	public List<Video> searchByName(String name, long subjectId, long gradeId) {
		// TODO Auto-generated method stub
		List<Video> vList;
		if (subjectId == 0 && gradeId == 0) {
			vList = videoRepo.searchByName(name);
		}
		else if (subjectId == 0) {
			vList = videoRepo.searchByNameAndGradeId(name, gradeId);
		}
		else if (gradeId == 0) {
			vList = videoRepo.searchByNameAndSubjectId(name, subjectId);
		}
		else {
			vList = videoRepo.findBySubjectIdAndGradeId(subjectId, gradeId);
		}
		return vList;
	}

}
