<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP AJAX</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
$(function(){	
	function searchFunction() {
		$.ajax({
			url:"userSearch.do",	
			type:"get",				
			data:{userName: $("#userName").val()},	// HTTP 요청과 함께 서버로 보낼 데이터
			dataType : "json",						// 서버에서 보내줄 데이터의 타입
			success: searchProcess,					// 성공적으로 값을 서버로 보냈을 경우 처리하는 코드
			error: function(){ 
				alert("서버요청실패");
			}
		});
	}
	
	function searchProcess(data){
		let table = document.getElementById("ajaxTable");
		table.innerHTML = "";
		let result = data.result;
		for(let i = 0; i < result.length ; i++){
			let row = table.insertRow(0);
			for(let j = 0; j < result[i].length; j++){
				var cell = row.insertCell(j);
				cell.innerHTML = result[i][j].value;
				console.log("result[" + i + "]" + "["+ j+"]" + result[i][j].value);
			}
		}
	}
	
	function registerFunction(){
		$.ajax({
			url:"userRegister.do",
			type: "get",
			data:{
				userName:$("#registerName").val(),
				userAge:$("#registerAge").val(),
				userGender:$('input[name=registerGender]:checked').val(),
				userEmail:$("#registerEmail").val()
				},
			dataType:"text",
			success:registerProcess,
			error:function(){
				alert("서버요청실패");
			}
		});
	}
	
	function registerProcess(result){
		if(result != 1){
			alert("등록에 실패했습니다.");
		}else {
			$("#userName").val("");
			$("#registerName").val("");
			$("#registerAge").val("");
			$("#registerEmail").val("");
			searchFunction();			
		}		
	}
	
	$(window).on("load", searchFunction);
	$("#userName").on("keyup", searchFunction);
	$("#registerBtn").on("click", registerFunction);
	
});
	</script>
</head>
<body>
	<input id="userName" type="text" size="20">
	<button onclick="searchFunction();" type="button" style='background-color: white'>검색</button><br><br>

	<table class="table"
		style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color: #fafafa; text-align: center;">이름</th>
				<th style="background-color: #fafafa; text-align: center;">나이</th>
				<th style="background-color: #fafafa; text-align: center;">성별</th>
				<th style="background-color: #fafafa; text-align: center;">이메일</th>
			</tr>
		</thead>
		<tbody id="ajaxTable"></tbody>
	</table><br><br>

	<table style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color: #fafafa;">회원 등록 양식</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이름</h5></td>
				<td><input type="text" id="registerName" size="20"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>나이</h5></td>
				<td><input type="text" id="registerAge" size="20"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>성별</h5></td>
				<td>
					<div style="text-align: center; margin: 0 auto;">
						<input type="radio" name="registerGender" value="남자" checked>남자 
						<input type="radio" name="registerGender"  value="여자">여자
					</div>
				</td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이메일</h5></td>
				<td><input class="form-control" type="text" id="registerEmail" size="20"></td>
			</tr>
			<tr>
				<td colspan="2"><button id="registerBtn" type="button" style='background-color: white;width:95%'>등록</button></td>
			</tr>
		</tbody>
	</table>
</body>
</html>

