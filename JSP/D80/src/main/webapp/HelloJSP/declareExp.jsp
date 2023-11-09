<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! 
	int i=1;
	String str = "ABCDE";
	public int sum(int n,int m){
		return n+m;
	}
%>
</head>
<body>
<%= i%>
<%= str %>
<%= sum(5,5) %>
<br>
<%@ page import = "java.util.Arrays" %>
<%
	int[] iArr = {10,20, 30};
	out.print(Arrays.toString(iArr));
%>
</body>
</html>


<!-- Q1. 선언 int i=1; -->
<!-- 선언 String str = "ABCDE"; -->
<!-- 선언 public int sum(int num1, int num2){ -->
<!-- 	return num1 + num2; -->
<!-- } -->
<!-- 위에 있는 내용들을 선언하고 각각을 출력하시오. -->

<!-- Q2. int[] iArr = {10,20, 30}; -->
<!-- 위에 배열을 Arrays의 toString() 메소드를 이용하여 출력하시오. -->