## 집합 연산

RDBMS의 창시자인 에드거 커드(Edgar F. Codd)는 관계형 모델을 고안한 인물이다. 관계형 모델을 채택한 데이터베이스를 관계형 데이터 베이스라 부른다.
관계형 모델에서의 관계형은 수학 집합론의 관계형 이론에서 유래했다. 집합론이라고 거창하게 말하지만 실질적으로는 데이터베이스의 데이터를 집합으로 간주해 다루기 쉽게 하자는 것에 지나지 않는다. 뜻을 잘 기억해 두면 이해하기 쉽다.

### SQL과 집합

벤 다이어 그램에서는 하나의 원이 곧 하나의 집합이다.  원 안에는 몇 가지 요소가 포함된다. 한편 데이터베이스에서는 테이블의 행이 요소에 해당한다. 행은 여러 개의 열로 구성되는 경우도 있으므로, 수치 상으로는 복수의 값이 존재한다. 하지만 집합의 요소라는 측면에서 보면 하나의 행이 곧 하나의 요소가 된다.

SELECT 명령을 실행하면 데이터베이스에 질의하며 그 결과 몇 개의 행이 반환된다. 이때 반환된 결과 전체를 하나의 집합이라고 생각하면 된다.

집합의 연산에는 '합집합'이라는 것이 있다. 이는 집합을 서로 더한 것을 말한다.

A와 B라는 두 개의 집합이 존재한다고 했을 때, A 집합에는 {1, 2, 3}이라는 세 개의 요소가, B집합에는 {2, 10, 11}이라는 세 개의 요소가 있다. 그중 2라는 요소는 A에도 B에도 모두 존재한다. 

집합 A와 B의 합집합을 구하면 그 결과는 {1, 2, 3, 10, 11}이 된다.

---

### UNION

SQL 에서는 SELECT 명령의 실행 결과를 하나의 집합으로 다룰 수 있다. 합집합을 계산할 경우에는 수학에서 사용하던 U대신 UNION 키워드를 사용한다. 즉, **수학에서의 'A U B'는 SQL에서는 'A UNION B'라고 표현한다.** A나 B로 표현했지만 실제로는 SELECT 명령이다.

```
CREATE TABLE sample71_a(a int);
INSERT INTO sample71_a VALUES(1);
INSERT INTO sample71_a VALUES(2);
INSERT INTO sample71_a VALUES(3);

CREATE TABLE sample71_b(b int);
INSERT INTO sample71_b VALUES(2);
INSERT INTO sample71_b VALUES(10);
INSERT INTO sample71_b VALUES(11);

SELECT * FROM sample71_a
UNION
SELECT * FROM sample71_b;	# 두 개의 명령을 하나의 명령으로 합친다.
```

한 번의 쿼리 실행으로 두 개의 SELECT 명령이 내부적으로 실행되는 형식이다. 이때 각 SELECT 명령의 실행결과(집합)를 합집합(UNION)으로 계산하여 최종적으로 결과를 반환한다.

UNION으로 두 개의 SELECT 명령을 하나로 연계해 질의 결과를 얻을 수 있다!

**UNION을 이용하면 여러 개의 SELECT 명령을 하나로 묶을 수 있다.** 1 + 2 + 3 ... 처럼 연속해서 더하는 것과 같은 형식이다. **이때 각각의 SELECT 명령의 열의 내용은 서로 일치해야 한다.** 예를 들어 sample71_a와 sample71_b의 경우, **열 이름은 서로 다르지만 열 개수와 자료형이 서로 같기 때문에 일치한다고 말할 수 있다.** 반면 다음과 같이 완전히 열 구성이 다른 테이블을 UNION으로 묶을 수는 없다.

```
SELECT * FROM sample71_a
UNION
SELECT * FROM sample71_b
UNION
SELECT * FROM sample31;
```

다만 전체 데이터를 반환하는 애스터리스크(*)를 쓰지 않고, 열을 따로 지정하여 각 SELECT 명령에서 집합의 요소가 될 데이터를 서로 맞춰주면 UNION으로 실행할 수 있는 쿼리가 된다. 예를 들면 다음과 같다.

