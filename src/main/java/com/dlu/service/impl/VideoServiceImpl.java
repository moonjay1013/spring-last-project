package com.dlu.service.impl;

import com.dlu.dao.VideoDao;
import com.dlu.pojo.Video;
import com.dlu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("VideoService")
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public void addVideo(Video video) {
        videoDao.save(video);
    }

    @Override
    public void deleteVideo(Integer id) {
        Video video = videoDao.getById(id);
        videoDao.delete(video);
    }

    @Override
    public void updateVideo(String videoPath, String coverPath, String videoDesc, Integer id) {
        videoDao.updateById(videoPath,coverPath,videoDesc,id);
    }

    @Override
    public List<Video> findAllById(Integer id) {
        return videoDao.findAllByUserId(id);
    }
}
