package com.lzkydh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzkydh.mapper")
public class CookupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookupApplication.class, args);
	}
}
