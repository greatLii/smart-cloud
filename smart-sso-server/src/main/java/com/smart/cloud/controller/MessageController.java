package com.smart.cloud.controller;

import com.smart.cloud.constant.Constant;
import com.smart.cloud.dto.ResponseDTO;
import com.smart.cloud.utils.MessageUtil;
import com.smart.cloud.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/9 21:16
 * @description：信息用户类
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    RedisTemplate redisTemplate;

    public ResponseDTO sendMessage(@PathVariable("/phone") String phone, @PathVariable("/code") String code) {
        if (redisTemplate.hasKey(Constant.VERIFY_PHONE + phone)) {
            return ResponseUtil.forbidden("please wait");
        }
        try {
            // 发送验证码
            MessageUtil.sendMessage(phone, code);
            // 加入redis
            redisTemplate.opsForValue().set(Constant.VERIFY_PHONE + phone, code);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ResponseUtil.success(Constant.SUCCESS);
    }
}
