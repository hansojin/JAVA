### 인덱스값 사용한 위치 요소 선택

```
$("선택자").eq(N)
// 선택한 요소의 인덱스 번호에 해당하는 요소를 가져옴
// 0부터 시작, 음수값이라면 역순

$("선택자").get(N)
$("선택자").[N]
// 선택한 요소중 N 번째 요소를 DOM 객체로 반환

$("선택자").이벤트종류(function(){
    $('지정요소').index();
})
// 선택된 해당 요소의 index 값을 가져옴
```

---


## 제이쿼리 탐색 선택자

#### 탐색 선택자
탐색 선택자를 사용하면 기본 선택자로 선택한 요소 중 원하는 요소를 한 번 더 탐색해서 좀 더 정확하게 선택할 수 있습니다. 대표적인 탐색 선택자에는 배열의 인덱스(index)를 사용해 선택하는 '위치 탐색 선택자'와 배열에 담겨진 요소 중 지정된 속성과 값으로 선택하는 '속성 탐색 선택자'가 있습니다.

(콘텐츠 포함 여부로 다시 선택할 수 있는 '콘텐츠 탐색 선택자'와 '필터링 선택자'도 있습니다.)

#### 위치 탐색 선택자
기본 선택자로 선택한 요소는 배열에 담깁니다. 이때 배열의 인덱스를 사용하면 특정 요소를 좀 더 정확하게 선택할 수 있습니다. 

#### first/last 선택자
first 선택자는 선택된 요소 중 첫 번째 요소만 선택합니다. 이와 반대로 last 선택자는 선택된 요소 중 마지막 요소만 선택합니다.

```
① $("요소선택:first") 또는 $("요소선택").first()
② $("요소선택:last") 또는 $("요소선택").last()
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#menu li:first")
		.css({"background-color":"#ff0"});

		$("#menu li:last")
		.css({"background-color":"#0ff"});
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul id="menu">
		<li>내용1</li>
		<li>내용2</li>
		<li>내용3</li>
		<li>내용4</li>
	</ul>
</body>
</html>
```

#### even/odd 선택자
even 선택자는 선택한 요소 중 홀수 번째(짝수 인덱스) 요소만 선택하고, 이와 반대로 odd 선택자는 짝수 번째(홀수 인덱스) 요소만 선택합니다. 

```
① $("요소선택:even")
② $("요소선택:odd")
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#menu li:even")
		.css({"background-color":"#ff0"});

		$("#menu li:odd")
		.css({"background-color":"#0ff"});
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul id="menu">
		<li>내용1</li>
		<li>내용2</li>
		<li>내용3</li>
		<li>내용4</li>
	</ul>
</body>
</html>
```

#### eq(index)/lt(index)/gt(index) 탐색 선택자
eq(index) 탐색 선택자는 선택한 요소 중 지정한 인덱스가 참조하는 요소만 선택하고 lt(index) 선택자는 선택한 요소 중 지정한 인덱스보다 작은(lt, Less Than) 인덱스를 참조하는 요소만 선택합니다. 이와 반대로 gt(index)는 선택한 요소 중 지정한 인덱스보다 큰(gt, Greater Than) 인덱스를 참조하는 요소만 선택합니다. 

```
① $("요소선택:eq(index)") 또는 $("요소선택").eq(index)
② $("요소선택:lt(index)") 
③ $("요소선택:gt(index)")
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#menu li").eq(2)
		.css({"background-color":"#ff0"});

		$("#menu li:lt(2)")
		.css({"background-color":"#0ff"});

		$("#menu li:gt(2)")
		.css({"background-color":"#f0f"});
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul id="menu">
		<li>내용1</li>
		<li>내용2</li>
		<li>내용3</li>
		<li>내용4</li>
		<li>내용5</li>
	</ul>
</body>
</html>
```

#### first-of-type/last-of-type 선택자
first-of-type 선택자는 선택한 요소의 무리 중 첫 번째 요소만 선택합니다. 이와 반대로 last-of-type은 선택한 요소의 무리 중 마지막에 위치한 요소만 선택합니다. 

```
① $("요소선택:first-of-type")
② $("요소선택:last-of-type")
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
		$("li:first-of-type")
		.css({"background-color":"#ff0"});

		$("li:last-of-type")
		.css({"background-color":"#0ff"});
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul>
		<li>내용1-1</li>
		<li>내용1-2</li>
		<li>내용1-3</li>
	</ul>
	<ul>
		<li>내용2-1</li>
		<li>내용2-2</li>
		<li>내용2-3</li>
	</ul>
</body>
</html>
```

