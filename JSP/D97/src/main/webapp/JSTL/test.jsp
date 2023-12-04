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
	c:set 태그<br/>
	변수를 선언하는 태그<br/>
	
	<c:set var="x" value="100"/>
	출력 : <c:out value="${x }" /><br><br>
	
	c:remove 태그<br/>
	변수를 삭제하는 태그이다.<br/>
	<c:remove var="x" />
	출력 : <c:out value="${x }" /><br><br>	
	
	<c:set var="x" value="${requestScope.data}" />
	출력 : <c:out value="${x }" /><br><br>
	<!-- 만약 값이 없으면 null -->

	<jsp:useBean id="aName" class="JSTL.NameInfo">
    	<c:set target="${aName}" property="name" value="JH" />
	</jsp:useBean>
	출력 : ${aName.name}<br><br>
	
	<c:out value="<h2>JAVA</h2>" escapeXml="false" /><br/>
	<!-- <h2> 태그가 동작하여 JAVA가 헤더 글씨체로 표시됨 -->
	
	<c:out value="<h2>JAVA</h2>" escapeXml="true" /><br/><br>
	<!-- 	태그도 화면에 출력됨 -->
	
	<%--
		c:param 태그
		<import>, <url>, <redirect> 태그를 사용할 때 데이터를 전달하는 매개 변수를 지정하는 태그이다.
		
		<c:param name="str" value="데이터" />
		str이라는 매개 변수에 "데이터"라는 값을 저장하여 전달한다.
	 --%>
	
	c:import 태그<br/>
	지정한 경로의 페이지를 가져오는 태그이다.<br/>
	<c:import url="hi.jsp" />
	<c:import url="http://localhost:8080/D97/JSTL/hi.jsp" />
	<%-- ELView.jsp 페이지를 현재 위치에 보여줌 --%>
	
	<c:import url="http://localhost:8080/D97/JSTL/hi.jsp" var="elurl" scope="request"/>
	<%-- 해당 페이지를 elurl라는 변수에 담아서 요청 객체에 저장한다. --%>
	
	<c:import url="http://localhost:8080/D97/JSTL/hi.jsp" 
		var="elurl" scope="request" charEncoding="UTF-8"/>
	<%-- 해당 페이지를 elurl라는 변수에 담아서 UTF-8로 인코딩하여 요청 객체에 저장한다. --%>
	${elurl }
	
	<c:import url="hi.jsp" varReader="in"> 
		<%-- varReader 리소스의 내용을 Reader 객체로 읽어올 때 사용 --%>
		<jsp:useBean id="dataout" class="JSTL.DataOut">
			<c:set target="${ dataout }" property="in" value="${ in }"/>
		</jsp:useBean>
	</c:import><br>
	
	c:redirect 태그<br/>
	특정 위치로 이동(sendRedirect)하게 하는 태그이다.<br><br>
<%-- 	<c:redirect url="http://localhost:8080/D97/JSTL/hi.jsp"/> --%>

<%-- 	<c:redirect url = "/hi.jsp" context="/D97/JSTL"/> --%>
<!-- 	해당 context root의 url 위치로 이동  -->

<%-- 	<c:redirect url="hi.jsp"> --%>
<%-- 		<c:param name="str" value="데이터" /> --%>
<%-- 		<%-- url 속성의 위치로 매개 변수 str을 가지고 이동 --%>
<%-- 		<%-- 해당 페이지에서, ${param.str } 로 출력가능 --%> 
<%-- 	</c:redirect> --%>

	c:url 태그<br/>
	URL 주소를 저장하는 태그이다. import 태그는 페이지를 저장하므로 서로 다르다.<br/>
	<c:url value="http://localhost:8080/D97/JSTL/hi.jsp" /><br>
	<%--value 속성의 주소를 그대로 화면에 출력한다. <c:out value="http://..."/>와 동일한 결과를 보인다. --%>
	
	<c:url value="http://localhost:8080/D97/JSTL/hi.jsp" var="input_url" scope="request"/>
	${input_url }<br><br>
	
	c:catch 태그<br/>
	예외를 처리하는 태그이다. <br/>
	
	<c:catch var="ex">
		<% Integer.parseInt("abcd"); %>
	</c:catch>
	Error : <c:out value="${ex}" /><br><br>
	<%-- 에러가 발생하면 에러 내용을 변수 ex에 담는다. --%>
	
	<c:catch var="error">
		<%= 10/0 %>
	</c:catch>
	<c:out value="${error.message }" /><br><br>
