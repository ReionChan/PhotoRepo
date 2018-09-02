package org.reion.impl.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.reion.api.service.IAmqService;
import org.reion.impl.domain.DataBaseLogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Autowired
    IAmqService AmqService;

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
    public void afterLog(JoinPoint joinPoint) {
        log.info("=========== after 后置通知 ===============");
        DataBaseLogMessage dbLogMsg = new DataBaseLogMessage();
        dbLogMsg.setSignature(joinPoint.getSignature().toShortString());
        dbLogMsg.setArgs(joinPoint.getArgs());
        dbLogMsg.setDatetime(System.currentTimeMillis());
        AmqService.sendMsg(dbLogMsg.convert());
        log.info("=========== after 后置通知 ===============\n");
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
