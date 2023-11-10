<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<style>
    * {
        margin: auto;
        text-align: center;
        margin-top: 135px;
    }
</style>
<body>
	<%
		String noParam = request.getParameter("num");
    	String gotoURL = "deleteLogic.jsp?num=" + java.net.URLEncoder.encode(noParam, "UTF-8");
	%>
    <form onsubmit="return checkPW();" action=<%=gotoURL %> method="post">
        PW <input type='password' id='pw' name='pw'>
        <input type='submit' value='SUBMIT' style='background-color:white;'>
    </form>

    <script>
        function checkPW() {
            var getPW = document.getElementById("pw");
            var oriPW = '<%= request.getParameter("pw") %>';

            if (getPW.value !== oriPW) {
            	getPW.value = '';
                alert("Please check your password");
                return false;
            } else {
                return true; 
            }
        }
    </script>
</body>
</html>
