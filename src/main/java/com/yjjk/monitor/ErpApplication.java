package com.yjjk.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.yjjk.monitor.mapper")
public class ErpApplication {


	public static void main(String[] args) {
    	SpringApplication.run(ErpApplication.class, args);
	}

}
