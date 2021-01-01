package com.fourspring.springtest.controller;

import com.fourspring.springtest.data.User;
import com.fourspring.springtest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * index 接口
 */
@RequestMapping("/")
@RestController
public class IndexController {
    @Autowired
    UserMapper userMapper;


    @GetMapping("/")
    public List<User> index() {
        System.out.println("index " + Thread.currentThread().getName());
        return userMapper.getUsers();
    }

    @GetMapping("/user/{id}")
    public User index(@PathVariable("id") Integer id) {
        System.out.println("index id " + Thread.currentThread().getName());
        return userMapper.getUser(id);
    }

    @GetMapping("/test/{msg}")
    public String testMsg(@PathVariable("msg") String msg) {
        return msg;
    }

}
