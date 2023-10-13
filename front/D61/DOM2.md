**웹 요소의 스타일가져와서 수정하기**

자바스크립트를 사용하면 스타일 속성 값을 가져오거나 원하는 값으로 수정할 수도 있다. 스타일은 웹 요소의 디자인을 담당하기 때문에 자바스크립트로 각 요소의 스타일을 수정하면서 웹 문서에서 다양한 효과를 만들 수 있다.

웹 요소의 스타일 속성에 접근할 때는 **요소 다음에 .style 예약어를 쓰고 그다음에 CSS 속성을 적는다.**

```
// 제목 텍스트의 글자 색상을 "white"로 바꾸자.
document.querySelector("#heading").style.color = "white";

// 콘솔 창에서 domCss1.html 문서에 있는 텍스트 단락(id="desc")의 글자를 빨간색으로 바꿔 보자
document.querySelector("#desc").style.color = "red";

//background-color나 border-radius처럼 가운데 하이픈(-)이 포함된 속성은 backgroundColor나 borderRadius처럼 두 단어를 합치고 두 번째 단어의 첫 글자를 대문자로 쓰는 낙타 표기법으로 입력한다.
// 아이디가 heading인 것의 배경색을 "gray"로 하자.
document.querySelector("#heading").style.backgroundColor = "gray";

// 도형 위로 마우스 포인터를 올렸을 때 녹색바탕의 둥근 원이 되게 하고, 도형 위에서 마우스 포인터가 빠져나왔을 때 네모난 사각형이 되게 하자.
var myRect = document.querySelector("#rect");
myRect.addEventListener("mouseover", function() {  
	myRect.style.backgroundColor = "green";  
	myRect.style.borderRadius = "50%";  
});

myRect.addEventListener("mouseout", function() { 
	myRect.style.backgroundColor = "";  
	myRect.style.borderRadius = ""; 
});
```

---

**웹 요소를 화면에 표시하기/감추기**

웹 문서에서 무엇인가를 화면에 표시하거나 감추려면 CSS 속성 중 display 속성이나 visibility 속성을 사용한다. **display:none** 을 사용해서 웹 요소를 화면에서 감추면 그 요소가 차지하던 공간도 사라지지만, **visibility:hidden** 을 사용해서 웹 요소를 감추면 요소가 있던 공간은 빈 상태로 남아 있게 된다는 점이 큰 차이이다.

웹 브라우저에서 product.html 문서를 열고 웹 개발자 도구 창을 열자. `[Elements]` 탭을 누르면 나오는 소스 중 `<div id="detail">` 부분이 상세 정보가 들어 있는 소스이다. 그 부분을 선택하면 오른쪽의 `[Styles]` 탭 부분에 현재 `#detail`에 적용된 소스가 표시된다. 그 중에서 `display:none;` 속성이 보일 것이다. 상세 정보 내용을 화면에서 감추는 CSS 속성이다.

`display:none;`에서 none 부분을 누르면 값을 입력할 수 있는 상태가 된다. none을 block으로 수정해서 `display:block;`으로 만들어 보자. 가려져 있던 상세 정보 내용이 화면에 표시 될 것이다.

```
// product-result.html
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
			<hr>
			<div id="detail">									
					
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
        var isOpen = false;
		var bigPic = document.querySelector("#cup");  
		var smallPics = document.querySelectorAll(".small");  

		for(i=0; i<smallPics.length; i++) {
			smallPics[i].addEventListener("click", function() {
				newPic = this.src;
				bigPic.setAttribute("src", newPic);
			});
		}

		var view = document.querySelector("#view");  // #view 요소를 가져옴
		view.addEventListener("click", function() {
			if (isOpen == false) {  // 상세 정보가 감춰져 있다면 
				document.querySelector("#detail").style.display = "block";  // 상세 정보를 화면에 표시
				view.innerHTML = "상세 설명 닫기";  // 링크 내용 수정
				isOpen = true;  // 표시 상태로 지정
			}
			else {  // 상세 정보가 표시되어 있다면 
				document.querySelector("#detail").style.display = "none";  // 상세 정보를 화면에서 감춤
				view.innerHTML = "상세 설명 보기";  // 링크 내용 수정
				isOpen = false;  // 감춰진 상태로 지정
			}
		});
    </script>
</body>
</html>
```

---

## DOM에 요소 추가하기

