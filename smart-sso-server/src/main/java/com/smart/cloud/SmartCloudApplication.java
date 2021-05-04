package com.smart.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smart.cloud.mapper")
public class SmartCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCloudApplication.class, args);
    }

}
