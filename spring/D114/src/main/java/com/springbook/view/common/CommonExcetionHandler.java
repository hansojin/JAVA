package com.springbook.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.springbook.view")
public class CommonExcetionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/arithmeticError.jsp");
		return mav;
	}

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/nullPointerError.jsp");
		return mav;
	}	

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}	
}

/*
클래스 위에 선언된 @ControllerAdvice("com.springbook.view") 어노테이션에 의해 CommonExceptionHandler 객체는 자동으로 생성된다. 
그리고 "com.springbook.view" 패키지로 시작하는 컨트롤러에서 예외가 발생하는 순간 @ExceptionHandler 어노테이션으로 지정한 메소드가 실행된다. 

이때, 어떤 예외가 발생했느냐에 따라 다른 메소드가 수행된다.
만약 ArithmeticException이 발생하면 handleArithmeticException() 메소드가 실행되고, 
NullPointerException이 발생하면 handleNullPointerException() 메소드가, 
그리고 전혀 다른 예외가 발생하면 handleException() 메소드가 기본으로 실행된다.
*/
