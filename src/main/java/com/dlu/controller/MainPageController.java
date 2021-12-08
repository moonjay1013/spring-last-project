package com.dlu.controller;

import com.dlu.pojo.*;
import com.dlu.service.*;
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private ReportService reportService;

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
        List<Comments> commentsList = commentService.findAll();
        List<UserReport> reportList = reportService.findAll();
        model.addAttribute("videos",videoList);
        model.addAttribute("bgms",bgmList);
        model.addAttribute("comments",commentsList);
        model.addAttribute("reports",reportList);
        return "dynamic_table";
    }

    /**bgm添加页*/
    @RequestMapping(value = "/layout/blank")
    public String blank(Model model, Bgm bgm){
        model.addAttribute("bgm",bgm);
        return "blank_page";
    }

    /**video添加页*/
    @RequestMapping(value = "/layout/boxed")
    public String boxed(Model model, Video video){
        model.addAttribute("video",video);
        return "boxed_view";
    }

    /**视频信息详情页*/
    @RequestMapping(value = "/layout/left")
    public String left(Model model){
        List<Video> videoList = videoService.findAll();
        model.addAttribute("videos",videoList);
        return "left_video_gallery";
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