● 모든 HTML 태그는 '요소(Element) 노드'로 표현한다.
● HTML 태그에서 사용하는 텍스트 내용은 '텍스트(Text) 노드'로 표현한다.
● HTML 태그에 있는 속성은 모두 '속성(Attribute)노드'로 표현한다.
● 주석은 '주석(Comment) 노드'로 표현한다.

웹 문서에 있는 요소는 단순히 태그만 있는 게 아니라 태그 속성과 내용을 함께 사용한다. 그래서 `<h1>`이나 `<p>`태그를 추가하고 싶다면 단순히 `<h1>`이나 `<p>`태그에 해당하는 요소 노드뿐만 아니라 태그 안에 있는 텍스트 내용과 속성도 노드로 추가해야 한다.

현재 문서의 DOM 트리에 새로운 노드를 추가하려면 웹 문서에 어떤 소스를 추가할지 먼저 생각해야 한다. 그러고 나서 그 소스에 따라 요소 노드나 텍스트 노드, 속성 노드 등을 만들고 연결한다. 예를 들어 웹 문서에 텍스트를 추가한다고 가정해 보자. 

`<p class="accent">주문이 완료되었습니다.</p>`

이 소스를 DOM 트리에 추가하려면 p 요소 노드와 "accent" 속성 값을 넣을 class 속성 노드, '주문이 완료되었습니다.'라는 텍스트를 넣을 텍스트 노드가 필요하다. 그리고 이렇게 만든 노드를 부모 노드에 연결해서 웹 문서에 추가한다.

**새로운 노드를 만들거나 부모 노드에 연결할 때** 는 다음 함수를 사용한다.

1	createElement()		새 요소 노드를 만든다.
2-1	createTextNode()		텍스트 내용이 있을 경우 텍스트 노드를 만든다.
	appendChild()		텍스트 노드를 요소 노드에 자식 노드로 추가한다.
2-2	createAttribute()		요소에 속성이 있을 경우 속성 노드를 만든다.
	setAttributeNode()		속성 노드를 요소 노드에 연결한다.
3	appendChild()		새로 만든 요소 노드를 부모 노드에 추가한다.


### 웹 문서에 새로운 노드 추가하기

domNode.html 문서를 열고, 웹 개발자 도구 창의 `[Elements]` 탭을 열어 보면 `<body>` 태그와 `</body>` 태그 사이에 아무 소스도 없다. 이 소스에 텍스트 단락을 추가할 텐데, 여기에서는 간단히 `<p>` 태그와 class 속성, 그리고 '주문이 완료되었습니다.'라는 내용을 추가해 보자.

`<p class="accent"> 주문이 완료되었습니다.</p>`

* 요소 노드 만들기 - **createElement()** 함수

DOM에 새로운 요소를 추가할 때 가장 먼저 할일은 요소 노드를 만드는 것입니다. 새로운 요소 노드를 만드는 함수 createElement()인데, 괄호 안의 요소에 해당하는 요소 노드를 적는다. 


`var newP = document.createElement("p");`

* 텍스트 노드 만들기 - **createTextNode()** 함수

새 요소 노드를 만든 후에는 요소에 표시할 내용(주문이 완료되었습니다.)을 텍스트 노드로 만든다. 텍스트 노드를 만드는 함수는 createTextNode()이고 괄호 안에 내용을 입력한다. 

`var newText = document.createTextNode("주문이 완료되었습니다.");`

* 자식 노드로 추가하기 - **appendChild()** 함수

앞에서 새로운 `<p>` 노드와 거기에 사용할 텍스트 노드를 만들었습니다. 아직까지는 노드가 만들어지기만 하고 서로 부모 노드와 자식 노드로 연결되지 않은 상태이다. appendChild()함수는 텍스트 노드를 요소 노드의 자식 노드로 연결하거나 요소 노드를 다른 요소 노드의 자식 노드로 연결할 때 사용하는 함수이다. 이 함수를 사용해 앞에서 만든 텍스트 노드 newText를 newP 노드의 자식 노드로 추가하는 소스를 콘솔 창에 작성한다.
(참고. 자식 노드가 여럿일 경우 appendChild() 함수를 사용해서 연결하는 노드는 자식 노드 중 맨끝에 추가된다.)

`newP.appendChild(newText);`

