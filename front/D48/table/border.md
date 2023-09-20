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



