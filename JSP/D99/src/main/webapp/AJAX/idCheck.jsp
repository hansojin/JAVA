<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AJAX ID Check</title>
</head>
<body>
	<form action="register.do" method="post">
		&nbsp;I&nbsp;D&nbsp; : <input type="text" name="id" id="id"> 
		<span id="idCheckMsg"></span><br> 
		name: <input type="text" name="name">
	</form>
	<script>
		$('#id').on('focusout', function(){
			let id = $('#id').val();
			$.ajax({
				url : "idCheck.do",		
				type:  "post",			
				data: {"id": id},			
				dataType: 'text',		
				success: function(result){
					if(result == 0){
						$("#idCheckMsg").html('사용할 수 없는 아이디 입니다.');
					} else{
						$("#idCheckMsg").html('사용할 수 있는 아이디 입니다.');
					}
				},
				error:function(){
					alert("서버요청실패");
				}
			})
		})
	</script>
</body>
</html>