package com.kotyara.api.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

  @Pointcut("execution(* com.kotyara..*.*(..))")
  private void loggingAllMethod(){

  }

  @Around("loggingAllMethod()")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = point.proceed();
    log.info(String.format(
        "%s completed in %s",
        ((MethodSignature) point.getSignature()).getMethod().getName(),
        System.currentTimeMillis() - start
    ));

    return result;
  }

  @AfterThrowing(pointcut = "loggingAllMethod()", throwing = "exception")
  public void infoException(Throwable exception){
    log.error(exception.toString());
  }
}
