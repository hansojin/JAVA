<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>

이름 : <%=request.getParameter("name") %><br>
성별 : <%=request.getParameter("gender") %><br>
취미 : 
<%
	String[] hobby = request.getParameterValues("hobby");
	for(int i=0;i<hobby.length;i++){
		out.print(hobby[i] + " ");
	}
%>

<hr>

${param.name }
${param.gender }
${paramValues.hobby[0] }
${paramValues.hobby[1] }
${paramValues["hobby"][2] }
${paramValues["hobby"][3] }


</body>
</html>