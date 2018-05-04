package com.troytan.ymcake;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.troytan.ymcake.repository")
public class RestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}
