package com.yjjk.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.yjjk.monitor.dao","com.yjjk.monitor.mapper"})
public class ErpApplication {


	public static void main(String[] args) {
    	SpringApplication.run(ErpApplication.class, args);
	}

}
