### 포커스 이벤트
포커스는 마우스로 `<a>` 또는 `<input>` 태그를 클릭하거나 Tab 키를 누르면 생성됩니다. 우리가 앞에서 배운 마우스 이벤트는 마우스가 없으면 사용할 수 없습니다. 마우스가 없다면 사용자는 키보드만 가지고 사용해야겠죠. 이때 사용자가 키보드만으로 사이트를 이용해도 불편함이 없도록 제이쿼리가 잘 작동되어야 하는데, 이를 키보드 접근성이라 합니다. 키보드 접근성을 높이기 위해서는 마우스 이벤트를 등록할 때 될 수 있으면 `<a>` 또는 `<input>` 태그에 등록하고, 키보드가 없을 경우를 고려하여 마우스 이벤트에 대응할 수 있는 키보드 이벤트까지 등록해야 합니다.

그러면 마우스 이벤트에 대응하는 focus(), focusin(), blur(), focusout() 이벤트 메서드에 대해 자세히 알아보겠습니다.

#### focus() / blur() / focusin() / focusout() 이벤트 메서드	

* focus() 이벤트 메서드 : 대상 요소로 포커스가 이동하면 이벤트를 발생시킵니다.
* blur() 이벤트 메서드 : 포커스가 대상 요소에서 다른 요소로 이동하면 이벤트를 발생시킵니다.
* focusin() 이벤트 메서드 : 대상 요소의 하위 요소 중 입력 요소로 포커스가 이동하면 이벤트를 발생시킵니다.
* focusout() 이벤트 메서드 : 대상 요소의 하위 요소 중 입력 요소에서 외부 요소로 이동하면 이벤트를 발생시킵니다.


```
① focus 이벤트 등록
$("이벤트 대상 선택").focus(function() { 자바스크립트 코드; });		// (deprecated)
$("이벤트 대상 선택").on("focus", function() { 자바스크립트 코드; });

② focus 이벤트 강제 발생
$("이벤트 대상 선택").focus();		// (deprecated)

③ blur 이벤트 등록
$("이벤트 대상 선택").blur(function() { 자바스크립트 코드; });		// (deprecated)
$("이벤트 대상 선택").on("blur", function() { 자바스크립트 코드; });

④ blur 이벤트 강제 발생
$("이벤트 대상 선택").blur();		// (deprecated)

① focusin 이벤트 등록
$("이벤트 대상 선택").focusin(function() { 자바스크립트 코드; });	// (deprecated)
$("이벤트 대상 선택").on("focusin", function() { 자바스크립트 코드; });

② focusin 이벤트 강제 발생
$("이벤트 대상 선택").focusin();	// (deprecated)

③ focusout 이벤트 등록
$("이벤트 대상 선택").focusout(function() { 자바스크립트 코드;});	// (deprecated)
$("이벤트 대상 선택").on("focusout", function() { 자바스크립트 코드; });

④ focus 이벤트 강제 발생
$("이벤트 대상 선택").focusout();	// (deprecated)
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$("#user_id_1, #user_pw_1").on("focus", 
	    function(){
		    $(this).css({"background-color":"pink"});
	});
	$("#user_id_1, #user_pw_1").on("blur",
	    function(){
		    $(this).css({"background-color":"#fff"});
	});

	$("#frm_2").on("focusin",
	    function(){
		    $(this).css({"background-color":"pink"});
	});
	$("#frm_2").on("focusout",
	    function(){
		    $(this).css({"background-color":"#fff"});
	});
});
</script>
</head>
<body>
<h1>focus / blur</h1>
<form action="#">
	<p>
		<label for="user_id_1">ID</label>
		<input type="text" 
		name="user_id_1" id="user_id_1">
	</p>
	<p>
		<label for="user_pw_1">PW</label>
		<input type="password" 
		name="user_pw_1" id="user_pw_1">
	</p>
</form>
<h1>focusin / focusout</h1>
<form action="#" id="frm_2">
	<p>
		<label for="user_id_2">ID</label>
		<input type="text" 
		name="user_id_2" id="user_id_2">
	</p>
	<p>
		<label for="user_pw_2">PW</label>
		<input type="password" 
		name="user_pw_2" id="user_pw_2">
	</p>
</form>
</body>
</html>
```

#### 키보드로 마우스 이벤트 대응하기
키보드 접근성이란 어떤 대상 요소에 마우스 이벤트를 등록했을 때 마우스 없이 키보드로 대상 요소를 사용할 수 있게 하는 것을 말합니다. 다음과 같이 마우스 이벤트가 등록되었을 때는 반드시 키보드로 작동할 수 있게 대응 이벤트를 함께 작성해야 합니다.

