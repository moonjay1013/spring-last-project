package com.dlu.controller;

import com.dlu.pojo.Bgm;
import com.dlu.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "Bgm表的CRUD操作")
public class BgmController {
    @Autowired
    private BgmService bgmService;

    /**bgm添加功能  重定向到基本表页面*/
    @PostMapping("/addBgm")
    public String addBgm(@ModelAttribute Bgm bgm){
        // bgm的path前加上相对路径
        String path = bgm.getPath();
        bgm.setPath("/bgm/"+path);
        bgmService.addBgm(bgm);
        return "redirect:/table/basic";
    }

    /**bgm更新页*/
    @GetMapping({"/updateB/{id}"})
    public String toUpdateBgm(@PathVariable("id") Integer id, Model model) {
        Bgm bgm = bgmService.getById(id);
        model.addAttribute("bgm", bgm);
        return "updateBgm";
    }

    /**更新bgm*/
    @RequestMapping({"/updateBgm"})
    public String updateBgm(@ModelAttribute Bgm bgm) {
        bgmService.updateBgm(("/bgm/" + bgm.getPath()),bgm.getMusicName(),bgm.getAuthor(), bgm.getId());
        return "redirect:/table/basic";
    }

    /**删除bgm 重定向到基本表页面*/
    @RequestMapping({"/deleleBgm"})
    public String del(Bgm bgm) {
        bgmService.delBgm(bgm.getId());
        return "redirect:/table/basic";
    }
}
