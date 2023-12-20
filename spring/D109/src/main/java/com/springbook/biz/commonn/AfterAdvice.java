package com.springbook.biz.commonn;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[AfterAdvice] 비즈니스 로직 수행 후 무조건 동작");
	}
}

/*
	finallyLog() 메소드가 After Advice 형태로 동작하도록 @Advice 어노테이션을 선언했다.
	그리고 finallyLog() 메소드에 바인드 변수가 없으므로 @After 설정은 @Before처럼 포인트컷 메소드만 참조하면 된다. 
	try-catch-finally문의 finally에 해당하는 블록으로, 예외가 발생해도 동작한다.
*/
