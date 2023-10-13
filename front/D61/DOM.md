자바스크립트는 웹 문서 안의 텍스트나 이미지, 표 등 웹 문서 요소를 자유롭게 조작할 수 있는 프로그래밍 언어이다. 그런데 자바스크립트가 웹 문서의 요소를 조작할 수 있는 이유는 무엇일까? 바로 이들 요소가 자바스크립트를 사용하여 접근할 수 있는 객체 형태로 준비되어 있기 때문이다. 그래서 이 객체를 특별히 문서 객체 모델이라고 구별하여 부른다.

**문서 객체 모델이란?**

문서 객체 모델은 보통 영어 **Document Object Model** 을 줄여 DOM으로 표기한다. 실무에서는 DOM을 그대로 읽어 '돔'이라고 부른다. 

---

### DOM의 정의

웹 문서의 모든 요소를 자바스크립트를 이용하여 조작할 수 있도록 **객체를 사용해 문서를 해석하는 방법**

웹문서의 텍스트·이미지·표 등 모든 요소는 모두 객체라는 것이다.

다음은 HTML로 작성한 커피 상품 정보이다. 만약 여기에서 상세 설명을 보이지 않게 만들려면 어떻게 해야 할까?

```
// dom.html
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>

<body>
  <div id="detail">
    <h2>상품 정보</h2>
    <ul>
      <li>원산지 : 에디오피아</li>
      <li>지 역 : 이르가체프 코체레</li>
      <li>농 장 : 게뎁</li>
      <li>고 도 : 1,950 ~ 2,000 m</li>
      <li>품 종 : 지역 토착종</li>
      <li>가공법 : 워시드</li>
    </ul>
    <h3>상세 설명</h3>
    <p>2차 세계대전 이후 설립된 게뎁 농장은 유기농 인증 농장으로 여성의 고용 창출과 지역사회 발전에 기여하며 3대째 이어져 내려오는 오랜 역사를 가진 농장입니다. 게뎁 농장은 SCAA 인증을 받은 커피
      품질관리 실험실을 갖추고 있어 철처한 관리를 통해 스페셜티 커피를 생산합니다.</p>
    <h3>커피의 풍미</h3>
    <p>은은하고 다채로운 꽃향, 망고, 다크 체리, 달달함이 입안 가득.</p>
  </div>
</body>

</html>
```

웹 문서를 비주얼 스튜디오 코드로 열어 상세 살명이 가려지도록 CSS를 작성하면 된다.

```
    //... 생략
    <h3 style="visibility: hidden">상세 설명</h3>
    <p style="visibility: hidden">2차 세계대전 이후 설립된 게뎁 농장은 유기농 인증 농장으로 여성의 고용 창출과 지역사회 발전에 기여하며 3대째 이어져 내려오는 오랜 역사를 가진 농장입니다. 게뎁 농장은 SCAA 인증을 받은 커피
      품질관리 실험실을 갖추고 있어 철처한 관리를 통해 스페셜티 커피를 생산합니다.</p>
    //... 생략
```


하지만 이런 기능을 추가하기 위해 매번 비주얼 스튜디오 코드로 웹 문서를 수정해야 한다면 매우 번거로울거다. 사용자가 버튼을 눌렀을 때 상세 설명을 가리는 등 더 복잡한 기능이라면 더욱 그럴 거다. 어떻게 하면 좀 더 편하게 이런 기능을 추가할 수 있을까?

바로 이런 경우에 자바스크립트로 DOM을 제어하면 된다.

```
// dom.html을 열고 다음의 내용을 콘솔 창에 입력해 보자.
document.querySelector('#detail h3').style.visibility = 'hidden';
document.querySelector('#detail p').style.visibility = 'hidden';
```

*visibility:hidden과 display:none 차이점*
* display: none → 화면에 보이지 않게 처리하고 차지하고 있는 공간도 없어짐
* visibility: hidden → 화면에 보이지 않게 처리하지만 차지하고 있는 공간은 그대로 둠