```
SELECT a FROM sample71_a
UNION
SELECT b FROM sample71_b
UNION
SELECT age FROM sample31;
```

SELECT 명령들은 UNION으로 묶을 때 나열 순서는 합집합의 결과에 영향을 주지 않는다. 따라서 **다음 명령들은 결과가 모두 같다. 단, 결괏값의 나열 순서는 달라질 수도 있다.** ORDR BY를 지정하지 않은 SELECT 명령은 결과가 내부처리의 상황에 따라 바뀌기 때문이다.

```
SELECT * FROM sample71_a UNION SELECT * FROM sample71_b;
SELECT * FROM sample71_b UNION SELECT * FROM sample71_a;
```
---

### UNION을 사용할 때의 ORDER BY

UNION으로 SELECT 명령을 결합해 합집합을 구하는 경우, 각 SELECT 명령에 ORDER BY를 지정해 정렬할 수는 없다. **ORDER BY를 지정할 때는 마지막 SELECT 명령에만 지정하도록 한다.**

```
SELECT a FROM sample71_a ORDER BY a         # ERROR 첫 번째 SELECT 명령에 ORDER BY를 지정할 수 없다.
UNION
SELECT b FROM sample71_b;	
```

ORDER BY로 정렬할 수 없다는 뜻이 아니다. 합집합의 결과를 정렬하므로, 가장 마지막의 SELECT 명령에 ORDER BY를 지정해야 한다는 의미이다.

```
SELECT a FROM sample71_a
UNION
SELECT b FROM sample71_b ORDER BY b;        # ERROR
```

하지만 이 쿼리에서도 에러가 발생. ORDER BY를 지정할 수 있다고 해도 마지막의 SELECT 명령의 결과만 정렬하는 것이 아니고 합집합의 결과를 정렬하는 것이기 때문이다. **이때 두 개의 SELECT 명령에서 열 이름이 서로 일치한다면 문제가 없겠지만 앞의 예제에서처럼 반드시 그렇다는 보장이 없다. 이런 경우 서로 동일하게 별명을 붙여 정렬할 수 있다.**

```
SELECT a AS c FROM sample71_a
UNION
SELECT b AS c FROM sample71_b ORDER BY c;
```

UNION으로 SELECT 명령을 연결하는 경우, 가장 마지막 SELECT 명령에 대해서만 ORDER BY 구를 지정할 수 있다! ORDER BY 구에 지정하는 열은 별명을 붙여 이름을 일치시킨다!

---

### UNION ALL

SELECT 명령에서 중복을 제거할 때는 SELECT 구에 DISTINCT를 지정. 이때 기본값은 ALL로, 명시적으로 지정하거나 생략할 수도 있다. 즉, 중복을 제거하는 경우에는 DISTINCT, 중복을 제거하지 않고 모두를 반환하는 경우에는 ALL을 지정했다. 한편 **UNION의 경우는 기본 동작이 DISTINCT이고, 모든 결과를 얻고 싶을 때는 ALL을 추가적으로 지정한다.** 즉, DISTINCT나 ALL로 중복제거 여부를 지정할 수 있다는 점은 똑같지만, UNION의 기본동작은 ALL이 아닌 DISTINCT라는 점이 다르다. 

```
-- 두 개의 SELECT 명령에 UNION ALL을 적용해 합집합 구하기
SELECT * FROM sample71_a
UNION ALL
SELECT * FROM sample71_b;
```

UNION ALL은 두 개의 집합을 단순하게 합치는 것이다. UNION에서는 이미 존재하는 값인지를 검사하는 처리가 필요한 만큼, UNION ALL 쪽이 성능적으로는 유리할 경우가 있다. 즉, 중복값이 없는 경우에는 UNION ALL을 사용하는 편이 좋은 성능을 보여준다.

```
-- 예제용 데이터베이스 구축
-- c:\sql 폴더에 sample.dump를 복사
-- sql 폴더로 이동
mysql -u root -p < sample.dump
1234
```

