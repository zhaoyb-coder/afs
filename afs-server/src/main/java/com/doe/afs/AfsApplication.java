package com.doe.afs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan("com.doe.afs.mapper")
public class AfsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AfsApplication.class, args);
		System.out.println("---------启动成功---------");
	}
}
