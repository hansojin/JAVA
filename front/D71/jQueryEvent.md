제이쿼리 이벤트 방문자의 모든 동작을 **이벤트**라고 하고, 이벤트가 발생했을 때 코드를 실행시키는 것을 **이벤트 핸들러**라고 합니다. 가령 방문자가 웹사이트에 방문했을 때 지정한 버튼에 마우스 포인터를 올리거나 클릭했을 때 글자의 크기가 커졌다면 여기서 버튼 위에 마우스 포인터를 올린 행위는 이벤트라 볼 수 있으며, 이 행위로 글자의 크기가 변경된 것은 동작이 일어났을 때 실행되는 코드이므로 이벤트 핸들러라 볼 수 있습니다. 

#### 이벤트 등록 메서드

이벤트란 사이트에서 방문자가 취하는 모든 행위를 말하고, 이벤트 핸들러는 이벤트가 발생했을 때 실행되는 코드를 말합니다.

이벤트 등록 메서드에는 하나의 이벤트만 등록할 수 있는 단독 이벤트 등록 메서드와 2개 이상의 이벤트를 등록할 수 있는 그룹 이벤트 등록 메서드가 있습니다. 단독 이벤트 메서드는 한 동작에 대한 이벤트를 등록할 때 사용하는 메서드입니다. 예를 들어 '요소를 클릭했을 때', '요소를 더블클릭했을 때', '요소에 마우스 포인터를 올렸을 때' 등 하나의 이벤트에만 대응하여 이벤트 핸들러의 코드가 실행됩니다.

#### 이벤트 등록 방식 
지정한 요소에 이벤트를 등록하는 방법에는 대상에 한 가지 동작에 대한 이벤트만 등록할 수 있는 **단독 이벤트 등록 방식** 과 대상에 한 가지 동작 이상의 이벤트를 등록할 수 있는 **그룹 이벤트 등록 방식** 의 두 종류가 있습니다.

```
1. 단독 이벤트 등록 메서드 
$("이벤트 대상 선택").이벤트 등록 메서드(function() {
	자바스크립트 코드;
});

<button id="btn1">버튼</button>
$("#btn1").click(function() {				
	alert("welcome");
});
```

```
2. 그룹 이벤트 등록 메서드 

① on() 메서드 등록 방식 1
$("이벤트 대상 선택").on("이벤트 종류1 이벤트 종류2 ... 이벤트 종류n",
function(){
	자바스크립트 코드;
});

② on() 메서드 등록 방식2
$("이벤트 대상 선택").on({
	"이벤트 종류1 이벤트 종류2 ... 이벤트 종류n" : function(){
		자바스크립트 코드;
	}
});

③ on() 메서드 등록 방식3
$("이벤트 대상 선택").on({
	"이벤트 종류1" : function() {자바스크립트 코드;1},
	"이벤트 종류2" : function() {자바스크립트 코드;2},
	...
	"이벤트 종류n" : function() {자바스크립트 코드;n}
});

// on() example
<button id="btn1">버튼</button>

① on() 메서드 등록 방식 1
$("#btn1").on("mouseover focus", function(){
	console.log("welcome");
})

② on() 메서드 등록 방식 2
$("#btn1").on({
	"mouseover focus" : function() {
		console.log("welcome");
	}
});

③ on() 메서드 등록 방식 3
$("#btn1").on({
	"mouseover" : function(){
		console.log("welcome");
	},
	"focus" : function() {
		console.log("welcome");
	}
});
```
```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(".btn1").click(function(){			// (deprecated)
		$(".btn1").parent().next()
		.css({"color":"#f00"});
	});

	$(".btn2").on({
		"mouseover focus": function() {
			$(".btn2").parent().next()
			.css({"color":"#0f0"});
		},
		"mouseout blur": function() {
			$(".btn2").parent().next()
			.css({"color":"#000"});
		},
	});   
});
</script>
</head>
<body>
	<p>
	<button class="btn1">버튼1</button>
	</p>
	<p>내용1</p>
	<p>
		<button class="btn2">버튼2</button>
	</p>
	<p>내용2</p>
</body>
</html>
```

#### 강제로 이벤트 발생시키기

