package com.springbook.view.controller;

public class ViewResolver {
	public String prefix;
	public String suffix;
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
		
	}
}


// ViewResolver 클래스는 Controller가 리턴한 View 이름에 접두사(prefix)와 점미사(suffix)를 결합하여 "최종으로 실행될 View 경로와 파일명을 완성"한다. 
// ViewResolver도 HandlerMapping과 마찬가지로 DispatcherServlet의 init() 메소드가 호출될 때 생성된다.