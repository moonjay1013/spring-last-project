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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/layout/blank")
    public String blank(Model model,Bgm bgm){
        model.addAttribute("bgm",bgm);
        return "blank_page";
    }

    @PostMapping("/addBgm")
    public String add(@ModelAttribute Bgm bgm){
        bgmService.addBgm(bgm);
        return "redirect:/table/basic";
    }

    @RequestMapping(value = "/layout/boxed")
    public String boxed(){ return "boxed_view"; }

    @RequestMapping(value = "/layout/left")
    public String left(Model model){
        List<Video> videoList = videoService.findAll();
        model.addAttribute("videos",videoList);
        return "left_video_gallery";
    }

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

    @RequestMapping(value = "/table/dynamic")
    public String dynamic(Model model){
        List<Video> videoList = videoService.findAll();
        List<Bgm> bgmList = bgmService.findAll();
        model.addAttribute("videos",videoList);
        model.addAttribute("bgms",bgmList);
        return "dynamic_table"; }

    @RequestMapping(value = "/table/editable")
    public String editable(Model model){
//        List<User> userList = userService.getAllUser();
//        model.addAttribute("users",userList);
        return "editable_table";
    }

    @RequestMapping(value = "/extra/profile")
    public String profile(){ return "profile"; }

    @RequestMapping(value = "/extra/404")
    public String notFound(){ return "error/404"; }

    @RequestMapping(value = "/extra/500")
    public String errorPage(){ return "error/500"; }

    @RequestMapping(value = "/extra/lock")
    public String lock(){
        return "lock_screen";
    }
}
