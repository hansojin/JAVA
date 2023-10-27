# 객체 조작

### 객체 조작 메서드
이제부터 객체를 생성, 복제, 삭제, 속성 변환하는 객체 조작 메서드에 대해 살펴보겠습니다. 객체 조작 메서드는 속성 조작 메서드와 수치 조작 메서드 그리고 객체 편집 메서드로 나눌 수 있습니다.

속성 조작 메서드는 요소의 속성을 바꿀 때 사용하고, 수치 조작 메서드는 요소의 너빗값 또는 높잇값 같은 수치를 바꿀 때 사용합니다. 이 두 메서드는 선택한 요소의 속성을 바꾸는 메서드이므로 성격이 비슷하다고 볼 수 있습니다. 그리고 객체 편집 메서드는 선택한 요소의 속성을 바꾸는 메서드이므로 성격이 비슷하다고 볼 수 있습니다. 그리고 객체 편집 메서드는 말 그대로 객체를 생성하거나 삭제 또는 복제할 때 사용합니다.

#### html() / text() 메서드
**html()** 메서드는 **선택한 요소의 하위 요소를 가져와 문자열로 반환** 하거나 **하위 요소를 전부 제거하고 새 요소를 바꿀 때 사용** 합니다. 그리고 **text()** 메서드는 **선택한 요소에 포함되어 있는 전체 텍스트를 가져오거나 선택한 하위 요소를 전부 제거하고 새 텍스트를 생성할 때 사용** 합니다.

```
① $("요소선택").html();
② $("요소선택").html("새요소");
③ $("요소선택").text();
④ $("요소선택").text("새 텍스트");

① 선택한 요소의 하위 요소를 가져와 문자열로 반환합니다.
② 선택한 요소의 하위 요소를 전부 제거하고 지정한 새 요소를 생성합니다.
③ 선택한 요소의 텍스트만 가져옵니다.
④ 선택한 요소의 하위 요소를 전부 제거하고 지정한 텍스트를 생성합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var result_1 = $("#sec_1").html( );
		console.log(result_1);
        // <h2><em>html()</em></h2>
		// <p>내용1</p>
		$("#sec_1 p").html("<a href=\"#\">Text1</a>");

		var result_2 = $("#sec_2").text( );
		console.log(result_2);    
        // 텍스트()
		// 내용2
		$("#sec_2 h2").text("text()");
	});
</script>
</head>
<body>
	<h1><strong>객체 조작 및 생성</strong></h1>
	<section id="sec_1">
		<h2><em>html()</em></h2>
		<p>내용1</p>
	</section>
	<section id="sec_2">
		<h2><em>텍스트()</em></h2>
		<p>내용2</p>
	</section>
</body>
</html>
```

#### attr() / removeAttr() 메서드
**attr()** 메서드는 선택한 요소에 **새 속성을 생성하거나 기존의 속성을 변경할 때** 또는 **요소의 속성값을 불러올 때** 사용합니다. **removeAttr()** 메서드는 선택한 요소에서 기존의 속성을 삭제할 때 사용합니다.

```
① $("요소선택").attr("속성명");
② $("요소선택").attr("속성명", "새값");
③ $("요소선택").attr({"속성명1" :  "새 값1", "속성명2" : "새 값2", ... "속성명n":"새 값n"});

① 선택한 요소의 지정한 속성값을 가져옵니다.
② 요소를 선택하여 지정한 속성값을 적용합니다.
③ 요소를 선택하여 지정한 여러 개의 속성값을 적용합니다.

① $("요소선택").removeAttr("속성");
① 선택한 요소에서 지정한 속성을 삭제합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var srcVal = $("#sec_1 img").attr("src");
		console.log(srcVal);

		$("#sec_1 img")
		.attr({
			"width":200,
			"src": srcVal.replace("1.jpg","2.jpg"),
			"alt": "바위"
		})
		.removeAttr("border");
	});
</script>
</head>
<body>
	<h1><strong>객체 조작 및 생성</strong></h1>
	<section id="sec_1">
		<h2>이미지 속성</h2>
		<p><img src="images/math_img_1.jpg" alt="바위" border="2"></p>
	</section>
</body>
</html>
```

