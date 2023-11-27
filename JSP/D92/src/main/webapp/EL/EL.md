## EL(Expression Language)

콤마(,)와 대괄호([])를 사용하여 자바 빈의 프로퍼티나 맵, 리스트, 배열의 값을 보다 쉽게 꺼내게 해주는 기술이다.

#### JSP에서 표현 언어 사용 설정

JSP 페이지에서 표현 언어(EL)를 사용하기 위해서는 **page 디렉티브의 isELIgnored 속성을 false로 설정** 해주어야 합니다. 그러나 이 속성은 명시하지 않는 경우 기본값이 false이므로 따로 지정해주지 않아도 됩니다.

`<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>`

### EL 표기법

```
${member.no} 
객체이름 프로퍼티

${member["no"]}
객체이름 프로퍼티
```
위의 EL 표기법을 자바 코드로 표현하면 다음과 같다.

```
Member member = (Member)pageContext.findAttribute("member");
int value = member.getNo();
```

PageContext의 findAttribute()는 다음 순서에 따라 보관소(Scope Objects)를 뒤져서 객체를 찾는다. 마지막까지 뒤졌는데 없다면 null을 반환한다.

`JspContext - ServletRequest - HttpSession - ServletContext - null`

---

#### EL에서 검색 범위 지정

EL도 `<jsp:useBean>`처럼 네 군데 보관소에서 값을 꺼낼 수 있다. 다만 `<jsp:useBean>`과 다른 점은 EL로는 객체를 생성할 수 없다는 것이다. 다음은 EL에서 보관소를 참조할 때 사용하는 이름이다.

```
pageScope	->	JspContext
requestScope	->	ServletRequest
sessionScope	->	HttpSession
applicationScope 	->	ServletContext
```

다음 그림은 ServletRequest 보관소에서 값을 꺼내는 EL 코드이다.

`${requestScope.member.no}`

위의 EL 코드를 자바 코드로 나타내면 다음과 같다.

```
Member member = (Member)request.getAttribute("member");
int value = member.getNo();
```

객체를 찾는 범위를 지정하지 않으면 JspContext부터 ServletContext까지 순차적으로 찾지만, 앞의 코드와 같이 범위를 지정하게 되면 해당 보관소에서만 객체를 찾는다. 못 찾으면 null을 반환한다.

---

#### JSP에서 제공하는 EL 기본 객체

다음은 JSP에서 기본 제공하는 EL 객체이다.

```
객체			설명				코드
pageContext		JSP의 PageContext 객체		
servletContext		ServletContext 객체		${pageContext.servletContext.객체명}
session			HttpSession 객체			${pageContext.session.객체명}
request			ServletRequest 객체		${pageContext.request.객체명}
response			ServletResponse 객체		
param			요청 매개변수의 값 조회		${param.매개변수명}
paramValues		요청 매개변수의 값 배열 조회	${paramValues.매개변수명}
header			Http 헤더의 값 조회		${header.헤더명}
headerValues		Http 헤더의 값 배열 조회		${headerValues.헤더명}
cookie			쿠키 값 조회			${cookie.쿠키명}
initParam			컨텍스트 초기화 매개변수의 값 조회 	${initParam.매개변수명}
pageScope		page 보관소의 값 조회		${pageScope.객체명}
requestScope		request 보관소의 값 조회		${requestScope.객체명}
sessionScope		session 보관소의 값 조회		${sessionScope.객체명}
applicationScope		application 보관소의 값 조회		${applicationScope.객체명}
```

---

#### EL 기본 문법

* 리터럴 표현식

EL 블록(${})에서 사용할 수 있는 값은 문자열, 정수, 부동소수점, 참거짓(boolean), 널(null)이 가능하다. 다음은 EL 표현식과 그 결과이다.

```
// EL 표현식  
* 문자열 : ${"test"}	
* 문자열 : ${'test'}
* 정수 : ${20}
* 부동소수점 : ${3.14}
* 참거짓 : ${true}
* null : ${null}
```

앞의 EL 표현식을 JSP 페이지에 넣고 테스트해 보면 다음과 같은 결과를 얻을 수 있다.

```
// 실행결과
문자열 : test
문자열 : test
정수 : 20
부동소수점 : 3.14
참거짓 : true
null : 
// 마지막 ${null}의 실행 결과는 빈 문자열("")이다.
```

---

#### 값 표현식

자바 객체, 배열, List, Map으로 부터 값을 꺼낼 때 사용하는 EL 표현식을 알아보면

**배열에서 값 꺼내기**

```
EL 표현식
<% // 값 준비
pageContext.setAttribute("scores", new int[] {90, 80, 70, 100});
%>
<%-- 배열에서 인덱스 2의 값 꺼내기 --%>
${scores[2]}

실행결과
70
```

**List 객체에서 값 꺼내기**

```
EL 표현식
<% // 값 준비
List<String> nameList = new LinkedList<String>();
nameList.add("홍길동");
nameList.add("임꺽정");
nameList.add("일지매");
pageContext.setAttribute("nameList", nameList);
%>
<%-- 리스트 객체에서 인덱스 1의 값 꺼내기 --%>
${nameList[1]}

실행 결과
임꺽정
```

**Map 객체에서 값 꺼내기**

```
EL 표현식
<% // 값 준비
	Map<String, String> map = new HashMap<String, String>();
	map.put("s01", "홍길동");
	map.put("s02", "임꺽정");
	map.put("s03", "일지매");
	pageContext.setAttribute("map", map);
%>
<%-- 맵 객체에서 키 s02로 저장된 값 꺼내기 --%>
${map.s02}

실행결과
임꺽정
```

