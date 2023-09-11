## 서브쿼리

서브쿼리는 SELECT 명령에 의한 데이터 질의로, 상부가 아닌 하부의 부수적인 질의를 의미한다.

서브쿼리는 **SQL 명령문 안에 지정하는 하부 SELECT 명령으로 괄호로 묶어 지정한다.** 문법에는 간단하게 'SELECT 명령'이라고 적었지만 SELECT 구, FROM 구, WHERE 구 등 SELECT 명령의 각 구를 기술할 수 있다.
특히 서브쿼리는 SQL명령의 WHERE 구에서 주로 사용된다. WHERE구는 SELECT, DELETE, UPDATE 구에서 사용할 수 있는데 이들 중 어떤 명령에서든 서브쿼리를 사용할 수 있다.
물론 상황에 따라 다른 구에서도 사용할 수 있다.

* DELETE의 WHERE 구에서 서브쿼리 사용하기

```
CREATE TABLE sample54(no int AUTO_INCREMENT PRIMARY KEY, a int);
INSERT INTO sample54 (a) values(100);
INSERT INTO sample54 (a) values(90);
INSERT INTO sample54 (a) values(20);
INSERT INTO sample54 (a) values(80);

SELECT * FROM sample54;
SELECT MIN(a) FROM sample54;

-- 최솟값을 가지는 행 삭제하기
-- 괄호로 서브쿼리를 지정해 삭제

DELETE FROM sample54 WHERE a = (SELECT MIN(a) FROM sample54); 	# MySQL Error
```

MySQL에서 예제를 실행하면 "You can't specify target table 'sample54' for update in FROM clause" 라는 에러가 발생한다. 

**데이터를 추가하거나 갱신할 경우 동일한 테이블을 서브쿼리에서 사용할 수 없도록 되어 있기 때문** 이다. 에러를 발생하지 않고 실행하려면 다음과 같이 **인라인 뷰로 임시 테이블을 만들도록 처리** 하면 된다. (FROM절에 있는 서브쿼리 : 인라인 뷰)

```
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) AS a FROM SAMPLE54) AS x);
SELECT * FROM sample54;
```

* 만약 위 쿼리문에서 'AS ali'를 지운다면 'Every derived table must have its own alias' 에러가 발생함
    * 서브쿼리에 Alias를 주지 않았을 경우 발생하는 에러
    * 오라클은 정상 동작하지만 MySQL의 경우 무조건 에러 발생
    * 괄호 안쪽 내용이 서브 쿼리이기 때문에 명시적으로 지정을 해주어야 함
    * **괄호가 끝나는 부분에 명시적인 이름을 넣어주자!**

---

### 클라이언트 변수

**@a가 변수가 되고 set이 변수에 대입하는 명령이 된다.**

```
set @a = (SELECT MIN(a) FROM sample54);

--- @a 에 있는 값 확인
select @a;

DELETE FROM sample54 WHERE a = @a;
SELECT * FROM sample54;
```

### 스칼라 값

서브쿼리를 사용할 때는 그 SELECT 명령이 어떤 값을 반환하는지 주의할 필요가 있다. 여러 가지 패턴 중에서도 다음과 같은 네 가지가 일반적인 서브쿼리 패턴이다.

#### 서브쿼리 패턴

```
-- 패턴 ① 하나의 값을 반환하는 패턴
SELECT MIN(a) FROM sample54;

-- 패턴 ② 복수의 행이 반환되지만 열은 하나인 패턴
SELECT no FROM sample54;

-- 패턴 ③ 하나의 행이 반환되지만 열이 복수인 패턴
SELECT MIN(a), MAX(no) FROM sample54;

-- 패턴 ④ 복수의 행, 복수의 열이 반환되는 패턴
SELECT no, a FROM sample54;
```

패턴 ①만 다른 패턴과 다르다. 이는 다른 패턴과 달리 하나의 값을 반환하기 때문이다. **단일 값** 으로도 통용되지만 데이터베이스 업계에서는 **스칼라 값** 이라 불리는 경우가 많으므로 기억해 두자.