---

### 테이블 결합(JOIN)

테이블의 집합 연산에서는 세로(행) 방향으로 데이터가 늘어나거나 줄어드는 계산을 했다. 이제부터 설명하는 결합에서는 가로(열) 방향으로 데이터가 늘어나는 계산이 된다.

보통 데이터베이스는 하나의 테이블에 많은 데이터를 저장하지 않고 몇 개의 테이블로 나누어 저장한다. 이처럼 여러 개로 나뉜 데이터를 하나로 묶어 결과를 내는 방법이 테이블 결합이다. 여기서 결합을 이해하는 동시에 기본이 되는 개념이 집합론 '곱집합'이다.

### 곱집합과 교차결합

곱집합은 합집합이나 교집합처럼 집합의 연산 방법 중 하나이다. 두 개의 집합을 곱하는 연산 방법으로 **곱집합** 또는 **카티전곱(Cartesian product)** 이라고도 불린다. 

집합 X는 {A, B, C}라는 요소를 가진다. 집합 Y는 {1, 2, 3}이라는 세 개의 요소를 가진다. 여기서 집합 X와 Y의 곱집합을 구하면 다음과 같다. 즉, 집합 X의 요소 A에 집합 Y의 요소를 붙여 계산하는 것이다. 이때 (A, 1)을 하나의 요소라고 생각해 보자.

```
-- 집합 X와 Y의 곱집합

	X		Y			곱집합
		
	A		1		A, 1	A, 2	A, 3
	B	X	2		B, 1	B, 2	B, 3
	C		3		C, 1	C, 2	C, 3
```

다음으로 한 시즌에 6화까지 있는 드라마가 3시즌까지 방영되는 경우를 생각해보자. {1, 2, 3}의 집합과 {1, 2, 3, 4, 5, 6}의 집합을 곱집합으로 계산하면 다음과 같은 방송표를 만들 수 있다. 이 같은 곱집합은 평상시에는 잘 사용하지 않지만 어떤 것인지는 기억해 두자.

드라마 곱집합

시즌1 	1-1화	1-2화	1-3화	1-4화	1-5화	1-6화
시즌2 	2-1화	2-2화	2-3화	2-4화	2-5화	2-6화
시즌3 	3-1화	3-2화	3-3화	3-4화	3-5화	3-6화

---

### 교차결합(Cross Join)

데이터베이스의 테이블은 집합의 한 종류라고 할 수 있다. 지금까지 SELECT 명령에서는 FROM 구에 하나의 테이블만 지정했다. 만약 테이블을 두 개 지정하면 이들은 곱집합으로 계산된다.

```
CREATE TABLE sample72_x(x char(4));
INSERT INTO sample72_x values('A');
INSERT INTO sample72_x values('B');
INSERT INTO sample72_x values('C');

CREATE TABLE sample72_y(y int);
INSERT INTO sample72_y values(1);
INSERT INTO sample72_y values(2);
INSERT INTO sample72_y values(3);

SELECT * FROM sample72_x;

-- 실행 결과
x
A
B
C

SELECT * FROM sample72_y;

-- 실행 결과
y
1
2
3

-- FROM구에 테이블 두 개를 지정해 곱집합 구하기
SELECT * FROM sample72_x, sample72_y;

실행결과
x	y
A	1
B	1
C	1
A	2
B	2
C	2
A	3
B	3
C	3
```

**FROM 구에 복수의 테이블을 지정하면 교차결합을 한다!** 

---

### UNION 연결과 결합 연결의 차이

앞서 UNION에서도 집합을 더해 새로 큰 집합을 만들어 계산할 수 있었다. 한편으로는 FROM 구에서 복수의 테이블을 결합할 때도 새로 큰 집합을 만들어 계산한다.

두 가지 방식이 서로 비슷하지만 확대 방향이 다르다. UNION으로 합집합을 구했을 경우에는 세로 방향으로 더해지게 된다. 한편 FROM 구로 테이블을 결합할 경우에는 가로 방향으로 더해지게 된다.

결합은 열(가로)방향으로 확대된다!

