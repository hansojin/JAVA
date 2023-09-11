## CASE 문으로 데이터 변환하기

```
CASE 
    WHEN 조건식1 THEN 식1
    [WHEN 조건식2 THEN 식2 ...]
    [ELSE 식3]
END
```

먼저 **WHEN 절에는 참과 거짓을 반환하는 조건식** 을 기술한다. 해당 조건을 만족하여 참이 되는 경우는 THEN 절에 기술한 식이 처리된다. 이때 WHEN과 THEN을 한데 조합해 지정할 수 있다. WHEN 절의 조건식을 차례로 평가해 나가다가 가장 먼저 조건을 만족한 WHEN 절과 대응하는 THEN 절 식의 처리결과를 CASE 문의 결괏값으로 반환한다. 그 어떤 조건식도 만족하지 못한 경우에는 ELSE 절에 기술한 식이 채택된다. **ELSE는 생략 가능하며 생략했을 경우 'ELSE NULL'로 간주된다.**

```
CREATE TABLE sample37(a int);
INSERT INTO sample37 VALUES(1);
INSERT INTO sample37 VALUES(2);
INSERT INTO sample37 VALUES(NULL);

-- sample37 테이블에서 a를 출력하고  "a(null=0)"이라는 별명으로 a의 값을 출력하는 데 NULL은 0으로 출력하자.

SELECT a, 
    CASE 
        WHEN a IS NULL THEN 0 
        ELSE a 
    END "a(null=0)" 
FROM sample37;

SELECT a, 
    COALESCE(a, 0) "a의값중 null을 찾는용도" 
FROM sample37;
```

**COALESCE 함수** 는 여러 개의 인수를 지정할 수 있다. 
주어진 인수 가운데 NULL이 아닌 값에 대해서는 가장 먼저 지정된 인수의 값을 반환한다. 
앞의 예문은 a가 NULL이 아니면 a값을 그대로 출력하고, 그렇지 않으면(a가 NULL 이면) 0을 출력한다.

| A | B | COALESCE(A,B) |
|---|---| ------------- |
| 1 |null|     1        |
|null| 2 |     2        |
|null|null|   null      |

---

**문자화하는 것을 '디코드'** 라 부르고 반대로 **수치화하는 것을 '인코드'** 라고 부른다.

|코드=수치| 데이터 | 정보 |
|-----|-------------| --- |
|1|------디코드--->|남|
|2|<------인코드---|여|

이와 같은 디코드를 CASE 문으로도 처리할 수 있다.

CASE 문에는 2개의 구문이 있다!

CASE 문은 '검색 CASE'와 '단순 CASE'의 두 개 구문으로 나눌 수 있다. 검색 CASE는 앞서 설명한 'CASE WHEN 조건식 THEN 식 ...' 구문이다. 한편 단순 CASE는 'CASE 식 WHEN 식 THEN 식 ...' 구문이다. 단순 CASE에서는 CASE 뒤에 식을 기술하고 WHEN 뒤에 (조건식이 아닌) 식을 기술한다.	 

**단순 CASE 식**
```
CASE 식1
	WHEN 식2 THEN 식3
	[WHEN 식4 THEN 식5 ...]
	[ELSE 식6]
END
```

식1의 값이 WHEN의 식2의 값과 동일한지 비교하고, 값이 같다면 식3의 값이 CASE 문 전체의 결괏값이 된다. 값이 같지 않으면 그 뒤에 서술한 WHEN 절과 비교하는 식으로 진행된다. 즉, 식1의 값과 식4의 값이 같은지를 비교하고 같다면 식5의 값이 CASE 문의 결괏값이 된다. 비교 결과 일치하는 WHEN 절이 하나도 없는 경우에는 ELSE 절이 적용된다.

성별 코드 변환하기(검색 CASE)
검색 CASE로 성별코드를 남자, 여자로 변환하기

```
SELECT a AS "코드",
    CASE
	    WHEN a = 1 THEN '남자'
	    WHEN a = 2 THEN '여자'
	    ELSE '미지정'
    END 
    AS "성별" 
FROM sample37;
```