SELECT 명령이 하나의 값만 반환하는 것을 '스칼라 값을 반환한다'고 한다!

스칼라 값을 반환하는 SELECT 명령을 특별 취급하는 이유는 서브쿼리로서 사용하기 쉽기 때문이다. 이처럼 스칼라 값을 반환하도록 SELECT 명령을 작성하고자 한다면 SELECT 구에서 단일 열을 지정한다. 복수 열을 반환하도록 하면 패턴 ③이나 ④가 되어버리기 때문이다.

= 연산자를 사용하여 비교할 경우에는 스칼라 값끼리 비교할 필요가 있다!

스칼라 값을 반환하는 서브쿼리를 특별히 '스칼라 서브쿼리'라 부르기도 한다. 앞서 HAVING 구를 설명할 때 '집계함수는 WHERE 구에서는 사용할 수 없다'라고 설명했다. 하지만 '스칼라 서브쿼리'라면 WHERE 구에 사용할 수 있으므로 집계함수를 사용해 집계한 결과를 조건식으로 사용할 수 있다.

그와 비슷한 문제로 'GROUP BY에서 지정한 열 이외의 열을 SELECT 구에 지정하면 에러가 된다'라는 것도 있다. 하나의 그룹에 다른 값이 여러 개 존재할 경우는 스칼라 값이라고 할 수 없다.

---

### SELECT 구에서 서브쿼리 사용하기

앞서 언급한 예에서는 WHERE 구에 서브쿼리를 사용했다. 그 밖에도 서브쿼리는 SELECT 구, UPDATE의 SET구 등 다양한 구 안에서 지정할 수 있다.

문법적으로 서브쿼리는 '하나의 항목'으로 취급한다. 단, 문법적으로는 문제없지만 실행하면 에러가 발생하는 경우가 자주 있다. 이는 스칼라 값의 반환여부에 따라 생기는 현상으로, 서브쿼리를 사용할 때는 스칼라 서브쿼리로 되어있는지 확인해야 한다.
SELECT 구에서 서브쿼리를 지정할 때는 스칼라 서브쿼리가 필요하다.

SELECT 구에서 서브쿼리 사용하기
```
SELECT 
	(SELECT COUNT(*) FROM sample51) AS sq1,
	(SELECT COUNT(*) FROM sample54) AS sq2;
```

여기서 한 가지 주의할 점이 있는데 서브쿼리가 아닌 상부의 SELECT 명령에는 FROM 구가 없다는 것이다. MySQL 등에서는 실제로 from 구를 생략할 수 있다. 하지만 Oracle 등 전통적인 데이터베이스 제품에서는 FROM를 생략할 수 없다. 이때 Oracle에서는 다음과 같이 FROM DUAL로 지정하면 실행할 수 있다. DUAL은 시스템 쪽에서 데이터베이스에 기본으로 작성되는 테이블이다.

SELECT 구에서 서브쿼리 사용하기(Oracle의 경우)
```
SELECT 
	(SELECT COUNT(*) FROM sample51) AS sq1,
	(SELECT COUNT(*) FROM sample54) AS sq2 FROM DUAL;
```

* SET 구에서 서브쿼리 사용하기
```
UPDATE sample54 SET a=(SELECT MAX(a) FROM sample54);		# MySQL ERROR
UPDATE sample54 SET a=(SELECT a FROM (SELECT MAX(a) AS a FROM SAMPLE54) AS x);
SELECT * FROM sample54;
```