#### 내부결합

FROM 구에 테이블을 복수로 지정하면 곱집합으로 계산되는 것을 배웠다. 앞의 예제에서는 두 개 테이블을 사용했지만 세 개, 네 개로도 지정할 수 있다. 단 테이블 수가 많아지면 조합 수가 엄청나게 늘어나 집합이 거대해진다. 이렇게 많은 테이블을 교차결합하는 경우는 드물다. 즉, 결합 방법으로는 교차결합보다 내부결합이 자주 사용된다.

수학에서의 집합은 유일한 요소로 구성된다. 즉, 중복된 값이 존재하지 않는다는 뜻이다. 마찬가지로 관계형 데이터베이스에서도 테이블의 데이터가 유일한 값을 가지도록 권장한다. 간단히 말하면 기본키(primary key)를 가지도록 하는 게 좋다는 것이다.

데이터베이스에는 다양한 데이터가 저장되지만 동일한 데이터를 중복해서 여러 곳에 저장하지 않도록 하는 편이 좋다. 만약 데이터가 변경되는 경우 여기저기 저장되어 있는 데이터를 모두 동일한 값으로 변경하기란 힘든 일이다. 이때 기본키는 하나의 데이터행을 대표할 수 있는 속성을 가진다.

예를 들어 상품의 가격이나 이름과 같은 데이터를 저장하는 '상품 테이블'을 작성한다고 하자. 이때 상품의 속성으로는 상품명, 메이커명, 가격, 상품분류 등을 꼽을 수 있다. 그 중에서 상품명을 기본키로 사용한다면 어떨까? 하지만 상품명의 경우 값이 중복할 우려가 있으므로 기본키로는 적합하지 않다. 이러한 이유로 '상품코드'를 '기본키'로 사용하는 경우가 많다.

```
-- 상품 테이블 작성하기
CREATE TABLE 상품(
    상품코드 CHAR(4) NOT NULL,
    상품명 varchar(30),
    메이커명 VARCHAR(30),
    가격 INTEGER,
    상품분류 VARCHAR(30),
    PRIMARY KEY(상품코드)
);
```

앞의 예제처럼 테이블을 만들어두면 동일한 상품명을 가진 상품이라도 구별하여 등록할 수 있다. 일반적인 전자상거래 시스템에서 상품 테이블 하나만으로 운영하는 곳은 없다고 생각해도 무리는 아닐 것이다. 상품 데이터를 참조하는 별도의 테이블 존재한다는 이야기이다. 예를 들어 재고도 같이 관리하는 경우에는 입출고나 재고 수를 상품단위로 관리하는 테이블이 있을것이다.

만약 재고관리 테이블을 만든다면 다음과 같이 작성할 수 있다.

```
CREATE TABLE 재고수(
    상품코드 CHAR(4),
    입고날짜 DATE,
    재고수 INTEGER
);
```

물론, 실제 시스템에서는 더 많은 열로 구성되어 있을 것이다. 여기서는 상품 테이블을 참조하는 테이블의 예를 설명하기 위해 간단하게 재고관리 테이블을 만들어 보았다. 이러한 이유로 기본키도 따로 지정하지 않았지만, 재고수 테이블을 참조하는 다른 테이블을 위해 기본키를 지정해두는 것도 좋다.

재고수 테이블에서의 착안점은 상품코드를 통해 상품 테이블과 연결할 수 있다는 것이다. 상품 테이블의 기본키는 '상품코드'이다. 이 열의 값을 알면 상품명을 포함한 상품 데이터를 참조할 수 있다. 요컨대 다른 테이블의 데이터를 참조해야 하는 경우, 참조할 테이블의 기본키와 동일한 이름과 자료형으로 열을 만들어서 행을 연결하는 경우가 많다.

```
SELECT * FROM 상품;
SELECT * FROM 재고수;
```

드디어 내부결합에 대해 설명할 수 있다. 재고수 테이블에서 상품분류가 식료품인 상품의 재고수를 표시하는 경우를 생각해보자. 이 경우 상품코드보다 상품명으로 표시하면 알아보기 쉬울 것이다. 목표는 다음과 같이 표시하는 것이다.

