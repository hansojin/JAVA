<%@page import="java.util.* "%>
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
	<!-- 기본 태그로 "Hello" 출력 -->
	<c:out value="Hello" /><br>
	
	<!-- 기본 태그로 username 이라는 변수를 선언하고 값을 "홍길동"을 준다. 저장영역은 session -->
	<c:set var="username" value="JH" scope="session" />
	<!-- 기본 태그로 username을 출력한다. -->
	<c:out value="${sessionScope.username }" />
	<c:out value="${username }" />
	${username }<br>
	
	<!-- username의 값을 슈퍼맨으로 변경. 그리고 username 출력 -->
	<c:set var="username" value="TM" scope="session"/>
	<c:out value="${sessionScope.username }" />
	<c:out value="${username }" />
	${username }<br>
	
	<!-- 기본 태그로 username을 제거한다.그리고 username 출력 -->
	<c:remove var="username" />
	${username }
	
	<hr>
	
	<!-- 액션태그로 com.superman.www.MyMember 객체를 member라는 이름으로 request영역에 생성 -->
	<jsp:useBean id="member" class="JSTL.MyMember" scope="request" />
	
	<!-- 액션태그로 member에 no에 100을 대입하자. -->
	<!-- 액션태그로 member에 name에 "홍길동"을 대입하자. -->
	<jsp:setProperty property="no" name="member" value="948"/>
	<jsp:setProperty property="name" name="member" value="JH"/>
	
	<!-- el로 member의 name과 no를 출력하자 -->
	BEFORE : ${member.name } ${member.no }<br>

	<!-- 기본태그(core)로 member에 no에 값을 100을 대입하자.-->
	<c:set property="no" target="${member }" value="100" />
	
	<!-- el로 member에 no를 출력하자 -->
	AFTER : ${member.name } ${member.no }
	
	<hr>
	
	<!-- 기본태그(core)로 num1 변수 선언하고 10에 값을 준다. -->
	<c:set var="num1" value="10" />
	<!-- 기본태그(core)로 num2 변수 선언하고 20에 값을 준다. -->
	<c:set var="num2" value="20" />
	
	<!-- 기본태그(core)로 num1이 num2보다 크면 num1이 크다고 출력한다. 그리고 그 조건이 true인지 false인지 출력한다. -->
	<c:if test="${num1>num2 }" var="res1">${num1 } is bigger than ${num2 }</c:if> ${res1 }
	<!-- 기본태그(core)로 num2가 num1보다 크면 num2가 크다고 출력한다. 그리고 그 조건이 true인지 false인지 출력한다. -->
	<c:if test="${num1<num2 }" var="res2">${num2 } is bigger than ${num1 }</c:if> ${res2 }
	
	<hr>
	
	<!-- 기본태그(core)로 userid라는 변수에 batman을 대입한다. -->
	<c:set var="userid" value="batman" />
	
	<c:choose>
		<c:when test="${userid==joker }">
			welcome LEDGER
		</c:when>
		<c:when test="${userid==twoFace }">
			welcome to Chaos
		</c:when>
		<c:otherwise>
			SUP
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<!-- forEach TEST -->
	<% pageContext.setAttribute("nameList", new String[] {"JH","TM","KB","MH","JK"}); %>
	<ul>
		<c:forEach var="name" items="${nameList }">
			<li>${name }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="name" items="${nameList }" begin="0" end="1">
			<li>${name }</li>
		</c:forEach>
	</ul>
	
<%
	ArrayList<String> nameList3 = new ArrayList<String>();
	nameList3.add("JH");
	nameList3.add("TM");
	nameList3.add("MH");
	nameList3.add("KB");
	nameList3.add("JK");
	pageContext.setAttribute("nameList3", nameList3);
%>
	<ul>
		<c:forEach var="name" items="${nameList3}" >
			<li>${name }</li>
		</c:forEach>
	</ul>
	
	<% pageContext.setAttribute("nameList4", "JH,TM,MH,KB,JK"); %>
	<ul>
		<c:forEach var="name" items="${nameList4}" >
			<li>${name }</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forEach var="no" begin="1" end="6">
			<li>TEST${no }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="no" begin="0" end="3" step="2">
			<li>TEST${no }</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	<% pageContext.setAttribute("tokens", "v1=20&v2=30&op=+"); %>
	<ul>
		<c:forTokens items="${tokens }" delims="&" var="item">
			<li>${item }</li>
		</c:forTokens>
	</ul>
	
	<hr>
	
	<c:url var="calcUrl" value="../JSTL/testParam.jsp">
		<c:param name="v1" value="20"/>
		<c:param name="v2" value="30"/>
		<c:param name="op" value="+"/>
	</c:url>
	<a href="${calcUrl}">clickME</a>
	
<%--<c:redirect url="www.naver.com" /> --%>

	<hr>
	
	<!-- Map 선언 -->
	<c:set var="mapTest" value="<%=new HashMap<String, String>()%>" />
	
	<!--기본태그(core)로 Map에 값 넣기
		mapTest에 키에 key1, 값에 value1을 넣는다.
		mapTest에 키에 key2, 값에 value2를 넣는다.-->
	<c:set target="${mapTest }" property="key1" value="value1" />
	<c:set target="${mapTest }" property="key2" value="value2" />
	
	<!-- mapTest의 키가 key1인것의 값을 출력하자. -->
	<!-- mapTest의 키가 key2인것의 값을 출력하자. -->
	${mapTest.key1}	
	${mapTest.key2}<br>
	
	<!-- 기본태그(core)의 반복문으로 mapTest의 키와 값을 출력하자. -->
	<c:forEach items="${mapTest }" var="mapTest">
		${mapTest.key } ${mapTest.value }
	</c:forEach>
</body>
</html>