## 제이쿼리란?

제이쿼리는 모질라 사의 자바스크립트 개발자였던 존 레식(John Resig)이 **자바스크립트를 이용해 만든 라이브러리 언어**이다. 라이브러리 언어란 자바스크립트로 만들어진 **다양한 함수들의 집합** 을 가리킨다.

제이쿼리에서 개선된 사항들은 다음과 같습니다.

1. 호환성 문제 해결
자바스크립트의 문서 객체 모델(DOM)과 이벤트 객체(Event Object)는 호환성(크로스 브라우징)이 떨어진다는 단점이 있습니다.

2. 쉽고 편리한 애니메이션 효과 기능 구현
자바스크립트로 애니메이션 효과를 구현하려면 많은 코드를 사용해야 하기 때문에 개발에 많은 시간이 필요했습니다. 하지만 제이쿼리는 애니메이션과 다양한 효과(Effect)를 지원하는 메서드를 제공하기 때문에 개발 시간을 많이 단축할 수 있습니다.


### 제이쿼리 라이브러리 연동

1. 제이쿼리 다운로드를 통해 연동
`jquery.com` 에서 원하는 버전의 코드를 저장하고 html 문서에 `<script src='path'></script>` 삽입

2. CDN 연동방식
`code.jquery.com`에서 원하는 버전을 선택하면, 복사할 수 있는 코드가 나옴

    *Content Delivery Network의 약자인 CDN은 지리적 제약 없이 전 세계 사용자에게 빠르고 안전하게 콘텐츠를 전송할 수 있는 콘텐츠 전송 기술로 서버와 사용자 사이의 물리적인 거리를 줄여 콘텐츠 로딩에 소요되는 시간을 최소화함. 각 지역에 캐시 서버(PoP, Points of presence)를 분산 배치해, 근접한 사용자의 요청에 원본 서버가 아닌 캐시 서버가 콘텐츠를 전달*

---

### 선택자

