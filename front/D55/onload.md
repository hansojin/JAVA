**onload 이벤트** 는 **객체가 로드될 때 발생** 합니다.

onload는 웹 페이지가 모든 콘텐츠(이미지, 스크립트 파일, CSS 파일 등 포함)를 완전히 로드한 후 스크립트를 실행하기 위해 `<body>` 요소 내에서 가장 자주 사용됩니다.

onload 이벤트를 이용하면 방문자의 브라우저 유형과 브라우저 버전을 확인하고, 해당 정보를 바탕으로 적절한 버전의 웹페이지를 로드할 수 있습니다.

```
//  in html
<element onload="myScript">

// in JS
object.onload = function(){myScript};
// or
object.addEventListener("load", myScript);
```


```
// 예시 1) <img> 요소에 onload를 사용합니다. 이미지가 로드된 직후 "이미지가 로드되었습니다"라는 경고

<img src="w3javascript.gif" onload="loadImage()" width="100" height="132">

<script>
function loadImage() {
  alert("Image is loaded");
}
</script>

// 예시 2) onload 이벤트를 사용하여 쿠키 처리

<body onload="checkCookies()">

<script>
function checkCookies() {
  var text = "";

  if (navigator.cookieEnabled == true) {
    text = "Cookies are enabled.";
  } else {
     text = "Cookies are not enabled.";
  }
  document.getElementById("demo").innerHTML = text;
}
</script>

```

---

* 비어있는 웹페이지 열기
  * **about:blank**
* console clear
  * JS에서 console.clear()
  * window에서 ctrl+L
  * mac에서 command+k
* data type 확인
  * **typeof(변수명)**
  