'이벤트가 강제로 발생했다'는 말은 '사용자에 의해' 이벤트가 발생했음을 의미하는 것이 아니라 '핸들러에 의해' 자동으로 이벤트가 발생했음을 의미한다. 예를 들어 버튼을 클릭할 때마다 변수의 값의 1씩 증가하는 버튼이 있다고 생각해 보자. 변수의 값을 증가시키려면 사용자가 직접 버튼을 클릭해야 한다. 하지만 **단독 이벤트 등록 메서드를 사용** 하거나 **trigger()** 메서드를 사용하면 강제로 이벤트를 발생시킬 수 있다. 즉, 사용자가 버튼을 클릭하지 않아도 변수가 증가한다.

```
① $("이벤트 대상").단독 이벤트 등록 메서드();
② $("이벤트 대상").trigger("이벤트 종류");
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(".btn1").click(function(){
			$(".btn1").parent().next( )
			.css({"color":"#f00"});
	});

	$(".btn2").on({
			"mouseover focus": function() {
				$(".btn2").parent().next( )
				.css({"color":"#0f0"});
			}
	});

	$(".btn1").click();   
	$(".btn2").trigger("mouseover");
});
</script>
</head>
<body>
	<p>
	<button class="btn1">버튼1</button>
	</p>
	<p>내용1</p>
	<p>
		<button class="btn2">버튼2</button>
	</p>
	<p>내용2</p>
</body>
</html>
```

#### 이벤트 제거 메서드
이벤트를 제거하는 메서드로 **off()** 가 있습니다. 

```
$("이벤트 대상").off("제거할 이벤트 종류");
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(".btn1").click(function(){
		$(".btn1").parent().next( )
		.css({"color":"#f00"});
	});

	$(".btn2").on({
		"mouseover focus": function() {
				$(".btn2").parent().next( )
				.css({"color":"#0f0"});
		}
	});

	$(".btn1").off("click");
	$(".btn2").off("mouseover focus");    
});
</script>
</head>
<body>
	<p>
	<button class="btn1">버튼1</button>
	</p>
	<p>내용1</p>
	<p>
		<button class="btn2">버튼2</button>
	</p>
	<p>내용2</p>
</body>
</html>
```

---

**개발자 도구를 사용하면 이벤트 등록 여부를 확인할 수 있다.(Event Listeners)**

#### 로딩 이벤트 메서드
로딩 이벤트 메서드는 사용자가 브라우저에서 HTML 문서를 요청하여 HTML 문서의 로딩이 완료되면 이벤트 핸들러를 실행합니다. 로딩 이벤트 메서드에는 ready()와 load()가 있습니다.

#### ready()/load() 이벤트 메서드		
ready() 이벤트 메서드는 사용자가 사이트를 방문할 때 요청한 HTML 문서 객체(document)의 로딩이 끝나면 이벤트를 발생시킵니다. load() 이벤트 메서드는 외부에 연동된 소스(iframe, img, video)의 로딩이 끝나면 이벤트를 발생시킵니다. *(deprecated)*

```
① $(document).ready(function() {자바스크립트 코드; });		(deprecated)
② $(document).on("ready", function() {자바스크립트 코드;});
③ $(window).load(function() { 자바스크립트 코드; });		(deprecated)
④ $(window).on("load", function() { 자바스크립트 코드; });
```

다음은 ready(), load() 이벤트 메서드를 사용한 예제입니다. 외부에서 불러온 이미지의 로딩이 끝나면 이미지의 높잇값을 콘솔 패널에 출력합니다.
```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(document).ready(function(){
		var h1 = $(".img1").height();
		console.log("ready :", h1);
	});     // (deprecated)

	$(window).load(function(){
		var h2 = $(".img1").height();
		console.log("load :", h2);
	});     // (deprecated)
});
</script>
</head>
<body>
	<p>
		<img src="http://place-hold.it/300X300" class="img1">
	</p>
</body>
</html>
```

---

### 마우스 이벤트
마우스 이벤트는 사용자가 사이트에서 마우스를 이용해서 취하는 모든 행위를 말합니다. 가령 사용자가 지정한 요소에 마우스 포인터를 올리거나 클릭하는 등의 행위를 말합니다.

#### click() / dblclick() 이벤트 메서드
click() 이벤트 메서드는 선택한 요소를 클릭했을 때 이벤트를 발생시키거나 선택한 요소에 강제로 클릭 이벤트를 발생시킬 때 사용합니다.

