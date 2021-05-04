package com.smart.cloud.dto;

import lombok.Data;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 22:53
 * @description：接口返回数据类
 */
@Data
public class ResponseDTO <T>{
    private Integer code;
    private String msg;
    private T data;
}
