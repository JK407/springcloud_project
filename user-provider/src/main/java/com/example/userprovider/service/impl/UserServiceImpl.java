package com.example.userprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.b2b.commonmodule.entity.User;
import com.example.userprovider.mapper.UserMapper;
import com.example.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User>  implements UserService {
   @Autowired
    private UserMapper userMapper;

    //根据ID查询用户
   public User selectById(@RequestParam int id){
       User users = userMapper.selectById(id);
       return users;
   }

    //根据用户名查询用户
    public List<User> findByUserName(@RequestParam String username){

        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("uname",username);   //查询uname为username的用户
        List<User> users = userMapper.selectByMap(map);
        return users;
    }

    //根据ID删除用户
    public void deleteUser(@PathVariable int id){
       userMapper.deleteById(id);
    }


    //根据username和password实现用户登录
    public boolean login(@RequestParam String username,@RequestParam String password) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",username);
        queryWrapper.eq("upwd",password);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null && user.getUpwd().equals(password)) {
            // 如果找到用户且密码匹配，则登录成功
            return true;
        } else {
            // 否则登录失败
            return false;
        }
    }
}
