package com.lyn.nzvod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.nzvod.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
