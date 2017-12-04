package com.lahib.db.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Aspect
@Slf4j
public class TracingAspect {

    @Before("execution(* * (..))")
    public void entering(JoinPoint joinPoint){
        log.info("Entering : " + joinPoint.getStaticPart().getSignature().toString());
    }

    @After("execution(* * (..))")
    public void exiting(JoinPoint joinPoint){
        log.info("Exiting : " + joinPoint.getStaticPart().getSignature().toString());
    }

    @Around("trackTime()")
    public void track(ProceedingJoinPoint joinPoint){
        System.out.println("tracking time for " + joinPoint.toString());
    }


    @Pointcut("@annotation(com.lahib.db.aspects.TrackTime)")
    public void trackTime(){}
}