<!-- 출력 : / by zero -->
	
	c:if 태그<br/>
	if 문을 처리하는 태그이다.<br/>
	
	<c:set var="xx" value="10" scope="request" />
	<c:if test="${not empty(requestScope.xx) and (requestScope.xx % 2 == 0) }" 
		var="res" scope="request">
	<%-- var 속성으로 선언한 변수에 test 속성의 조건에 의한 결과가 저장됨 --%>
	RESULT = <c:out value="${requestScope.res}" /><br><br>
	</c:if>
	
	c:choose, c:when, c:otherwise 태그<br/>

	<c:set var="x" value="ab" scope="request" />
<%-- 	<c:set var="x" value="10" scope="request" /> --%>
	<c:catch var="ex2">
		<c:choose>
			<c:when test="${requestScope.x % 2 == 0 }">
				<c:out value="짝수입니다. "/><br/><br/>
			</c:when>
			<c:when test="${requestScope.x % 2 == 1 }">
				<c:out value="홀수입니다." /><br/><br/>
			</c:when>
			<c:otherwise>
					<c:out value="수가 아닙니다.[이 부분은 실행 안되고 에러 걸림]" /><br/><br/>
			</c:otherwise>
		</c:choose>
	</c:catch>
	<c:if test="${not empty(ex2) }">
		exception2 : <c:out value="${ex2}" /><br/><br/>
<!-- 	exception2 : java.lang.NumberFormatException: For input string: "ab" -->
	</c:if>
	
	c:forEach 태그<br/>
	for 문처럼 반복해서 실행하며 결과를 표시하는 태그이다.<br/>
	구구단 9단을 출력하는 for 문이다.<br/>
	
	<c:forEach var="i" begin="1" end="9" step="1">
		9 * ${ i} = ${ 9*i }<br>
	</c:forEach><br>
	
	<%
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		session.setAttribute("list", list);
	%>
	<c:forEach var="obj" items="${list}" begin="2" end="3" step="1" varStatus="pos">
		${pos.count} : ${obj}<br/>		
<!-- 	출력 _ 1:ccc  2:ddd -->
	</c:forEach><br>
	
	c:forTokens 태그<br/>
	특정 구분자를 기준으로 데이터를 분할하여 반복해서 수행하는 태그이다.<br/>
	<c:set var="delim_str" value="JK,JH,KB,MH,TM" scope="request"/>
	<c:forTokens var="obj" items="${delim_str}" delims="," varStatus="pos">
		${pos.count} : ${obj}<br/>	
	</c:forTokens><br>
	
	<!-- HashMap 변수를 mapTest라는 이름으로 생성 -->
	<c:set var="mapTest" value="<%=new HashMap<String, String>()%>" />

	<c:set target="${mapTest}" property="key1" value="value1" />
	<c:set target="${mapTest}" property="key2" value="value2" />

	${mapTest.key1} <!-- value1 출력 -->
	${mapTest.key2} <!-- value2 출력 -->
	<br>
	<c:forEach var="mapTest" items="${mapTest}">
    	${mapTest.key}     
    	${mapTest.value}   
		<!--key1 value1 key2 value2 ...-->
	</c:forEach><br><br>
	
	<c:set var="mapTest" value="<%=new HashMap<String, String>()%>"/>
	<c:set target="${mapTest}" property="key1" value="value1"/>
	<c:set target="${mapTest}" property="key2" value="value2"/>
	<c:set target="${mapTest}" property="key3" value="value3"/>
	
	<c:forEach var="map" items="${mapTest}" varStatus="status">
		${status.index }
		${status.count }
		${map.key }
		${map.value }
		<c:if test="${status.first}"> FIRST </c:if>
		<c:if test="${status.last}"> LAST </c:if><br>
	</c:forEach>
	
<!-- 
	< c : forEach > 와 forTokens 태그에 사용할 수 있는 속성 중에는 varStatus 속성이 있다. 
	varStatus 속성은 배열이나 컬렉션과 같은 집합체에서 항목의 인덱스 값을 사용해야 할 경우가 생기는 데 이 때 사용하게 된다.
	varStatus 속성은 인덱스(index)는 물론 반복 횟수(count) 등과 같은 반복 상태에 관련된 정보를 프로퍼티로 알려준다.
	
	프로퍼티				설명
	index			items에 지정한 집합체의 현재 반복 중인 항목의 index를 알려준다. 0부터 순서 부여
	count 			루핑을 돌 때 현재 몇 번째를 반복 중인지 알려준다. 1부터의 순서가 부여
	first			현재 루프가 처음인지 여부를 알려준다. 첫 번째일 경우에는 true 아니면 false를 리턴
	last			현재 루프가 마지막인지 여부를 알려준다. 마지막일 경우에는 true 아니면 false를 리턴
 -->
	
	
</body>
</html>