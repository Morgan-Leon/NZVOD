/** Created on 2016年10月12日 上午11:28:31 By lyn*/

package com.lyn.nzvod.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyn.nzvod.model.Grade;
import com.lyn.nzvod.service.GradeService;
import com.lyn.nzvod.service.SubjectService;
import com.lyn.nzvod.service.VideoService;

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
    public MainController(VideoService videoService,GradeService gradeService, SubjectService subjectService) {
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
    public List<Grade> findAll() {
        LOGGER.debug("Finding all todo entries.");
        List<Grade> models = gradeService.findAll();
        LOGGER.debug("Found {} to-do entries.", models.size());

        return models;
    }
}
