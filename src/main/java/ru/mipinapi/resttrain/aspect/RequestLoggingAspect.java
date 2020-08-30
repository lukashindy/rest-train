package ru.mipinapi.resttrain.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RequestLoggingAspect {

    @Pointcut("execution (* ru.mipinapi.resttrain.controller.*.*(..))")
    private void forControllerPackage() {};

    @Pointcut("execution (* ru.mipinapi.resttrain.service.*.*(..))")
    private void forServicePackage() {};

    @Pointcut("forControllerPackage() || forServicePackage()")
    private void forAppFlow() {};

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        log.info("===> in @Before: calling method: " + method);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args)
            log.info("===> Argument: " + arg);
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        log.info("====> in @AfterReturning: from method :" + method);
        log.info("====> result: " + result);
    }

}
