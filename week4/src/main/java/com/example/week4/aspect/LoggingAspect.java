package com.example.week4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.week4.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(
                "AOP Before Advice: Calling method -> "
                        + joinPoint.getSignature().getName()
        );
    }
}