#### addClass() / removeClass() / toggleClass() / hasClass() 메서드
addClass() 메서드는 선택한 요소에 클래스를 생성하고, removeClass() 메서드는 선택한 요소에서 지정한 클래스를 삭제합니다. toggleClass() 메서드는 선택한 요소에 지정한 클래스가 없으면 생성하고, 있을 경우에는 삭제합니다. hasClass() 메서드는 선택한 요소에 지정한 클래스가 있으면 true를 반환하고, 없으면 false를 반환합니다.

```
① $("요소선택").addClass("class 값");
② $("요소선택").removeClass("class 값");
③ $("요소선택").toggleClass("class 값");
④ $("요소선택").hasClass("class 값");

① 요소를 선택하여 지정한 class 값을 생성합니다.
② 요소를 선택하여 지정한 class 값을 삭제합니다.
③ 요소를 선택하여 지정한 class 값이 있으면 삭제하고, 없으면 생성합니다.
④ 선택한 요소에 지정한 class 값이 있으면 true, 없으면 false를 반환합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		$("#p1").addClass("aqua");
		$("#p2").removeClass("red");
		$("#p3").toggleClass("green");
		$("#p4").toggleClass("green");
		$("#p6").text($("#p5").hasClass("yellow"));
	});
</script>
<style>
	.aqua{background-color:#0ff;}
	.red{background-color:#f00;}
	.green{background-color:#0f0;}
	.yellow{background-color:#ff0;}
</style>
</head>
<body>
	<p id="p1">내용1</p>
	<p id="p2" class="red">내용2</p>
	<p id="p3">내용3</p>
	<p id="p4" class="green">내용4</p>
	<p id="p5" class="yellow">내용5</p>
	<p id="p6"></p>
</body>
</html>
```

#### val() 메서드
val() 메서드는 선택한 폼 요소의 value 속성값을 가져오거나 새 값을 적용할 때 사용합니다.

```
① $("요소선택").val();
② $("요소선택").val("새 값");

① 선택한 폼 요소의 value 속성값을 가져옵니다.
② 요소를 선택하여 value 속성에 새 값을 적용합니다.

+ value 속성의 초깃값을 알려주는 prop("defaultValue") 메서드
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var result_1 = $("#user_name").val();
		console.log(result_1);

		$("#user_id").val("javascript");

		var result_2 = $("#user_id").prop("defaultValue"); 
		console.log(result_2);
	});
</script>
</head>
<body>
	<h1>객체 조작 및 생성</h1>
	<form action="#" id="form_1">
		<p>
			<label for="user_name">이름</label> 
			<input type="text" name="user_name"
				id="user_name" value="용대리">
		</p>
		<p>
			<label for="user_id">아이디</label> 
			<input type="text" name="user_id"
				id="user_id" value="hello">
		</p>
	</form>
</body>
</html>
```

#### prop() 메서드
prop() 메서드는 **선택한 폼 요소(선택 상자, 체크 박스, 라디오 버튼)의 상태 속성값을 가져오거나 새롭게 설정할 때 사용** 합니다. 그리고 선택한 요소의 태그명(tagName), 노드타입(nodeType), 선택 상자의 선택된 옵션의 인덱스(Index)값도 알 수 있습니다.

