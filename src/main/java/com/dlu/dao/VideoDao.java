package com.dlu.dao;

import com.dlu.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface VideoDao extends JpaRepository<Video,Integer> {
    @Modifying
    @Query("update videos v set v.videoPath = ?1 where v.id=?2")
    void updateById(String videoPath, Integer id);
}
