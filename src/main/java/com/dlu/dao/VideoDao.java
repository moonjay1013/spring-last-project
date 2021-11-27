package com.dlu.dao;

import com.dlu.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface VideoDao extends JpaRepository<Video,Integer> {
    @Modifying
    @Query("update videos v set v.videoPath = ?1, v.coverPath = ?2 where v.id = ?3")
    void updateById(String videoPath, String coverPath, Integer id);
}