어떤가? 웹 문서를 직접 수정하는 대신 자바스크립트로 웹 문서를 수정했다. 어떻데 이런 일이 가능한가? document는 웹 문서 자체를 가리키는 DOM 요소 중 하나이다. 콘솔 창에 document라고 입력한 다음 ▶을 눌러 결괏값을 살펴보자.

결괏 값을 사용하면 자바스크립트에서 웹 문서의 소스 전부를 인식할 수 있기 때문에 수정도 할 수 있는 것이다. 이렇듯 document는 수 많은 DOM 요소 중 하나이다.

![DOM-TREE](https://github.com/hansojin/JAVA/assets/112622663/92ebba84-4e98-430e-8583-4677251e4eea)

그림이 마치 나무를 거꾸로 뒤집어 놓은 것 같다. 그래서 이것을 **DOM 트리(Tree)** 라고 부른다. 

DOM 트리는 가지와 노드로 표현한다. 노드(Node)는 그림에서 네모 상자를 가리키고, 웹문서에 있는 요소나 속성을 나타낸다. 가지는 말 그대로 그림에서 보이는 얇은 선을 가리키는 것으로, 노드와 노드 사이의 연결 관계를 나타낸다. 그런데 DOM 트리는 웹 문서의 HTML 요소만 표현하지 않는다. HTML의 요소가 품고 있는 텍스트, 이미지도 자식으로 간주하여 DOM 트리에 표현한다. 다음은 위의 웹 문서를 DOM 트리로 표현한 것이다.

DOM 트리는 **웹 문서 요소** 를 다음과 같이 표현한다.

● 웹 문서의 태그는 요소(Element) 노드로 표현한다.
● 태그가 품고 있는 텍스트는 해당 요소 노드(태그)의 자식 노드인 텍스트(Text) 노드로 표현한다.
● 태그의 속성은 모두 해당 요소 노드(태그)의 자식 노드인 속성(Attribute) 노드로 표현한다.
● 주석은 주석(Comment) 노드로 표현한다.

--- 

DOM 트리가 만들어지는 과정을 실시간으로 확인할 수 있는 사이트 :  [Live DOM Viewer](software.hixie.ch/utilities/js/live-dom-viewer/)

```
// [Markup to test] 창에 다음 소스를 입력해 보자. 소스를 입력할 때마다 바로 아래에 있는 [DOM view]창에 DOM 트리가 실시간으로 추가되는 것을 확인할 수 있다.

<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>DOM TREE 알아보기</title>
	</head>
	<body>
		<h1>DOM</h1>
		<p>DOM을 공부합시다.</p>
	</body>
</html>
```

태그 요소는 보라색으로 표시된다. 그리고 #text:라고 표시된 것은 텍스트 노드이다. 텍스트 노드에 값이 없는 것은 줄 바꿈을 의미한다. 다음은 [DOM view] 창에 표현된 노드를 DOM 트리로 표현한 것이다.

![DOM TREE 알아보기](https://github.com/hansojin/JAVA/assets/112622663/fc499e87-7225-4374-a371-1edeaa746955)

그림을 보면 노드 위에 특별히 띠를 둘러 어떤 노드인지 적어 놓았다. 맨 위에 있는 html 노드는 요소 노드(Element Node) 이면서 다른 요소 노드가 뻗어 나가기 시작하는 노드이기도 하다. 이를 나무 뿌리에 비유하여 루트 노드(Root Node)라고 부른다. 그래서 html 노드의 띠에는 root element라고 적어 놓았다. 그리고 특정 노드를 기준으로 위에 붙어 있는 노드를 부모 노드, 아래에 있는 노드는 자식 노드라고 부른다. 예를 들어 head 노드의 부모 노드는 html 노드, 자식 노드는 title 노드이다.

이렇게 웹 문서를 놓고 DOM 트리를 상상하면 자바스크립트로 원하는 요소에 어떻게 접근할 지 쉽게 생각할 수 있다.

---

### DOM 요소에 접근하기

```
// acessDom.html
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>DOM에 접근하기</title>
	<link rel="stylesheet" href="css/dom.css">
</head>
<body>
	<div id="container">
			<h1 id="heading">에디오피아 게뎁</h1>
			<div id="prod-img">
				<img src="images/coffee-pink.jpg" alt="에디오피아 게뎁">
			</div>
			<div id="desc">
					<h2 class="bright">Information</h2>
					<p>2차 세계대전 이후 설립된 <span class="accent">게뎁농장</span>은 유기농 인증 농장으로 여성의 고용 창출과 지역사회 발전에 기여하며 3대째 이어져 내려오는 오랜 역사를 가진 농장입니다. 게뎁 농장은 <span class="accent">SCAA 인증</span>을 받은 커피 품질관리 실험실을 갖추고 있어 철처한 관리를 통해 스페셜티커피를 생산합니다.</p>
					<h2>Flavor Note</h2>
					<p class="bright">은은하고 다채로운 꽃향, 망고, 다크 체리, 달달함이 입안 가득.</p>
			</div>
	</div>
</body>
</html>
```


```
// 콘솔 창에 다음을 타이핑해보자.
document.getElementById("heading");

document.getElementById("heading").onclick = function() {
	this.style.fontSize = "5em";
}
```

```
// <div id = "desc"> 태그로 감싸져 있는 텍스트 부분에 접근하는 소스를 작성하시오.
document.getElementById("desc");

// class 이름이 accent인 것들에 접근
document.getElementsByClassName("accent");

// class 이름이 accent인 것들 중에 첫번째 것에 접근
document.getElementsByClassName("accent")[0];

// class 이름이 accent인 것들 중에 첫번째 것에 접근하여 밑줄 긋기
document.getElementsByClassName("accent")[0].style.textDecoration = "underline"

// class="accent"를 사용하는 웹 요소 중 두 번째 요소에 접근하는 소스
document.getElementsByClassName("accent")[1];

// 태그 이름이 h2인것을 선택
document.getElementsByTagName("h2");

// h2 태그 이름으로 접근한 DOM 요소 중 첫 번째 요소의 배경색을 #eee 로 바꾸자.
document.getElementsByTagName("h2")[0].style.backgroundColor = "#eee";

// h2 태그 이름으로 접근한 DOM 요소 중 첫 번째 요소의 배경색을 없애기
document.getElementsByTagName("h2")[0].style.backgroundColor = "";

// id 값을 사용하여 DOM 요소에 접근하는 방법 => getElementById() 함수와 querySelector() 함수
// querySelector()를 사용하면 id 선택자뿐만 아니라 querySelctor("#container > ul")처럼 둘 이상의 선택자를 사용해서 요소에 접근할 수 있음
document.getElementById("container");		
document.querySelector("#container");

// id="heading"인 제목(에디오피아 게뎁) 요소를 querySelector() 함수로 접근해 보자.
document.querySelector("#heading");

//class 값이 accent인 DOM 요소에 접근해 보자.
document.querySelectorAll(".accent");

// 클래스 이름이 accent인 것들중에 두 번째 것에 배경색을 yellow로 하자.
document.querySelectorAll(".accent")[1].style.backgroundColor = "yellow";
```

### 웹 요소의 태그 속성 가져와서 수정하기

HTML 태그 속성을 가져오거나 수정하는 함수 - **getAttribute(), setAttribute()**

이미지를 다른 이미지로 표시하고 싶다면 img 태그의 src 속성을 바꾸면 된다. HTML 태그의 속성 값을 바꾸고 싶다면 setAttribute() 함수를 사용하고, 괄호 안에 속성 이름과 속성 값을 넣으면 된다. 이때 지정한 속성이 아직 없다면 새로 속성과 속성 값을 추가하고, 지정한 속성이 있다면 괄호 안에 넣은 속성 값으로 수정한다.

```
// 이미지를 선택하고, 선택한 이미지의 파일경로를 "images/coffee-blue.jpg"로 지정해 보자.
document.querySelector("#prod-img > img").setAttribute("src", "images/coffee-blue.jpg");
```

*querySelectorAll("img")로 접근한 후 몇 번째 이미지인지 인덱스를 지정할 수도 있지만, 이미지가 많은 문서일 경우 자식 선택자(>)를 사용해서 어떤 이미지인지 정확하게 지정하는 것이 좋다.*

---

```
// showBig-result.html
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>DOM</title>
	<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<div id="container">
			<h1 id="heading">에디오피아 게뎁</h1>
			<div id="prod-pic">
				<img src="images/coffee-pink.jpg" alt="에디오피아 게뎁" id="cup" width="200" height="200">
					<div id="small-pic">
						<img src="images/coffee-pink.jpg" class="small">
						<img src="images/coffee-blue.jpg" class="small">
						<img src="images/coffee-gray.jpg" class="small">
					</div>
			</div>			
			<div id="desc">
				<ul>
					<li>상품명 : 에디오피아 게뎁</li>
					<li class="bluetext">판매가 : 9,000원</li>
					<li>배송비 : 3,000원<br>(50,000원 이상 구매 시 무료)</li>
					<li>적립금 : 180원(2%)</li>
					<li>로스팅 : 2019.06.17</li>
					<button>장바구니 담기</button>
				</ul>				
				<a href="#" id="view">상세 설명 보기</a>				
			</div>
			
			<div id="detail">									
					<hr>
					<h2>상품 상세 정보</h2>
					<ul>
						<li>원산지 : 에디오피아</li>
						<li>지 역 : 이르가체프 코체레</li>
						<li>농 장 : 게뎁</li>
						<li>고 도 : 1,950 ~ 2,000 m</li>
						<li>품 종 : 지역 토착종</li>
						<li>가공법 : 워시드</li>
					</ul>
					<h3>Information</h3>
					<p>2차 세계대전 이후 설립된 게뎁 농장은 유기농 인증 농장으로 여성의 고용 창출과 지역사회 발전에 기여하며 3대째 이어져 내려오는 오랜 역사를 가진 농장입니다. 게뎁 농장은 SCAA 인증을 받은 커피 품질관리 실험실을 갖추고 있어 철처한 관리를 통해 스페셜티 커피를 생산합니다.</p>
					<h3>Flavor Note</h3>
					<p>은은하고 다채로운 꽃향, 망고, 다크 체리, 달달함이 입안 가득.</p>
			</div>
	</div>

	<script>
        var bigPic = document.querySelector("#cup");            // 큰 이미지 가져옴
		var smallPics = document.querySelectorAll(".small");    // 작은 이미지들을 노드 리스트로 가져옴

		for(var i = 0; i < smallPics.length; i++) {
			smallPics[i].addEventListener("click", chagePic);   // 노드를 클릭하면 changePic 함수 실행
		}

		function chagePic() {
				var newPic = this.src;                          // click 이벤트가 발생한 대상의 src 속성 값 가져옴
				bigPic.setAttribute("src", newPic);             // newPic 값을 큰 이미지의 src 속성에 할당.
		    //= bigPic.src = newPic; 
			}	
    </script>
</body>
</html>
```

**예약어 this는 click 이벤트가 발생한 요소, 즉 누른 작은 이미지를 가리킨다.** 그렇다면 this.src는 작은 이미지의 파일경로를 가르키겠죠? 그 값을 가져와서 bigPic 요소의 src 속성에 지정한다.(큰 이미지에 src 값을 할당할 때 bigPic.setAttribute("src", newPic);을 bigPic.src = newPic;으로 작성할 수도 있다.



**setAttribute() 함수 대신 속성 사용하기**

웹 요소의 속성 값을 수정할 때 setAttribute() 함수를 사용하지 않고 속성을 사용해도 된다. 예를 들어 앞에서 작성한 소스를 다음과 같이 사용할 수도 있다.

```
for(i=0;i<smallPics.length;i++){
	smallPics[i].onclick = function(event) {
		bigPic.src = this.src;
	};
}
```

---

### DOM에서 이벤트 처리하기

**1. 이벤트 처리 방법 _ onclick=함수명()**

```
<img id="pic" src="images/girl.png" alt="" onclick="changePic()">
```

이 방법은 HTML 태그와 자바스크립트 소스가 섞여 있는 형태라서 중간에 이벤트를 바꾼다거나 연결 함수를 바꾸려면 HTML 소스를 수정해야 한다. HTML 소스가 길지 않아서 쉽게 확인이 가능할 때 사용할 수 있다. 이 방법은 하나의 요소에 하나의 이벤트 처리기만 사용할 수 있다.

```
// domEvent1.html
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>이벤트 처리하기</title>
	<link rel="stylesheet" href="css/domevent.css">
</head>
<body>
	<div id="container">
		<img id="pic" src="images/girl.png" alt="" onclick="changePic()">
	</div>
	<script>		
		var pic = document.querySelector('#pic');
		function changePic() {			
			pic.src = "images/boy.png";
		}
	</script>
</body>
</html>
```

**2. 이벤트 처리 방법 _ DOM 요소에 이벤트 처리기 연결하기**

```
    var pic = document.querySelector('#pic');
    pic.onclick = changePic;
```

이 방법은 이벤트가 발생한 웹 요소를 가져온 후 이벤트 처리기를 연결하는 방법이다. 먼저 살펴본 domEvent1.html 문서와 마찬가지로 이미지를 눌렀을 때 changePic() 함수를 실행하지만 그 과정에서 차이가 있다. 이벤트 처리기를 자바스크립트 소스에서 실행한다. 이미지 요소를 가져와 pic 변수에 저장한 후 click 이벤트가 발생했을 때 changPic() 함수를 실행한다.

DOM 요소에 이벤트 처리기를 연결하는 방법은 HTML 태그와 뒤섞이지 않고 자바스크립트 소스를 사용한다는 점에서는 좋지만, 역시 하나의 요소에 하나의 이벤트 처리기만 사용할 수 있다.

```
// domEvent2.html
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>이벤트 처리하기</title>
	<link rel="stylesheet" href="css/domevent.css">
</head>
<body>
	<div id="container">
		<img id="pic" src="images/girl.png" alt="">
	</div>
	<script>		
    var pic = document.querySelector('#pic');
    pic.onclick = changePic;
    
		function changePic() {			
			pic.src = "images/boy.png";
		}
	</script>
</body>
</html>
```

**3. 이벤트 처리 방법 _ addEventListener() 함수로 여러 이벤트를 한번에 처리하기**

지금까지 살펴본 이벤트 처리기 연결 방법은 한 요소에 하나의 이벤트 처리기만 연결할 수 있었다. **한 요소에 여러 이벤트가 발생했을 때 이를 동시에 처리하려면** 어떻게 해야 할까? 바로 DOM의 **addEventListener() 함수** 를 사용하면 된다. addEventListener() 함수는 이벤트가 발생한 요소에 이벤트 처리기를 연결해 주는 함수로, 웹 문서에서 이미지나 텍스트 등 특정 요소뿐만 아니라 Document 객체나 Window 객체 어디에서든 사용할 수 있다. 

```
    var pic = document.querySelector('#pic');
    pic.addEventListener("mouseover", changePic, false);
                    //        ①           ②        ③    
    function changePic() {			
      pic.src = "images/boy.png";
    }
    function originPic() {
      pic.src = "images/girl.png";
    }
```

① 이벤트 유형
처리할 이벤트 유형을 지정한다. 단 이 함수에서 이벤트 유형을 지정할 때는 'on'을 붙이지 않고 'click' 이나 'mouseover'처럼 이벤트 이름만 사용한다.

② 함수
이벤트가 발생했을 때 실행할 명령을 나열하거나 따로 함수를 만들었다면 함수 이름을 지정한다.

③ 캡처 여부
이벤트를 캡처링하는지 여부를 지정하는데 생략할 수 있다. true이면 캡처링, false이면 버블링한다는 의미인데, 기본 값은 false이다. 이벤트 캡처링은 DOM의 부모 노드에서 자식 노드로 이벤트가 전달되는 것이고, 이벤트 버블링은 DOM의 자식 노드에서 부모 노드로 이벤트가 전달되는 것이다.

