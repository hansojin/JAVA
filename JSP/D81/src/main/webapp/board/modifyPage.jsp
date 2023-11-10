<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>

<form method="post" action="modifyLogic.jsp">
    <table border='1' style="margin-bottom:20px">
        <caption style='font-weight:bold; margin:10px; font-size:1.2em'>수정하기</caption>
        <tr>
            <td>Title</td>
            <td><input type='text' id='title' name='title' value='<%= URLDecoder.decode(request.getParameter("title"), "UTF-8") %>'></td>
        </tr>
        <tr>
            <td>Writer</td>
            <td>&nbsp;<%= URLDecoder.decode(request.getParameter("name"), "UTF-8") %></td>
        </tr>
        <tr>
            <td>Date</td>
            <td>&nbsp;<%= URLDecoder.decode(request.getParameter("date"), "UTF-8") %></td>
        </tr>
        <tr>
            <td colspan='2' style='height:150px; font-weight:400'>
                <textarea id='content' name='content' style='height:120px'><%= URLDecoder.decode(request.getParameter("content"), "UTF-8") %></textarea>
            </td>
        </tr>
    </table>
    <input type='submit' value='SUBMIT' style='background-color:white; width:100px; margin-left:140px'>
    <button><a href='mainBoard.jsp' style='text-decoration: none;text-align: center'>HOME</a></button>
    <input type="hidden" name="num" value="<%= URLDecoder.decode(request.getParameter("num"), "UTF-8") %>">
</form>

</body>
</html>
