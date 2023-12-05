package filter.myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyCharacterFilter implements Filter { // 필터는 Filter 인터페이스를 구현해야함

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest h_request = (HttpServletRequest)request;
		String method = h_request.getMethod();
		if(method.equalsIgnoreCase("POST")) {		
			request.setCharacterEncoding("UTF-8");
		}
		chain.doFilter(request, response);		//	필터 메서드 내용부의 마지막 코드는 현재까지 작업한 내용을 적용하고 연결된 페이지로 이동하도록 만들어줌
	}
}

/*
 * 웹 프로그램에서 하나의 페이지에서 다른 페이지로 전달되는 데이터가 필터를 지나며 가공되거나 걸러지게 된다.
 * 이런 필터 기능을 구현할 때 사용하는 클래스가 필터 클래스이다.
 * 
 * 필터는 데이터를 가로채서 처리를 한다고 생각하면 된다. 하나의 작업에서 다른 작업으로 넘어갈 때나 어떤 작업이
 * 또 다른 작업으로 넘어갈 때 데이터를 가로채서 처리를 할 수 있다. 요청이나 세션에 담긴 데이터뿐 아니라 헤더에도 필터가 적용될 수 있다. 
 * 기존 작업이 일어나기 직전(전처리)이나 일어난 직후(후처리) 모두 필터가 적용되는 시점이다. 필터가 웹 프로그램에서 사용되는 경우는 다음과 같다.
 * 
 * @ 전달받은 데이터를 인코딩하는 경우
 * @ 세션 데이터를 인증하는 경우
 * @ 이벤트나 공지 등 팝업을 추가하는 경우
 * 
 * 웹 관련 클래스가 모두 그러하듯이 필터 클래스의 메서드도 요청 객체와 응답 객체를 매개 변수로 가진다.
 * 여기에 추가적으로 FilterChain 객체를 매개 변수로 갖는데, 이유는 필터 기능 자체가 페이지의 분기점에 있기 때문이다. 
 * 따라서 FilterChain 객체는 필터 기능이 완료되고 다음 페이지로 연결하는 기능에 사용된다. 
 * 또한, 서블릿의 일반 클래스처럼 web.xml 파일에 등록해야 한다. 
 * 당연하겠지만 일반 클래스가 아니므로 <servlet> 태그가 아니라 <filter> 태그를 사용한다.
 * 필터 관련 클래스로는 javax.servlet.Filter, javax.servlet.FilterConfig, javax.servlet.FilterChain 등이 있다.
 * 필터 클래스가 일반 서블릿 클래스와 다른 점은 Filter라는 인터페이스를 상속받는다는 것과 서블릿의 service()나 doGet(), doPost() 메서드 대신에 
 * doFilter() 메서드를 사용한다는 것이다. 또한, 매개 변수에는 Http 계열은 사용할 수 없고 코드에서처럼 HTTP를 지원하는 형으로 변환을 사용해야만 한다. 
 * 마지막으로 세 번째 매개 변수인 FilterChain 클래스의 객체인 chain을 이용해서 다른 필터나 서블릿과 연결하는 코드를 반드시 작성해야 한다.
 * <filter>태그는 <servlet>태그보다 앞에 놓여야 한다. 이렇게 하나의 페이지에서 다른 페이지로 연결되는 사이에 데이터를 가로채서 특정 기능을 수행하는 클래스가 
 * 필터 클래스이다. 필터 클래스를 사용하여 페이지를 분기하는 작업이 가능하다.
 */
