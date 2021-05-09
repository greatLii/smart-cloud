package com.smart.cloud.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;
import com.smart.cloud.constant.Constant;
import org.apache.logging.log4j.core.util.JsonUtils;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：GreatLi
 * @date ：Created 2021/5/9 21:04
 * @description：短信工具类
 */
public class MessageUtil {
    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return
     * @throws Exception
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = Constant.ALI_DOMAIN;
        return new Client(config);
    }

    public static void sendMessage(String phone, String code) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = MessageUtil.createClient(Constant.ACCESS_KEY_ID, Constant.ACCESS_KEY_SECRET);
        Map<String, String> codeMap = new HashMap<>();
        codeMap.put("code", code);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName(Constant.SIGN_NAME)
                .setTemplateCode(Constant.TEMPLATE_CODE)
                .setTemplateParam(JSONObject.toJSONString(codeMap));
        // 复制代码运行请自行打印 API 的返回值
        client.sendSms(sendSmsRequest);
    }
}
