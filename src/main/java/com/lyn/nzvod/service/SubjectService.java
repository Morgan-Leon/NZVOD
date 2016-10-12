/** Created on 2016年10月11日 下午8:32:12 By lyn*/

package com.lyn.nzvod.service;

import java.util.List;

import com.lyn.nzvod.model.Subject;
import com.lyn.nzvod.model.Video;
import com.lyn.nzvod.todo.model.Todo;

/**
 * @author lyn
 *
 */
public interface SubjectService {
	
    public Subject add(Subject Subject);

    public Subject date(Long SubjectID);

    public Subject findById(Long id);
    
    /**
     * Returns a list of to-do entries.
     * @return
     */
    public List<Subject> findAll();


    public Subject deleteById(Long id);

//	Page<Subject> findAll(Pageable pageable);
}