```
① click 이벤트 등록
$("이벤트 대상 선택").click(function() { 자바스크립트 코드; });		(deprecated)
$("이벤트 대상 선택").on("click", function() { 자바스크립트 코드; });

② click 이벤트 강제 발생
$("이벤트 대상 선택").click();		(deprecated)

① dblclick 이벤트 등록
$("이벤트 대상 선택").dblclick(function() { 자바스크립트 코드; });		(deprecated)
$("이벤트 대상 선택").on("dblclick", function() { 자바스크립트 코드; });

② dblclick 이벤트 강제 발생
$("이벤트 대상 선택").dblclick();		(deprecated)
```

#### `<a>`, `<form>` 태그에 클릭 이벤트 적용 시 기본 이벤트 차단하기
`<a>` 요소에 click이나 dblclick을 등록하면 클릭할 때마다 `<a>`에 링크된 주소로 이동하는 문제가 발생합니다. 이 문제를 해결하려면 `<a>` 요소의 기본 이벤트를 차단해야 합니다. `<form>` 요소의 제출버튼(submit)도 action에 등록된 주소로 이동시키는 문제가 발생합니다. 우리가 등록한 이벤트를 정상적으로 수행하려면 이러한 기본 이벤트를 차단해야 합니다.

다음은 `<a>`, `<form>` 태그에 이벤트를 등록하기 위해 기본 이벤트를 차단하는 기본형입니다.

```
① return false를 이용한 차단 방식
$("a 또는 form").이벤트 메서드(function() {
	자바스크립트 코드;
	return false;
});

② preventDefault() 메서드를 이용한 차단 방식
$("a 또는 form").이벤트 메서드(function(e){
	e.preventDefault();
	자바스크립트 코드;
});
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(".btn1").on("click", function(e){
		e.preventDefault( );        // 링크 이동 X
		$(".txt1")
		.css({"background-color":"#ff0"});
	});
	$(".btn2").on("click", function(e){
		$(".txt2")                  // 링크 이동 O
		.css({"background-color":"#0ff"});
	});
	$(".btn3").on("dblclick", function(){
		$(".txt3")
		.css({"background-color":"#0f0"});
	});   
});
</script>
</head>
<body>
	<p><a href="http://www.easyspub.co.kr/" class="btn1">버튼1</a></p>
	<p class="txt1">내용1</p>
	<p><a href="http://www.easyspub.co.kr/" class="btn2">버튼2</a></p>
	<p class="txt2">내용2</p>
	<p><button class="btn3">버튼3</button></p>
	<p class="txt3">내용3</p>
</body>
</html>
```

#### mouseover() /mouseout() / hover() 이벤트 메서드		

mouseover() 이벤트 메서드는 선택한 요소에 마우스 포인터를 올릴 때마다 이벤트를 발생시키거나 선택한 요소에 mouseover 이벤트를 강제로 발생시킵니다. mouseout() 이벤트 메서드는 선택한 요소에서 마우스 포인터가 벗어날 때마다 이벤트를 발생시키거나 선택한 요소에 mouseout 이벤트를 강제로 발생시킵니다. 그리고 hover() 이벤트 메서드는 선택한 요소에 마우스 포인터가 올라갈 때와 선택한 요소에서 벗어날 때 각각 이벤트를 발생시키며, 이때 각각 다른 이벤트 핸들러를 실행시킵니다. *(deprecated)*

```
① mouseover 이벤트 등록
$("이벤트 대상 선택").mouseover(function() { 자바스크립트 코드; });		// (deprecated)
$("이벤트 대상 선택").on("mouseover", function() { 자바스크립트 코드; });

② mouseover 이벤트 강제 발생
$("이벤트 대상 선택").mouseover();		// (deprecated)

① mouseout 이벤트 등록
$("이벤트 대상 선택").mouseout(function() { 자바스크립트 코드; });		// (deprecated)
$("이벤트 대상 선택").on("mouseout", function() { 자바스크립트 코드; });

② mouseout 이벤트 강제 발생
$("이벤트 대상 선택").mouseout();		// (deprecated)

① hover 이벤트 등록
$("이벤트 대상 선택").hover(
	function() { 마우스 오버 시 실행될 코드},
	function() { 마우스 아웃 시 실행될 코드}
);
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(".btn1").on({
		"mouseover" : function( ) {
			$(".txt1")
			.css({"background-color":"yellow"});
		},
		"mouseout" : function( ) {
			$(".txt1")
			.css({"background":"none"});
		}
	});

	$(".btn2").hover(function( ) {
		$(".txt2")
		.css({"background-color":"aqua"});
	}, function(){
		$(".txt2")
		.css({"background":"none"});
	});
});
</script>
</head>
<body>
	<p><button class="btn1">Mouse Over/Mouse Out</button></p>
	<p class="txt1">내용1</p>
	<p><button class="btn2">Hover</button></p>
	<p class="txt2">내용2</p>
</body>
</html>
```

