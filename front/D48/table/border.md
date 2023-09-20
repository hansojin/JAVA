border-collapse는 표(table)의 테두리와 셀(td)의 테두리 사이의 간격을 어떻게 처리할 지 정합니다.
* border-collapse: separate | collapse | initial | inherit

    * separate(default) : 표(table)의 테두리와 셀(td)의 테두리 사이에 간격을 둡니다.
    * collapse : 표(table)의 테두리와 셀(td)의 테두리 사이의 간격을 없앱니다. 겹치는 부분은 한 줄로 나타냅니다.
    * initial : 기본값으로 설정합니다.
    * inherit : 부모 요소의 속성값을 상속받습니다.

```
table {
        border-collapse: collapse;
}

.textCenter{
	text-align: center;
    // 속성 값들 center, right, left 
}
```


---

### border 속성

* 태그의 테두리를 설정하는 속성
* width - style - color의 순서로 사용
    * border-width
        * 테두리의 두께로, 주로 px 단위를 사용
    * border-style
        * 실선, 점선, 이중선 등의 옵션이 존재
        * solid(실선), dotted(점선), dashed(긴점선), double, groove 등
    * border-color
* 방향
    * border-top, border-bottom, border-left, border-right
    * 특정 방향의 색, 두께, 스타일을 따로 설정 할 수 있음

