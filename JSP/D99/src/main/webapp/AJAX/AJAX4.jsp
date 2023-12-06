<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	var req = new XMLHttpRequest();
	req.onreadystatechange = function a(){
		console.log(this.readyState, this.status);
		if(this.readyState == 4 && this.status == 200){
			console.log(this.response);		// data2 출력
			var data = JSON.parse(this.response);
			for(var i in data){
				var t = document.querySelector(".template").cloneNode(true);
				// 자식 노드 역시 복제가 필요한 경우라면 true를 사용 (default : false)
				t.children[0].innerText = data[i].id;
				t.children[1].innerText = data[i].msg;
				document.body.appendChild(t);
			}
		}			
	}
	req.open("GET", "./data2.txt");
	req.send();
</script>
</head>
<body>
	<p class="template">
		<span class="character">SH</span> : <span class="word">S2</span>
	</p>
</body>
</html>