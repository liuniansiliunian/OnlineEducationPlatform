package com.example.onlineeducationplatform.service;

import com.example.onlineeducationplatform.mapper.UserMapper;
import com.example.onlineeducationplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    // 【新增】
    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}