<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <c:out> 태그 _ 출력문을 만드는 태그 --%>
<%-- <c:out value="출력할 값" default="기본값"/> --%>
<%-- <c:out value="출력할 값">기본값</c:out> --%>

<!-- value 속성 값으로 EL 표현식을 사용.  -->
<!-- value 값이 null 이면, 기본값이 출력 -->
<!-- 기본값마저 없다면 빈 문자열이 출력 -->

	<c:out value="HI" /><br>
	<c:out value="${null }" /><br>
	<c:out value="hello " >world</c:out><br>
	<c:out value="${null }" default="default"/><br>
	<c:out value="${null }" > default</c:out><br>
	<!-- 출력 : HI, NULL, hello, default, default -->

<hr>

<%-- <c:set> 태그 _ 변수를 생성하거나 기존 변수의 값을 덮어쓸 때 사용 --%>
<%-- <c:set var="변수명" value="값" scope="page|request|session|application"/> --%>
<%-- <c:set var="변수명" scope="page|request|session|application">값</c:set> --%>
<!-- scope 속성의 기본값은 page -->

	<h3>값 설정 방식</h3>
    <c:set var="username1" value="JH"/>
    <c:set var="username2">TM</c:set>
    1 ${username1}<br/>
    2 ${username2}<br/>
    
    <h3>기본 보관소 - page</h3>
    3 ${pageScope.username1}<br/>
    4 ${requestScope.username2}<br/>	<!-- NULL -->

    
    <h3>보관소 지정 - scope 속성</h3>
    <c:set var="username3" scope="request">KB</c:set>
    5 ${pageScope.username3}<br/>		<!-- NULL -->
    6 ${requestScope.username3}<br/>
    
    <h3>기존의 값 덮어씀</h3>
    <% pageContext.setAttribute("username4", "MH"); %>
    7 기존 값 = ${username4}<br>
    <c:set var="username4" value="JK"/>
    8 덮어쓴 값 = ${username4}<br/>
    
    <hr>
    
    <h3>객체의 프로퍼티 값 변경</h3>
	<%!
		public static class MyMember {
			int no;
			String name;
			public int getNo() { return no; }
			public void setNo(int no) { this.no = no; }
			public String getName() { return name; }
			public void setName(String name) { this.name = name; }
		}
	%>
	<%
		MyMember member = new MyMember();
		member.setNo(100);
		member.setName("JH");
		pageContext.setAttribute("member", member);
	%>
		BEFORE : ${member.name}<br />
		<c:set target="${member}" property="name" value="TM" />
		AFTER  : ${member.name}<br />
		
	<hr>
	
<%-- <c:remove> 태그  --%>
<%-- <c:remove var="변수명" scope="page|request|session|application"/> --%>
		
	<h3>보관소에 저장된 값 제거</h3>
    <% pageContext.setAttribute("username1", "JH"); %>
    BEFORE : ${username1}<br/>
    <c:remove var="username1"/>
    AFTER  : ${username1}<br/>
    
    <hr>
    
<%-- <c:if>태그 _ test 속성값이 참이면, 콘텐츠가 실행 --%>
<!-- 참거짓 테스트 결과를 보관소에 저장할 수도 있음 -->
<%-- <c:if test="조건" var="변수명" scope="page|request|session|application">콘텐츠</c:if> --%>

		<c:if test="${10 > 20 }" var = "result1">
         	10 > 20 <br/>
        </c:if>
        ${result1}<br/>
<!--    false라 콘텐츠(10>20)는 print 되지 않음 -->

        <c:if test="${10 < 20 }" var = "result2">
        10 < 20 <br/>
        </c:if>
        ${result2}<br/>
<!-- 	출력 : false 10<20 true -->

	<hr>
	
<%-- <c:choose> 태그 _ 자바의 switch, case.. 등과 같은 기능을 수행 --%>
<%-- <c:choose> --%>
<%-- 	<c:when test="참거짓 값"></c:when> 		// when 태그는 한개 이상 --%>
<%-- 	<c:when test="참거짓 값"></c:when> 		--%>
<!-- 	... 									-->
<%-- 	<c:otherwise></otherwise>				// 0 또는 1개 --%>
<%-- </c:choose> --%>

	<c:set var="userid" value="admin" />
	<c:choose>
		<c:when test="${userid == 'JH'}">
			Welcome JH
		</c:when>
		<c:when test="${userid == 'TM'}">
			Welcome TM
		</c:when>
		<c:when test="${userid == 'admin'}">
			Welcome ADMIN	<!--  << 출력 -->
		</c:when>
		<c:otherwise>
			UNRECOGNIZED
		</c:otherwise>
	</c:choose>
	
	<hr>
	