* FROM 구에서 서브쿼리 사용하기
FROM 구에서도 서브쿼리를 사용할 수 있다. 지금까지는 FROM 구에서 테이블 지정만 해왔지만 이번에는 FROM 구에 테이블 이외의 것도 지정해보자.
FROM 구에 서브쿼리를 지정하는 경우에도 서브쿼리의 기술방법은 같다. 괄호로 SELECT 명령을 묶으면 된다. 다만 FROM 구에는 기본적으로 테이블을 지정하는 만큼 다른 구와는 조금 상황이 다르다.
한편 SELECT 구나 SET 구에서는 스칼라 서브쿼리를 지정해야 하지만 FROM 구에 기술할 경우에는 스칼라 값을 반환하지 않아도 좋다. 물론 스칼라 값이라도 상관없다.

```
SELECT * 
FROM (SELECT * 
    FROM sample54) sq;
```

SELECT 명령 안에 SELECT 명령이 들어있는 듯 보인다. 이를 '네스티드(nested) 구조', 또는 '중첩구조'나 '내포구조'라고 부른다. sq는 테이블의 별명으로, Sub Query의 이니셜에서 따왔다. SELECT 구에서는 열이나 식에 별명을 붙일 수 있다. 마찬가지로 FROM 구에서는 테이블이나 서브쿼리에 별명을 붙일 수 있다.

테이블에는 이름이 붙여져 있지만 서브쿼리에는 이렇다 할 이름이 붙여져 있지 않다. 별명을 붙이는 것으로 비로소 서브쿼리의 이름을 지정한다. 이 때도 SELECT 구에서 별명을 붙일 때처럼 'AS' 키워드를 사용하여 지정한다. 다음과 같이 지정해도 결과는 같다.(단, Oracle 에서는 AS를 붙이면 에러가 발생한다. Orcale에서는 AS를 붙이지 않는다.)

FROM 구에서 서브쿼리 사용하기(AS로 지정)
```
SELECT * FROM(SELECT * FROM sample54) AS sq;
```

중첩구조는 몇 단계로든 구성할 수 있다.
```
SELECT * FROM (SELECT * FROM (SELECT * FROM sample54) sq1) sq2;
```

보충 설명을 하자면 위에 예제처럼 테이블 한 개를 지정하는 데 3단계 중첩구조로 작성하지는 않는다. 의미가 없기 때문이다. 어디까지나 중첩구조를 설명하는 예제임을 알아주기 바란다.

실제 업무에서 FROM 구에 서브쿼리를 지정하여 사용하는 경우
Oracle에는 LIMIT 구가 없다. ROWNUM으로 행 개수를 제한할 수 있지만, 정렬 후 상위 몇 건을 추출하는 조건은 붙일 수 없다. 이는 ROWNUM의 경우 WHERE 구로 인해 번호가 할당되기 때문이다. 하지만 FROM 구에서 서브쿼리를 사용하는 것으로 Oracle에서도 정렬 후 상위 몇 건을 추출한다는 행 제한을 할 수 있다.

Oracle에서 LIMIT 구의 대체 명령
```
SELECT * FROM(
	SELECT * FROM sample54 ORDER BY a DESC
) sq
WHERE ROWNUM <= 2;
```

### INSERT 명령과 서브쿼리

INSERT 명령과 서브쿼리를 조합해 사용할 수도 있다. INSERT 명령에는 VALUES 구의 일부로 서브쿼리를 사용하는 경우와, VALUES구 대신 SELECT 명령을 사용하는 두 가지 방법이 있다.

먼저 VALUES 구의 값으로 서브쿼리를 사용하는 예를 살펴보자. 이 때 서브쿼리는 스칼라 서브쿼리로 지정할 필요가 있다. 물론 자료형도 일치해야 한다.

```
CREATE TABLE sample541(a int, b int);                                                                                               
VALUES 구에서 서브쿼리 사용하기
INSERT INTO sample541 VALUES(
	(SELECT COUNT(*) FROM sample51),
	(SELECT COUNT(*) FROM sample54)
);
SELECT * FROM sample541;
```

INSERT SELECT
이번에는 VALUES 구 대신에 SELECT 명령을 사용하는 예를 살펴보겠다. 다만 다음 예에서는 괄호를 붙이지 않아 서브쿼리라고 부르기 어려울 수도 있겠다.