| 마우스 이벤트 | 키보드 이벤트 |
| ------------ | ------------ |		
|mouseover	|focus|
|mouseout	|blur|


다음은 버튼에 마우스 포인터를 올리면 마우스 이벤트가 발생되어 '내용1'이 숨겨지는 예입니다.  이 예는 마우스가 없으면 동작하지 않습니다. 

```
1. 키보드 접근성을 배려하지 않은 이벤트 예 (비추천)
<button class="btn">버튼</button>
<p class="txt_1">내용1</p>

$(".btn").mouseover(function() {
	$(".txt_1").hide();
});
```

하지만 해당 이벤트에 대응하는 키보드 이벤트도 함께 등록하면 마우스가 없는 사용자도 키보드를 사용해 이 버튼의 기능을 사용할 수 있습니다. *(Tab키를 누르면 포커스를 이동할 수 있습니다.)*

```
2. 키보드 접근성을 배려한 이벤트 적용 예 (추천)
<button class="btn">버튼</button>
<p class="txt_1">내용1</p>

$(".btn").on("mouseover focus", function() {
	$(".txt_1").hide();
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
$(function(){
	$("#btn1")
	.data({"text":"javascript"})
	.on({
		"mouseover": overFnc,
		"mouseout": outFnc
	});

	$("#btn2")
	.data({"text":"welcome!"})
	.on({
		"mouseover focus": overFnc,
		"mouseout blur": outFnc
	});

	function overFnc() {
		$(".txt").text($(this).data("text"));
	}
	function outFnc() {
		$(".txt").text("");
	}
});
</script>
</head>
<body>
	<p><button id="btn1">버튼1</button></p>
	<p><button id="btn2">버튼2</button></p>
	<p class="txt"></p>
</body>
</html>
```

#### change() 이벤트 메서드

change() 이벤트 메서드는 선택한 폼 요소의 값(value)을 새 값으로 바꿉니다. 그리고 포커스가 다른 요소로 이동하면 이벤트를 발생시킵니다. change() 이벤트 등록 메서드의 기본형은 다음과 같습니다.

```
① change 이벤트 등록
$("이벤트 대상 선택").change(function() { 자바스크립트 코드; });	 // (deprecated)
$("이벤트 대상 선택").on("change", function() { 자바스크립트 코드; });

② change 이벤트 강제 발생
$("이벤트 대상 선택").change();	 // (deprecated)
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$("#rel_site").on("change", function(){
		$(".txt").text($(this).val());
	});
});
</script>
</head>
<body>
<select id="rel_site">
		<option value="">사이트 선택</option>
		<option value="www.google.com">구글</option>
		<option value="www.naver.com">네이버</option>
		<option value="www.daum.net">다음</option>
</select>
<p class="txt"></p>
</body>
</html>
```


#### 키보드 이벤트

키보드 이벤트는 사용자가 키보드로 입력을 하면 발생합니다. 예를 들어 키를 누르거나 키에서 손을 떼면 키보드 이벤트가 발생합니다.

#### keydown() / keyup() / keypress() 이벤트 메서드	
keydown()와 keypress() 이벤트 메서드는 선택한 요소에서 키보드 자판을 눌렀을 때 이벤트를 발생시키거나 해당 이벤트를 강제로 발생시킵니다. 두 이벤트의 차이점을 보면 keydown()은 모든 키(한글 키 제외)에 대해서 이벤트를 발생시키지만 keypress()는 기능키(F1~F12, Alt, Ctrl, Shift, ↑, Backspace, Caps Lock, 한/영, Tab 등)에 대해서는 이벤트를 발생시키지 않습니다. 또한 키보드 이벤트 핸들러에서 생성된 이벤트 객체의 속성을 이용하면 고유 키의 코드값을 구할 수 있습니다. 그리고 이를 사용하여 단축키 기능을 만들 수 있습니다.

keyup() 이벤트 메서드는 자판의 키를 눌렀다 키에서 손을 때면 이벤트를 발생시키거나 keyup 이벤트를 강제로 발생시킵니다. 다음은 keydown(), keyup(), keypress() 이벤트 메서드의 기본형입니다.

