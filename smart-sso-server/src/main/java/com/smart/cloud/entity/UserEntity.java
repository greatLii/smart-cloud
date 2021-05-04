package com.smart.cloud.entity;

import lombok.Data;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 19:58
 * @description：用户信息
 */
@Data
public class UserEntity extends BaseEntity {
    private String uuid;
    private String userName;
    private String passWord;
}