SELECT 결과를 INSERT 하기

```
INSERT INTO sample541 SELECT 1, 2;
SELECT * FROM sample541;
```

흔히 'INSERT SELECT'라 불리는 명령으로 INSERT와 SELECT를 합친 것과 같은 명령이 되었다. SELECT가 결괏값으로 1과 2라는 상수를 반환하므로, INSERT INTO sample541 VALUES(1, 2)의 경우와 같다. 이때 SELECT 명령이 반환하는 값이 꼭 스칼라 값일 필요는 없다. SELECT가 반환하는 열 수와 자료형이 INSERT할 테이블과 일치하기만 하면 된다.

INSERT SELECT 명령은 SELECT 명령의 결과를 INSERT INTO로 지정한 테이블에 전부 추가한다. SELECT 명령의 실행 결과를 클라이언트로 반환하지 않고 지정된 테이블에 추가하는 것이다. 이 때문에 데이터의 복사나 이동을 할 때 자주 사용하는 명령이다.

열 구성이 똑같은 테이블 사이에는 다음과 같은 INSERT SELECT 명령으로 행을 복사할 수도 있다.

```
CREATE TABLE sample542(a int, b int);

-- 테이블의 행 복사하기
INSERT INTO sample542 SELECT * FROM sample541;

SELECT * FROM sample542;
```
---

* 서브쿼리의 위치에 따른 명칭
    - SELECT문에 있는 서브쿼리 : 스칼라 서브쿼리
    - FROM절에 있는 서브쿼리 : 인라인 뷰
    - WHERE절에 있는 서브쿼리 : 서브쿼리

* 서브쿼리의 반환 값에 따른 서브쿼리 종류
    - 단일 행 서브쿼리(Single-Row Subquery) : 서브쿼리의 결과가 1행
    - 다중 행 서브쿼리(Multiple-Row Subquery) : 서브쿼리의 결과가 여러 행
    - 다중 컬럼 서브쿼리(Multi-Column Subquery) : 서브쿼리의 결과가 여러 컬럼

* 스칼라 서브쿼리(Scala Subquery)

    - SELECT문에서 사용하는 서브쿼리로 1행만 반환

* 상호연관 서브쿼리(Correlated Subquery)
    - 메인쿼리의 값을 서브쿼리가 사용하고, 서브쿼리의 값을 받아서 메인쿼리가 계산하는 구조의 쿼리

---

## 상관 서브쿼리

**EXISTS** 술어를 사용하면 서브쿼리가 반환하는 결괏값이 있는 지를 조사할 수 있다. 특히 EXISTS를 사용하는 경우에는 서브쿼리가 반드시 스칼라 값을 반환할 필요는 없다. EXISTS는 단지 반환된 행이 있는지를 확인해보고 값이 있으면 **참, 없으면 거짓을 반환** 하므로 어떤 패턴이라도 상관없다.

서브쿼리를 사용해 검색할 때 '데이터가 존재하는지 아닌지' 판별하기 위해 조건을 지정할 수도 있다. 이런 경우 EXISTS 술어를 사용해 조사할 수 있다.

```
CREATE TABLE sample551(no int, a char(10));
INSERT INTO sample551 VALUES(1, NULL);
INSERT INTO sample551 VALUES(2, NULL);
INSERT INTO sample551 VALUES(3, NULL);
INSERT INTO sample551 VALUES(4, NULL);
INSERT INTO sample551 VALUES(5, NULL);

CREATE TABLE sample552(no2 int);
INSERT INTO sample552 VALUES(3);
INSERT INTO sample552 VALUES(5);
```

* EXISTS를 사용해 '있음'으로 갱신하기
```
-- sample551에 no열이 sample552의 no2열과 같은 행이 있으면 a열을 '있음'으로 갱신하기.
UPDATE sample551 SET a = '있음' WHERE 
	EXISTS(SELECT * FROM sample552 WHERE no2 = no);
```

