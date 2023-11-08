## 효과 및 애니메이션 메서드

문서 객체를 보이게 했다가 안 보이게 하려면 스타일(CSS)의 display 속성을 이용해야 합니다. 단, 스타일을 이용하는 방법은 객체를 단순하게 조절하는 정도의 효과만 기대할 수 있습니다. 하지만 이번에 살펴볼 효과(Effect) 메서드를 이용하면 스타일(CSS)를 이용하는 것보다 좀 더 역동적으로 동작을 조절하여 객체를 화려하게 숨기거나 보이게 만들 수 있습니다. 그리고 애니메이션 메서드까지 사용하면 선택한 요소에 다양한 동작(Motion)까지 적용할 수 있습니다.

### 효과 메서드
효과(Effect)메서드에는 선택한 요소를 역동적으로 숨겼다가 보이게 만드는 기능을 가진 메서드가 있습니다.

![1](https://github.com/hansojin/JAVA/assets/112622663/a71dc6cb-a93c-48ed-b4c1-433acef581d5)


```
$("요소 선택").효과메서드(효과 소요 시간, 가속도, 콜백 함수);
			        ①	    ②	    ③
```

효과 소요 시간(①)은 요소를 숨기거나 노출할 때 소요되는 시간입니다. 효과 소요 시간은 다음과 같이 적용할 수 있습니다.

방법1 : "slow", "normal", "fast"

방법2 : 1000(1초), 500(0.5초)

가속도(②)는 숨기거나 노출하는 동안의 가속도를 설정합니다. 가속도에 적용할 수 있는 값은 다음과 같습니다.

방법1: "swing"   : 시작과 끝은 느리게, 중간은 빠른 속도로 움직입니다.(기본값).

방법2: "linear"     : 일정한 속도로 움직입니다.

콜백 함수(③)는 노출과 숨김 효과가 끝난 후에 실행할 함수입니다. 콜백 함수는 생략할 수 있습니다.

다음은 id 값이 "box"인 요소를 2초간 위로 올려 숨기는 예로, 가속도는 "linear"입니다. 요소가 숨겨지면 콜백 함수가 실행되어 "hello"라는 메시지가 나타납니다.

```
$("#box").slideUp(2000, "linear", function() {
	alert("hello");
});
```

### fadeTo() 메서드

```
$("요소 선택").fadeTo(효과 소요 시간, 투명도, 콜백 함수);
```

투명도는 0 ~ 1 까지의 값을 입력할 수 있습니다. 1에 가까울수록 선명하게 보입니다.

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 효과와 애니메이션 </title>  
<script src="js/jquery.js"></script>
<script>
$(function( ) {
	$(".btn2").hide();

	$(".btn1").on("click", function( ) {
		$(".box").slideUp(1000, "linear", 
		function( ) {
			$(".btn1").hide( );
			$(".btn2").show( );
		});
	});

	$(".btn2").on("click", function( ) {
		$(".box").fadeIn(1000, "swing", 
		function( ) {
			$(".btn2").hide( );
			$(".btn1").show( );
		});
	});

	$(".btn3").on("click", function( ) {
		$(".box").slideToggle(1000, "linear");
	});


	$(".btn4").on("click", function( ) {
		$(".box").fadeTo("fast", 0.3);
	});

	$(".btn5").on("click", function( ) {
		$(".box").fadeTo("fast", 1);
	});

});
</script>
<style>
	.content{
		width:400px;
		background-color: #eee;
	}
</style>
</head>
<body>
	<p>
		<button class="btn1">slideUp</button>
		<button class="btn2">fadeIn</button>
	</p>
	<p>
		<button class="btn3">toggleSide</button>
	</p> 
	<p>
		<button class="btn4">fadeTo(0.3)</button>
		<button class="btn5">fadeTo(1)</button>
	</p>   
	<div class="box">
		<div class="content">
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas feugiat consectetur nibh, ut luctus urna placerat non. Phasellus consectetur nunc nec mi feugiat egestas. Pellentesque et consectetur mauris, sed rutrum est. Etiam odio nunc, ornare quis urna sed, fermentum fermentum augue. Nam imperdiet vestibulum ipsum quis feugiat. Nunc non pellentesque diam, nec tempor nibh. Ut consequat sem sit amet ullamcorper sodales.
		</div>
	</div>
</body>
</html>
```

---

## 애니메이션 메서드
이번에 배울 메서드는 애니메이션 메서드입니다. 애니메이션 메서드를 적용하면 스타일을 적용한 요소를 움직이게 할 수 있습니다.

### animate() 메서드

animate() 메서드를 이용하면 선택한 요소에 다양한 동작(Motion) 효과를 적용할 수 있습니다. 예를 들어 요소를 앞으로 이동시키거나 점차 커지게 하는 등 다양한 동작을 적용할 수 있습니다.

```
$("요소선택").animate({스타일 속성}, 적용 시간, 가속도, 콜백 함수)
```

스타일 속성은 애니메이션으로 적용할 스타일 속성입니다.

적용 시간은 동작에 반응하는 데 소요되는 시간이며, 적용 시간의 옵션은 효과 함수에 적용한 것과 같습니다.

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 효과와 애니메이션 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$(".btn1").on("click", function( ) {
		$(".txt1").animate({
			marginLeft:"500px",
			fontSize:"30px"
		},
		2000, "linear", function( ) {
			alert("모션 완료!"); 
		});
	});
	
	$(".btn2").on("click", function( ) {
		$(".txt2").animate({
			marginLeft:"+=50px"
		},1000);
	}); 

});
</script>
<style>
	.txt1{background-color: aqua;}
	.txt2{background-color: pink;}
</style>
</head>
<body>
	<p><button class="btn1">버튼1</button></p>
	<span class="txt1">"500px" 이동</span>
	<p><button class="btn2">버튼2</button></p>
	<span class="txt2">"50px"씩 이동</span>
</body>
</html>
```

#### 애니메이션 효과 제어 메서드

애니메이션 효과 제어 메서드란 '효과' 또는 '애니메이션'이 적용된 요소의 동작을 제어하는 메서드
입니다. 

#### 애니메이션 적용 원리와 큐의 개념

애니메이션 메서드는 함수가 적용된 순서대로 **큐(queue)** 라는 저장소(memory)에 저장됩니다. *FIFO(First In First Out)*


#### stop() / delay() 메서드
stop() 메서드는 요소에 적용한 애니메이션을 정지시키고, delay() 메서드는 요소에 적용한 애니메이션을 지정한 시간만큼 지연시킵니다. 먼저 stop() 메서드에 대해 알아보겠습니다.

```
① $("요소 선택").stop();
② $("요소 선택").stop(clearQueue, finish);
```

① 진행 중(inprogress)인 첫 번째 애니메이션만 정지시킵니다. 큐에 대기 중인 애니메이션은 계속해서 실행합니다.
② clearQueue, finish는 true나 false의 값을 입력할 수 있습니다.*(기본값은 false)* clearQueue가 true면 큐에서 대기 중인 애니메이션을 모두 제거합니다. finsih가 true면 진행 중인 애니메이션을 강제로 종료합니다.

stop() 메서드를 좀 더 자세히 알아보기 위해 다음 두 가지 경우를 예로 들어 보겠습니다.

```
① 진행 중인 애니메이션만 정지시키는 경우
$(".txt").animate({opacity:0.5}, 1000).animate({marginLeft:"500px"}, 1000);
$(".txt").stop();

② 대기 중인 애니메이션은 제거하고 진행 중인 애니메이션은 강제로 종료하는 경우
$(".txt2").animate({opacity:0.5}, 1000).animate({marginLeft:"500px"}, 1000);
$(".txt2").stop(true, true);
```

stop() 메서드는 첫 번째, 두 번째 인자값(clearQueue, finish)에 따라 메서드 적용 방식이 달라집니다.
모든 인자값을 생략한 stop() 메서드는 진행 중인 애니메이션만 정지시킵니다. 모든 인자값에 true를
적용하면 대기 중인 애니메이션은 제거되고 진행 중인 애니메이션은 강제로 종료됩니다. 그래서
실제로는 애니메이션이 아닌 CSS 메서드를 적용한 것처럼 보입니다.

#### delay() 메서드

```
$("요소선택").delay(지연 시간).애니메이션 효과 메서드();

// 애니메이션 함수 앞에 delay(3000) 메서드를 적용하면 3초 후에 애니메이션이 적용됩니다.
$(".txt1").delay(3000).animate({marginLeft:"500px"}, 1000);
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 효과와 애니메이션 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$(".txt1")
	.animate({marginLeft:"300px"},1000);

	$(".txt2").delay(3000)
	.animate({marginLeft:"300px"},1000);

	$(".btn1").on("click", moveElement);

	function moveElement( ) {
		$(".txt3")
		.animate({marginLeft:"+=50px"},800);

		$(".txt4")
		.animate({marginLeft:"+=50px"},800);
		$(".txt4").stop();

		$(".txt5")
		.animate({marginLeft:"+=50px"},800);
		$(".txt5").stop(true, true);
	}
});
</script>
<style>
	p{width: 110px;text-align: center;}
	.txt1{background-color: aqua;}
	.txt2{background-color: pink;}
	.txt3{background-color: orange;}
	.txt4{background-color: green;}
	.txt5{background-color: gold;}
</style>
</head>
<body>
	<p class="txt1">효과1</p>
	<p class="txt2">효과2<br> delay(3000)</p>

	<p><button class="btn1">50px 전진</button></p>
	<p class="txt3">효과3</p>
	<p class="txt4">효과4<br>stop( )</p>
	<p class="txt5">효과5<br>stop(true, true)</p>
</body>
</html>
```

#### queue() / dequeue() 메서드
queue() 메서드는 큐(queue)에 적용된 애니메이션 함수를 반환하거나 큐에 지정한 함수를 추가합니다. queue() 메서드를 실행하면 실행 이후의 모든 애니메이션이 취소됩니다. dequeue() 메서드는 queue() 메서드 실행 이후에 적용된 애니메이션 메서드가 취소되지 않게 연결해 줍니다.

```
① 큐(Queue)의 함수 반환
$("요소 선택").queue();

② 큐(Queue)에 함수 추가
$("요소 선택").queue(function() { 자바스크립트 코드 } );

③ dequeue() 메서드
$("요소 선택").dequeue();
```

다음은 애니메이션이 적용된 요소에 queue(function() {...})를 사용하여 새로운 함수를 큐에 추가하는 예제입니다. 이때는 dequeue() 메서드를 사용했기 때문에 queue() 이후의 애니메이션이 취소되지 않습니다.

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 효과와 애니메이션 </title>  
<script src="js/jquery.js"></script>
<script>
$(function(){
	$(".txt1")
	.animate({marginLeft:"200px"},1000)
	.animate({marginTop:"200px"},1000)
	.queue(function() {
			$(this).css({background:"red"});
			$(this).dequeue();
	})
	.animate({marginLeft:0},1000)
	.animate({marginTop:0},1000);
});
</script>
<style>
	*{margin:0;}
	.txt1{width:50px;text-align: 
	center;background-color: aqua;}
</style>
</head>
<body>
	<p class="txt1">내용1</p>
</body>
</html>
```

#### clearQueue() 메서드
clearQueue() 메서드는 진행 중인(첫 번째) 애니메이션을 제외하고 큐에서 대기하는 모든 애니메이션 함수를 제거합니다.

```
$("요소 선택").clearQueue();
```

```
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> 효과와 애니메이션 </title>  
<script src="js/jquery.js"></script>
<script>
$(function() {
	$(".txt1")
	.animate({marginLeft:"100px"},1000)
	.animate({marginLeft:"300px"},1000)
	.animate({marginLeft:"400px"},1000);

	$(".txt2")
	.animate({marginLeft:"100px"},1000)
	.animate({marginLeft:"300px"},1000)
	.animate({marginLeft:"400px"},1000);
	$(".txt2").clearQueue();

});
</script>
<style>
	.txt1, .txt2{width:50px; text-align: 
	center; background-color: aqua;}
	.txt2{background-color:orange;}
</style>
</head>
<body>
	<p class="txt1">내용1</p>
	<p class="txt2">내용2</p>
</body>
</html>
```