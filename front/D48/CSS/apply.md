## CSS를 적용하는 방법

1. 인라인 스타일(Inline style)

2. 내부 스타일 시트(Internal style sheet)

3. 외부 스타일 시트(External style sheet)

---

### 인라인 스타일(Inline style)

*  **HTML 요소 내부** 에 style 속성을 사용하여 CSS 스타일을 적용하는 방법
* 이 방식은 한 번 설정된 스타일을 변경하기가 매우 어려우며, 스타일 시트를 사용하는 많은 이점을 잃게 됨
* 따라서 이 방식은 될 수 있으면 꼭 필요한 경우에만 사용해야 함

```
<body>
    <h2 style="color:green; text-decoration:underline">INLINE</h2>
</body>
```

--- 

### 내부 스타일 시트(Internal style sheet)

* HTML 문서 내의 **<head>태그에 <style>태그를 사용** 하여 CSS 스타일을 적용
* 이러한 내부 스타일 시트는 해당 HTML 문서에만 스타일을 적용할 수 있음

```
<head>
    <style>
        body { background-color: lightyellow; }
        h2 { color: red; text-decoration: underline; }
    </style>
</head>
```

---

### 외부 스타일 시트(External style sheet)

* 웹 사이트 전체의 스타일을 하나의 파일에서 변경할 수 있도록 해줌
* 외부에 작성된 이러한 **스타일 시트 파일은 .css 확장자를 사용** 하여 저장
* 스타일을 적용할 웹 페이지의 **<head>태그에 <link>태그** 를 사용하여 외부 스타일 시트를 포함해야만 스타일이 적용됨

```
<head>
    <link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
```

---

#### 스타일 적용의 우선순위

1. 인라인 스타일 (HTML 요소 내부에 위치함)

2. 내부 / 외부 스타일 시트 (HTML 문서의 head 요소 내부에 위치함)

3. 웹 브라우저 기본 스타일