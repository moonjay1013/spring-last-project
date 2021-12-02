package com.dlu.controller;

import com.dlu.pojo.Bgm;
import com.dlu.pojo.User;
import com.dlu.pojo.Video;
import com.dlu.service.BgmService;
import com.dlu.service.UserService;
import com.dlu.service.VideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author moonjay
 */
@Controller
@Api(tags = "后台主界面Api")
public class MainPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private BgmService bgmService;

    /**bgm添加页*/
    @RequestMapping(value = "/layout/blank")
    public String blank(Model model,Bgm bgm){
        model.addAttribute("bgm",bgm);
        return "blank_page";
    }

    /**bgm添加功能  重定向到基本表页面*/
    @PostMapping("/addBgm")
    public String addBgm(@ModelAttribute Bgm bgm){
        // bgm的path前加上相对路径
        String path = bgm.getPath();
        bgm.setPath("/bgm/"+path);
        bgmService.addBgm(bgm);
        return "redirect:/table/basic";
    }

    /**删除bgm 重定向到基本表页面*/
    @RequestMapping({"/deleleBgm"})
    public String del(Bgm bgm) {
        bgmService.delBgm(bgm.getId());
        return "redirect:/table/basic";
    }

    /**video添加页*/
    @RequestMapping(value = "/layout/boxed")
    public String boxed(Model model,Video video){
        model.addAttribute("video",video);
        return "boxed_view";
    }

    /**video添加功能 重定向到基本表*/
    @PostMapping("/addVideo")
    public String addVideo(@ModelAttribute Video video){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
//        新加入的视频一些默认值--设置video初始状态
//        视频的默认创建时间为当前的日期，视频的长、宽默认为100
//        点赞数默认为0,状态码默认为0
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

    /**视频信息详情页*/
    @RequestMapping(value = "/layout/left")
    public String left(Model model){
        List<Video> videoList = videoService.findAll();
        model.addAttribute("videos",videoList);
        return "left_video_gallery";
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

    /**基本表 --用户、视频、bgm*/
    @RequestMapping(value = "/table/basic")
    public String basic(Model model){
        List<User> userList = userService.findAll();
        List<Video> videoList = videoService.findAll();
        List<Bgm> bgmList = bgmService.findAll();
        model.addAttribute("users",userList);
        model.addAttribute("videos",videoList);
        model.addAttribute("bgms",bgmList);
        return "basic_table";
    }

    /**动态表  模糊查询*/
    @RequestMapping(value = "/table/dynamic")
    public String dynamic(Model model){
        List<Video> videoList = videoService.findAll();
        List<Bgm> bgmList = bgmService.findAll();
        model.addAttribute("videos",videoList);
        model.addAttribute("bgms",bgmList);
        return "dynamic_table";
    }

    /**用户详情页 显示该用户上传的视频*/
    @RequestMapping(value = "/extra/profile/{id}")
    public String profile(Model model, @PathVariable Integer id){
        // 根据用户id查询其上传的所有视频
        List<Video> videoList = videoService.findAllById(id);
        model.addAttribute("vs",videoList);
        return "profile";
    }

    @RequestMapping(value = "/extra/404")
    public String notFound(){ return "error/404"; }

    @RequestMapping(value = "/extra/500")
    public String errorPage(){ return "error/500"; }

    @RequestMapping(value = "/extra/lock")
    public String lock(){
        return "lock_screen";
    }
}
