package com.lyn.nzvod.todo.repository;

import com.lyn.nzvod.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Petri Kainulainen
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