```
① $("요소선택").prop("[checked | selected]");         
② $("요소선택").prop("[checked | selected]", [true | false]);
③ $("요소선택").prop("[tagName | nodeType | selectedIndex | defaultValue]");

① true/false를 반환
② 폼 요소(체크 박스, 라디오 버튼, 선택 상자)를 선택하여 체크 또는 선택 상태를 바꿀 수 있습니다.
③ 선택한 요소의 태그명(tagName)이나 노드 타입(nodeType), 선택된 옵션의 인덱스값을 구합니다. 이때 폼 요소에 prop("defaultValue")를 사용하면 사용자가 value 속성값을 바꿔도 초기의 value 속성값을 가져옵니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var result_1 = $("#chk1").prop("checked");
		console.log(result_1);

		var result_2 = $("#chk2").prop("checked");
		console.log(result_2);

		var result_2 = $("#chk3").prop("checked", true);

		var result_3 = $("#se_1").prop("selectedIndex");    
		console.log(result_3);
	});
</script>
</head>
<body>
	<h1><strong>객체 조작 및 생성</strong></h1>
	<form action="#" id="form_1">
		<p>
			<input type="checkbox" name="chk1" id="chk1">
			<label for="chk1">chk1</label>
			<input type="checkbox" name="chk2" id="chk2" checked>
			<label for="chk2">chk2</label>
			<input type="checkbox" name="chk3" id="chk3">
			<label for="chk3">chk3</label>
		</p>
		<p>
			<select name="se_1" id="se_1">
				<option value="opt1">option1</option>
				<option value="opt2">option2</option>
				<option value="opt3" selected>option3</option>
			</select>
		</p>
	</form>
</body>
</html>
```

---

### 수치 조작 메서드
수치 조작 메서드는 요소의 속성을 조작할 때 사용하는 메서드입니다.

```
① 요소의 높잇값과 너빗값을 반환 또는 변경
$("요소선택").height(); / $("요소선택").width();
$("요소선택").height(값);/$("요소선택").width(값);

② 여백을 포함한 요소의 높잇값과 너빗값을 반환 또는 변경
$("요소선택").innerHeight(); / $("요소선택").innerWidth();
$("요소선택").innerHeight(값); / $("요소선택").innerWidth(값);

③ 여백 및 선 두께를 포함한 요소의 높잇값과 너빗값을 반환 또는 변경
$("요소선택").outerHeight(); / $("요소선택").outerWidth();
$("요소선택").outerHeight(값); / $("요소선택").outerWidth(값);
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var w1 = $("#p1").height();
		console.log(w1);

		var w2 = $("#p1").innerHeight();
		console.log(w2);

		var w3 = $("#p1").outerHeight();
		console.log(w3);

		$("#p2")
		.outerWidth(100)
		.outerHeight(100);
	});
</script>
<style>
	*{padding: 0;}
	#p1, #p2{
		width: 100px;
		height: 50px;
		padding:20px;
		border: 5px solid #000;
		background-color: #ff0;
	}
</style>
</head>
<body>
	<h1>수치 조작 메서드</h1>
	<p id="p1">내용1</p>
	<p id="p2">내용2</p>
</body>
</html>
```

---

### 요소 위치 메서드
요소 위치 메서드에는 position() 메서드와 offset() 메서드가 있습니다. **position()** 메서드는 포시션 **기준이 되는 요소를 기준으로 선택한 요소에서 가로/세로로 떨어진 위치의 좌푯값을 반환하거나 변경할 때 사용** 합니다. **offset()** 메서드는 **문서(Document)를 기준으로 선택한 요소의 가로/세로로 떨어진 위치의 좌푯값을 반환하거나 변경할 때 사용** 합니다.

```
① $("요소선택").position().[left | right | top | bottom]
② $("요소선택").offset().[left | top]

① 포지션 기준이 되는 요소를 기준으로 선택한 요소의 위치 좌푯값을 반환합니다.
② 문서(Document)를 기준으로 선택한 요소의 위치 좌푯값을 반환합니다.
```

