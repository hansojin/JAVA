## 폼과 자바스크립트

어떤 웹 사이트의 경우 회원 가입을 해야 이용할 수 있습니다. 사용자는 회원 가입을 하는 과정에서 아이디와 비밀번호 등의 정보를 입력해야 하지요. 또 쇼핑몰 사이트에서 물건을 주문할 때도 주소지와 전화 번호 같은 배송 정보를 사용자가 입력해야 합니다. 이렇게 **사용자가 정보를 입력할 수 있게 만들어 놓은 웹 요소** 를, '폼(Form)'이라고 합니다. 그리고 사용자가 폼 요소에 내용을 입력했을 때 그 내용을 가져오거나 수정하는 일, 입력한 내용이 미리 정한 형식에 맞는지를 확인하는 일을 **자바스크립트로 처리** 하지요.

## 배송 정보 자동 입력기

### id 값이나 class 값을 사용해 폼 요소에 접근하기

아이디가 billingName인 것의 값(value)를 출력하자.

`document.querySelector("#billingName").value`

order.html 문서에서 [연락처: ] 필드의 id 값을 확인한 후 그 필드에 전화번호를 입력했을 때 그 내용을 가져오는 소스를 콘솔 창에 작성하시오.

`document.querySelector("#billingTel").value`

### name 값을 사용해 폼 요소에 접근하기

폼 요소에 id나 class 속성이 없고 name 속성만 있다면 name 식별자를 사용해 폼 요소에 접근할 수도 있습니다. id나 class 속성은 웹 개발에 CSS를 사용하기 시작하면서부터 등장했지만, name 속성은 자바스크립트에서 폼 요소를 구별하고 접근할 수 있도록 HTML 초기부터 사용하던 방법이다. 직접 폼을 작성한다면 id나 class 선택자를 사용하는 것이 낫지만, 다른 사람이 작성해 놓은 폼 소스에 name 속성만 있다면 이 방법을 사용해야 한다.

order.html 문서의 소스를 연다. 다음과 같이 `<form>` 태그의 name 값이 ship이고, 텍스트 필드의 **name 값이 shippingName** 인 폼 요소가 있는 것을 확인할 수 있다. *([이름: ] 필드에는 id 값이 있기 때문에 querySelector() 함수를 사용하는 것이 낫지만, 여기에서는 name 속성 사용법을 익히기 위해 name 속성을 사용합니다. 폼 요소에서 사용하는 name 값은 주로 id 값과 같게 지정합니다.)*

```
<form name="ship">
	...
	<label class="field" for="shippingName">이름 : </label>
	<input type="text" class="input-box" id="shippingName" name="shippingName">
	...
</form>
```

폼 안에 있는 텍스트 필드에 접근하려면 `<form>`의 name 값과 텍스트 필드의 name 값을 사용하면 됩니다. 콘솔 창에 다음과 같이 입력해 보자. 이 소스는 '배송 정보' 중 [이름: ] 항목의 텍스트 필드에 접근하는 소스이다.

`document.ship.shippingName`

또는 다음과 같이 접근할 수도 있다.

`document.forms["ship"].elements["shippingName"]`

name이 shippingName의 값 가져오기

`document.ship.shippingName.value`

order.html에서 '배송 정보' 중 [주소] 항목에 내용을 입력했을 때 name 속성을 사용해 그 내용에 접근하는 소스를 작성하세요.

`document.ship.shippingAddr.value` 또는
`document.forms["ship"].elements["shippingAddr"].value`

앞에서 살펴본 id 식별자를 통해 접근하는 방법은 접근할 요소에 id 속성이 지정되어 있다면 쉽게 접근할 수 있지만, name 속성을 사용해 접근하려면 `<form>` 태그뿐만 아니라 접근하려는 폼 요소에 모두 name 속성이 지정되어 있는지 확인해야 한다.

### 폼 배열을 사용해 폼 요소에 접근하기

이번에는 폼 배열을 사용해 폼 요소에 접근해 보겠습니다. document의 속성 중 forms 속성은 문서 안에 있는 `<form>` 태그를 모두 가져와 배열 형태로 반환합니다. 이 방법은 **폼 요소에 id나 class 속성도 없고 name 속성도 없을 때 사용** 합니다.

이제 폼 배열을 사용해 폼에 접근하는 방법을 알아보겠습니다. 웹 브라우저에서 reg.html 문서를 열어 보세요. 이 문서에서는 1개의 `<form>`태그를 사용하고 있는데, `<form>` 태그와 그 안에 있는 다른 폼 요소에도 id나 class 선택자가 없고 name 속성도 없습니다. 이럴 경우에 폼 배열을 사용하면 됩니다. *(폼 배열을 사용하는 방법은 웹 문서에 `<form>`태그가 몇 개나 사용되었는지 알고 있어야 하고, `<form>` 태그 안에 폼 요소가 많을 경우 원하는 요소에 접근하기 쉽지 않기 때문에 실무에서 자주 사용하지는 않습니다.)*

