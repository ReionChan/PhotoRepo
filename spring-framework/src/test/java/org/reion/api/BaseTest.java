package org.reion.api;

import org.junit.runner.RunWith;
import org.reion.impl.aspect.DatabaseLogAspect;
import org.reion.impl.config.DatabaseLogConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



/**
 * 测试基类。
 *
 * ------配置数据库方案一-----------
 * 【testApplicationContext.xml】
 * <context:property-placeholder location="classpath:jdbc-test.properties"/>
 *   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
 *   <property name="driverClassName" value="${jdbc.driverClassName}"/>
 *   <property name="url" value="${jdbc.url}"/>
 *   <property name="username" value="${jdbc.username}"/>
 *   <property name="password" value="${jdbc.password}"/>
 * </bean>
 *
 * 【BaseTest.java】
 * 将类注解 @TestPropertySource 和 @Sql 取消注释
 *
 * -------配置数据库方案二------------
 * 【testApplicationContext.xml】
 * <jdbc:embedded-database id="dataSource" type="DERBY">
 *  <jdbc:script location="classpath:schema-derby.sql"/>
 *  <jdbc:script location="classpath:test-data.sql"/>
 * </jdbc:embedded-database>
 *
 * 【BaseTest.java】
 * 将类注解 @TestPropertySource 和 @Sql 注释
 *
 * @author Reion
 * @date 2018-08-21
 * @version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:testApplicationContext.xml",
        "classpath:test-spring-mvc.xml"})
@WebAppConfiguration
//@Transactional
//@TestPropertySource({"classpath:jdbc-test.properties"})
@ActiveProfiles("test")
//@Sql({"classpath:schema-derby.sql","classpath:test-data.sql"})
public abstract class BaseTest {

}
