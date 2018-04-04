package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 标注此为一个控制器
@RestController
public class HelloController {
	
	/*
	 *  将 `/hello` URL 映射到 `sayHi` 方法
	 *  
	 *  Tips: @RequestMapping 默认映射所有 http 请求方法
	 *  		例如：GET、POST、PUT 等等
	 */
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
}