```
<div id="container">
    <h3>로그인</h3>
    <form>
      <div id="login_input">
        <input type="text" autofocus placeholder="아이디">
        <input type="password" placeholder="비밀번호">
      </div>
      <div id="login_bttn">
        <button type="submit" class="order">로그인</button>
      </div>
    </form>
</div>
```

콘솔 창에 다음과 같이 입력하면 숫자 없이 HTMLCollection이라고 표시됩니다. 이 문서에는 form 요소가 하나뿐이기 때문이죠. `<form>` 태그가 두 개라면 HTMLCollection(2)처럼 괄호 안에 form 요소의 개수가 표시됩니다.

`document.forms`

`<form>` 태그 안에 포함된 요소에 접근하려면 elements 속성을 사용합니다. 해당 폼 안에 있는 폼 요소를 모두 가져오는 속성입니다. 콘솔 창에 다음과 같이 입력하세요. 문서에 폼이 하나 밖에 없으므로 forms[0]이라고 입력해 forms 배열의 첫 번째 요소를 지정합니다. forms[0] 안에 있는 요소를 모두 가져오면 HTMLFormControlsCollection 배열 형태로 저장됩니다. ▶를 누르면, 인덱스 0부터 2까지 어떤 요소가 저장되었는지 확인할 수 있습니다.

1) 현재 문서의 2) 첫 번째 form의 3) 첫 번째 요소의 4) 값

`document.forms[0].elements[0].value;`

reg.html 문서에서 폼 배열을 사용해 '비밀번호' 필드에 입력한 값을 가져오려면 어떤 소스를 사용해야 할까요?

`document.forms[0].elements[1].value;`


```
// 배송 정보 자동 입력 프로그램 만들기
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>결제하기</title>
	<link rel="stylesheet" href="css/order.css">
</head>
<body>
	<div id="container">
		<form name="order">
			<fieldset>
				<legend>주문 정보</legend>
				<ul>
					<li>
						<label class="field" for="billingName">이름 : </label>
						<input type="text" class="input-box" id="billingName" name="billingName">
					</li>
					<li>
						<label class="field" for="billingTel">연락처 : </label>
						<input type="text" class="input-box" id="billingTel" name="billingTel">	
					</li>
					<li>
						<label class="field" for="billingAddr">주소 : </label>
						<input type="text" class="input-box" id="billingAddr" name="billingAddr">
					</li>
				</ul>
			</fieldset>
		</form>
		<form name="ship">
			<fieldset>
				<legend>배송 정보</legend>								
				<ul>
					<li>
						<input type="checkbox" id="shippingInfo" name="shippingInfo">
						<label for="shippingInfo" class="check">주문 정보와 배송 정보가 같습니다</label>
					</li>
					<li>
						<label class="field" for="shippingName">이름 : </label>
						<input type="text" class="input-box" id="shippingName" name="shippingName">
					</li>
					<li>
						<label class="field" for="shippingTel">연락처 : </label>
						<input type="text" class="input-box" id="shippingTel" name="shippingTel">	
					</li>
					<li>
						<label class="field" for="shippingAddr">주소 : </label>
						<input type="text" class="input-box" id="shippingAddr" name="shippingAddr">
					</li>
				</ul>				
			</fieldset>
			<button type="submit" class="order">결제하기</button>
		</form>		
	</div>

	<script>
        var check = document.querySelector("#shippingInfo");  // 체크박스의 id는 shippingInfo

	    check.addEventListener("click", function() {   // check 요소에 click 이벤트가 발생했을 때 실행할 함수
			if(check.checked == true) {  // 체크되었다면
				document.querySelector("#shippingName").value = document.querySelector("#billingName").value;  // 주문 정보(이름)를 배송 정보(이름)에 복사
				document.querySelector("#shippingTel").value = document.querySelector("#billingTel").value;  // 주문 정보(전화번호)를 배송 정보(전화번호)에 복사
				document.querySelector("#shippingAddr").value = document.querySelector("#billingAddr").value;   // 주문 정보(주소)를 배송 정보(주소)에 복사
			}
			else {  // 체크되어 있지 않다면 배송 정보 필드를 지움.
				document.querySelector("#shippingName").value = "";
				document.querySelector("#shippingTel").value = "";
				document.querySelector("#shippingAddr").value = "";
			}
		});
    </script>
</body>
</html>
```

