package com.springbook.biz.common;

public class AfterAdvice {
	public void afterLog() {
		System.out.println(">> After : 비즈니스 메소드가 실행된 후, 무조건 실행(finally 블록에 해당)");
	}
}