![3  DOM Tree](https://github.com/hansojin/JAVA/assets/112622663/8c12fc79-e5e5-42fc-89bb-76d24b66df32)


HTML의 문서 객체 구조를 그림으로 표현하면 트리 구조가 됩니다. 이때 가장 상위에 위치하는 `<html>`은 뿌리(Root)라고 부르고, 뿌리로부터 가지처럼 뻗어나가는 모양의 요소를 노드(Node)라고 부릅니다. 노드의 종류에는 요소 노드(Element Node), 텍스트 노드(Text Node), 속성 노드(Attribute Node)가 있습니다.

#### 선택자 사용하기

선택자를 사용하기 위해서는 문서 객체를 불러와야 합니다. 

[방법 1]은 제이쿼리가 먼저 실행되고 그 다음 `<body>` 영역에 문서 객체를 불러옵니다. 이렇게 하면 `<body>`가 생성되기 이전에 선택자가 먼저 실행되어 선택자로 문서 객체를 선택할 수 없습니다.

```
// 방법1(잘못된 적용)
<head>
...
<script src="js/jquery.js"></script>
<script>
	$("#txt").css("color", "red");
</script>
</head>
<body>
	<p id="txt">내용</p>
</body>
```

`<body>` 영역에 문서 객체를 먼저 불러온 다음 선택자를 사용할 수 있도록 [방법2]나 [방법3]과 같이 작성해야 합니다.

```
// 방법2 (정상 적용)
<head>
...
<script src="js/jquery.js"></script>
<script>
$(document).ready(function(){
	$("#txt").css("color", "red");
});
</script>
</head>
<body>
	<p id="txt">내용</p>
</body>

// 방법3 (정상 적용 _ 보통 가장 많이 사용되는 형태)
<head>
...
<script src="js/jquery.js"></script>
<script>
$(function(){
	$("#txt").css("color", "red");
});
</script>
</head>
<body>
	<p id="txt">내용</p>
</body>
```

다음은 제이쿼리 선택자로 **스타일이나 속성을 적용** 하는 기본형입니다. 선택자는 **$()** 에 문자형 데이터로 CSS 선택자를 입력하면 됩니다.

```
기본형
1. 선택한 요소에 지정한 스타일을 적용합니다.
$("CSS 선택자").css("스타일 속성명", "값");

2. 선택한 요소에 지정한 속성을 적용합니다.
$("CSS 선택자").attr("속성명", "값");
```

다음은 제이쿼리의 아이디 선택자를 적용하여 글자 색상을 바꾸는 예제입니다.

```
<head>
<meta charset="UTF-8">
<title> 선택자 </title>
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#title").css("color","red");
	});
</script>
</head>
<body>
	<h1 id="title">제목</h1>
</body>
```


#### 기본 선택자

이번에는 `<body>` 영역에 있는 문서 객체를 선택할 수 있는 선택자를 살펴보겠습니다. 제이쿼리의 기본 선택자는 다음과 같이 직접 선택자와 인접 관계 선택자로 나눌 수 있습니다.

```
 <기본 선택자 종류 >

구분		종류		사용법			설명
직접 선택자	전체 선택자	$("*")			모든 요소를 선택합니다.
		아이디 선택자	$("#아이디명")		id 속성에 지정한 값을 가진 요소를 선택합니다.
		클래스 선택자	$(".클래스명")		class 속성에 지정한 값을 가진 요소를 선택합니다.
		요소 선택자	$("요소명")		지정한 요소명과 일치하는 요소들만 선택합니다.
		그룹 선택자	$("선택1, 선택2, 선택3, ... 선택n)	선택1, 선택2, 선택3, ... 선택n에 지정된 요소들을 한 번에 선택합니다.
		종속 선택자	$("p.txt_1")		<p>요소 중 class 값이 txt_1인 요소
				$("p#txt_1")		<p>요소 중 id 값이 txt_1인 요소를 선택합니다.
```

* 직접 선택자
    * 직접 선택자는 주로 멀리 떨어진 요소를 직접 선택할 때 사용하는 선택자입니다. 직접 선택자의 종류는 전체(*), 아이디(#), 클래스(.), 요소명, 그룹(,) 선택자가 있습니다.

* 전체 선택자
    * 전체(Universal) 요소를 선택할 때 사용합니다. 즉, 이 선택자를 사용하면 현재 HTML의 모든 태그를 선택합니다 

```
// 전체 선택자 기본형$("*")
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("*").css("border","1px solid blue");
	});
</script>
</head>
<body>
	<h1>제이쿼리</h1>
	<h2>선택자</h2>
	<h3>직접 선택자</h3>
</body>
```

```
// 아이디 선택자 $("#아이디명")
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
		$("#tit").css("background-color","#ff0")
		.css("border", "2px solid #f00");	
});
</script>
</head>
<body>
	<h1>제이쿼리</h1>
	<h2 id="tit">선택자</h2>
	<h3>직접 선택자</h3>
</body>
```


#### 체이닝 기법이란?

**선택한 요소에는 메서드를 연속해서 사용** 할 수 있는데, 이를 마치 체인이 엮인 모양과 같다고 하여 '체이닝 기법'이라 합니다. 제이쿼리에서는 한 객체에 다양한 메서드를 줄줄이 이어서 사용할 수 있습니다. 메서드 사용이 완료되면 **문장 마지막에는 세미콜론(;)을 작성하여 마무리** 합니다.

```
$(요소 선택).css(속성1, 값1).css(속성2, 값2).css(속성3, 값3);
```

```
// 클래스 선택자 $(".클래스명")
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$(".tit").css("background-color","#ff0")
		.css("border", "2px dashed #f00");
	});
</script>
</head>
<body>
	<h1>제이쿼리</h1>
	<h2 class="tit">선택자</h2>
	<h3>직접 선택자</h3>
</body>
```

```
// 요소명(Tag Name) 선택자 $("요소명")
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("h2").css("background-color","#0ff")
		.css("border", "2px dashed #f00");
	});
</script>
</head>
<body>
	<h1>제이쿼리</h1>
	<h2>선택자</h2>
	<h3>직접 선택자</h3>
</body>
```

```
// 그룹 선택자 :  $("요소선택1, 요소선택2, 요소선택3,...요소선택n");
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("h1, #tit3").css("background-color","#0ff")
		.css("border", "2px dashed #f00");
	});
</script>
</head>
<body>
	<h1>제이쿼리</h1>
	<h2>선택자</h2>
	<h3 id="tit3">직접 선택자</h3>
	<h3>인접 선택자</h3>
</body>
</html>
```

```
// 종속 선택자 : $("요소명#id값"), $("요소명.class값")
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("h1.tit").css("background-color","#0ff")
		.css("border", "2px dashed #f00");
	});
</script>
</head>
<body>
	<h1 class="tit">제이쿼리</h1>
	<h2>선택자</h2>
	<h3 class="tit">직접 선택자</h3>
</body>
</html>
```

#### 인접 관계 선택자 

직접 선택자로 요소를 먼저 선택하고 그 다음 선택한 요소와 가까이에 있는(이전과 다음 요소)요소를 선택할 때 사용

```
// 부모 요소 선택자 : 선택한 요소를 감싸고 있는 부모 요소를 선택 _ $("요소 선택").parent();
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#list_1").parent()
		.css("border", "2px dashed #f00");
	});     // ul이 선택되면서 1-1,1-2에 border 처리
</script>
</head>
<body>
	<h1>인접 관계 선택자</h1>
	<ul id="wrap">
		<li>리스트1
			<ul>
				<li id="list_1">리스트1-1</li>
				<li>리스트1-2</li>
			</ul>
		</li>
		<li>리스트2</li>
		<li>리스트3</li>
	</ul>
</body>
```

```
// 하위 요소 선택자 : 기준 요소로 선택한 하위 요소만 선택 _ $("기준요소선택1 요소선택2")
// EX. $("#wrap h1")는 id="wrap"인 요소가 기준 요소가 됨

<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#wrap  h1")
		.css({
			"background-color":"yellow",
			"border":"2px dashed #f00"
		});
	});
</script>
</head>
<body>
	<div id="wrap">
		<h1>인접 관계 선택자</h1>       // css 적용
		<p>내용1</p>
		<section>
			<h1>하위 요소 선택자</h1>   // css 적용
			<p>내용2</p>
		</section>
	</div>
</body>
```


#### 자식 요소 선택자

```
1. $("요소선택 > 자식요소선택")
2. $("요소선택").children("자식요소선택")
3. $("요소선택").children()

1. 2. 선택한 요소를 기준으로 지정한 자식 요소만 선택합니다.
3. 선택한 요소를 기준으로 모든 자식 요소를 선택합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#wrap > h1").css("border","2px dashed #f00");

		$("#wrap > section").children( )
		.css({ 
			"background-color":"yellow",
			"border":"2px solid #f00"
		});
	});
</script>
</head>
<body>
	<div id="wrap">
		<h1>인접 관계 선택자</h1>
		<p>내용1</p>
		<section>
			<h1>자식 요소 선택자</h1>
			<p>내용2</p>
		</section>
	</div>
</body>
</html>
```

---

#### 속성과 값 전달 방식

1. 인자 값 사용

```
$("요소선택").css("속성명1", "값1").css("속성명2", "값2");
```

2. 객체 사용
```
$("요소 선택").css({"속성명1" : "값1", "속성명2" : "값2" ... "속성명n":"값n"});
```

#### 형(이전) / 동생(다음)요소 선택자

형 요소 선택자는 선택한 요소를 기준으로 바로 이전 형제 요소만 선택합니다. 그리고 동생 요소 선택자는 선택한 요소를 기준으로 바로 다음 형제 요소만 선택합니다.

```
① $("요소선택").prev()
② $("요소선택").next()
③ $("요소선택1 + 요소선택2")

① 선택한 요소를 기준으로 이전에 오는 형제 요소만 선택합니다.
② 선택한 요소를 기준으로 다음에 오는 형제 요소만 선택합니다.
③ 선택한 요소를(요소선택1) 기준으로 바로 다음에 오는 선택한 요소(요소선택2)만 선택합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var style_1 = {
			"background-color":"#0ff",
			"border":"2px solid #f00"
		}
		var style_2 = {
			"background-color":"#ff0",
			"border":"2px dashed #f00"
		}

		$(".txt").prev()
		.css(style_1);              // 내용1

		$(".txt + p").css(style_2); // 내용2

		$(".txt").next().next()
		.css(style_2);              // 내용3
	});
</script>
</head>
<body>
	<div id="wrap">
		<h1>인접 관계 선택자</h1>
		<p>내용1</p>
		<p class="txt">내용2</p>
		<p>내용3</p>
		<p>내용4</p>
	</div>
</body>
</html>
```

#### 전체 형(이전) / 동생(다음)요소 선택자

전체 형 요소 선택자는 선택한 요소를 기준으로 이전에 오는 전체 형제 요소를 선택합니다. 그리고 전체 동생 요소 선택자는 선택한 요소를 기준으로 다음에 오는 전체 형제 요소를 선택합니다.

```
① $("요소선택").prevAll()
② $("요소선택").nextAll()
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var style_1 = {
			"background-color":"#0ff",
			"border":"2px solid #f00"
		}
		var style_2 = {
			"background-color":"#ff0",
			"border":"2px dashed #f00"
		}

		$(".txt").prevAll( )
		.css(style_1);

		$(".txt").nextAll( )
		.css(style_2);   
	});
</script>
</head>
<body>
	<div id="wrap">
		<h1>인접 관계 선택자</h1>
		<p>내용1</p>
		<p class="txt">내용2</p>
		<p>내용3</p>
		<p>내용4</p>
	</div>
</body>
</html>
```

### 전체 형제 요소 선택자

전체 형제 요소 선택자는 선택한 요소의 모든 형제 요소를 선택합니다.

```
$("요소선택").siblings();
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var style_1 = {
			"background-color":"#0ff",
			"border":"2px solid #f00"
		}

		$(".txt").siblings( )
		.css(style_1);
	});
</script>
</head>
<body>
	<div id="wrap">
		<h1>인접 관계 선택자</h1>
		<p>내용1</p>
		<p class="txt">내용2</p>
		<p>내용3</p>
		<p>내용4</p>
	</div>
</body>
</html>
```

#### 범위 제한 전체형/동생 요소 선택자

범위 제한 전체 형/동생 요소 선택자는 선택한 요소를 기준으로 형제 요소 중 지정한 범위 내의 전체 형 요소 또는 전체 동생 요소를 선택합니다.

```
① $("요소선택").prevUntil("범위제한요소선택")
② $("요소선택").nextUntil("범위제한요소선택")

① 선택한 요소를 기준으로 범위 제한 요소까지 전체 형 요소를 선택합니다.
② 선택한 요소를 기준으로 범위 제한 요소까지 전체 동생 요소를 선택합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var style_1 = {
			"background-color":"#0ff",
			"border":"2px solid #f00"
		}

		$(".txt3").prevUntil(".title")
		.css(style_1);              // 내용 1 2에 적용

		$(".txt3").nextUntil(".txt6")
		.css(style_1);              // 내용 4 5에 적용
	});
</script>
</head>
<body>
<div id="wrap">
	<h1 class="title">선택자</h1>
	<p>내용1</p>
	<p>내용2</p>
	<p class="txt3">내용3</p>
	<p>내용4</p>
	<p>내용5</p>
	<p class="txt6">내용6</p>
</div>
</body>
</html>
```

#### 상위 요소 선택자

상위 요소 선택자는 선택한 요소를 기준으로 모든 상위 요소를 선택하거나 상위 요소 중 선택하고자 하는 요소만 선택할 때 사용합니다.

```
① $("요소선택").parents()
② $("요소선택").parents("요소선택")

① 선택한 요소를 기준으로 상위 요소를 모두 선택합니다.
② 선택한 요소를 기준으로 상위 요소 중 선택한 요소만 선택합니다.
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$(".txt1").parents()
		.css({
			"border":"2px dashed #00f"
		});

		$(".txt2").parents("div")
		.css({
			"border":"2px solid #f00"
		});
	});
</script>
</head>
<body>
	<h1 class="title">선택자</h1>
	<section>
		<div>
			<p class="txt1">내용</p>
		</div>
	</section>
	<section>
		<div>
			<p class="txt2">내용</p>
		</div>
	</section>
</body>
</html>
```

#### 가장 가까운 상위 요소 선택자

가장 가까운 상위 요소 선택자는 선택한 요소를 기준으로 가장 가까운 상위 요소만 선택할 때 사용합니다.

```
$("요소선택").closest("요소선택")
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$(".txt1").closest("div")
		.css({
			"border":"2px solid #f00"
		});
	});
</script>
</head>
<body>
	<h1 class="title">선택자</h1>
	<div>
		<div>
			<p class="txt1">내용</p>
		</div>
	</div>
</body>
</html>
```