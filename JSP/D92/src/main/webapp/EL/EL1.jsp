<%@page import="java.util.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>EL 표현식</h4>
문자열 : ${"test"} <br/>
문자열 : ${'test'} <br/>
정수 : ${20} <br/>
부동소수점 : ${3.14} <br/>
참거짓 : ${true} <br/>
null : ${null} <hr>

<h4>배열에서 값 꺼내기</h4>
<% // 값 준비
	pageContext.setAttribute("scores", new int[] {90, 80, 70, 100});
%>
way1 : ${pageScope.scores[2]} <br/>
way2 : ${scores[2]} <hr>

<h4>LIST에서 값 꺼내기</h4>
<% // 값 준비
	List<String> nameList = new LinkedList<String>();
	nameList.add("JH");
	nameList.add("TM");
	nameList.add("JK");
	pageContext.setAttribute("nameList", nameList);
%>
way1 : ${pageScope.nameList[1]} <br/>
way2 : ${nameList[1]} <hr>

<h4>MAP 객체에서 값 꺼내기</h4>
<% // 값 준비
	Map<String, String> map = new HashMap<String, String>();
	map.put("s01", "JH");
	map.put("s02", "TM");
	map.put("s03", "JK");
	pageContext.setAttribute("map", map);
%>
way1 : ${pageScope.map.s01} <br/>
way2 : ${map.s01} <hr>

<h4>산술 연산자</h4>
\${10 + 20} = ${10 + 20} <br/>
\${10 - 20} = ${10 - 20} <br/>
\${10 * 20} = ${10 * 20} <br/>
\${10 / 20} = ${10 / 20} <br/>
<%-- \${10 div 20} = ${10 div 20} <br/> --%>
\${10 % 20} = ${10 % 20} <br/>
\${10 mod 20} = ${10 mod 20} <hr>

<h4>논리 연산자</h4>
\${true && false} = ${true && false}<br/>
\${true and false} = ${true and false}<br/>
\${true || false} = ${true || false}<br/>
\${true or false} = ${true or false}<br/>
\${not true} = ${not true}<br/>
\${!true} = ${!true} <hr>

<h4>관계 연산자</h4>
\${10 == 11} = ${10 == 11} <br/>
\${10 eq 11} = ${10 eq 11} <br/>
\${10 != 11} = ${10 != 11} <br/>
<%-- \${10 ne 11} = ${10 ne 11} <br/> --%>
\${10 < 11} = ${10 < 11} <br/>
\${10 lt 11} = ${10 lt 11} <br/>
\${10 > 11} = ${10 > 11} <br/>
\${10 gt 11} = ${10 gt 11} <br/>
\${10 <= 11} = ${10 <= 11} <br/>
\${10 le 11} = ${10 le 11} <br/>
\${10 >= 11} = ${10 >= 11} <br/>
\${10 ge 11} = ${10 ge 11} <hr>

<h4>empty</h4>
<% // 값 준비
pageContext.setAttribute("title", "EL 연산자!");
%>
자바빈에서 프로퍼티 email의 값 꺼내기 <br/ >
way1 : <br>
\${empty pageScope.title} = ${empty pageScope.title}<br/>
\${empty pageScope.title2} = ${empty pageScope.title2}<br/>
way 2: <br>
\${empty title} = ${empty title}<br/>
\${empty title2} = ${empty title2}<hr>
<!-- 실행결과 : F T F T -->

<h4>조건식</h4>
\${10 > 20 ? "크다" : "작다"} = ${10 > 20 ? "크다" : "작다"}<hr>

<h4>예약어test</h4>
<%	// 값 준비
	pageContext.setAttribute("ne", "오호라!");
%>
<%-- ${ne} --%>
<%-- 예약어를 써서 오류남 --%>
</body>
</html>