#### nth-child(숫자n)/nth-last-of-type(숫자) 선택자
nth-child(숫자n) 선택자는 선택한 요소의 무리 중 지정한 숫자(배수)의 요소를 선택합니다. 예를 들어 li:nth-child(2)는 선택한 요소의 무리 중 두 번째의 `<li>`태그를 가리키고, li:nth-child(2n)은 선택한 요소의 무리 중 2의 배수의 `<li>`태그를 가리킵니다. 이에 비해 nth-last-of-type(숫자) 선택자는 선택한 요소의 무리 중 마지막에서 지정한 숫자의 요소를 선택합니다.

```
① $("요소선택:nth-child(숫자)")
② $("요소선택:nth-child(숫자n)")
③ $("요소선택:nth-last-child(숫자)")

① 선택한 요소 중 지정한 숫자에 위치한 요소를 선택합니다.
② 선택한 요소 중 지정한 배수에 위치한 요소를 선택합니다.
③ 선택한 요소 중 마지막 위치에서 지정한 숫자에 위치한 요소를 선택합니다.
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
		$("#menu1 li:nth-child(1)")
		.css({"background-color":"#ff0"});

		$("#menu1 li:nth-child(2n)")
		.css({"border":"2px dashed #f00"});

		$("#menu2 li:nth-last-child(2)")
		.css({"background-color":"#0ff"});
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul id="menu1">
		<li>내용1-1</li>
		<li>내용1-2</li>
		<li>내용1-3</li>
		<li>내용1-4</li>
	</ul>
	<ul id="menu2">
		<li>내용2-1</li>
		<li>내용2-2</li>
		<li>내용2-3</li>
	</ul>
</body>
</html>
```

#### only-child/slice(index) 선택자
only-child 선택자는 선택한 요소가 '부모 요소에게 하나뿐인 자식 요소'인 경우에 선택합니다. slice(start index, end index) 선택자는 선택한 요소의 지정 구간 인덱스의 요소를 선택합니다. 다음은 only-child 선택자와 slice(start index, end index) 선택자의 기본형입니다.

```
① $("요소선택:only-child")
② $("요소선택").slice(start index, end index)
① 선택한 요소가 부모 요소에게 하나뿐인 자식 요소면 선택합니다.
② 지정 구간 인덱스의 요소를 선택합니다. 예를 들어 slice(1, 3)은 1 초과 3 이하의 요소를 선택합니다.
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
		$("#menu1 li").slice(1,3)
		.css({"background-color":"#ff0"});

		$("li:only-child")
		.css({"background-color":"#0ff"});
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul id="menu1">
		<li>내용1-1</li>
		<li>내용1-2</li>    // css 적용
		<li>내용1-3</li>    // css 적용
		<li>내용1-4</li>
	</ul>
	<ul id="menu2">
		<li>내용2-1</li>    // css 적용
	</ul>
</body>
</html>
```

---

### 제이쿼리 배열 관련 메서드

#### `each()` / `$.each()` 메서드
선택자로 선택한 요소(문서객체)는 배열에 순서대로 저장됩니다. 이때 `each()`와 `$.each()` 메서드는 배열에 저장된 요소를 순서대로 하나씩 선택하면서 인덱스 정보를 가져옵니다.

```
① $("요소선택").each(function(매개변수1, 매개변수2){})
② $.each($("요소선택"), function(매개변수1, 매개변수2){})
③ $("요소선택").each(function() { $(this) })
④ $.each($("요소선택"), function() {$(this)})

①,② 배열에 저장된 요소의 개수만큼 메서드를 반복 실행합니다. 메서드를 실행할 때마다 매개변수1, 매개변수2에는 배열에 저장된 요소와 인덱스의 값이 배열에 오름차순으로 대입됩니다.
③,④ 배열에 저장된 요소의 개수만큼 메서드를 반복 실행합니다. 메서드를 실행할 때마다 $(this)에는 배열에 저장된 요소가 오름차순으로 대입됩니다.
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
		var obj = [
			{"area":"서울"},
			{"area":"부산"},
			{"area":"전주"}
		];

		$(obj).each(function(index, object){
				console.log(index + ":", object);
		});
		console.log("==== The End 1 ====");

		$.each($("#menu2 li"), function(i, o){
				console.log(i + ":", o);
		});
		console.log("==== The End 2 ====");    

		$.each($("#menu2 li"), function(i){
				console.log(i + ":", $(this));
		});    
	});
</script>
</head>
<body>
	<h1>탐색 선택자</h1>
	<ul id="menu1">
		<li>내용1-1</li>
		<li>내용1-2</li>
		<li>내용1-3</li>
	</ul>
	<ul id="menu2">
		<li>내용2-1</li>
		<li>내용2-2</li>
		<li>내용2-3</li>
	</ul>
</body>
</html>
```

