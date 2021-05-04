package com.smart.cloud;

import com.smart.cloud.entity.UserEntity;
import com.smart.cloud.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SmartCloudApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        UserEntity entity = userMapper.getUserInfoByUUid("11");
        System.out.println(entity.getUserName());
    }

}
