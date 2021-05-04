package com.smart.cloud.entity;

import lombok.Data;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 20:05
 * @description：必要字段
 */
@Data
public class BaseEntity {
    private String createTime;
    private String createBy;
    private String updateTime;
    private String updateBy;
}
