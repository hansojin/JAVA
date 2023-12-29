package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
    @Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : " + path);
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행한다.
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 5. 검색된 화면으로 이동한다.
		response.sendRedirect(view);
	}
}

// Controller를 구성하는 요소 중에서 DispatcherServlet은 클라이언트의 요청을 가장 먼저 받아들이는 Front Controller이다. 
// 하지만 클라이언트의 요청을 처리하기 위해 DispatcherServlet이 하는 일은 거의 없으며, 실질적인 요청 처리는 각 Controller에서 담당한다.
// 구체적인 Controller 클래스들을 구현하기에 앞서 모든 Controller를 같은 타입으로 관리하기 위한 인터페이스를 만들어야 한다(Controller.java)
// 클라이언트의 요청을 받은 DispatcherServlet은 HandlerMapping을 통해 Controller 객체를 검색하고, 검색된 Controller를 실행한다. 


/*
<< MVC 프레임워크 >>
클래스				기능
DispatcherServlet	유일한 서블릿 클래스로서 모든 클라이언트의 요청을 가장 먼저 처리하는 Front Controller
HandlerMapping		클라이언트의 요청을 처리할 Controller 매핑
Controller			실질적인 클라이언트의 요청 처리
ViewResolver		Controller가 리턴한 View 이름으로 실행될 JSP 경로 완성

동작 방법 예시
1. 클라이언트가 로그인 버튼을 클릭하여 "/login.do" 요청을 전송하면 DispatcherServlet이 요청을 받는다.
2. DispatcherServlet은 HandlerMapping 객체를 통해 로그인 요청을 처리할 LoginController를 검색하고,
3. 검색된 LoginController의 handlerRequest() 메소드를 호출하면 로그인 로직이 처리된다.
4. 로그인 처리 후에 이동할 화면정보가 리턴되면
5. DispatcherServlet은 ViewResolver를 통해 접두사와 접미사가 붙은 JSP 파일의 이름과 경로를 리턴받는다.
6. 그리고 최종적으로 JSP를 실행하고 실행 결과가 브라우저에 응답된다.
 */
