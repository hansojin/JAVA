## JSP 저장 영역

- page
- request
- session
- application

### JSP 내장 객체 메소드

- setAttribute(name,value)
- getAttribute(name)
- getAttributeNames()
- removeAttribute(name)

---

### 데이터 저장 영역

- 페이지 객체
	- 현재 페이지 내에서만 사용할 변수를 저장하는 영역
- 요청 객체
	- 요청 객체가 유지되는 영역에서 사용할 변수를 저장하는 영역
	```
	1. 객체 : ServletRequest 또는 HttpServletRequest 객체
	2. 추가 : request.setAttribute("key","value")
	3. 삭제 : request.removeAttribute("key","value")
	4. 획득 : Object obj = request.getAttribute("key")
	```
- 세션 객체
	- 웹 브라우저가 종료되기 전까지나 세션이 끊어지기 전까지 사용할 변수를 저장하는 영역
	- 클라이언트마다 독립적으로 데이터를 저장하고 관리할 수 있는 최고 범위의 데이터 저장 영역
	```
	1. 객체 : HttpSession 객체
	2. 생성 : session = request.getSession() 또는 request.getSession(boolean);
	3. 추가 : session.setAttribute("key","value")
	4. 삭제 : session.removeAttribute("key","value")
	5. 획득 : Object obj = session.getAttribute("key")
	```
- servletContext 객체
	- 서버가 종료되기 전까지 사용할 변수를 저장하는 영역
	```
	1. 객체 : servletContext 객체
	2. 생성 : application = this.getServletContext();
	3. 추가 : application.setAttribute("key","value")
	4. 삭제 : application.removeAttribute("key","value")
	5. 획득 : Object obj = application.getAttribute("key")
	```
	- 현재의 서블릿에서 servletContext 객체를 획득한다는 것은, 서버 자체의 저장 영역을 사용한다는 의미 
	- 즉, 저장된 데이터는 클라이언트 모두가 공유