![relative](https://github.com/hansojin/JAVA/assets/112622663/502d072b-dcce-498b-846a-f0c2c8ae32e1)

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var $txt1 = $(".txt_1 span"),
			$txt2 = $(".txt_2 span"),
			$box = $(".box");

		var off_t = $box.offset().top; //100
		var pos_t = $box.position().top; //50

		$txt1.text(off_t);
		$txt2.text(pos_t);    
	});
</script>
<style>
	*{margin:0;padding:0;}
	#box_wrap{
		width:300px;
		height:200px;
		margin:50px auto 0;
		position: relative;
		background-color:#ccc;
	}
	.box{
		width:50px;height:50px;
		position:absolute;
		left:100px;top:50px;
		background-color:#f00;
	}
</style>
</head>
<body>
	<div id="box_wrap">
		<p class="box">박스</p>
	</div>
	<p class="txt_1">절대 top위칫값: <span></span></p>
	<p class="txt_2">상대 top위칫값: <span></span></p>
</body>
</html>
```

#### 스크롤바 위치 메서드
scrollTop() scrollLeft() 메서드는 브라우저의 스크롤바가 수직/수평으로 이동한 위칫값을 불러오거나 변경할 때 사용합니다.

```
① $(요소선택).scrollTop(); $(요소선택).scrollLeft();
② $(요소선택).scrollTop(새값); $(요소선택).scrollLeft(새값);

① 스크롤바가 수직 또는 수평으로 이동한 위칫값을 반환합니다.
② 입력한 수치만큼 수직 또는 수평으로 스크롤바를 이동시킵니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var topNum = $("h1").offset().top;
		$(window).scrollTop(topNum);

		var sct = $(window).scrollTop();
		console.log(sct);
	});
</script>
<style>
	*{margin:0;padding:0;}
	body{line-height:1;}
	#wrap{
			height:5000px;
			padding-top:2000px;
	}
</style>
</head>
<body>
	<div id="wrap">
			<h1>위치 메서드</h1>
	</div>
</body>
</html>
```

---

### 객체 편집 메서드

#### before() / insertBefore() / after() /insertAfter() 메서드
before()와 insertBefore() 메서드는 선택한 요소의 이전 위치에 새 요소를 생성하고, after()와 insertAfter() 메서드는 선택한 요소의 다음 위치에 새 요소를 생성합니다.

```
① $("요소선택").before("새요소");
② $("새요소").insertBefore("요소선택");
③ $("요소선택").after("새요소");
④ $("새요소").insertAfter("요소선택");

①과 ③, ②와 ④는 서로 사용법만 다르고 기능은 같습니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		$("#wrap p:eq(2)").after("<p>After</p>");
		$("<p>insertAfter</p>").insertAfter("#wrap p:eq(1)");

		$("#wrap p:eq(1)").before("<p>Before</p>");
		$("<p>insertBefore</p>").insertBefore("#wrap p:eq(0)");

        // insertBefore > 내용1 > before > 내용2 > insertAfter > 내용3 > after
	});
</script>
</head>
<body>
	<div id="wrap">
		<p>내용1</p>
		<p>내용2</p>
		<p>내용3</p>
	</div>
</body>
</html>
```

#### append() / appendTo() / prepend() / prependTo() 메서드
append() 메서드와 appendTo() 메서드는 선택한 요소 내의 마지막 위치에 새 요소를 생성하고 추가합니다. prepend() 메서드와 prependTo() 메서드는 선택한 요소 내의 앞 위치에 새 요소를 생성하고 추가합니다.

```
① 선택한 요소 내의 마지막 위치에 새 요소를 생성하고 추가
$("요소선택").append("새요소");
$("새요소").appendTo("요소선택");

② 선택한 요소 내의 앞 위치에 새 요소를 생성하고 추가
$("요소선택").prepend("새요소");
$("새요소").prependTo("요소선택");
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		$("<li>appendTo</li>").appendTo("#listZone");
		$("#listZone").prepend("<li>prepend</li>");

        // prepend > 리스트 > appendTo
	});
