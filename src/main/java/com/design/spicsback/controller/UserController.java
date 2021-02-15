package com.design.spicsback.controller;

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
    @GetMapping("login")
    public User selectOne(String username, String password) {
        return this.userService.queryByUserNameAndPwd(username, password);

    }

    /**
     * 注册用户
     * @param user 用户信息
     * @return 用户数据
     */
    @PostMapping("register")
    public User insertOne(User user) {
        return this.userService.insert(user);
    }
}