package com.design.spicsback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = "com.design.spicsback.*")
@MapperScan(basePackages = "com.design.spicsback.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpicsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpicsBackApplication.class, args);
    }

}
