package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		System.out.println("[Around Start]");
		stopWatch.start();
		Object obj = pjp.proceed();
		System.out.println("[Around End]");
		stopWatch.stop();
		
		System.out.println(method +"() 수행 시간 : " + stopWatch.getTotalTimeMillis() + "ms");
		System.out.println("OBJ : " + obj);
		return obj;
	}
}

