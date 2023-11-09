## JSP 파일 만드는 법

Eclipse EE에서 File - new - Dynamic Web Project 

Project name : HelloJSP -> next -> next -> Generate web.xml deployment descriptor 체크

프로젝트 이름 선택 - 마우스 오른쪽 클릭 -> new -> JSP File

```
<%
	out.print("Hello JSP<br>");
%>
```

`<body>`와 `</body>` 사이에 위에 코드를 넣고 **ctrl + f11** 키를 누르고 실행시킨다.

---

*이클립스 웹 브라우저를 크롬 브라우저로 바꾸기*

Window - General - Web Browser - Use external web browser - Chrome

---

## JSP 구성요소

- 지시자(Directive) : <%@ %> : 페이지 속성
- 주석(Comment) : <%-- --%> : 웹브라우저에서 소스보기로 해도 보이지 않는다.
- 선언(Declaration) : <%! %> : 변수, 메소드 선언
- 표현식(Expression) : <%= %> : 결과값 출력
- 스크립트릿(Scriptlet) : <% %> : JAVA코드
- 액션태그(Action tag) : <jsp:action> </jsp:action>

---

개발자가 **객체를 생성하지 않고 바로 사용할 수 있는 객체가 내장객체** 이다.

JSP에서 제공되는 내장객체는 JSP 컨테이너에 의해 Servlet으로 변환될 때 자동으로 객체가 생성 된다.

## JSP 내장 객체 종류

request, response, pageContext, application, out, page, config, session, exception

---

### 지시자

JSP페이지의 전체적인 속성을 지정할 때 사용한다.

page, include, taglib가 있으며, **<%@ 속성 %>** 형태로 사용 된다.

- page : 해당 페이지의 전체적인 속성 지정
- include : 별도의 페이지를 현재 페이지에 삽입
- tablib : 태그라이브러리의 태그 사용

* taglib 지시자

사용자가 만든 tag들을 태그라이브러리라고 한다. 그리고 이러한 태그라이브러리를 사용하기 위해 taglib지시자를 사용한다. 

uri 및 prefix 속성이 있으며, uri는 태그라이브러리의 위치 값을 가지며, prefix는 태그를 가리키는 이름 값을 가진다.

---

### 주석

<!-- 여기는 주석 html주석 -->

<%-- 여기는 주석 jsp주석--%>

---

### request
웹브라우저를 통해 서버에 어떤 정보를 요청하는 것을 request라고 한다. 그리고 이러한 요청 정보는 request 객체가 관리한다.

* Request객체 관련 메소드

- getContextPath() : 웹어플리케이션의 컨텍스트 패스를 얻는다.
- getMethod() : get방식과 post방식을 구분할 수 있다.
- getSession() : 세션 객체를 얻는다.
- getProtocol() : 해당 프로토콜을 얻는다.
- getRequestURL() : 요청 URL을 얻는다.
- getRequestURI() : 요청 URI를 얻는다.
- getQueryString() : 쿼리스트링을 얻는다.

---

`C:\work\web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\프로젝트이름\org\apache\jsp` 이곳으로 가면 jsp파일이 java파일로 변경된 것을 볼 수가 있다.













