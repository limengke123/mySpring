package com.limengke.mySpring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.limengke.mySpring.model.User;
import com.limengke.mySpring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("showUser.do")
    public void selectUser(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping("showMyUser.do")
    @ResponseBody
    public User selectUser1 (
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        long userId = Long.parseLong(request.getParameter("id"));
        User user = userService.selectUser(userId);
        return user;
    }
}
