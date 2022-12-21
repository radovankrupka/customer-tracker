package com.springdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

 private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());


 @Pointcut("execution(* com.springdemo.controllers.*.*(..))")
    private void forControllerPackage() {

 }


    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.springdemo.DAO.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}



    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

     logger.info("in @Before , method : " + joinPoint.getSignature().toShortString());

     Object[] args = joinPoint.getArgs();

        for (Object obj: args
             ) {
            logger.info("====> argument: " + obj);

        }

    }

    @AfterReturning(pointcut = "forAppFlow()",
                    returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){

        logger.info("====> in @AfterReturning , method : " + joinPoint.getSignature().toShortString());
        logger.info("====> result :" + result);

    }


}