#### `$.map()` / `$.grep()` 메서드

`$.map()` 메서드는 배열에 **저장된 데이터 수만큼 메서드를 반복 실행** 합니다. 그리고 메서드에서 반환된 데이터는 새 배열에 저장되고 그 배열 객체를 반환합니다. `$.grep()` 메서드는 배열에 저장된 데이터 수만큼 메서드를 반복 실행하며 인덱스 오름차순으로 배열의 데이터를 불러옵니다. 메서드의 **반환값이 true면 데이터가 새 배열에 저장되고 배열을 반환**합니다.
 
```
// ① $.map() 메서드
$.map(Array, function(매개변수1, 매개변수2){
	return 데이터;
});

// ② $.grep() 메서드
$.grep(Array, function(매개변수1, 매개변수2){
	return [true|false];
});
```

① 배열에 저장된 요소만큼 메서드를 반복 실행합니다. 메서드가 실행될 때마다 매개변수1, 매개변수2에는 배열의 데이터와 인덱스값이 인덱스 오름차순으로 대입됩니다. 반환된 데이터는 새 배열에 저장되고 새롭게 가공된 배열 객체를 반환합니다.
② 배열에 저장된 요소만큼 메서드를 반복 실행합니다. 메서드가 실행될 때마다 매개변수1, 매개변수2에는 배열에 데이터와 인덱스 정보가 인덱스 오름차순으로 대입됩니다. 반환된 데이터가 true면 인덱스 오름차순으로 데이터를 새 배열에 저장하고 새롭게 가공된 배열 객체를 반환합니다.

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var arr = [{
			    "area":"서울", 
			    "name":"무대리"
			},{
				"area":"부산", 
				"name":"홍과장"
			},{
				"area":"대전", 
				"name":"박사장"
			},{
				"area":"서울", 
				"name":"빅마마"
			}];

		var arr1 = $.map(arr, function(a, b){
			if(a.area == "서울") {
				return a;
			}
		});
		console.log(arr1);
		console.log("==== first End ====");

		var arr2 = $.grep(arr, function(a, b){
			if(a.area == "서울") {
				return true;
			} else {
				return false;
			}
		});
		console.log(arr2);
		console.log("==== Second End ====");    
	});
</script>
</head>
<body>
</body>
</html>
```

#### `$.inArray()` / `$.isArray()` / `$.merge()`메서드
`$.inArray()` 메서드는 배열에 저장된 데이터 중 **지정한 데이터를 찾아 인덱스값을 반환** 합니다. 또한 `$.isArray()` 메서드는 지정한 데이터가 **배열 객체면 true** 를, 배열 객체가 아니면 false를 반환합니다. `$.merge()` 메서드는 **두 배열 객체를 하나의 객체로 묶** 습니다.

```
① $.inArray(data, Array, start index)
② $.isArray(object)
③ $.merge(Array1, Array2)
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var arr1 = ["서울", "대전", "부산", "전주"];
		var arr2 = ["한국", "미국", "일본", "중국"];
		var obj = {
			"name":"정부장", 
			"area":"서울"
		}
		
		var idxNum = $.inArray("부산", arr1);   
                var idxNum2 = $.inArray("여수", arr1);  
		console.log(idxNum);    // 2
                console.log(idxNum2);   //-1

		var okArray1 = $.isArray(arr1);
		var okArray2 = $.isArray(obj);
		console.log(okArray1);
		console.log(okArray2);

		$.merge(arr2, arr1);
		console.log(arr2);
	});
</script>
</head>
<body>
</body>
</html>
```

#### index() 메서드
`$.index()` 메서드는 지정 선택 요소를 찾아서 인덱스값을 반환합니다.

```
$("요소선택").index("지정선택요소");
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var idxNum = $("li").index($("#list3"));
		console.log(idxNum);    // 2
	});
</script>
</head>
<body>
	<h1>배열 관련 메서드</h1>
	<ul>
		<li>내용1</li>
		<li>내용2</li>
		<li id="list3">내용3</li>
		<li>내용4</li>
	</ul>
