## 관계형 모델

관계형 모델을 기반으로 작성된 데이터베이스를 '관계형 데이터베이스'라고 한다.

SQL은 관계형 모델에 의해 구축된 데이터베이스를 조작하는 체계적인 명령의 집합이다. 관계형 모델에서 SQL이 만들어졌지만 유감스럽게도 관계형 모델에서 사용하는 용어와 SQL의 용어는 일치하지 않는다.

---

### 관계형 모델
관계형 모델(Relational Model)의 기본적인 요소는 릴레이션(Relation)이다. 이 릴레이션이라는 말 자체는 관계를 뜻하지만 관계형 모델에서는 약간 다른 의미를 가진다.

일반적인 시스템의 데이터베이스에는 복수의 테이블이 있어 테이블 간의 관계가 중요하다. 관계형 모델의 릴레이션은 SQL에서 말하는 테이블에 해당된다. 테이블끼리의 관계가 아니다.

릴레이션은 테이블을 말한다!

관계형 모델의 릴레이션에는 몇 가지 '속성(attribute)'이 있다. 이 속성은 속성 이름과 형 이름으로 구성된다. 속성은 SQL에서 말하는 열에 해당한다. 그리고 SQL에서의 행은 관계형 모델에서 '튜플(tuple)'이라 불린다.

관계형 모델은 데이터 구조에 관해 정의한다. 릴레이션은 튜플의 집합이며, 릴레이션에 대한 연산이 집합에 대한 연산에 대응된다는 이론을 '관계대수'라고 한다. 이 같은 관계대수의 기본규칙은 다음과 같다.

* 하나 이상의 관계를 바탕으로 연산한다.
* 연산한 결과, 반환되는 것 또한 관계이다.
* 연산을 중첩 구조로 실행해도 상관없다.

UNION이나 테이블의 결합을 익힌 만큼, 연산한 결과도 관계(릴레이션 = 테이블)라는 점 또한 이해할 수 있을 것이다.

---

## 관계형 모델과 SQL

관계대수에서는 자주 사용될 것 같은 릴레이션의 연산 방법을 몇 가지 규정한다. 이에 관해 SQL 명령과 비교하면서 간단히 설명하면,

### 합집합
합집합(union)은 릴레이션끼리의 덧셈을 말한다. SQL에서는 **UNION** 에 해당한다.

```
CREATE TABLE A(no int);
INSERT INTO A values(1);
INSERT INTO A values(2);
INSERT INTO A values(3);

CREATE TABLE B(no int);
INSERT INTO B values(2);
INSERT INTO B values(10);
INSERT INTO B values(11);

SELECT * FROM A 
UNION 
SELECT * FROM B;
```

### 차집합
차집합(difference)은 릴레이션끼리의 뺄셈을 말한다. SQL에서는 **EXCEPT** 에 해당한다.

```
SELECT * FROM A EXCEPT SELECT * FROM B;

SELECT A.no 
FROM A 
LEFT JOIN B 
    on A.no = B.no 
WHERE B.NO IS NULL;
```

### 교집합
교집합은(intersection)은 릴레이션끼리의 공통부분(교집합)을 말한다. SQL에서는 **INTERSECT**에 해당한다.

```
SELECT * FROM A INTERSECT SELECT * FROM B;

SELECT A.no 
FROM A 
JOIN B 
    on A.no = B.no;
```

*EXCEPT와 INTERSECT는 PostgreSQL에서만 활용가능하다.(지금은 MySQL도 가능하다.)*

### 곱집합
이전에 결합을 설명할 때 언급한 내용으로, 곱집합(cartesian product)은 릴레이션끼리의 대전표를 조합하는 연산을 말한다. 

SQL에서는 **FROM 구에 복수의 테이블을 지정** 한 경우 곱집합으로 계산된다. 결합을 설명할 때 미처 언급하지 못했는데, **CROSS JOIN** 으로 교차결합을 하면 곱집합을 구할 수 있다.

```
SELECT * FROM A, B;

SELECT * FROM A CROSS JOIN B;
```

---

### 선택
선택(selection)은 튜플의 추출을 말한다. 선택은 제한이라 불리기도 한다. 튜플은 SQL에서 행을 말하기 때문에 WHERE 구에 조건을 지정해 데이터를 검색하는 것에 해당된다.

```
CREATE TABLE C(no int, a char(4));
INSERT INTO C VALUES(1, 'A');
INSERT INTO C VALUES(2, 'B');
INSERT INTO C VALUES(3, 'C');

SELECT * FROM C WHERE no < 3;
```


### 투영
투영(projection)은 속성의 추출을 말한다. SQL에서 속성은 열을 말하기 때문에 SELECT 구에 결과로 반환할 열을 지정하는 것에 해당된다.

```
SELECT a FROM C;
```


### 결합
결합(JOIN)은 릴레이션끼리 교차결합해 계산된 곱집합에서 결합조건을 만족하는 튜플을 추출하는 연산이다. SQL에서는 내부결합에 해당한다. 관계대수에도 내부결합과 외부결합이 있다.

```
CREATE TABLE D(no int, b char(4));
INSERT INTO D VALUES(1, '가');
INSERT INTO D VALUES(2, '나');
INSERT INTO D VALUES(3, '다');

SELECT * FROM C INNER JOIN D ON C.no = D.no;
```

- 집합연산
    - 테이블은 데이터행의 집합으로 간주할 수 있다. SQL에서는 UNION으로 합집합을 구할 수 있다. 데이터베이스의 지원 여부에 따라 차집합이나 교집합을 구할 수도 있다.

- 교차결합, 곱집합
    - FROM 구에 테이블을 복수로 지정하여 교차결합으로 곱집합을 구할 수 있다. 곱집합은 대전표를 조합하는 것과 같은 방법으로 연산되며 내부결합이나 외부결합의 기반이 된다.

- 내부결합
    - 내부결합은 곱집합에서 필요한 행만 검색하도록 조건을 지정해 결합하는 것을 말한다. 이때 지정하는 조건을 결합조건이라 부른다.

- 외부결합
    - 내부결합으로 결합되지 않는 행을 강제적으로 결과에 포함하는 방법을 말한다.

- 관계형 모델
    - 관계형 모델은 관계형 데이터베이스의 기반이 되는 이론적 개념으로, 사용되는 용어는 SQL과 일치하지 않는다.

---

- 문제1
    - 테이블을 결합할 때 결합조건을 지정하지 않고 실행하면 구할 수 있는 집합은? 곱집합
        - 결합조건을 지정하지 않을 경우에는 교차결합이 된다. 교차결합은 곱집합으로 계산된다.

- 문제2
    - 내부결합 할 때 사용하는 키워드는? INNER JOIN

- 문제3
    - 관계형 모델에서 릴레이션에 해당하는 SQL 용어는? 테이블