```
① keydown 이벤트 등록	
① $("이벤트 대상 선택").keydown(function() { 자바스크립트 코드; });	// (deprecated)
② $("이벤트 대상 선택").on("keydown", function() { 자바스크립트 코드; });

② keydown 이벤트 강제 발생
$("이벤트 대상 선택").keydown();	// (deprecated)

③ keyup 등록		
① $("이벤트 대상 선택").keyup(function() { 자바스크립트 코드; });	// (deprecated)
② $("이벤트 대상 선택").on("keyup", function() { 자바스크립트 코드;});

④ keyup  이벤트 강제 발생	
$("이벤트 대상 선택").keyup();		// (deprecated)

⑤ keypress 등록		
① $("이벤트 대상 선택").keypress(function() { 자바스크립트 코드; });	// (deprecated)
② $("이벤트 대상 선택").on("keypress", function() { 자바스크립트 코드; });

⑥ keypress 이벤트 강제 발생	
$("이벤트 대상 선택").keypress();	// (deprecated)
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$(document).on("keydown", keyEventFnc);
	function keyEventFnc(e) {
	var direct = "";

	switch(e.keyCode){
		case 37: direct = "LEFT";
		break;
		case 38: direct = "TOP";
		break;
		case 39: direct = "RIGHT";
		break;
		case 40: direct = "BOTTOM";
		break;
	}
	
	if(direct) $("#user_id").val(direct);
	}
});
</script>
</head>
<body>
	<p><input type="text" name="user_id" id="user_id"></p>
</body>
</html>
```

---

#### 이벤트가 발생한 요소 추적하기
이번에는 사이트 방문자가 이벤트를 발생시킨 요소의 정보를 구해오는 방법에 대해 알아보겠습니다. 이벤트가 발생한 요소를 선택해 오는 선택자 `$(this)`의 사용법과 개념을 알아보고, 이벤트가 발생한 요소의 인덱스값을 반환하는 index() 인덱스 반환 메서드에 대해서도 알아 볼 것입니다. 이를 이용하면 이벤트를 발생한 요소를 다양하게 제어할 수 있습니다. 

#### `$(this)` 선택자
이벤트 핸들러에서 `$(this)`를 사용하면 이벤트가 발생한 요소를 선택하여 이벤트가 발생한 요소를 추적할 수 있습니다.

#### index() 인덱스 반환 메서드
index() 인덱스 반환 메서드는 이벤트를 등록한 요소 중 이벤트가 발생한 요소의 인덱스 값을 반환합니다.

```
$("이벤트 대상 선택").on("이벤트 종류", function() {
	$("이벤트 대상 선택").index(this);
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
$(function(){
	$(".menuWrap_1 a").on("click", function(e) {
		e.preventDefault();

		$(".menuWrap_1 a")
		    .css({"background-color":"#fff"});

		$(this)
		    .css({"background-color":"#ff0"});
	});

	$(".menuWrap_2 a").on("click", function(e) {
		e.preventDefault();

		$(".menuWrap_2 a")
		    .css({"background-color":"#fff"});

		var idx = $(".menuWrap_2 a").index(this);

		$(".menuWrap_2 a").eq(idx)
		    .css({"background-color":"#0ff"});
		
		$(".idxNum").text(idx);
	});
});
</script>
</head>
<body>
<h2>$(this)</h2>
<ul class="menuWrap_1">
	<li><a href="#">메뉴1</a></li>
	<li><a href="#">메뉴2</a></li>
	<li><a href="#">메뉴3</a></li>
</ul>
<h2>Index( )</h2>   
<ul class="menuWrap_2">
	<li><a href="#">메뉴4</a></li>
	<li><a href="#">메뉴5</a></li>
	<li><a href="#">메뉴6</a></li>
</ul>
<p class="idxNum"></p>
</body>
</html>
```

---


### 그룹 이벤트 등록 메서드

| 그룹 이벤트 등록 메서드 | 설명 |
| --------------------- | ---- |		
|on()|		이벤트 대상 요소에 2개 이상의 이벤트를 등록합니다. 사용 방식에 따라 이벤트를 등록한 이후에도 동적으로 생성되거나 복제된 요소에도 이벤트가 적용됩니다.		
|bind()|	이벤트 대상 요소에 2개 이상의 이벤트를 등록합니다. *(deprecated)*
|delegate()|	선택한 요소의 하위 요소에 이벤트를 등록합니다. 이벤트를 등록한 이후에도 동적으로 생성되거나 복제된 요소에도 이벤트가 적용됩니다.*(deprecated)*
|one()|		이벤트 대상 요소에 1개 이상의 이벤트를 등록합니다. 지정한 이벤트가 1회 발생하고 자동으로 해제됩니다.

#### on() 메서드
on() 메서드는 선택한 요소에 이벤트를 등록한 이후에도 새롭게 생성되거나 복제된 요소에 이벤트를 적용할 수 있습니다. 즉, 동적으로 생성되거나 복제된 요소에도 이벤트가 등록됩니다.

