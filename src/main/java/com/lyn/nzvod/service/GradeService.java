/** Created on 2016年10月11日 下午8:32:02 By lyn*/

package com.lyn.nzvod.service;

import java.util.List;

import com.lyn.nzvod.model.Grade;
import com.lyn.nzvod.todo.model.Todo;

/**
 * @author lyn
 *
 */
public interface GradeService {
    public Grade add(Grade Grade);

    public Grade date(Long GradeID);

    public Grade findById(Long id);

    public Grade deleteById(Long id);
    
    /**
     * Returns a list of to-do entries.
     * @return
     */
    public List<Grade> findAll();


//	Page<Grade> findAll(Pageable pageable);
}