---

#### 연산자

EL 블록에서도 간단한 연산을 수행할 수 있다. EL에서 제공하는 연산자 중 몇몇은 기호뿐만 아니라 동일한 기능의 영문으로 된 연산자도 있다. 다음은 EL에서 지원하는 주요 연산자에 대한 설명이다.

**산술 연산자**

EL에서 제공하는 산술 연산자에는 더하기(+), 빼기(-), 곱하기(*), 나누기(/, div), 나머지(%, mod) 값을 구하는 연산자가 있다.

'${' 앞에 **'\\'** 가 붙으면 '${'은 EL 문법이 아닌 **일반 텍스트로 취급** 한다.

```
EL 표현식
\${10 + 20} = ${10 + 20} <br/>
\${10 - 20} = ${10 - 20} <br/>
\${10 * 20} = ${10 * 20} <br/>
\${10 / 20} = ${10 / 20} <br/>
\${10 div 20} = ${10 div 20} <br/>
\${10 % 20} = ${10 % 20} <br/>
\${10 mod 20} = ${10 mod 20} <br/>

실행결과
${10 + 20} = 30 
${10 - 20} = -10 
${10 * 20} = 200 
${10 / 20} = 0.5 
${10 div 20} = 0.5 
${10 % 20} = 10 
${10 mod 20} = 10 
```

**논리 연산자**

EL에서 제공하는 논리 연산자는 AND(&&, and), OR(||, or) NOT(!, not)이 있다.

```
EL 표현식
\${true && false} = ${true && false}<br/>
\${true and false} = ${true and false}<br/>
\${true || false} = ${true || false}<br/>
\${true or false} = ${true or false}<br/>
\${not true} = ${not true}<br/>
\${!true} = ${!true}<br/>

실행결과
${true && false} = false
${true and false} = false
${true || false} = true
${true or false} = true
${not true} = false
${!true} = false
```

**관계 연산자**

EL에서 제공하는 관계 연산자는 같다(==, eq), 같지 않다(!=, ne), 크다(>, gt), 작다(<, lt), 크거나 같다(>=, ge), 작거나 같다(<=, le)가 있다.

```
eq	equal		같다
ne	not equal		다르다
gt	greater than	크다
ge	greater than or equal	크거나 같다
lt	less than		작다
le	less than or equal	작거나 같다
```

```
EL 표현식
\${10 == 11} = ${10 == 11} <br/>
\${10 eq 11} = ${10 eq 11} <br/>
\${10 != 11} = ${10 != 11} <br/>
\${10 ne 11} = ${10 ne 11} <br/>
\${10 < 11} = ${10 < 11} <br/>
\${10 lt 11} = ${10 lt 11} <br/>
\${10 > 11} = ${10 > 11} <br/>
\${10 gt 11} = ${10 gt 11} <br/>
\${10 <= 11} = ${10 <= 11} <br/>
\${10 le 11} = ${10 le 11} <br/>
\${10 >= 11} = ${10 >= 11} <br/>
\${10 ge 11} = ${10 ge 11} <br/>

<실행결과>
${10 == 11} = false 
${10 eq 11} = false 
${10 != 11} = true 
${10 ne 11} = true 
${10 < 11} = true 
${10 lt 11} = true 
${10 > 11} = false 
${10 gt 11} = false 
${10 <= 11} = true 
${10 le 11} = true 
${10 >= 11} = false 
${10 ge 11} = false 
```

**empty**

'empty'는 값이 비어 있거나 null인지를 조사할 때 사용하는 연산자이다. 값이 null이면 true를 반환한다. 또한, 문자열과 배열, Map, Collection 객체의 크기가 0인 경우에도 true를 반환한다. 그 밖에는 false를 반환한다.

```
EL 표현식
<% // 값 준비
pageContext.setAttribute("title", "EL 연산자!");
%>
<%-- 자바빈에서 프로퍼티 email의 값 꺼내기 --%>
\${empty title} = ${empty title}<br/>
\${empty title2} = ${empty title2}<br/>

실행결과
${empty title} = false
${empty title2} = true
```


**조건**

자바의 조건 연산자와 쓰임이 같다. 'A ? B : C'에서 A 조건이 참이면 B를 실행하고, A 조건이 거짓이면 C 조건을 실행합니다.

```
EL 표현식
\${10 > 20 ? "크다" : "작다"} = ${10 > 20 ? "크다" : "작다"}

실행결과
${10 > 20 ? "크다" : "작다"} = 작다
```

---

### 예약 키워드

다음은 EL에서 사용하거나 사용하기로 예약한 키워드이다.

`and, or, not, eq, ne, lt, ge, true, false, null, instanceof, empty, div, mod`

JspContext나 SevletRequest, HttpSession, ServletContext 보관소에 객체를 저장할 때, 그 **식별자(키)는 EL의 예약 키워드 이름과 같아서는 안 된다**  EL을 사용하지 않는다면 문제가 되지 않겠지만, EL을 사용한다면 오류가 발생할 것이다. 다음 예제는 객체 식별자의 이름이 예약 키워드의 이름과 같을 때, 오류가 발생하는 것을 보여준다.

```
EL 표현식
<%	// 값 준비
	pageContext.setAttributte("ne", "오호라!");
%>
<%-- pageContext에서 값 꺼내기 --%>
${ne}
<%-- 예약어를 써서 오류남 --%>
```