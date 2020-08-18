package com.qy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qy")
public class LinkConvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkConvertApplication.class, args);
    }

}
