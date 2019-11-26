package com.yjjk.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@EnableScheduling
@SpringBootApplication
@MapperScan({"com.yjjk.erp.dao","com.yjjk.erp.mapper"})
@ComponentScan(basePackages = {"com.yjjk"})
public class ErpApplication {


    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

}
