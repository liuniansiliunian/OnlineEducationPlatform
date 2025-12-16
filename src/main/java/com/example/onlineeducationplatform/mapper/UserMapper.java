package com.example.onlineeducationplatform.mapper;

import com.example.onlineeducationplatform.model.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
    // 原有的
    User getUserById(int id);

    // 【新增】登录查询
    User login(@Param("username") String username, @Param("password") String password);

    // 【新增】查询所有用户
    List<User> getAllUsers();
}