```
-- 원하는 결과
상품명      재고수
****        200
@@@@        500
```

재고수는 재고수 테이블에서 가져오면 되지만 상품명과 상품분류는 상품 테이블에 있다. 이때 재고수 테이블과 상품 테이블을 결합해 가로로 나열하고 한다. 그러기 위해서는 FROM구에서 테이블을 서로 결합한다.

```
DESC 상품;
DESC 재고수;
SELECT * FROM 상품;
SELECT * FROM 재고수;

SELECT * FROM 상품, 재고수;
```

FROM 구에 테이블을 복수로 지정하면 곱집합으로 계산된다. 상품 테이블행에 재고수 데이터 행으로 곱집합을 구하면 행은 3*3=9가 된다. 검색결과를 봤을 때, 왼쪽이 상품 페이블의 데이터, 오른쪽이 재고수 테이블의 데이터이다.

이렇게 만들어진 집합에서 원하는 데이터를 검색하기 위해 WHERE 구로 조건을 지정한다. 먼저 상품코드가 같다는 조건이 필요하다. 앞의 예제에서 상품 테이블의 상품코드와 재고수 테이블의 상품코드가 서로 같은 것을 찾아보자.

열 이름이 '상품코드'로 서로 동일하므로 WHERE 구에 조건식을 지정할 때 테이블 이름도 같이 지정할 필요가 있다. 상품 테이블의 상품코드 열은 '상품.상품코드'로, 재고수 테이블의 상품코드 열은 '재고수.상품코드'로 지정한다.

```
-- 상품코드가 같은 행을 검색하기
SELECT * FROM 상품, 재고수 WHERE 상품.상품코드 = 재고수.상품코드;
```

이렇게 교차결합으로 계산된 곱집합에서 원하는 조합을 검색하는 것을 **내부결합(Inner Join)**이라 부른다.

다음으로 상품분류가 '식료품'이라는 조건이 필요하다. 이 조건을 WHERE구에 추가해 보겠다. 추가할 때는 기존 조건식과 상품분류의 조건식이 모두 참이어야 하므로 AND로 조건식을 연결한다. 또한 상품명과 재고수만 반환하도록 SELECT 구에 열을 지정한다.

```
-- 검색할 행과 반환할 열 제한하기
SELECT 상품.상품명, 재고수.재고수 FROM 상품, 재고수
	WHERE 상품.상품코드 = 재고수.상품코드
	AND 상품.상품분류 = '식료품';
```
WHERE 구에는 두 개의 조건식이 지정되어 있다. 첫 번째 조건식은 교차결합으로 계산된 곱집합에서 원하는 조합을 검색하는 것이다. 두 번째 조건식은 결합 조건이 아닌 검색 조건이다. 여기에서 첫 번째 조건식의 조건을 '결합조건'이라 부른다.

---

#### INNER JOIN으로 내부결합하기

지금까지 설명한 결합방법에 관해 다음과 같이 간단히 정리하면
* FROM 구에 테이블을 복수 지정해 가로 방향으로 테이블을 결합할 수 있다.
* 교차결합을 하면 곱집합으로 계산된다.
* WHERE 조건을 지정해 곱집합에서 필요한 조합만 검색할 수 있다.

이와 같은 결합방법을 상품 테이블과 재고수 테이블로 확인해 보았지만, 사실 지금까지 설명한 결합방법은 구식이다. 최근에는 INNER JOIN 키워드를 사용한 결합방법이 일반적으로 통용된다. 그럼, 지금부터 상품 테이블과 재고수 테이블을 이용한 사례를 INNER JOIN을 활용해 바꿔보겠다.

```
SELECT 상품.상품명, 재고수.재고수
	FROM 상품 INNER JOIN 재고수
		ON 상품.상품코드 = 재고수.상품코드
	WHERE 상품.상품분류 = '식료품';
```

* SYNTAX 내부결합
    * SELECT * FROM 테이블명1 **INNER JOIN** 테이블명2 **ON 결합조건**

