package com.smart.cloud.filter;

import com.smart.cloud.constant.Constant;
import com.smart.cloud.utils.CookieUtil;
import com.smart.cloud.utils.EncryptUtil;
import com.smart.cloud.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/5 11:14
 * @description：字段头检测
 */
@Slf4j
@Component
public class TokenFilter implements Filter {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info(request.getRequestURI());
        Cookie[] cookies = request.getCookies();
        HashMap<String, String> cookieMap = CookieUtil.getCookieMap(cookies);
        // 登录校验参数
        if (!cookieMap.isEmpty()) {
            String uuid = cookieMap.get(Constant.COOKIE_UUID);
            String token = cookieMap.get(Constant.VERIABLE_TOKEN);
            // csrf-token 校验参数
            String shId = cookieMap.get(Constant.SH_ID);
            String headerToken = request.getHeader(Constant.S_H_TOKEN);
            // 不存在对应的token 代表未登录 直接返回 401未登录
            if (StringUtils.isEmpty(uuid) || StringUtils.isEmpty(token) || StringUtils.isEmpty(shId) || StringUtils.isEmpty(headerToken)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }

            // 取UUID和redis中的数据校验，看是否匹配
            String redisToken = (String) redisTemplate.opsForValue().get(Constant.USER_TOKEN_PREFIX + uuid);
            if (redisToken.equals(token)) {
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
            // csrf-token 校验
            if (shId.equals(EncryptUtil.decrypt(headerToken, Constant.ASSETS_KEY))) {
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