</body>
</html>
```

---

### 속성과 값에 따른 탐색 선택자
속성과 값에 따른 탐색 선택자는 선택한 요소 중 지정한 속성과 일치하는 속성이 있는지, 없는지의 포함 여부를 따져 요소를 선택합니다. 즉, 이 선택자는 특정 속성을 포함하는 요소를 선택할 때 주로 사용합니다.

```
① $("요소선택[속성]")       // 속성이 포함된 요소만 선택
② $("요소선택[속성^=값]")   // 명시한 값으로 시작하는 요소만 선택
③ $("요소선택[속성$=값]")   // 명시한 값으로 끝나는 요소만 선택
④ $("요소선택[속성*=값]")   // 명시한 값을 포함하는 요소만 선택
⑤ $("선택자:type 속성값")   // type 속성값이 일치하는 요소만 선택
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#wrap a[target]")
		.css({"color":"#f00"});

		$("#wrap a[href^=https]")
		.css({"color":"#0f0"});

		$("#wrap a[href$=net]")
		.css({"color":"#00f"});

		$("#wrap a[href*=google]")
		.css({"color":"#000"});

		$("#member_f :text")
		.css({"background-color":"#ff0"});

		$("#member_f :password")
		.css({"background-color":"#0ff"});
	});
</script>
</head>
<body>
	<div id="wrap">
		<p><a href="http://easyspub.co.kr" target="_blank">EasysPub</a></p>
		<p><a href="https://naver.com">Naver</a></p>
		<p><a href="http://daum.net">Daum</a></p>
		<p><a href="http://google.co.kr">Google</a></p>
	</div>
	<form action="#" method="get" id="member_f">
		<p>
			<label for="user_id">아이디</label>
			<input type="text" name="user_id" id="user_id">
		</p>
		<p>
			<label for="user_pw">비밀번호</label>
			<input type="password" name="user_pw" id="user_pw">
		</p>
	</form>
</body>
</html>
```

#### 속성 상태에 따른 탐색 선택자
속성 상태에 따른 탐색 선택자는 선택한 요소 중 속성 상태에 따라 요소를 선택합니다.

```
① $("요소선택:[visible | hidden]")
② $(":selected")
③ $(":checked")
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#wrap p:hidden").css({
				"display":"block",
				"background":"#ff0"
		});

		var z1 = $("#zone1 :selected").val( );
		console.log(z1);
		
		var z2 = $("#zone2 :checked").val( );
		console.log(z2);

		var z3 = $("#zone3 :checked").val( );
		console.log(z3);
	});
</script>
</head>
<body>
	<div id="wrap">
		<p>내용1</p>
		<p style="display:none">내용2</p>
		<p>내용3</p>
	</div>
	<form action="#">
		<p id="zone1">
		<select name="course" id="course">
				<option value="opt1">옵션1</option>
				<option value="opt2" selected>옵션2</option>
				<option value="opt3">옵션3</option>
		</select>
		</p>
		<p id="zone2">
				<input type="checkbox" name="hobby1" value="독서"> 독서
				<input type="checkbox" name="hobby2" value="자전거"> 자전거
				<input type="checkbox" name="hobby3" value="등산" checked> 등산
		</p>
		<p id="zone3">
				<input type="radio" name="gender" value="male"> 남성
				<input type="radio" name="gender" value="female" checked> 여성
		</p>
	</form>
</body>
</html>
```

#### contains() / contents() / has() / not() / end() 탐색 선택자
contains() 탐색 선택자는 선택한 요소 중 지정한 텍스트를 포함하는 요소만 선택하고, **contents() 탐색 선택자는 선택한 요소의 하위 요소 중 1 깊이의 텍스트와 태그 노드를 선택** 합니다. has() 탐색 선택자는 선택한 요소 중 지정한 태그를 포함하는 요소만 선택합니다. not() 탐색 선택자는 선택한 요소 중 지정한 요소만 제외한 채 선택하고, **end() 탐색 선택자는 현재 선택된 요소의 이전 요소를 선택하는 메서드** 이다.

```
① $("요소선택:contains(텍스트)")
② $("요소선택").contents()
③ $("요소선택:has(요소명)") 
  $("요소선택").has("요소명")
④ $("요소선택:not(제외할요소선택)") 
  $("요소선택").not(제외할요소선택)
⑤ $("요소선택").탐색선택자().end()
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#inner_1 p:contains(내용1)")
		.css({"background-color":"#ff0"});

		$("#inner_1 p:has(strong)")
		.css({"background-color":"#0ff"});

		$("#outer_wrap").contents( )
		.css({"border":"1px dashed #00f"});
        // 선택 요소의 하위 요소 중 깊이 1인 노드 -> h1, section(#inner1, #inner2)

		$("#inner_2 p").not(":first")
		.css({"background-color":"#0f0"});  // 내용 5,6 적용

		$("#inner_2 p").eq(2).end()
		.css({"color":"#f00"});         
        // #inne2 > p idx 요소의 이전 요소 = $("#inner_2 p") -> 내용 4,5,6 적용

	});