구식 방법에서는 쉼표(,)로 구분하여 테이블을 FROM 구에 지정했다. 새로운 형식에서는 테이블과 테이블 사이에 'INNER JOIN'이라는 키워드를 넣는다. 여기서 INNER는 '안쪽'이라는 의미이며 JOIN은 '연결시킨다'라는 의미이다. 즉, 'INNER JOIN'은 '내부결합'이라는 의미가 된다. 구식 방법에서는 WHERE 구에 결합조건을 지정하였지만 INNER JOIN에서는 ON을 사용하여 결합조건을 지정한다.

INNER JOIN으로 두 개 테이블을 가로로 결합할 수 있다!

---

#### 내부결합을 활용한 데이터 관리

'하나의 데이터는 한 군데에 저장한다'라는 룰에 따라 데이터 구조를 설계한다고 했을 때, 메이커코드와 메이커명을 가지는 메이커 테이블을 작성해 데이터를 관리해 보겠다.

상품을 제조하는 메이커가 많이 있다고 해도 상품 수보다는 적겠지요. 이때 코드와 이름을 가지는 테이블로 분할해 관리하면 저장공간도 절약할 수 있다. 그럼 메이커 테이블을 작성하는 명령과 저장할 데이터를 살펴보도록 하겠다.

```
CREATE TABLE 메이커(
    메이커코드 CHAR(4) NOT NULL,
    메이커명 VARCHAR(30),
    PRIMARY KEY(메이커코드)
);

DESC 메이커;
DESC 상품2;

SELECT * FROM 메이커;
SELECT * FROM 상품2;

-- 상품 테이블과 메이커 테이블을 내부 결합하기
SELECT S.상품명, M.메이커명
	FROM 상품2 S INNER JOIN 메이커 M
	    ON S.메이커코드 = M.메이커코드;
```

이번에는 테이블에 별명을 붙여 보았다. SELECT 명령에서 복수의 테이블을 다룰 경우 어느 테이블의 열인지 정확하게 지정해야 한다. 이때 테이블명을 매번 지정하는 것은 번거로운 일이므로 짧게 줄여 별명을 붙이는 경우가 많다. 앞의 예제에서도 메이커 테이블에는 'M', 상품 테이블에는 'S'라는 짧은 별명을 붙였다.

---

- 외부키
    * 메이커 테이블의 메이커코드는 기본키이다. 그에 비해 상품2 테이블의 메이커코드는 '외부키'라 불리는 것으로, 다른 테이블의 기본키를 참조하는 열이 외부키가 된다.

- 자기결합(Self Join)
    * 자기결합은 테이블에 별명을 붙일 수 있는 기능을 이용해 같은 테이블끼리 결합하는 것을 말한다. 특별히 명령어가 정해져 있는 것은 아니다.

```
-- 상품 테이블을 자기결합 하기
SELECT S1.상품명, S2.상품명
	FROM 상품 S1 INNER JOIN 상품 S2
	    ON S1.상품코드 = S2.상품코드;
```

상품 테이블을 가로로 두 개 나열해 상품코드로 결합했다. 자기결합에서는 결합의 좌우가 같은 테이블이 되기 때문에 이를 구별하기 위해서 반드시 별명을 붙여야 한다.
사실 평소에는 이러한 결합을 할 일은 없다. 어떻게 생각하면 쓸모 없는 쿼리일 수도 있다. 자기결합은 자기 자신의 기본키를 참조하는 열을 자기 자신이 가지는 데이터 구조로 되어 있을 경우에 자주 사용된다.

---

#### 외부결합

결합 방법은 크게 내부결합과 외부결합의 두 가지로 구분된다.

외부결합이라고 해도 교차결합으로 결합 조건을지정하여 검색한다는 기본적인 사고방식은 같다. 외부결합은 '어느 한 쪽에만 존재하는 데이터행을 어떻게 다룰지'를 변경할 수 있는 결합 방법이다.