---


### 폼 요소에서 입력값 검증하기

자바스크립트를 여러 분야에 사용하기 전에는 주로 **폼에 입력한 값의 유효성을 검사할 때 사용** 했습니다. 값이 입력되었는지, 입력된 값이 정해진 조건에 맞는지 등을 검사하는 이 작업은 흔히 **Form Validation** 이라고 불립니다.

#### 회원 가입 페이지 입력값 검증하기


```
// 아이디 글자 수 확인하기
var userId = document.querySelector("#user-id");	
userId.onchange = checkId;

function checkId() {
	if(userId.value.length < 4 || userId.value.length > 15) {
		// userId 필드 내용의 길이가 4이하이거나 15이상일 경우 실행
		alert("4~15자리의 영문과 숫자를 사용하세요.");	// 오류 메시지 출력
		userId.select();	// 다시 입력할 수 있도록 userId 필드 선택
	}
}
```

```
// 전체 코드
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/register.css">
	<title>회원 가입</title>
</head>
<body>
	<div id="container">
		<h1>회원 가입</h1>
		<form action="#" id="register">
			<ul id="user-info">
				<li>
					<label for="user-id" class="field">아이디</label>
					<input type="text" id="user-id" placeholder="4~15자리의 영문과 숫자로 입력" required>
				</li>
				<li>
					<label for="email" class="field">이메일</label>
					<input type="email" id="email" required>
				</li>
				<li>
					<label for="user-pw1" class="field">비밀번호</label>
					<input type="password" id="user-pw1" placeholder="8자리 이상" required>
				</li>
				<li>
					<label for="user-pw2" class="field">비밀번호 확인</label>
					<input type="password" id="user-pw2" required>
				</li>
				<li>
					<label class="field">메일링 수신</label>
					<label class="r"><input type="radio" value="yes" name="mailing">예</label>
					<label class="r"><input type="radio" value="no" name="mailing">아니오</label>
				</li>
			</ul>
			<ul id="buttons">
				<li>
					<button type="submit" class="btn btnBlack">가입하기</button>					
				</li>
				<li>
					<button type="reseet" class="btn btnGray">취소</button>
				</li>
			</ul>
		</form>
	</div>
	
	<script>
        var userId = document.querySelector("#user-id");  
		var pw1 = document.querySelector("#user-pw1");  
		var pw2 = document.querySelector("#user-pw2");  

		userId.onchange = checkId;
		pw1.onchange = checkPw;
		pw2.onchange = comparePw;

		function checkId() {			
			if (userId.value.length < 4 || userId.value.length > 15) {  
				alert("4~15자리의 영문과 숫자를 사용하세요.");  
				userId.select();    // 다시 입력할 수 있도록 userId 필드 선택
			}
		}

		function checkPw() {			
			if (pw1.value.length < 8) {
                alert("비밀번호는 8자리 이상이어야 합니다.");  
                pw1.value = "";  // ‘비밀번호’ 필드 지움
				pw1.focus();  // 비밀번호를 다시 입력할 수 있게 포커싱
			}
		}

		function comparePw() {						
			if(pw1.value != pw2.value) {
				alert("암호가 다릅니다. 다시 입력하세요.");
				pw2.value = "";  // ‘비밀번호 확인’ 필드 지움
				pw2.focus();   // 비밀번호를 다시 입력할 수 있게 포커싱
			}
		}
    </script>
</body>
</html>
```

---


*참고*

**focus()** 함수는 해당 요소에 포커스를 맞추는 자바스크립트 내장 함수입니다. 텍스트 필드에서 사용할 경우 해당 텍스트 필드 안에 커서를 갖다 놓습니다.

**select()** 함수는 자바스크립트에 내장되어 있습니다. select() 함수를 사용하면 텍스트 필드에 입력한 내용을 선택합니다.

**select() 함수와 focus() 함수**

텍스트 필드를 검증해서 오류가 발생했을 때 사용자가 입력한 값을 어떻게 처리할지에 따라 select() 함수와 focus() 함수를 사용할 수 있다. checkId() 함수에 사용한 select() 함수는 사용자가 기존에 입력한 값을 선택하고, checkPw() 함수에 사용된 focus() 함수는 기존에 입력한 값이 지워진 자리에 새로운 값을 입력하도록 텍스트 필드에 커서를 가져도 놓습니다.

**태그 자체에서 폼 검증하기**

