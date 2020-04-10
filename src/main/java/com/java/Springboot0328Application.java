package com.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 秒度
 */
//@EnableCaching
//@EnableScheduling
//@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.java.dao")
public class Springboot0328Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0328Application.class, args);
    }

}
