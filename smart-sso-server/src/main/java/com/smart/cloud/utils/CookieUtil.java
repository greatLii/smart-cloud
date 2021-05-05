package com.smart.cloud.utils;

import javax.servlet.http.Cookie;
import java.util.HashMap;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/5 12:20
 * @description：cookie工具类
 */
public class CookieUtil {
    public static HashMap<String, String> getCookieMap(Cookie[] cookies) {
        HashMap<String, String> cookieMap = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }
}
