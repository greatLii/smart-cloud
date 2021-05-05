package com.smart.cloud.controller;

import com.smart.cloud.dto.ResponseDTO;
import com.smart.cloud.entity.UserEntity;
import com.smart.cloud.service.UserService;
import com.smart.cloud.utils.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 22:47
 * @description：用户控制类
 */
@RestController
@RequestMapping("/api/v1/user/")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public ResponseDTO userLogin(UserEntity user) {
        userService.userLogin(user);
        return ResponseUtil.success(user);
    }
}
