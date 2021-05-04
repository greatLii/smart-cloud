package com.smart.cloud.service;

import com.smart.cloud.entity.UserEntity;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 23:09
 * @description：
 */
public interface UserService {
    UserEntity userLogin(UserEntity user);
}