새로 만든 `<p>` 태그 소스는 웹 문서의 `<body>` 태그 안에 추가해야 하므로 newP 노드를 body 노드의 자식 노드로 추가한다.

`document.body.appendChild(newP);`

지금까지 소스를 모두 입력했다면 브라우저 창에 p 요소의 텍스트 내용이 표시된다. 웹 개발자 도구 창의 `[Elements]` 탭을 눌러 보자. 처음에는 아무 소스도 없던 `<body>` 태그 안에 조금 전에 추가한 `<p>` 태그가 보일 것이다.

* 속성 노드 만들기 - **createAttribute()** 함수

콘솔 창에서 추가한 `<p>` 태그에 class="accent" 속성을 추가해 보자. 먼저 추가할 속성 노드를 만들어야겠죠? 새로운 속성 노드를 만들 때는 createAttribute() 함수를 사용하며 함수의 괄호 안에 추가할 속성 이름을 지정한다. 여기에서는 새로운 class 속성 노드를 만들어 변수 attr에 저장한다. 그리고 attr.value를 사용해 attr 속성 값을 "accent"로 지정합니다. 이렇게 해서 attr 속성 노드가 만들어 졌습니다.

`var attr = document.createAttribute("class");`

`attr.value = "accent";`

* 속성 노드 연결하기 - **setAttributeNode()** 함수

속성 노드를 만들었으면 앞에서 선언해 놓은 p 노드에 연결해야겠죠? 속성 노드를 요소 노드에 연결할 때는 setAtrributeNode() 함수를 사용한다. 콘솔 창에 다음과 같이 입력하자. `<p>` 태그에 class="accent" 속성이 추가되면서 브라우저 창에 있는 텍스트 단락에 배경색과 테두리가 표시된다. (setAttributeNode() 함수의 반환 값은 null)

`newP.setAttributeNode(attr);`

*참고  _ setAttribute() 함수를 사용할 수도 있음*

앞에서 속성 노드를 추가할 때 먼저 createAttribute() 함수로 속성 노드를 만들고 "accent" 값을 넣은 뒤 setAttributeNode() 함수를 사용해 p 노드에 연결했습니다. 하지만 이렇게  텍스트 노드를 만들어 추가해 놓은 경우 다음 소스와 같이 setAttribute() 함수를 사용해서 더 간단히 속성을 추가할 수도 있다.

```
var newP = document.createElement("p");
var newText = document.createTextNode("주문이 완료되었습니다.");
newP.appendChild(newText);
document.body.appendChild(newP);
newP.setAttribute("class", "accent");
```

---------------------------

```
// EX1 _ id = "doit_js" 속성을 추가하려고 한다. 
// 콘솔 창에서 easys라는 속성 노드를 만들고 속성 값을 지정해 보시오.
var easys = document.createAttribute("id");
easys.value = "doit_js";
```

```
// 참가 신청 명단 프로그램 만들기
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>DOM - Create & Add Node</title>
	<link rel="stylesheet" href="css/nameList.css">
</head>
<body>
	<div id="container">
		<h1>참가 신청</h1>
		<form action="">
			<input type="text" id="userName" placeholder="이름" required>
			<button onclick="newRegister();return false;">신청</button>
            <!-- return false를 추가하는 것은 원래 버튼의 기능(입력 내용을 서버로 전송하는 기능)을 사용하지 않겠다는 뜻 -->
		</form>
		<hr>
		<div id="nameList"></div>
	</div>
	<script>
		function newRegister(){
			var newP = document.createElement("p");
			var userName = document.querySelector("#userName");
			var newText = document.createTextNode(userName.value);
			newP.appendChild(newText);		// newText 노드를 newP 노드의 자식 노드로 연결
			var nameList = document.querySelector("#nameList");	// #nameList 가져옴
			nameList.appendChild(newP);		// newP 노드를 nameList 노드의 자식 노드로 연결
			userName.value = "";		// 다음 이름을 입력할 수 있도록 텍스트 필드 비우기
		}
	</script>
</body>
</html>
```

### 추가한 노드 순서 바꾸거나 삭제하기

웹 브라우저에서 nodeList.html을 열고 콘솔 창에 다음과 같이 입력한 다음 NodeList 왼쪽의 ▶를 눌러 노드 리스트의 내용을 확인해 보자.

`document.querySelectorAll("p")`

