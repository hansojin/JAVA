<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<!-- 
	JSP 페이지에서 표현 언어(EL)를 사용하기 위해서는 page 디렉티브의 isELIgnored 속성을 false로 설정해주어야 합니다. 
	그러나 이 속성은 명시하지 않는 경우 기본값이 false이므로 따로 지정해주지 않아도 됩니다.
	만약 이 isELIgnored속성을 true로 하게 되면 표현언어 구문을 해석할때 표현언어가 아닌 단순한 text로 해석하게 됩니다.
-->

<%!
	public class Inner {
		private String data;
		public void setData(String data) { this.data = data; }
		public String getData() { return this.data; }
	}
%>

<%
	Inner inner = new Inner();
	inner.setData("JH");
	request.setAttribute("inner", inner);
	
	//숫자로 등록된 데이터는 사칙연산이 발생할 경우 자동 숫자로 변환됨
	request.setAttribute("su1", "100");
	request.setAttribute("su2", "30");
	request.setAttribute("bool", "false");
	request.setAttribute("data", "");
%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 연산자</title>
</head>
<body>
	<h3>EL 연산 </h3>
	inner.data : ${ requestScope.inner.data }<br/>
	inner["data"] : ${ requestScope.inner["data"] }<br/>
	su1 * (su2 + 3) : ${ requestScope.su1 * (requestScope.su2 + 3) }<br/>
	!bool : ${ !requestScope.bool }<br/>
	not bool : ${ not requestScope.bool }<br/>
	empty(data) : ${ empty(requestScope.data) }<br/>
	su1 / su2 : ${ requestScope.su1 / requestScope.su2 }<br/>
	su1 div su2 : ${ requestScope.su1 div requestScope.su2 }<br/>
	su1 != su2 : ${ requestScope.su1 != requestScope.su2 }<br/>
	su1 ne su2 : ${ requestScope.su1 ne requestScope.su2 }<br/>	
	(su1 % 2 == 0) and (su2 mod 4 == 0) : 
		${ (requestScope.su1 % 2 == 0) and (requestScope.su2 mod 4 == 0) }<br/><br/>
		
	inner.data : ${ inner.data }<br/>
	inner["data"] : ${ inner["data"] }<br/>
	su1 * (su2 + 3) : ${ su1 * (su2 + 3) }<br/>
	!bool : ${ !bool }<br/>
	not bool : ${ not bool }<br/>
	empty(data) : ${ empty(data) }<br/>
	su1 / su2 : ${ su1 / su2 }<br/>
	su1 div su2 : ${ su1 div su2 }<br/>
	su1 != su2 : ${ su1 != su2 }<br/>
	su1 ne su2 : ${ su1 ne su2 }<br/>	
	(su1 % 2 == 0) and (su2 mod 4 == 0) : ${ (su1 % 2 == 0) and (su2 mod 4 == 0) }<br/>
</body>
</html>