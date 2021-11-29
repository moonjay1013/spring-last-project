package com.dlu.dao;

import com.dlu.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface VideoDao extends JpaRepository<Video,Integer> {
    @Modifying
    @Query("update videos v set v.videoPath = ?1, v.coverPath = ?2, v.videoDesc = ?3 where v.id = ?4")
    void updateById(String videoPath, String coverPath, String videoDesc, Integer id);

    @Query(value = "select * from videos v where v.user_id = ?1", nativeQuery = true)
    List<Video> findAllByUserId(Integer user_id);
}
