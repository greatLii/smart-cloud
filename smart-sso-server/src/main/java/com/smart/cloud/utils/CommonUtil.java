package com.smart.cloud.utils;

import java.util.UUID;

/**
 * @author ：GreatLi
 * @date ：Created 2021/3/21 23:00
 * @description：公共工具类
 */
public class CommonUtil {
    public static synchronized String getUUID() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid).replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
