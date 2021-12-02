package com.dlu.controller;

import com.dlu.pojo.Bgm;
import com.dlu.pojo.User;
import com.dlu.pojo.Video;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "使用swagger的 @ApiModel注解 须在controller 使用 @RequestBody 注解 否则无法显示models")
public class SwaggerController {

    @RequestMapping("user")
    public String hello1(@RequestBody User user){
        return user.toString();
    }

    @RequestMapping("bgm")
    public String hello2(@RequestBody Bgm bgm){
        return bgm.toString();
    }

    @RequestMapping("video")
    public String hello3(@RequestBody Video video){
        return video.toString();
    }
}