</script>
</head>
<body>
	<ul id="listZone">
		<li>리스트</li>
	</ul>
</body>
</html>
```

#### clone() / empty() / remove() 메서드

clone() 메서드는 선택한 요소를 복제합니다. empty() 메서드는 선택한 요소의 모든 하위 요소를 삭제하고, remove() 메서드는 선택한 요소를 삭제합니다.

```
① $("요소선택").clone([true | false]);
② $("요소선택").empty();
③ $("요소선택").remove();

① 선택한 요소를 복제합니다. 인자값이 true면 이벤트까지 복제하고, false면 요소만 복제합니다. 기본값은 false 입니다.
② 선택한 요소의 모든 하위 요소를 삭제합니다.
③ 선택한 요소를 삭제합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		var copyObj = $(".box1").children().clone();

		$(".box2").remove( );

		$(".box3").empty( );
		$(".box3").append(copyObj);
	});
</script>
</head>
<body>
	<div class="box1">
		<p>내용1</p>
		<p>내용2</p>
	</div>
	<div class="box2">
		<p>내용3</p>
		<p>내용4</p>
	</div>
	<div class="box3">
		<p>내용5</p>
		<p>내용6</p>
	</div>
</body>
</html>
```

#### replaceAll() / replaceWith() 메서드
replaceAll() 메서드와 replaceWith() 메서드는 선택한 요소를 새 요소로 바꿀 때 사용합니다. 주로 선택한 모든 요소를 한꺼번에 바꿀 때 사용하며 각 메서드의 기본형은 다음과 같습니다.

```
$("새 요소").replaceAll("요소선택");
$("요소선택").replaceWith("새요소");
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		$("h2").replaceWith("<h3>replace method</h3>");
		$("<p>Change</p>").replaceAll("div"); 
	});
</script>
</head>
<body>
	<section class="box1">
		<h2>제목1</h2>
		<div>내용1</div>
		<div>내용2</div>
	</section>
	<section class="box2">
		<h2>제목2</h2>    
		<div>내용3</div>
		<div>내용4</div>
	</section>
</body>
</html>
```

#### unwrap() / wrap() / wrapAll() / wrapInner() 메서드
unwrap() 메서드는 선택한 요소의 부모 요소를 삭제합니다. wrap() 메서드는 선택한 요소를 각각 새 요소로 감싸고, wrapAll() 메서드는 선택한 요소를 한꺼번에 새 요소로 감쌉니다. wrapInner() 메서드는 선택한 요소의 모든 하위요소를 새 요소로 감쌉니다.

```
① $("요소선택").unwrap();
② $("요소선택").wrap("새요소");
③ $("요소선택").wrapAll("새요소");
④ $("요소선택").wrapInner("새요소");

① 선택한 요소의 부모 요소를 삭제합니다.
② 선택한 요소를 새 요소로 각각 감쌉니다.
③ 선택한 요소를 새 요소로 한꺼번에 감쌉니다.
④ 선택한 요소의 모든 요소를 새 요소로 감쌉니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 객체 조작 및 생성 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function( ){
		$("strong").unwrap( );      // 부모 요소인 h1 속성 삭제
		$(".ct1").wrap("<div />");  // 내용 1,2 각각 div 처리
		$(".ct2").wrapAll("<div />");   // 내용 3,4 전체 div 처리
		$("li").wrapInner("<h3 />");    // 모든 li 요소를 h3으로 감쌈 -> <li><h3>내용3</h3></li>
	});
</script>
<style>
	div{background-color:aqua;}
</style>
</head>
<body>
	<h1 id="tit_1">
		<strong>객체 조작 및 생성</strong>
	</h1>
	<p class="ct1">내용1</p>
	<p class="ct1">내용2</p>
	<p class="ct2">내용3</p>
	<p class="ct2">내용4</p>
	<ul>
		<li>내용3</li>
		<li>내용4</li>
	</ul>
</body>
</html>
```