동적으로 생성된 요소에도 이벤트가 등록되는 on() 메서드의 '라이브 이벤트 등록 방식'의 기본형이다.

```
$([document | "이벤트 대상의 상위 요소 선택"]).on("이벤트 종류", "이벤트 대상 선택", function(){
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
$(function(){
		$(".btn_1.on").on("mouseover focus", function() {
			alert("HELLO!");
		});
		$(".btn_1").addClass("on");

		$(document).on("mouseover focus",".btn_2.on", function() {
				alert("WELCOME!");
		});
		$(".btn_2").addClass("on");
});
</script>
</head>
<body>
	<div id="wrap">
		<p><button class="btn_1">버튼1</button></p>
		<p><button class="btn_2">버튼2</button></p>
	</div>
</body>
</html>
```

#### delegate()/one() 이벤트 등록 메서드	
delegate()  이벤트 등록 메서드는 선택한 요소의 하위 요소에 이벤트를 등록합니다. 그리고 이벤트를 등록한 이후에도 동적으로 생성된 요소와 복제된 요소에도 이벤트를 등록합니다. *(deprecated)*

```
$([document | "이벤트 대상의 상위 요소 선택"]).delegate("이벤트 대상 요소 선택", "이벤트 종류", function(){
	자바스크립트 코드;
});

① one() 기본 이벤트 등록 방식
$("이벤트 대상 선택").one("이벤트 종류", function(){
	자바스크립트 코드;
});

② one() 라이브 이벤트 등록 방식
$([document | "이벤트 대상의 상위 요소 선택"]).one("이벤트 종류", "이벤트 대상 요소 선택", function(){
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
$(function(){
	$(".btn_wrap").delegate(".btn_1.on", 
	"mouseover focus", function() {
		alert("HELLO!");
	});
	$(".btn_1").addClass("on");

	$(document).one("mouseover focus", 
	".btn_2.on", function() {
		alert("WELCOME!");
	});
	$(".btn_2").addClass("on");
});
</script>
</head>
<body>
<div id="wrap">
	<p class="btn_wrap">
		<button class="btn_1">버튼1</button>
	</p>
	<p><button class="btn_2">버튼2</button></p>
</div>
</body>
</html>
```

### 이벤트 제거 메서드


| 이벤트 제거 메서드 | 설명 |
| ---------------- | ---- |
|off()	|		on() 메서드로 등록한 이벤트를 제거합니다.
|unbind()|		bind() 메서드로 등록한 이벤트를 제거합니다.	*(deprecated)*
|undelegate()	|delegate() 메서드로 등록한 이벤트를 제거합니다.	*(deprecated)*


#### off() / unbind() / undelegate()로 이벤트 해제하기
이벤트 등록 메서드에 따라 이벤트를 해제하는 방법도 달라집니다. on() 메서드는 off() 메서드로,
bind() 메서드는 unbind() 메서드로, delegate() 메서드는 undelegate() 메서드로 이벤트를
해제합니다.

```
① on() 이벤트 해제를 위한 off() 메서드
- 기본 이벤트 제거 방식
$("이벤트 대상 요소 선택").off("이벤트 종류");
- 라이브 이벤트 제거 방식
$([document | "이벤트 대상 상위 요소 선택"]).off("이벤트 종류", "이벤트 대상 요소 선택");

② bind() 이벤트 해제를 위한 unbind() 메서드
$("이벤트 대상 요소 선택").unbind("이벤트 종류")

③ delegate() 이벤트 해제를 위한 undelegate() 메서드
- 기본 이벤트 제거 방식
$("이벤트 대상 요소 선택").delegat("이벤트 종류");
- 라이브 이벤트 제거 방식
$([document | "이벤트 대상의 상위 요소 선택"]).undelegate("이벤트 대상 선택", "이벤트 종류");
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 이벤트 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$(".btn_1").on("mouseover", function() {
		alert("HELLO!");
	});
	$(document).on("mouseover", ".btn_2", function() {
		alert("WELCOME!");
	});   

	var btn_2 = $("<p><button class=\"btn_2\">버튼2</button></p>");
	$("#wrap").append(btn_2);

	$(".del_1").on("click", function(){
		$(".btn_1").off("mouseover");
	});
	$(".del_2").on("click", function(){
		$(document).off("mouseover",".btn_2");
	});
});
</script>
</head>
<body>
<div id="wrap">
	<p><button class="btn_1">버튼1</button></p>
</div>
<p>
	<button class="del_1">버튼1 이벤트 해지</button> 
	<button class="del_2">버튼2 이벤트 해지</button>
</p>
</body>
</html>
```