<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Info</title>
</head>
<body>
	<%@ include file='sqlInfo.jsp'%>
	<%
    String id = (String) session.getAttribute("id");
    String pw = (String) session.getAttribute("pw");
    int result = 0;
    String sql = "SELECT * FROM member WHERE id=? AND pw=?";
    try (Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, id);
        pstmt.setString(2, pw);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
%>
	<form method="post" action="../modify" name='myform'>
		<table>
			<caption style='font-weight: bold'>MODIFY INFO</caption>
			<tr>
				<td><label for="title">NAME</label></td>
				<td><input type="text" name="name" id="name" size="40" value="<%=rs.getString("name") %>" readonly></td>
			</tr>
			<tr>
				<td><label for="id">ID</label></td>
				<td><input type="text" name="id" id="id" size="40" value="<%=rs.getString("id") %>" readonly></td>
			</tr>
			<tr>
				<td><label for="pw">PW</label></td>
				<td><input type="password" name="pw" id="pw" size="40" required></td>
			</tr>
			<tr>
				<td><label for="pw2">PW check</label></td>
				<td><input type="password" name="pw2" id="pw2" size="40" required></td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input type='radio' name='gender' value='female' <%= "female".equals(rs.getString("gender")) ? "checked='checked'" : "" %>> XX 
				<input type='radio' name='gender' value='male' <%= "male".equals(rs.getString("gender")) ? "checked='checked'" : "" %>> XY</td>
			</tr>
			<tr>
				<td><label for="email">E-MAIL</label></td>
				<td><input type="email" name="email" id="email" size="40" value="<%=rs.getString("email") %>"></td>
			</tr>
			<tr>
				<td>HOBBY</td>
				<td>
					<%
            			String[] hobbies = rs.getString("hobby").split(",");
            			List<String> hobbyList = Arrays.asList(hobbies);
        			%>
					<input type="checkbox" name="hobby" value="swimming" <%= hobbyList.contains("swimming") ? "checked" : "" %>> 수영
					<input type="checkbox" name="hobby" value="baseball" <%= hobbyList.contains("baseball") ? "checked" : "" %>> 야구
        			<input type="checkbox" name="hobby" value="soccer" <%= hobbyList.contains("soccer") ? "checked" : "" %>> 축구
        			<input type="checkbox" name="hobby" value="basketball" <%= hobbyList.contains("basketball") ? "checked" : "" %>> 농구
				</td>
			</tr>
			<tr>
				<td><label for="number">PHONE</label></td>
				<td>
					<select name='numFront' id='numFront' style='background-color: white'>
						<option value='010' <%= "010".equals(rs.getString("phonePre")) ? "selected" : "" %>>010</option>
						<option value='011' <%= "011".equals(rs.getString("phonePre")) ? "selected" : "" %>>011</option>
					</select> 
					<input type="text" name="number" id="number" size="32" value="<%=rs.getString("phoneElse") %>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="MODIFY" style='background-color: white; width: 80px; margin-left: 120px' onclick="checkPW()"> 
					<input type="reset" value="RESET" style='background-color: white; width: 80px'></td>
			</tr>
		</table>
	</form>
	<%
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
	<script>
    function checkPW() {
        var one = document.getElementById('pw');
        var two = document.getElementById('pw2');
        var pw = '<%= session.getAttribute("pw") %>';
        var form = document.myform;
        if (one.value === two.value && one.value===pw) {
            form.submit();
        } else {
            alert("Check your password");
            two.value = "";
            two.focus();
        }
    }
</script>
</body>
</html>
