package com.dlu.dao;

import com.dlu.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDao extends JpaRepository<Video,Integer> {
}