querySelectorAll() 함수를 사용해 여러 개의 노드를 한꺼번에 가져오면 3개의 p노드가 한꺼번에 저장되는데, 이것을 **노드 리스트** 라고 한다. 배열 형식에 여러 값을 저장하듯 여러 노드가 하나의 변수에 저장된 것을 가리킨다.

노드 리스트에서 특정 위치의 **노드에 접근할 때는 인덱스를 사용** 한다.

`document.querySelectorAll("p")[0];`

`document.querySelectorAll("p")[1]`

#### DOM 트리를 활용해 원하는 노드 다루기

* 자식 노드 확인하기 - **hasChildNodes()** 함수

hasChildNodes() 함수는 특정 노드에 자식 노드가 있는지를 확인하는 함수이다. 자식 노드가 있다면 true를, 그렇지 않다면 false를 반환한다.

웹 브라우저 창에 nodeList.html 문서가 열려 있는 상태에서 콘솔 창에 다음과 같이 입력해 보세요. 여러 p 노드 중 첫번째 p 노드에 자식 노드가 있는지 확인하는 것이다. 결과가 true로 표시되었으니 첫 번째 p 노드에는 자식 노드가 있겠군요.

`document.querySelectorAll("p")[0].hasChildNodes();`

* 자식 노드에 접근하기 - **childNodes** 속성

자식 노드가 있다면 childNodes 속성을 사용해서 현재 노드의 자식 노드에 접근할 수 있다. 이때 **요소 노드뿐만 아니라 태그와 태그 사이의 줄바꿈도 빈 텍스트 노드인 자식 노드로 인식** 한다.(자식 노드는 한 개일 수도 있고 여러 개일 수도 있기 때문에 속성 이름이 복수형인 점을 기억해 두자.)

콘솔 창에 다음과 같이 입력해 보자.

`document.querySelector("#nameList").childNodes`

`#nameList` 요소의 자식 노드가 표시되는데 모두 7개의 노드가 있다. 이것은 `<div>` 태그 다음의 줄 바꿈, `<p>` 태그 사이의 줄 바꿈, 그리고 `</div>` 태그 앞의 줄 바꿈을 빈 텍스트 노드로 인식하기 때문이다.


* 요소에만 접근하려면 **children** 속성 사용

DOM에서 childNodes 속성을 사용하면 요소 노드뿐만 아니라 텍스트 노드나 주석 노드까지 모두 접근할 수 있다. 만약 자식 노드 중에서 텍스트 노드와 주석 노드는 필요하지 않고 요소 노드 에만 접근한다면 children 속성을 사용하면 된다.

nodeList.html 문서가 웹 브라우저 창에 열려 있는 상태에서 콘솔 창에 다음과 같이 입력하면 3개의 p요소만 가져온다. 이때 요소만 가져와 저장된 자료형을 HTMLCollection이라 하고, 사용법은 배열과 같다.

`document.querySelector("#nameList").children`


#### 원하는 위치에 노드 삽입하기 - insertBefore() 함수

자식 노드를 추가하는 appendChild()  함수는 부모 노드에 자식 노드가 있을 경우 마지막 자식 노드로 추가 된다. 하지만 insertBefore() 함수를 사용하면 부모 노드에 자식 노드를 추가할 때 기준이 되는 노드를 지정하고 그 앞에 자식 노드를 추가할 수 있다.

웹 브라우저에 nodeList.html 문서를 열자. 화면에 3개의 이름이 나열되어 있는데, insertBefore() 함수를 사용해서 3번째 이름을 맨 앞으로 옮겨 보자.

`var nameList = document.querySelector("#nameList");`

콘솔 창에서 insertBefore() 함수를 사용해 다음과 같이 입력하자. insertBefore() 함수에서는 2개의 인수를 사용하는데, 첫 번째 인수는 추가하는 노드, 두 번째 인수는 기준이 되는 노드이다. 다음 소스에서 기준이 되는 노드는 nameList의 첫 번째 자식 노드이고, 삽입할 노드는 nameList의 세 번째 자식 노드이다. 즉 세 번째 자식 노드를 첫 번째 자식 노드 앞에 추가하는 것이다.

`nameList.insertBefore(nameList.children[2], nameList.children[0]);`

웹 브라우저 창을 확인해 보자. 세 번째 노드 '도레미'가 맨 앞으로 옮겨졌다.

#### 특정 노드 삭제하기 - removeChild() 함수와 parentNode 속성

