package com.smart.cloud.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smart.cloud.constant.Constant;
import com.smart.cloud.entity.UserEntity;
import com.smart.cloud.mapper.UserMapper;
import com.smart.cloud.service.UserService;
import com.smart.cloud.utils.JWTUtil;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 23:11
 * @description：
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public UserEntity userLogin(UserEntity user) {
        UserEntity entity = userMapper.getUserInfoByUUid(user.getUuid());
        if (entity != null && entity.getUserName().equals(user.getUserName()) && entity.getPassWord().equals(user.getPassWord())) {
            // 生成token，存入redis
            redisTemplate.opsForValue().set(Constant.USER_UUID_PREFIX + entity.getUuid(), JWTUtil.getClaims(JSONObject.toJSONString(entity)));
            return entity;
        }
        return null;
    }
}
