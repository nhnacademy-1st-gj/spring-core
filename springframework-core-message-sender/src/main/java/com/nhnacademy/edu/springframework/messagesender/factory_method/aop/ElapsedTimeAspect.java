package com.nhnacademy.edu.springframework.messagesender.factory_method.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ElapsedTimeAspect {

   @Pointcut("execution(* com.nhnacademy.edu.springframework.messagesender.service.MessageSendService.doSendMessage())")
   private void anyOldTransfer(){}

   //@Around("anyOldTransfer()")
   public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
      StopWatch stopWatch = new StopWatch("Logging Tracker");

      try {
         stopWatch.start();
         Object retVal = pjp.proceed();

         return retVal;
      }finally {
         stopWatch.stop();
         System.out.println(stopWatch.prettyPrint());
      }
   }

   @Before("@annotation(timeLogging) && args(name)")
   public void before(JoinPoint joinPoint, TimeLogging timeLogging, String name){
      System.out.println("=======================================");
      System.out.println("signature name = " + joinPoint.getSignature().getName());
      System.out.println("annotation value = " + timeLogging.value());
      System.out.println("aop name = " + name);
      System.out.println("=======================================");
   }

}
