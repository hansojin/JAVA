package com.springbook.biz.commonn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[Before] " + method + "()'s ARGS : " +args[0].toString());
	}
	
}

/*
우선 클래스 선언부에 @Service와 @Aspect를 추가하여 BeforeAdvice 클래스가 컴포넌트 스캔되어 애스팩트 객체로 인식되도록 했다. 
그리고 allPointcut() 참조 메소드를 추가하여 포인트컷을 선언했다. 
마지막으로 beforeLog() 메소드 위에 @Before를 추가하여 allPointcut()으로 지정한 메소드가 호출될 때, beforeLog() 메소드가 Before 형태로 동작하도록 설정했다. 
*/