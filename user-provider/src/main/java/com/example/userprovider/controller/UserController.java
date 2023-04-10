package com.example.userprovider.controller;


import com.example.b2b.commonmodule.entity.User;
import com.example.b2b.commonmodule.utils.Result;
import com.example.userprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    //查询所有用户
    @GetMapping("/getAll")
    public Result getAll(){
       List<User> users= userService.list();
       if(users!=null)
            return  Result.ok(users);
       else
           return  Result.UserGetNull("查询用户列表失败");
    }

    //根据用户名查找用户
    @GetMapping("/findByUserName")
    public Result getUsersByUserName(@RequestParam String username) {
        //判断username是否为空
        if (StringUtils.isEmpty(username)){
            return Result.usernameNull("用户名不能为空");
        }
        List<User> users =userService.findByUserName(username);
        //判断user是否存在
        if (users.isEmpty()){
            return Result.userNull("用户不存在");
        }
        return Result.ok(userService.findByUserName(username));
    }


    //根据id查找用户
    @GetMapping("/findById")
    public Result getUsersByUserId(@RequestParam int id) {

        User users =userService.selectById(id);
        //判断user是否存在
        if (users == null){
            return Result.userNull("用户ID不存在");
        }
        return Result.ok(users);
    }

    //添加用户
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        //判断username和password是否为空
        if (StringUtils.isEmpty(user.getUname()) || StringUtils.isEmpty(user.getUpwd())){
            return Result.usrNameAndPasswordNotNull("用户名和密码不能为空，请重新输入");
        }
        List<User> users =userService.findByUserName(user.getUname());
        if (!users.isEmpty()){
            return Result.AddError("用户名已经被注册!");
        }
        boolean addedUser = userService.save(user);
        return Result.saveSuccess("添加成功！");
    }

    //更新用户
    @Transactional
    @PutMapping("/update")
    public Result updateUser(@RequestBody User user) {
        User users =userService.getById(user.getUaccount());
        //判断user是否存在
        if (users == null){
            return Result.userNull("用户不存在");
        }
        //判断username和password是否为空
        if (StringUtils.isEmpty(user.getUname()) || StringUtils.isEmpty(user.getUpwd())){
            return Result.usrNameAndPasswordNotNull("用户名和密码不能为空，请重新输入");
        }

        User user1 = new User();
        user1.setUaccount(user.getUaccount());
        user1.setUname(user.getUname());
        user1.setUpwd(user.getUpwd());
        user1.setUsex(user.getUsex());

        boolean success = userService.updateById(user);


        return Result.updateSuccess("更新成功！");
    }

    //删除用户
    @Transactional
    @DeleteMapping("/delete/{id}")
    public Result deleteUser(@PathVariable int id) {
        User users =userService.getById(id);
        //判断user是否存在
        if (users == null){
            return Result.userNull("用户不存在");
        }
        userService.deleteUser(id);
        return Result.deleteSuccess("删除成功");
    }

    //用户登录
    @PostMapping("/login")
    public Result login(@RequestParam String username,@RequestParam String password) {
        //判断username和password是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return Result.usrNameAndPasswordNotNull("用户名和密码不能为空，请重新输入");
        }
        List<User> users =userService.findByUserName(username);
        if (users.isEmpty()){
            return Result.userNull("用户不存在!");
        }
        boolean success = userService.login(username, password);
        if (success) {
            return Result.loginSuccess("账户和密码匹配成功，登录成功！");
        } else {
            return Result.loginFailed("账户和密码不匹配，登录失败！");
        }
    }


}
