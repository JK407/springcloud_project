package com.example.userprovider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.b2b.commonmodule.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface UserService  extends IService<User> {

    //根据ID查询用户
    User selectById (@RequestParam int id);

    //根据用户名查询用户
    List<User> findByUserName (@RequestParam String username);

    //根据ID删除用户
    void deleteUser(@PathVariable int id);


    //根据username和password实现用户登录
    boolean login(@RequestParam String username,@RequestParam String password);

}
