package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 标注此为 Spring Boot 应用入口
@SpringBootApplication
public class CourseApiApp {
	public static void main(String[] args) {
		// 启动
		SpringApplication.run(CourseApiApp.class, args);
	}
}