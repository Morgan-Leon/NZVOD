package com.lyn.nzvod.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lyn.nzvod.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
	@Query("SELECT Distinct(v) FROM Video v WHERE v.name like ('%' || :name || '%')  "
			  + "AND v.subjectId=(:subjectId) AND gradeId=(:gradeId) "
			  + "AND v.deleted=0 ORDER BY v.modificationTime DESC")
	ArrayList<Video> searchByName(
			@Param("name")String name,
			@Param("subjectId")Long subjectId,
			@Param("gradeId")Long gradeId);
	
	@Query("SELECT Distinct(v) FROM Video v WHERE subjectId=(:subjectId)"
		  +" AND gradeId=(:gradeId) AND v.deleted=0 ORDER BY v.modificationTime DESC")
	ArrayList<Video> findBySubjectIdAndGradeId(
											   @Param("subjectId")Long subjectId,
											   @Param("gradeId")Long gradeId);
	
	@Query("SELECT Distinct(v) FROM Video v WHERE v.gradeId=(:gradeId) AND v.deleted=0 ORDER BY v.modificationTime DESC")
	ArrayList<Video> findByGradeId(@Param("gradeId")Long gradeId);
	
	
	@Query("SELECT Distinct(v) FROM Video v WHERE v.subjectId=(:subjectId) AND v.deleted=0 ORDER BY v.modificationTime DESC")
	ArrayList<Video> findBySubjectId(@Param("subjectId")Long subjectId);
}	