#### mouseenter() / mouseleave() 이벤트 메서드		
mouseenter() 이벤트 메서드는 대상 요소의 경계 범위에 마우스 포인터가 들어오면 이벤트를 발생시키고, mouseleave() 이벤트 메서드는 대상 요소의 경계 범위에서 마우스 포인터가 완전히 벗어나면 이벤트를 발생시킵니다. *(deprecated)*

```
① mouseenter 이벤트 등록
$("이벤트 대상 선택").mouseenter(function() { 자바스크립트 코드; });		// (deprecated)
$("이벤트 대상 선택").on("mouseenter", function() { 자바스크립트 코드; });

② mouseenter 이벤트 강제 발생
$("이벤트 대상 선택").mouseenter();

① mouseleave 이벤트 등록
$("이벤트 대상 선택").mouseleave(function() { 자바스크립트 코드; });		// (deprecated)
$("이벤트 대상 선택").on("mouseleave", function() { 자바스크립트 코드; });

② mouseleave 이벤트 강제 발생
$("이벤트 대상 선택").mouseleave();
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$("#box_1").on("mouseout", function(){
		$("#box_1")
		.css({"background-color":"yellow"});
	});
	
	$("#box_2").on("mouseleave", function(){
		$("#box_2")
		.css({"background-color":"pink"});
	});
});
</script>
</head>
<body>
<h1>mouseout</h1>
<div id="box_1">
				<p><a href="#">내용1</a></p>
				<p><a href="#">내용2</a></p>
				<p><a href="#">내용3</a></p>
</div>

<h1>mouseleave</h1>
<div id="box_2">
				<p><a href="#">내용4</a></p>
				<p><a href="#">내용5</a></p>
				<p><a href="#">내용6</a></p>
</div>
</body>
</html>
```

#### mousemove() 이벤트 메서드			

```
① mousemove 이벤트 등록
① $("이벤트 대상 선택").mousemove(function() {자바스크립트 코드; });
② $("이벤트 대상 선택").on("mousemove", function() {자바스크립트 코드; });

② mousemove 이벤트 발생
$("이벤트 대상 선택").mousemove();
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(document).on("mousemove", function(e) {
		$(".posX").text(e.pageX);
		$(".posY").text(e.pageY);
	});
});
</script>
</head>
<body>
<h1>mousemove</h1>
<p>X : <span class="posX">0</span>px</p>
<p>Y : <span class="posY">0</span>px</p>
</body>
</html>
```

---

#### 이벤트 객체와 종류
사용자가 이벤트를 발생시킬 때마다 이벤트 핸들러의 매개변수에는 이벤트 객체가 생성되며, 이벤트 객체에는 이벤트 타입에 맞는 다양한 정보를 제공하는 속성과 메서드가 포함되어 있습니다. 다음은 이벤트 객체를 생성하기 위한 기본형입니다.

```
$("이벤트 대상 선택").mousemove(function(매개변수) {
	매개변수(이벤트 객체).속성;
});
```

#### scroll() 이벤트 메서드
scroll() 이벤트 메서드는 대상 요소의 스크롤바가 이동할 때마다 이벤트를 발생시키거나 강제로 scroll 이벤트를 발생시키는 데 사용합니다.

```
① scroll 이벤트 등록
$("이벤트 대상 선택").scroll(function() { 자바스크립트 코드; });	// deprecated
$("이벤트 대상 선택").on("scroll", function() { 자바스크립트 코드; });

② scroll 이벤트 강제 발생
$("이벤트 대상 선택").scroll();
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
	$(window).on("scroll",function(e){
		$(".top").text($(this).scrollTop());
		$(".left").text($(this).scrollLeft());
	});
</script>
<style>
	body{
		height:10000px;
		width:5000px;
	}
	#wrap{
		position: fixed;
		left: 10px; top: 10px;
	}
</style>
</head>
<body>
<div id="wrap">
	<p>scrollTop: <span class="top">0</span>px</p>
	<p>scrollLeft: <span class="left">0</span>px</p>
</div>
</body>
</html>
```