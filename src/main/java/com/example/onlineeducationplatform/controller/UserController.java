package com.example.onlineeducationplatform.controller;

import com.example.onlineeducationplatform.model.User;
import com.example.onlineeducationplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin // 确保跨域注解还在
public class UserController {

    @Autowired
    private UserService userService;

    // 原有的
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // 【新增 1】查询所有用户（用于列表页）
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 【新增 2】登录接口
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User loginUser) {
        Map<String, Object> result = new HashMap<>();
        // 调用 Service
        User user = userService.login(loginUser.getUsername(), loginUser.getPassword());

        if (user != null) {
            result.put("code", 200);
            result.put("message", "登录成功");
            result.put("user", user);
        } else {
            result.put("code", 400);
            result.put("message", "用户名或密码错误");
        }
        return result;
    }
}