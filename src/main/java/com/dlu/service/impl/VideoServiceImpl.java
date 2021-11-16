package com.dlu.service.impl;

import com.dlu.dao.VideoDao;
import com.dlu.pojo.Video;
import com.dlu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
