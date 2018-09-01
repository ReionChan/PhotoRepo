package org.reion.impl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 数据库日志记录配置
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-31 14:46
 **/
@Configuration
@ComponentScan({"org.reion.impl.aspect"})
@EnableAspectJAutoProxy
public class DatabaseLogConfig {
}
