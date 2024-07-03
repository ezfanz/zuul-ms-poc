package com.irfan.currencyexchangeservice.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut("execution(* com.irfan.currencyexchangeservice..*(..))")
    public void myPointcut() {
    }
    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Aspect triggered");
        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String classname = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();
        log.info("method invoked " + classname + ": " + methodName + "()" + " arguments :" + mapper.writeValueAsString(array));

        Object object = proceedingJoinPoint.proceed();
        log.info(classname + ": " + methodName + "()" + " Response :" + mapper.writeValueAsString(object));

        return object;
    }

}
