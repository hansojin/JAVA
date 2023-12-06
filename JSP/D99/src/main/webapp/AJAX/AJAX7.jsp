<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AJAX</title>
<style>
	.character { color : black;}
	.word{color:gray;}
</style>
<script>
	$(window).on(
			'load',
			function() {
				$.ajax({
					url : "face.do", 	// 요청을 보낼 서버 URL 주소
					type : "post", 		// HTTP 요청방식 (get/post)
					dataType : "JSON", 	// 서버에서 보내줄 데이터의 타입
					success : function(data) {
// 						var data = JSON.parse(data);	// JSON으로 보내면 파싱 불필요
						for ( var i in data) {
							var t = document.querySelector(".template").cloneNode(true);
							t.children[0].innerText = data[i].id;
							t.children[1].innerText = data[i].msg;
							document.body.appendChild(t);
						}
					},
					error : function() {
						alert("서버요청실패");
					}
				});
	});
</script>
</head>
<body>
	<p class="template">
		<span class="character">SH</span> : <span class="word">S2</span>
	</p>
</body>
</html>