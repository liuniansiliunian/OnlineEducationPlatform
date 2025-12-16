package com.example.onlineeducationplatform.service;

import com.example.onlineeducationplatform.model.User;
import java.util.List;

public interface UserService {
    User getUserById(int id);

    // 【新增】
    User login(String username, String password);
    List<User> getAllUsers();
}