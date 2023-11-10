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
    
    <form onsubmit="return checkPW();" id="modifyForm" method="post">
        PW <input type='password' id='pw' name='pw'>
        <input type="hidden" name="num" value="<%= java.net.URLEncoder.encode(request.getParameter("num"), "UTF-8") %>">
        <input type="hidden" name="title" value="<%= java.net.URLEncoder.encode(request.getParameter("title"), "UTF-8") %>">
        <input type="hidden" name="name" value="<%= java.net.URLEncoder.encode(request.getParameter("name"), "UTF-8") %>">
        <input type="hidden" name="pw" value="<%= java.net.URLEncoder.encode(request.getParameter("pw"), "UTF-8") %>">
        <input type="hidden" name="email" value="<%= java.net.URLEncoder.encode(request.getParameter("email"), "UTF-8") %>">
        <input type="hidden" name="date" value="<%= java.net.URLEncoder.encode(request.getParameter("date"), "UTF-8") %>">
        <input type="hidden" name="view" value="<%= java.net.URLEncoder.encode(request.getParameter("view"), "UTF-8") %>">
        <input type="hidden" name="content" value="<%= java.net.URLEncoder.encode(request.getParameter("content"), "UTF-8") %>">
        <input type='submit' value='SUBMIT' style='background-color:white;'>
    </form>

    <script>
        function checkPW() {
            var getPW = document.getElementById("pw");
            var oriPW = '<%= java.net.URLEncoder.encode(request.getParameter("pw"), "UTF-8") %>';
            
            if (getPW.value !== oriPW) {
            	getPW.value = '';
                alert("Please check your password");
                return false;
            } else {
                var modifyForm = document.getElementById("modifyForm");
                modifyForm.action = "modifyPage.jsp" +
                    "?num=" + '<%= java.net.URLEncoder.encode(request.getParameter("num"), "UTF-8") %>' +
                    "&title=" + '<%= java.net.URLEncoder.encode(request.getParameter("title"), "UTF-8") %>' +
                    "&name=" + '<%= java.net.URLEncoder.encode(request.getParameter("name"), "UTF-8") %>' +
                    "&pw=" + '<%= java.net.URLEncoder.encode(request.getParameter("pw"), "UTF-8") %>' +
                    "&email=" + '<%= java.net.URLEncoder.encode(request.getParameter("email"), "UTF-8") %>' +
                    "&date=" + '<%= java.net.URLEncoder.encode(request.getParameter("date"), "UTF-8") %>' +
                    "&view=" + '<%= java.net.URLEncoder.encode(request.getParameter("view"), "UTF-8") %>' +
                    "&content=" + '<%= java.net.URLEncoder.encode(request.getParameter("content"), "UTF-8") %>';
                return true;
            }
        }
    </script>
</body>
</html>
