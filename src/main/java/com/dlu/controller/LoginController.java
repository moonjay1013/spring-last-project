package com.dlu.controller;

import com.dlu.pojo.User;
import com.dlu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author moonjay
 */
@Controller
@Api(tags = "登陆注册相关Api")
public class LoginController {
    @Autowired
    private UserService userService;

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @ResponseBody
    @RequestMapping("/hello")
    String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/login")
    @ApiOperation(value = "Login", notes = "从DB查询用户信息验证登录，不登录则无法访问主界面")
    public String doLogin(@RequestParam(name = "name",required=false)String name, @RequestParam(name = "pwd",required=false)String pwd,
                          Model model, Map<String, Object> map, HttpSession session, User user) {
        User userFind = userService.findUser(name,pwd);
        model.addAttribute("user",user);
        if (userFind != null){
            if (userFind.getName().equals(name) && userFind.getPwd().equals(pwd)) {
                session.setAttribute("user", userFind);
                log.info("登陆成功，用户名：" + userFind.getName());
                //防止重复提交使用重定向
                return "redirect:/index";
            } else {
                map.put("msg", "用户名或密码错误");
                log.error("登陆失败");
                return "login";
            }
        }else {
            // 注销session
            session.invalidate();
            return "login";
        }
    }

    // 用户注册跳转页

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request){
        // 这里获得session是为了在登陆成功的后台界面显示用户信息
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }
}
