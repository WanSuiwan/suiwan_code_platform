package com.suiwan.aicodemother;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.suiwan.aicodemother.mapper")
public class YuAiCodeMotherApplication {
    public static void main(String[] args) {
        SpringApplication.run(YuAiCodeMotherApplication.class, args);
    }
}