<%-- <c:forEach> 태그 _ 반복적인 작업을 정의할 때 사용 --%>
<!-- 목록에서 값을 꺼내어 처리하고 싶을 때 이 태그를 사용 -->
	
<%-- <c:forEach var="변수명" items="목록데이터" begin="시작인덱스" end="종료인덱스"> --%>
<!-- 	콘텐츠 -->
<%-- </c:forEach> --%>
	
<!-- 	items 속성값 : 배열, java.util.Collection(ArrayList,LinkedList,Vector,EnumSet,etc), -->
<!-- 				 java.util.Enumeration, java.util.Map, comma로 구분된 문자열 -->

	<% pageContext.setAttribute("nameList", new String[] {"JH","TM","MH","JK","KB"}); %>
	<ul>
		<c:forEach var="name" items="${nameList}" >
			<li>${name}</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forEach var="name" items="${nameList}" begin="2" end="3">
			<li>${name}</li>	<!-- MH,JK -->
		</c:forEach>
	</ul>

	<hr>
	
<!-- ArrayList 객체에 대해 반복문 -->
<%
	ArrayList<String> nameList3 = new ArrayList<String>();
	nameList3.add("JK");
	nameList3.add("JH");
	nameList3.add("MH");
	nameList3.add("KB");
	nameList3.add("TM");
	pageContext.setAttribute("nameList3", nameList3);
%>
	<ul>
		<c:forEach var="name" items="${nameList3}">
			<li>${name}</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	<!-- 콤마(,)로 구분된 문자열에 대한 반복문 -->
	<% pageContext.setAttribute("nameList4", "JK,JH,KB,MH,TM"); %>
	<ul>
		<c:forEach var="name" items="${nameList4}">
			<li>${name}</li>
		</c:forEach>
	</ul>
	
	<hr>	
	
<!-- 배열이나 List 없이 임의적으로 특정 횟수만큼 반복문을 돌리고 싶을 때 -->
	<ul>
        <c:forEach var="no" begin="1" end="6">
            <li><a href="#">test ${no}</a></li>
        </c:forEach>
    </ul>
<!-- 증가 단계 지정 _ 출력 : test 0 2-->
    <ul>
        <c:forEach var="no" begin="0" end="3" step="2">
            <li><a href="#">test ${no}</a></li>
        </c:forEach>
    </ul>
    
    <hr>
    
<%-- <c:forTokens>태그 _ 문자열을 특정 구분자(delimiter)로 분리하여 반복문을 돌릴 수 있음 --%>

	<% pageContext.setAttribute("tokens", "v1=20&v2=30&op=+"); %>
	<ul>
		<c:forTokens var="item" items="${tokens}" delims="&">
			<li>${item}</li>
<!-- 		출력 : v1=20 \n v2=30 \n op=+ -->
		</c:forTokens>
	</ul>
	
    <hr>
    
<%-- <c:url> 태그 _ URL을 만들 때 사용 --%>
	<c:url var="calcUrl" value="testParam.jsp">
		<c:param name="v1" value="20"/>
		<c:param name="v2" value="30"/>
		<c:param name="op" value="+"/>
	</c:url>
	<a href="${calcUrl}">clickME</a>
<%-- 	출력 through ${param.v1} --%>
	<hr>
	
<%-- <c:redirect> 태그 _ 내부적으로 HttpServletResponse의 sendRedirect()를 호출 --%>
<%-- 	<c:redirect url="http://www.naver.com"/> ... 바로 이동 하더라 ㅎㅅㅎ--%>


	<hr>
	
	<!-- Map 선언 -->
	<c:set var="mapTest" value="<%=new HashMap<String, String>()%>" />
	
	<!-- Map 값 넣기-->
	<c:set target="${mapTest}" property="key1" value="value1" />
	<c:set target="${mapTest}" property="key2" value="value2" />

	<!-- 출력 : value1 value2 key1 value1 key2 value2 -->
	${mapTest.key1}	
	${mapTest.key2}	
	
	<c:forEach var="mapTest" items="${mapTest}">
		${mapTest.key}		
		${mapTest.value}	
	</c:forEach>
	
</body>
</html>