DOM 트리에 있는 노드를 삭제할 때는 removeChild() 함수를 사용한다. 함수 이름에서 알 수 있듯이 부모 노드에서 자식 노드를 삭제하는 함수이고, 괄호 안에는 삭제하려는 자식 노드가 들어간다.

노드는 스스로 자신을 삭제할 수 없기 때문에 부모 노드에 접근한 후 부모 노드에서 삭제해야 한다. 그래서 특정 노드를 삭제하려고 할 때 그 노드의 부모 노드를 먼저 찾아야 하는데, 부모 노드 정보를 가지고 있는 속성이 parentNode 속성이다. parentNode 속성은 현재 노드의 부모 요소 노드를 반환한다.

*참고. childNodes는 끝에 -s가 붙는 복수형이지만 부모 노드는 하나뿐이므로 parentNode는 단수형으로 사용한다.*

웹 브라우저에 nodeList.html 문서가 열려 있는 상태에서 노드를 삭제해 보자.

이 문서에서 첫 번째 `<span class="del">X</span>` 요소의 부모 노드는 무엇일까? 콘솔 창에서 확인해 보자. 콘솔 창에 다음과 같이 입력해 보자. 결과 내용 `<p>` 앞의 ▶를 눌러보면 "홍길동"이라는 텍스트가 있는 p 요소가 부모 요소인 것을 알 수 있다.

`document.querySelectorAll(".del")[0].parentNode`

nodeList.html 문서에서 "홍길동"이라는 텍스트의 부모 노드는 어떤 노드일까? 콘솔 창에 소스를 입력해서 "홍길동"이라는 텍스트의 부모를 찾아보자.

`document.querySelectorAll("p")[0].parentNode`

따라서 첫 번째 `<span class="del">X</span>` 요소를 삭제하려면 첫 번째 `p` 요소에서 `removeChild()` 함수를 실행해야 한다.

```
var firstDel = document.querySelectorAll(".del")[0];		// 첫 번째 X
var firstP = document.querySelectorAll("p")[0];		// 첫 번째 p 요소
firstP.removeChild(firstDel);				// 첫 번째 p 요소에 있는 첫번째 x 삭제
// document.querySelectorAll("p")[0].removeChild(firstDel);
```

---

참가 신청 명단 프로그램 개선하기 
```
// 최근에 입력한 이름을 명단 맨 위에 표시하기.
var nameList = document.querySelector("#nameList");
// nameList.appendChild(newP);		// 이거 대신에 
nameList.insertBefore(newP, nameList.childNodes[0]);	// p 요소를 #nameList 맨 앞에 추가하기
```


```
function newRegister() {						
    var newP = document.createElement("p");     // 새 p 요소 만들기 
    var userName = document.querySelector("#userName");					
    var newText = document.createTextNode(userName.value);  // 새 텍스트 노드 만들기
    newP.appendChild(newText);      // 텍스트 노드를 p 요소의 자식 요소로 연결하기
   
    var delBttn = document.createElement("span"); 	// 새 button 요소 만들기 
    var delText = document.createTextNode("X");  // 새 텍스트 노드 만들기
    delBttn.setAttribute("class", "del");  // 버튼에 class 속성 설정하기
    delBttn.appendChild(delText);  // 텍스트 노드를 button 요소의 자식 요소로 연결하기							
    newP.appendChild(delBttn);  //	del 버튼을 p 요소의 자식 요소로 		

    var nameList = document.querySelector("#nameList");  
    nameList.insertBefore(newP, nameList.childNodes[0]);  // p 요소를 #nameList 맨 앞에 추가하기
    userName.value = "";  // 텍스트 필드 지우기
  
    var removeBttns = document.querySelectorAll(".del");
          
    for (var i=0; i<removeBttns.length; i++) {  // removeBttns에 있는 요소 전체를 반복
        removeBttns[i].addEventListener("click", function() {  // i번째 버튼을 클릭했을 때 실행할 함수 선언
        if (this.parentNode.parentNode)  // 현재 노드(this)의 부모 노드의 부모 노드가 있을 경우 실행
            this.parentNode.parentNode.removeChild(this.parentNode);  // ‘현재 노드(this)의 부모 노드의 부모 노드’를 찾아 ‘현재 노드(this)의 부모 노드(p 노드)’ 삭제
    });
  }	
}
```