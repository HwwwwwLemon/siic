package com.hwwwww.siic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.hwwwww.siic")
@MapperScan("com.hwwwww.siic.mapper")
@EnableTransactionManagement
public class SiicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiicApplication.class, args);
    }

}