성별 코드 변환하기(단순 CASE)
단순 CASE로 성별 코드를 남자, 여자로 변환하기

```
SELECT a AS "코드",
    CASE a
	    WHEN 1 THEN '남자'
	    WHEN 2 THEN '여자'
	    ELSE '미지정'
    END 
    AS "성별" 
FROM sample37;
```

ELSE를 생략하면 ELSE NULL이 되는 것에 주의하자. 상정한 것 이외의 데이터가 들어오는 경우도 많다. 대응하는 WHEN이 하나도 없으면 ELSE 절이 사용된다. 이때 ELSE를 생략하면 상정한 것 이외의 데이터가 왔을 때 NULL이 반환된다. 따라서 ELSE를 생략하지 않고 지정하는 편이 낫다.

CASE 문의 ELSE는 생략하지 않는 편이 낫다!

- WHEN에 NULL 지정하기
단순 CASE에서는 WHEN 뒤에 1개의 상수값을 지정하는 경우가 많을 것이다.
앞에서 살펴본 예제에서처럼 WHEN 1 TEHN '남자' WHEN 2 THEN '여자'와 같이 쓸 수 있다. 여기에서 데이터가 NULL인 경우를 고려해 WHEN NULL THEN '데이터 없음'과 같이 지정해도 문법적으로는 문제가 없지만 정상적으로 처리되지 않는다.

그 이유에 대해 상세하게 설명하면, 단순 CASE 문에서는 CASE에서 지정된 식과 WHEN에서 지정된 식을 비교해가며 확인한다.

**단순 CASE 문에서 WHEN 절에 NULL 지정하기**

```
SELECT a AS "코드",
    CASE a
	    WHEN 1 THEN '남자'
	    WHEN 2 THEN '여자'
	    WHEN NULL THEN '데이터 없음'
	    ELSE '미지정'
    END
    AS "성별" 
FROM sample37;
```

이 예제에서는 다음과 같은 순서로 조건식을 처리한다.

① a = 1
② a = 2
③ a = NULL

비교 연산자 = 로는 NULL 값과 같은지 아닌지를 비교할 수 없다. 따라서 a 열의 값이 NULL이라 해도 a = NULL은 참이 되지 않는다. 즉 '데이터 없음' 대신 '미지정'이라는 결괏값이 나온다. 단순 CASE 문으로는 NULL을 비교할 수 없다는 문제점이 있다.

이 때 **NULL 값인지 아닌지를 판정하기 위해서는 IS NULL을 사용** 한다. 다만 단순 CASE 문은 특성상 = 연산자로 비교하는 만큼, NULL 값인지를 판정하려면 검색 CASE 문을 사용해야 한다.

```
SELECT a AS "코드",
CASE
	WHEN a = 1 THEN '남자'
	WHEN a = 2 THEN '여자'
	WHEN a IS NULL THEN '데이터 없음'
	ELSE '미지정'
END
AS "성별" FROM sample37;
```

단순 CASE문으로는 NULL 값을 비교할 수 없다!

**DECODE NVL**

Oracle에는 이 같은 디코드를 수행하는 DECODE 함수가 내장되어 있다. DECODE 함수는 CASE 문과 같은 용도로 사용할 수 있다. 다만 DECODE 함수는 Oracle에서만 지원하는 함수인 만큼 다른 데이터베이스 제품에서는 사용할 수 없다. 그에 비해 CASE 문은 표준 SQL로 규정된 덕분에 많은 데이터베이스 제품이 지원한다.

또한 NULL 값을 변환하는 함수도 있는데 Oracle 에서는 NVL 함수, SQL Server에서는 ISNULL 함수가 이에 해당한다. 다만 이 함수들은 특정 데이터베이스에 국한된 함수인 만큼 NULL 값을 변환할 때는 표준 SQL로 규정되어 있는 COALESCE 함수를 사용한다.



* 연습문제1 - ORDER BY 구에 의해 정렬되는 것은 무언인가?
    * 행

* 연습문제2 - 식 중에 NULL 값이 포함된 경우 연산결과는 무엇인가?
    * NULL

* 연습문제3 - SELECT 구로 식에 붙일 수 있는 것은 무엇인가?
    * 별명
