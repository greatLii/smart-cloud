package com.smart.cloud.utils;

import com.smart.cloud.constant.Constant;
import com.smart.cloud.dto.ResponseDTO;
import org.springframework.http.HttpStatus;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/4 23:00
 * @description：返回工具类
 */
public class ResponseUtil {
    public static ResponseDTO success(Object data) {
        ResponseDTO dto = new ResponseDTO();
        dto.setCode(HttpStatus.OK.value());
        dto.setMsg(Constant.SUCCESS);
        dto.setData(data);
        return dto;
    }

    public static ResponseDTO forbidden(Object data) {
        ResponseDTO dto = new ResponseDTO();
        dto.setCode(HttpStatus.FORBIDDEN.value());
        dto.setMsg(String.valueOf(HttpStatus.FORBIDDEN.value()));
        dto.setData(data);
        return dto;
    }
}