서브쿼리 부분이 UPDATE의 WHERE 구로 행을 검색할 때마다 차례로 실행되는 느낌이다. 서브쿼리의 WHERE 구는 no2=no 라는 조건식으로 되어 있다. no2는 sampl552의 열이고 no는 sample551의 열이다. 이때 no가 3과 5일 때만 서브쿼리가 행을 반환한다.

EXISTS 술어에 서브쿼리를 지정하면 서브쿼리가 행을 반환할 경우에 참을 돌려준다. 결과가 한 줄이라도 그 이상이라도 참이 된다. 반면 반환되는 행이 없을 경우에는 거짓이 된다.

* NOT EXISTS를 사용해 '없음'으로 갱신하기
```
-- sample551에 no열이 sample552의 no2열과 같은 행이 아니면 a열을 '없음'으로 갱신하기.
UPDATE sample551 SET a = '없음' WHERE
	NOT EXISTS(SELECT * FROM sample552 WHERE no2 = no);

SELECT * FROM sample551;
```

'없음'의 경우, 행이 존재하지 않는 상태가 참이 되므로 이때는 NOT EXISTS를 사용한다. NOT을 붙이는 것으로 값을 부정할 수 있다.

UPDATE 명령(부모)에서 WHERE 구에 괄호로 묶은 부분이 서브쿼리(자식)가 된다. 부모 명령에서는 sample551를 갱신한다.   자식인 서브쿼리에서는 sample552 테이블의 no2 열 값이 부모의 no 열 값과 일치하는 행을 검색한다. 

이처럼 **부모 명령과 자식인 서브쿼리가 특정 관계를 맺는 것을 '상관 서브쿼리'라** 부른다.

밑에 설명한 DELETE의 경우에는 상관 서브쿼리가 아니다. 상관 서브쿼리가 아닌 단순한 서브쿼리로 단독 쿼리로 실행할 수 있다.

```
DELETE FROM sample54 WHERE a = (SELECT MIN(a) FROM sample54);	# MySQL Error
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) AS a FROM SAMPLE54) AS x);
SELECT MIN(a) FROM sample54;
```

하지만 상관 서브쿼리에서는 부모 명령과 연관되어 처리되기 때문에 상관 서브쿼리 부분만을 따로 떼어내어 실행시킬 수 없다.

```
UPDATE sample551 SET a = '있음' WHERE
	EXISTS(SELECT * FROM sample552 WHERE no2 = no );

SELECT * FROM sample552 WHERE no2 = no;
-- 에러. AS, no가 불명확하다
```

### 열에 테이블명 붙이기

SAMPLE551과 SAMPLE552는 각각 열이 no와 no2로 서로 다르기 때문에 no가 sample551의 열, no2가 sample552의 열인 것을 알 수 있다. 하지만 만약 두 열이 모두 같은 이름을 가진다면 어떨까? 'where no = no'라고 조건을 지정하면 제대로 동작할까?

