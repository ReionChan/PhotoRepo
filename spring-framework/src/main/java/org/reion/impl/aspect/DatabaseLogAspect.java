package org.reion.impl.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 数据库日志记录器切面
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-31 14:58
 **/
@Component
@Aspect
public class DatabaseLogAspect {

    private static final Log log = LogFactory.getLog(DatabaseLogAspect.class);

    @Pointcut("execution(* org.reion.impl.dao.*.*(..))")
    public void cut() {
    }

//    @Before("cut()")
//    public void beforeLog() {
//        System.out.println("before 前置通知...");
//    }


//    @Around("cut()")
//    public void aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("around 环绕通知-前...");
//        pjp.proceed();
//        System.out.println("around 环绕通知-后...");
//    }

    @After("cut()")
    public void afterLog() {
        log.info("after 后置通知...");
    }

//    @AfterReturning("cut()")
//    public void afterReturnLog() {
//        System.out.println("afterReturning 返回后通知...");
//    }


//    @AfterThrowing("cut()")
//    public void afterThrowLog() {
//        System.out.println("异常后通知...");
//    }
}
