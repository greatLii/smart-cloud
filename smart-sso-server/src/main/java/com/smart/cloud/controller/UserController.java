package com.smart.cloud.controller;

import com.smart.cloud.dto.ResponseDTO;
import com.smart.cloud.entity.UserEntity;
import com.smart.cloud.utils.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 22:47
 * @description：用户控制类
 */
@RestController
@RequestMapping("/api/v1/user/")
public class UserController {
    @PostMapping("login")
    @ResponseBody
    public ResponseDTO userLogin(UserEntity user){
        return ResponseUtil.success(user);
    }
}