</script>
</head>
<body>
	<div id="outer_wrap">
		<h1>콘텐츠 탐색 선택자</h1>
		<section id="inner_1">
			<h1>contains( ), contents( ), has( )</h1>
			<p><span>내용1</span></p>
			<p><strong>내용2</strong></p>
			<p><span>내용3</span></p>
		</section>
		<section id="inner_2">
			<h1>not( ), end( )</h1>
			<p>내용4</p>
			<p>내용5</p>
			<p>내용6</p>
		</section>
	</div>
</body>
</html>
```

#### find() / filter() 탐색 선택자
find() 탐색 선택자는 **선택한 하위 요소 중에서 find()로 필터링** 한 요소만 선택합니다. filter() 탐색 선택자는 **선택한 요소 중에서 filter()로 필터링** 한 요소만 선택합니다. (즉, 둘의 차이점은 필터링 대상이 선택 요소를 기준으로 '하위 요소'인지, '선택한 요소'인지로 구분한다는 것입니다.)

```
① $("요소선택").find("하위요소중 필터링할 요소 선택")
② $("요소선택").filter("선택한 요소 중 필터링할 요소 선택")
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		$("#inner_1").find(".txt1")
		.css({"background-color":"#ff0"});

		$("#inner_1 p").filter(".txt2")
		.css({"background-color":"#0ff"});

		$("#inner_2 p").filter(function(idx, obj){
			console.log(idx);
			return idx % 2 == 0;
		})
		.css({"background-color":"#0f0"});    
	});
</script>
</head>
<body>
	<div id="outer_wrap">
		<h1>콘텐츠 탐색 선택자</h1>
		<section id="inner_1">
			<h2>find( ), filter( )</h2>
			<p class="txt1">내용1</p>
			<p class="txt2">내용2</p>
		</section>
		
		<section id="inner_2">
			<h2>filter(function)</h2>
			<p>index 0</p>
			<p>index 1</p>
			<p>index 2</p>
			<p>index 3</p>
		</section>
	</div>
</body>
</html>
```

#### 선택자와 함께 알아두면 유용한 메서드

```
메서드 종류		사용법					설명
is(":요소상태")	$(".txt").is(":visible")				선택한 요소가 보이면 true를 반환합니다.
$.noConflict()	var 변수 = $.noConflict();			$.noConflict() 함수를 이용하면 현재 제이쿼리에서 사용중인
		변수("요소 선택")				$메서드 사용을 중단하고 새로 지정한 변수명 메서드를 사용합니다.
get()		$("요소선택").get(0).style.color = "#f00"		선택자에 get(0)을 적용하면 자바스크립트 DOM 방식의 스타일을 사용할 수 있습니다.
```
*참고. 제이쿼리로 선택한 요소는 자바스크립트 DOM 방식의 스타일을 사용할 수 없습니다.*

#### is() 메서드
is() 메서드는 선택한 요소의 상태가 지정한 속성과 일치하면 true를 반환하고, 그렇지 않으면 false를 반환합니다. is() 메서드는 입력 요소의 체크박스나 선택상자의 '선택여부' 또는 '보이는지의 여부'를 알아볼 때 주로 사용합니다.

```
$("요소선택").is(:[checked | selected | visible | hidden | animated]")
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 탐색 선택자 </title>  
<script src="js/jquery.js"></script>
<script>
	$(function(){
		var result_1 = $("#inner_1 p")
		.eq(0).is(":visible");
		console.log(result_1);

		var result_2 = $("#inner_1 p")
		.eq(1).is(":visible");
		console.log(result_2);

		var result_3 = $("#chk1").is(":checked");
		console.log(result_3);

		var result_4 = $("#chk2").is(":checked");
		console.log(result_4);
	});
</script>
</head>
<body>
	<div id="outer_wrap">
		<h1>is( )</h1>
		<section id="inner_1">
			<h2>문단 태그 영역</h2>
			<p>내용1</p>
			<p style="display:none;">내용2</p>
		</section>
		
		<section id="inner_2">
			<h2>폼 태그 영역</h2>
			<p>
				<input type="checkbox" name="chk1" id="chk1" checked>
				<label for="chk1">체크1</label>

				<input type="checkbox" name="chk2" id="chk2">
				<label for="chk2">체크2</label>           
			</p>
		</section>
	</div>
</body>
</html>
```