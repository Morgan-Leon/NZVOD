/** Created on 2016年10月12日 上午11:28:31 By lyn*/

package com.lyn.nzvod.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyn.nzvod.dto.VideoDTO;
import com.lyn.nzvod.model.Grade;
import com.lyn.nzvod.model.Subject;
import com.lyn.nzvod.model.Video;
import com.lyn.nzvod.service.GradeService;
import com.lyn.nzvod.service.SubjectService;
import com.lyn.nzvod.service.VideoService;
import com.lyn.nzvod.todo.dto.TodoDTO;

/**
 * @author lyn
 *
 */
@Controller
@RequestMapping(value="/api")
public class MainController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    
    private VideoService videoService;
    private GradeService gradeService;
    private SubjectService subjectService;
    
    @Autowired
    public MainController(VideoService videoService,
    				GradeService gradeService,
    				SubjectService subjectService) {
        this.videoService = videoService;
        this.gradeService = gradeService;
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage() {
        LOGGER.debug("Rendering home page.");
        return null;
    }
    
    @RequestMapping(value = "/grade", method = RequestMethod.POST)
    @ResponseBody
    public Grade addGrade(@Valid @RequestBody String gradeName) {
    	LOGGER.debug("Adding a new to-do entry with information: {}", gradeName);
        Grade added = gradeService.add(gradeName);
        LOGGER.debug("Added a to-do entry with information: {}", added);
        return added;
    }
    
    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    @ResponseBody
    public List<Grade> findAllGrades() {
        List<Grade> models = gradeService.findAll();
        LOGGER.debug("Found {} to-do entries.", models.size());
        return models;
    }
    
    @RequestMapping(value = "/subject", method = RequestMethod.POST)
    @ResponseBody
    public Subject addSubject(@Valid @RequestBody String subjectName) {
    	LOGGER.debug("Adding a new to-do entry with information: {}", subjectName);
        Subject added = subjectService.add(subjectName);
        LOGGER.debug("Added a to-do entry with information: {}", added);
        return added;
    }
    
    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    @ResponseBody
    public List<Subject> findAllSubjects() {
        List<Subject> models = subjectService.findAll();
        LOGGER.debug("Found {} to-do entries.", models.size());
        return models;
    }
    
    @RequestMapping(value = "/video", method = RequestMethod.POST)
    @ResponseBody
    public Video addVideo(@Valid @RequestBody VideoDTO videoDto) {
    	LOGGER.debug("Adding a new to-do entry with information: {}", videoDto);
        Video added = videoService.add(videoDto);
        LOGGER.debug("Added a to-do entry with information: {}", added);
        return added;
    }
    
    @RequestMapping(value = "/video/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Video findAVideo(@PathVariable("id") long id) {
        Video model = videoService.findById(id);
        LOGGER.debug("Found {} to-do entries.", model);
        return model;
    }
    
    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    @ResponseBody
    public List<Video> findAllVideos() {
        List<Video> models = videoService.findAll();
        LOGGER.debug("Found {} to-do entries.", models.size());
        return models;
    }
    
    @RequestMapping(value = "/subject/{subjectId}/grade/{gradeId}/videos", method = RequestMethod.GET)
    @ResponseBody
    public List<Video> findVideosBySubjectAndGrade(@PathVariable("gradeId") long gradeId,
    											   @PathVariable("subjectId") long subjectId) {
        List<Video> models = videoService.findBySubjectAndGrade(subjectId, gradeId);
        LOGGER.debug("Found {} video entries.", models.size());
        return models;
    }
    
    @RequestMapping(value = "/videos/conditions", method = RequestMethod.GET)
    @ResponseBody
    public List<Video> searchVideosByName(
    	    @RequestParam(value = "name", required = false) String name,
    	    @RequestParam(value = "subjectId", required = false) long subjectId,
    	    @RequestParam(value = "gradeId", required = false)  long gradeId) {
    	List<Video> models;
        if (name == null || name == "") {
			return findVideosBySubjectAndGrade(gradeId, subjectId);
		}
        else {
        	models = videoService.searchByName(name, subjectId, gradeId);
        }
        LOGGER.debug("Found {} video entries.", models.size());
        return models;
    }
    
    
    
}