HTML5의 `<input>` 태그에 폼 검증을 위한 여러 속성이 추가되면서 자바스크립트 대신 type 속성 값을 사용해서 필드 값을 체크할 수 있다. HTML5에서 `<input>`태그의 유형과 속성을 통해 검증할 수 있는 것은 다음과 같다.

`<input>` 태그의 새로운 유형

* `<input type="email">`		이메일 주소 필드 입니다. 이메일 주소 형식에 맞지 않으면 오류 메시지를 표시합니다.
* `<input type="tel">	`	전화번호 필드입니다. 전화번호 숫자가 아닌 내용을 입력하면 오류 메시지를 표시합니다.
* `<input type="url">`	사이트 주소 필드입니다. http:로 시작하지 않으면 오류 메시지를 표시합니다.

`<input>` 태그의 새로운 속성

- autocomplete		
    * 자동 완성 기능을 켜고 끄는 속성입니다.
- autofocus			
    * 해당 필드에 마우스 커서를 자동으로 표시합니다.
- placeholder		
    * 필드 안에 힌트가 표시되어 사용자에게 어떤 내용을 입력해야 하는지 알려 줍니다. 필드 내부를 누르면 표시된 힌트가 사라집니다.
- required			
    * 필수 입력 항목으로 지정합니다. 필드가 작성하지 않으면 오류 메시지를 표시하며 다음 단계로 넘어갈 수 없습니다.
    * required 속성을 사용해 필수 필드로 지정했는데 값을 입력하지 않으면 오류 메시지를 표시하는데, 오류 메시지는 브라우저에서 처리한 것이기 때문에 브라우저마다 나타나는 오류 내용이 다릅니다.

---

### 다양한 폼 요소 다루기

getForm.html 문서를 웹 브라우저에서 실행하여 콘솔 창에서 name="major" 인 것을 선택해 보자.

`document.testForm.major`

option 목록을 가져오자.

`document.testForm.major.options`

콘솔 창에 다음과 같이 입력하면 HTMLOptionsCollection(7)이라고 표시되며 이것은 선택 목록에는 7개의 option이 있고 배열 형식으로 저장되어 있다는 의미이다.

HTMLOptionsCollection(7) 앞에 있는 ▶를 눌러 배열을 열어 보면 인덱스 0부터 6까지의 배열에 선택 목록의 항목(option 항목)이 들어 있고, length 속성에는 옵션 항목의 개수가 저장되어 있습니다. 그리고 selectedIndex에는 여러 옵션 중 사용자가 선택한 옵션의 인덱스 값이 저장된다. 아직 아무것도 선택하지 않았으므로 기본 값 0이 출력된다.

선택 목록 중 다섯 번째 옵션 항목에 접근하자.

`document.testForm.major.options[4];`

다섯 번째 옵션이 **화면에 표시하는 내용** 에 접근하자.

`document.testForm.major.options[4].innerText;`		

다섯 번째 옵션 항목을 선택했을 때 **서버로 넘겨주는 값** 선택

`document.testForm.major.options[4].value;`		

getForm.html 문서에 있는 선택 목록에서 세 번째 항목이 화면에 표시하는 내용을 가져오는 소스를 작성하세요.

`document.testForm.major.options[2].innerText;`

선택 목록에서 사용자가 선택한 옵션 항목 찾아내기

`document.testForm.major.options.selectedIndex`

라디오 버튼 이름이 "subject"인 요소에 접근한다.

`document.testForm.subject;`

이름이 mailing1인 요소에 접근한다.

`document.testForm.mailing1;`

라디오 버튼 요소나 체크 상자 요소에는 **checked 속성이 있는데 기본 값은 false** 이다. 그리고 해당 항목을 선택하면 값이 true로 바뀐다.

웹 브라우저 창에서 3개의 라디오 버튼 중 `[문법]` 항목을 누른 후 콘솔 창에 다음 소스를 입력해 보자. 첫 번째 항목은 선택되지 않았기 때문에 false로 표시되고, 두 번째 항목은 선택되었기 때문에 true라고 표시된다.

```
document.testForm.subject[0].checked;
document.testForm.subject[1].checked;
document.testForm.subject[2].checked;
```

체크 상자도 확인해 볼까요? 3개의 체크 상자 중 [해외 단신] 항목을 누른 후 다음을 입력해 보세요. 체크한 항목은 true, 나머지는 false가 표시된다.

```
document.testForm.mailing1.checked;
document.testForm.mailing2.checked;
document.testForm.mailing3.checked;
```

*(체크 상자의 name을 다르게 지정하는 것이 번거롭다면, mailing[] 처럼 배열로 지정할 수도 있습니다. 이렇게 하면 mailing[0], mailing[1], ... 식으로 name이 할당됩니다.)*