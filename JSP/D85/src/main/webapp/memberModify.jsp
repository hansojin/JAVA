<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hellojsp?useSSL=false&serverTimezone=UTC";
	String user = "root";
	String password = "1234";
	
	try{
		Class.forName(driver);
	} catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	String name=null, id=null, sex=null, email=null, hobby=null, mobilePhone=null;
	String sql = "SELECT * FROM MEMBER2 WHERE ID=?";
	try(Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		
		pstmt.setString(1, (String)session.getAttribute("id") );
		try(ResultSet rs= pstmt.executeQuery()){			
			if(rs.next()){
				name = rs.getString("name");
				id = rs.getString("id");
				sex = rs.getString("sex");
				email = rs.getString("email");
				hobby = rs.getString("hobby");
				mobilePhone = rs.getString("mobilePhone");
			}	
		}		
	}  catch(SQLException e){
		e.printStackTrace();
	}	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원정보수정</h2>
<form name="member" method="post" action="MemberModifyOK" onsubmit="return validateForm()">
<table>
<tr>
	<td>이름 </td><td><input type="text" name="name" value="<%=name %>" disabled></td>
</tr>
<tr>
	<td>아이디 </td><td><input type="text" name="id" value="<%=id %>"  disabled></td>
</tr>
<tr>
	<td>비밀번호 </td><td><input type="password" name="password" required></td>
</tr>
<tr>
	<td>비밀번호확인 </td><td><input type="password" name="passwordChk" required></td>
</tr>
<tr>
	<td>성별 </td>
	<td><input type="radio" name="sex" value="male" <%if(sex.equals("male")){ %>checked <%} %> >남 
		<input type="radio" name="sex" value="female" <%if(sex.equals("female")){ %>checked <%} %>>여
	</td>
</tr>
<tr>
	<td>이메일</td><td><input type="email" name="email" value="<%=email %>" required></td>
</tr>
<tr>
	<td>취미</td>
	<td>
		<input type="checkbox" name="hobby" value="수영" <%if(hobby.indexOf("수영")!=-1){ %>checked <%} %>>수영 
		<input type="checkbox" name="hobby" value="야구" <%if(hobby.indexOf("야구")!=-1){ %>checked <%} %>>야구 
		<input type="checkbox" name="hobby" value="영화감상" <%if(hobby.indexOf("영화감상")!=-1){ %>checked <%} %>>영화감상 
		<input type="checkbox" name="hobby" value="음악감상" <%if(hobby.indexOf("음악감상")!=-1){ %>checked <%} %>>음악감상 
	</td>
</tr>
<tr>
	<td>핸드폰</td>
	<td><select name="mobilePhone1">
			<option value="010" <%if( mobilePhone.substring(0,3).equals("010") ){ %> selected <%}%> >010</option>
			<option value="011" <%if( mobilePhone.substring(0,3).equals("011") ){ %> selected <%}%> >011</option>
			<option value="016" <%if( mobilePhone.substring(0,3).equals("016") ){ %> selected <%}%> >016</option>
		</select>
		<input type="text" name="mobilePhone2" value="<%=mobilePhone.substring(3) %>" required>	
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="정보수정" style='background-color:white;'> 
		<input type="reset" value="초기화" style='background-color:white;'>
	</td>
</tr>
</table>
</form>
<script>
function validateForm() {
    var password = document.forms["member"]["password"].value;
    var passwordChk = document.forms["member"]["passwordChk"].value;
    if(password != passwordChk){
        alert("비밀번호와 비밀번호확인이 서로 다릅니다.");
        return false;
    }
}
</script>
</body>
</html>