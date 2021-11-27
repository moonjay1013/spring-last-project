package com.dlu.service;

import com.dlu.pojo.Video;

import java.util.List;

public interface VideoService {
    List<Video> findAll();

    void addVideo(Video video);

    void deleteVideo(Integer id);

    void updateVideo(String videoPath,String coverPath,Integer id);
}