앞에서 살펴보았던 상품 테이블과 재고수 테이블 중에 상품 테이블에만 행이 존재하는 상황을 생각해 보자. 실제로 상품 데이터를 등록한 직후에는 이러한 상황이 존재할 수 있겠다.

```
DESC 상품3;
DESC 재고수;
SELECT * FROM 상품3;
SELECT * FROM 재고수;
```

상품3 테이블에는 상품코드가 0009인 행을 새롭게 추가했다. 재고수 테이블에는 아직 이 상품에 대한 데이터가 없다. 이런 상태에서 곱집합을 구해도 0009 = 0009가 되는 행은 존재하지 않으므로 내부결합 결과에서는 상품코드가 0009인 상품이 제외된다.



```
-- 내부결합에서는 상품코드가 0009인 상품이 제외된다.
SELECT 상품3.상품명, 재고수.재고수
	FROM 상품3 INNER JOIN 재고수
	    ON 상품3.상품코드 = 재고수.상품코드
	WHERE 상품3.상품분류 = '식료품';
```

이런 경우에 외부결합을 사용하면 된다. **외부결합은 결합하는 테이블 중에 어느 쪽을 기준으로 할지 결정할 수 있다.** 이번에는 상품 테이블(결합의 왼쪽)을 기준으로 INNER JOIN 대신 LEFT JOIN을 사용해 보겠다.

```
-- 외부결합으로 상품코드 0009인 상품도 결과에 포함하기
SELECT 상품3.상품명, 재고수.재고수
	FROM 상품3 LEFT JOIN 재고수
	ON 상품3.상품코드 = 재고수.상품코드
	WHERE 상품3.상품분류 = '식료품';
```

재고수 테이블에는 0009에 대한 **데이터가 없으므로 값이 NULL로 표시** 되는 점에 주의하기 바란다. 기준이 되는 상품 테이블을 JOIN의 왼쪽에 기술했으므로 LEFT JOIN이라 지정했다. 상품 테이블을 오른쪽에 지정하는 경우나 재고 테이블을 기준으로 삼고 싶은 경우에는 RIGHT JOIN을 사용해 외부결합을 시행한다.

LEFT JOIN, RIGHT JOIN으로 외부결합을 할 수 있다!

---


- 구식방법에서의 외부결합과 표준 SQL
MySQL은 비교적 최근에 나온 데이터베이스이다. 따라서 구식 방법을 이용해도 내부결합은 가능하지만 외부결합은 할 수 없다. 그러므로 여기에서는 Oracle의 경우를 예로 소개하겠다.

구식 결합방법에서는 FROM 구에 결합 조건을 기술하지 않았다. 대신 WHERE구로 결합 조건을 지정한다. 그냥 조건식을 지정하면 내부결합이 되어버리므로, 외부결합으로 진행하고 싶은 경우에는 특별한 연산자를 사용한다.

Oracle에서는 데이터가 존재하지 않을 수도 있는 테이블의 열에 (+)라는 특수한 기호를 붙여서 조건식을 지정한다.

```
-- Oracle에서 구식 외부결합으로 0009의 상품을 결과에 포함하기
Select 상품3.상품명, 재고수.재고수
	FROM 상품3, 재고수
	WHERE 상품3.상품코드 = 재고수.상품코드(+)
	AND 상품3.상품분류 = '식료품';
```

그 밖에도 SQL Server에서는 특수한 연산자(*= 또는 =*)를 사용해서 외부결합을 할 수 있다. 이전에는 이처럼 데이터베이스에 따라 서로 다른 방법으로 외부결합을 지원했다. 즉, SQL의 방언에 속한다. 하지만 현재는 표준화로 인해 내부결합은 INNER JOIN, 외부결합은 LEFT JOIN이나 RIGHT JOIN을 사용하도록 권장한다.

지금까지는 설명을 위해 구식 결합방법부터 설명했다. 하지만 표준화가 진행된 현재에는 별다른 장점이 없는 구식 결합방법은 사용하지 않는다. 따라서 여기서 소개한 예제는 어디까지나 참고로 삼기 바란다.

구식 결합방법은 사용하지 않는다!