사실은 양쪽 테이블 모두 no라는 열로 되어있다면 잘 동작하지 않는다.(대부분은 열이 애매하다는 내용의 에러가 발생한다. * 다만 MySQL에서는 서브쿼리의 'WHERE no = no'는 'WHERE sample552.no = sample552.no'가 되어 조건식은 항상 참이 된다. 결과적으로 sample551의 모든 행은 a열 값이 있다'로 갱신된다.) 그래서 여기서는 예제 테이블을 작성할 때 설명하기 쉽도록 의도적으로 열명을 바꾸었다. 대신 조금 부자연스러울 수도 있겠다. 같은 데이터라면 같은 이름으로 지정하는 편이 자연스럽다.

```
UPDATE sample551 SET a = '있음' WHERE
	EXISTS (SELECT * FROM sample552 WHERE sample552.no2 = sample551.no);
```

---
 
### IN

스칼라 값끼리 비교할 때는 = 연산자를 사용한다. 다만 집합을 비교할 때는 사용할 수 없다. **IN을 사용하면 집합 안의 값이 존재하는 지를 조사할 수 있다.**

sample552에는 3과 5라는 값이 존재한다. 서브쿼리를 사용하지 않고 WHERE 구로 간단하게 처리한다면 다음과 같이 조건을 붙일 수 있다. 
```
WHERE no = 3 OR no = 5;
```

IN에서는 오른쪽에 집합을 지정한다. 왼쪽에 지정된 값과 같은 값이 집합 안에 존재하면 참을 반환한다. 
집합은 상수 리스트를 괄호로 묶어 기술한다. 앞의 WHERE 조건식을 IN을 사용하도록 수정하면 다음과 같다.

IN을 사용해 조건식 기술

```
SELECT * FROM sample551 WHERE no IN (3, 5);
```

한편, 집합 부분은 서브쿼리로도 지정할 수 있다.
```
SELECT * FROM sample551 WHERE no IN (SELECT no2 FROM sample552);
```
이 같은 경우 서브쿼리는 스칼라 서브쿼리가 될 필요는 없다. IN에는 집합을 지정할 수 있기 때문이다.

IN은 집합 안에 값이 포함되어 있으면 참이 된다. 반면 NOT IN으로 지정하면 집합에 값이 포함되어 있지 않을 경우 참이 된다.

- IN과 NULL
집계함수에서는 집합 안의 NULL 값을 무시하고 처리했다. IN에서는 집합안에 NULL 값이 있어도 무시하지는 않는다. 다만 NULL = NULL을 제대로 계산할 수 없으므로 IN을 사용해도 NULL 값은 비교할 수 없다. 즉, NULL을 비교할 때는 IS NULL을 사용해야 한다. 또한 NOT IN의 경우, 집합 안에 NULL 값이 있으면 설령 왼쪽 값이 집합 안에 포함되어 있지 않아도 참을 반환하지 않는다. 그 결과는 '불명(UNKNOWN)'이 된다.

MySQL에서 집합에 NULL이 포함되어 있는 경우, 조건식 IN은 왼쪽 값이 집합에 포함되어 있으면 참을, 그렇지 않으면 NULL을 반환한다. NOT IN은 왼쪽 값이 집합에 포함되어 있으면 거짓을, 그렇지 않으면 NULL을 반환한다. 결국 NOT IN의 경우 집합에 NULL이 포함되어 있다면 그 결괏값은 0건이 된다. NULL을 반환한다는 것은 비교할 수 없다는 것을 의미한다. 왼쪽의 값이 NULL인 경우에도 오른쪽의 값과 관계없이 비교할 수 없으므로, 조건식은 참 또는 거짓이 아닌 NULL을 반환한다.

```
SELECT * FROM SAMPLE551 WHERE NO IN(3, 5, NULL);
SELECT * FROM SAMPLE551 WHERE NO NOT IN(3, 5, NULL);
SELECT * FROM SAMPLE551 WHERE NO NOT IN(3, 5);
```

위처럼, (not) in 구문 안에 null을 넣지 말자. 제대로 된 값을 반환하지 못한다.


* 문제 1
    * 테이블의 행 개수를 알고 싶을 때 사용하는 집계함수는 무엇인가? : COUNT 

* 문제2
    * SELECT 명령에 GROUP BY를 지정한 경우 데이터베이스 내부에서 수행되는 처리는 무엇인가? : 그룹화

* 문제3
    * SELECT 구에서 지정할 수 있는 서브쿼리는 무엇인가? : 스칼라 서브쿼리

* 참고:
    * EXISTS: 조건에 해당하는 ROW의 존재 유무와 체크 후 더 이상 수행하지 않는다. 
    * IN : 조건에 해당하는 ROW의 칼럼을 비교하여 체크한다. SELECT 절에서 조회한 칼럼 값으로 비교하므로 EXISTS에 비해 성능이 떨어진다.