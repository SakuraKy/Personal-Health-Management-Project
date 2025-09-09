package com.atsakuraky.sportplay.controller;


import com.alibaba.fastjson.JSON;
import com.atsakuraky.sportplay.bean.User;
import com.atsakuraky.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    //`@RestController` 注解用于标记一个类为 Spring Boot 的 RESTful 控制器。它的作用是让该类中的方法返回的数据自动序列化为 JSON 或 XML，并直接作为 HTTP 响应体返回，而不是跳转到某个视图页面。这样可以方便地开发 API 接口。
    public String login(@RequestBody User user) {
        String flag = "error";
        User us = userDao.getUserByMessage(user.getUsername(), user.getPassword());
        System.out.println("user:" + us);
        HashMap<String, Object> res = new HashMap<>();
        if (us != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", user);
        /*
         * @RestController：方法返回值会自动转换为JSON并作为HTTP响应体
         * 那为什么还要使用JSON.toJSONString()呢？
         * 因为如果不使用的话，HashMap对象不能return
         * return的类型只能是String
         */

        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
