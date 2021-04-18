package com.design.spicsback.controller;

import com.design.spicsback.entity.Information;
import com.design.spicsback.entity.User;
import com.design.spicsback.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author jj
 * @since 2021-02-15 09:07:48
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户数据
     */
    @PostMapping("login")
    public Information<User> selectOne(String username, String password) {
        System.out.println(username);
        User user = this.userService.queryByUserNameAndPwd(username, password);
        if (user == null){
            // 返回错误信息
            return Information.error(200,"用户名或密码错误");
        }else {
            // 敏感信息不传回
            user.setPassword("");
            return Information.success(200,"登录成功",user);
        }
    }

    /**
     * 注册用户
     * @param user 用户信息
     * @return 用户数据
     */
    @PostMapping("register")
    public Information insertOne(User user) {
        // 保证用户名唯一
        User checkRepeat = this.userService.queryByUserName(user.getUsername());
        if (checkRepeat != null) {
            return Information.error(300,"用户名重复");
        }
        User register = this.userService.insert(user);
        if (register == null) {
            return Information.error(500,"注册失败，重试");
        }
        return Information.success("注册");
    }

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    @PostMapping("update")
    public Information updateOne(User user){
        User isUpdated=this.userService.update(user);
        if(isUpdated!=null){
            return Information.success("更改");
        }else {
            return Information.error(301,"更改失败");
        }
    }
}