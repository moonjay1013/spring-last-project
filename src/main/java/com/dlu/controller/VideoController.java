package com.dlu.controller;


import com.dlu.pojo.Video;
import com.dlu.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Api(tags = "Video表的CRUD操作")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**video添加功能 重定向到基本表*/
    @PostMapping("/addVideo")
    public String addVideo(@ModelAttribute Video video){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        // 新加入的视频一些默认值--设置video初始状态
        // 视频的默认创建时间为当前的日期，视频的长、宽默认为100
        // 点赞数默认为0,状态码默认为0
        video.setStatus(0);
        video.setLikeCounts(0L);
        video.setCrateTime(currentTime);
        video.setVideoWidth(100);
        video.setVideoHeight(100);
        // 获取当前选择文件的path -- 正确格式为"/videos/..."，需要修改
        String vp = video.getVideoPath();
        String newV = "/videos/"+vp;
        video.setVideoPath(newV);
        String cp = video.getCoverPath();
        String newC = "/videos/"+cp;
        video.setCoverPath(newC);

        videoService.addVideo(video);
        return "redirect:/table/basic";
    }

    /**删除视频 重定向到详情页*/
    @RequestMapping("/del")
    public String del(Video video){
        videoService.deleteVideo(video.getId());
        return "redirect:/layout/left";
    }

    /**video更新功能
     * 根据id更新视频封面。路径和描述信息*/
    @RequestMapping("/update")
    public String update(Video video){
        videoService.updateVideo(video.getVideoPath(),video.getCoverPath(),video.getVideoDesc(),video.getId());
        return "redirect:/layout/left";
    }
}
