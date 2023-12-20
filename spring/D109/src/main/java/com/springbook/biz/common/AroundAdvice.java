package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
//  	aroundLog 메소드를 만들고 비즈니스 메소드가 실행되는데 걸린 시간을 출력해보자
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println(">> Around BEFORE ");
		Object returnObj = pjp.proceed();
		System.out.println(">> Around AFTER ");
		stopWatch.stop();
		System.out.println(method +"() 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
}

/*
클라이언트의 요청을 가로챈 어드바이스는 클라이언트가 호출한 비즈니스 메소드를 호출하기 위해서 ProccedingJoinPoint 객체를 매개변수로 받아야 한다. 
ProceedingJoinPoint 객체의 procced() 메소드를 통해서 비즈니스 메소드를 호출할 수 있다.
*/