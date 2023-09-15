### 선형탐색

* sequential search
* 주어진 데이터 집합에서 원하는 데이터를 **처음부터 순차적으로 비교**하면서 찾는 방법

### 이진탐색

* binary search
* **정렬**된 데이터 집합을, **이분화**하면서 탐색

### 이진 탐색 트리

* 데이터 삽입, 삭제, 탐색에 효율적인 구조
* 이진 트리 이면서, 중복 노드 X
* 왼쪽 서브트리는 현재 노드 값보다 작고, 오른쪽 서브트리는 현재 노드 값보다 큼

---

## 인덱스

인덱스는 테이블에 붙여진 색인이라 할 수 있다. **인덱스의 역할은 검색속도의 향상** 이다. 여기서 '검색'이란 SELECT 명령에 WHERE 구로 조건을 지정하고 그에 **일치하는 행을 찾는 일련의 과정** 을 말한다. 검색은 탐색이라고도 불린다. 테이블에 인덱스가 지정되어 있으면 효율적으로 검색할 수 있으므로 WHERE로 조건이 지정된 SELECT 명령의 처리 속도가 향상된다.

책의 목차나 색인 역시 인덱스라고 생각하면 좀더 이해하기 쉬울 것이다. 책안에 있는 특정한 부분을 찾고 싶은 경우, 본문을 처음부터 읽어나가기보다 목차나 색인을 참고해서 찾는 편이 효율적이다. 인덱스가 바로 이런 역할을 한다.

인덱스의 구조도 목차나 색인과 비슷하다. 목차나 색인에 제목-키워드별 페이지 번호가 적혀있듯, 데이터베이스의 인덱스에는 검색 시에 쓰이는 키워드와 대응하는 데이터 행의 장소가 저장되어 있다.

인덱스는 테이블과는 별개로 독립된 데이터베이스 객체로 작성된다. 하지만 인덱스만으로는 아무런 의미가 없다. 목차밖에 없는 책은 본적이 없는 것처럼, **인덱스는 테이블에 의존하는 객체** 라 할 수 있다. 대부분의 데이터베이스에서는 테이블을 삭제하면 인덱스도 삭제된다.

### 검색에 사용하는 알고리즘

인덱스를 사용하여 효율적으로 검색할 수 있는 이유를 설명하면...

대량의 데이터를 효율적으로 검색하는 방법에 관해서는 예전부터 여러 가지로 연구되어 왔다. 데이터 탐색이라든가 검색 알고리즘 등이 그에 해당한다. 데이터베이스의 인덱스에 쓰이는 대표적인 검색 알고리즘으로는 '이진 트리(binary tree)'가 있으며, 그 다음으로 '해시'가 유명하다.

이진 트리는 정확히 말하면 탐색 방법이라기보다 데이터 구조에 가깝다. 탐색 방법으로 말하자면 이진탐색(binary search)이 된다. 이때 이진탐색에서 검색하기 쉬운 구조로 한 것이 이진 트리이다.

- 풀 테이블 스캔(full table scan)
    - 인덱스가 지정되지 않은 테이블을 검색할 때는 풀 테이블 스캔이라 불리는 검색 방법을 사용한다. 처리방법은 단순한데, 테이블에 저장된 **모든 값을 처음부터 차례로 조사** 해나가는 것이다. 아주 단순한 검색방법으로, 행이 1,000건 있다면 최대 1,000번 값을 비교한다.

- 이진 탐색(binary search)
    - 이진 탐색은 **차례로 나열된 집합에 대해 유효한** 검색 방법이다. 처음부터 순서대로 조사하는 것이 아니고 집합을 **반으로 나누어 조사** 하는 검색방법이다.

- 이진 트리(binary tree)
    - 이진 탐색은 고속으로 검색할 수 있는 탐색 방법이지만 데이터가 **미리 정렬되어** 있어야 한다. 하지만 테이블 내의 행을 언제나 정렬된 상태로 두는 것은 힘든 작업이다.
    - 일반적으로는 테이블에 인덱스를 작성하면 **테이블 데이터와 별개로 인덱스용 데이터가 저장장치에 만들어 진다. 이때 이진 트리라는 데이터 구조로 작성된다.**

---

### 유일성

이진 트리의 구조를 살피다 보면, 같은 값을 가지는 노드가 여러 개 있을 때의 결과에 대한 의문이 생길 수 있다. 사실 **이진 트리에서는 집합 내에 중복하는 값을 가질 수 없다.** 즉, 노드의 가지는 큰 쪽과 작은쪽의 두 가지로 나뉘며, 같은 값을 허용하기 위해서는 '같은'이라는 제3의 노드를 가질 필요가 있다.

하지만, 이진 트리에서 '같은 값을 가지는 노드를 여러 개 만들 수 없다'라는 특성은 키에 대하여 유일성을 가지게 할 경우에만 유용하다. 그래서 기본키 제약은 이진 트리로 인덱스를 작성하는 데이터베이스가 많은 것 같다.


인덱스 작성과 삭제

```
-- SYNTAX 인덱스 작성, 삭제
-- CREATE INDEX
-- DROP INDEX

CREATE TABLE sample62(no int, a varchar(10));
INSERT INTO sample62 VALUES(2, 'ABC');
INSERT INTO sample62 VALUES(1, 'DEF');
INSERT INTO sample62 VALUES(100, 'GHI');
INSERT INTO sample62 VALUES(3, 'JKL');
INSERT INTO sample62 VALUES(101, 'MNO');
```

인덱스는 데이터베이스 객체의 하나로 DDL을 사용해 작성하거나 삭제한다.

표준 SQL에서는 CREATE INDEX 명령은 없다. 인덱스 자체가 데이터베이스 제품에 의존하는 선택적인 항목으로 취급된다. 하지만 대표적인 데이터베이스 제품에는 모두 인덱스 구조가 도입되어 있으며, 모두 비슷한관리 방법으로 인덱스를 다룰 수 있다.

---

1. 인덱스 작성

**인덱스는 CREATE INDEX 명령으로 만든다.** 인덱스에 이름을 붙여 관리하는데, 데이터베이스 객체가 될지 테이블의 열처럼 취급될지는 데이터베이스 제품에 따라 다르다. Oracle이나 DB2 등에서 인덱스는 스키마 객체가 된다. 따라서 스키마 내에 이름이 중복하지 않도록 지정해 관리한다. 한편 SQL Server나 MySQL에서 인덱스는 테이블 내의 객체가 된다. 따라서 테이블 내에 이름이 중복되지 않도록 지정해 관리한다.

인덱스를 작성할 때는 **해당 인덱스가 어느 테이블의 어느 열에 관한 것인지 지정할 필요** 가 있다. 이때 열은 복수로도 지정할 수 있다. 인덱스의 네임스페이스가 데이터베이스 제품마다 다르다는 점만 주의하면 문법은 그렇게 어렵지 않다.

```
-- SYNTAX CREATE INDEX
-- CREATE INDEX 인덱스명 ON 테이블명 (열명1, 열명2, ...)

-- sample62 테이블의 no 열에 isample62라는 인덱스를 지정한다. 인덱스를 작성할 때는 저장장치에 색인용 데이터가 만들어진다. 
-- 테이블 크기에 따라 인덱스 작성시간도 달라지는데, 행이 대량으로 존재하면 시간도 많이 걸리고 저장공간도 많이 소비한다.

-- 인덱스 작성하기
CREATE INDEX isample62 ON sample62(no);

-- 인덱스 보기
SHOW INDEX FROM sample62;	

-- 인덱스 삭제
-- SYNTAX DROP INDEX(테이블 내 객체의 경우)
DROP INDEX 인덱스명 ON 테이블명

-- 인덱스는 테이블에 의존하는 객체이다. DROP TABLE로 테이블을 삭제하면 테이블에 작성된 인덱스도 자동으로 삭제된다. 인덱스만 삭제하는 경우에는 DROP INDEX를 사용한다.

-- 인덱스 삭제하기
DROP INDEX isample62 ON sample62;

-- 인덱스를 작성해두면 검색이 빨라진다. 작성한 인덱스의 열을 WHERE 구로 조건을 지정하여 SELECT 명령으로 검색하면 처리속도가 향상된다. 
-- 하지만 모든 SELECT 명령에 적용되는 만능 인덱스는 작성할 수 없다. 한편, INSERT 명령의 경우에는 인덱스를 최신 상태로 갱신하는 처리가 늘어나므로 처리속도가 조금 떨어진다.

CREATE INDEX isample62 ON sample62(a);

-- WHERE 구에 a열에 대한 조건식을 지정한 경우 SELECT 명령은 인덱스를 사용해 빠르게 검색할 수 있다. 
-- 예를 들면 다음과 같은 SELECT 명령이 된다. 그러나 WHERE 구의 조건식에 a열이 전혀 사용되지 않으면 SELECT 명령은 isample62 라는 인덱스를 사용할 수 없다.

SELECT * FROM sample62 WHERE a = 'a';

-- EXPLAIN
-- 인덱스 작성을 통해 쿼리의 성능 향상을 기대할 수 있다. 이때 실제로 인덱스를 사용해 검색하는지를 확인하려면 EXPLAIN 명령을 사용한다.

-- SYNTAX EXPLAIN
-- EXPLAIN SQL 명령

-- EXPLAIN 명령의 문법은 간단하다. EXPLAIN에 뒤이어 확인하고 싶은 SELECT 명령 등의 SQL 명령을 지정하면 된다. 다만 이 SQL 명령은 실제로는 실행되지 않는다. 
-- 어떤 상태로 실행되는 지를 데이터베이스가 설명해줄 뿐이다.(MySQL의 경우 상황에 따라 다르지만 필요한 정보를 얻기 위해 SQL 명령의 일부분을 실제로 실행하는 경우도 있다.)

-- EXPLAIN은 표준 SQL에는 존재하지 않는, 데이터베이스 제품 의존형 명령이다. 하지만 어떤 데이터베이스 제품이라도 이와 비슷한 명령을 지원한다.

EXPLAIN SELECT * FROM sample62 WHERE a = 'a';

-- sample62의 a 열에는 isample62라는 인덱스가 작성되어 있다. EXPLAIN의 뒤를 잇는 SELECT 명령은 a 열의 값을 참조해 검색하므로 isample62을 사용해 검색한다.
-- (possible_keys 라는 곳에 사용될 수 있는 인덱스가 표시되며, key는 사용된 인덱스가 표시된다.)

-- 그럼, WHERE 조건을 바꾸면 어떻게 변하는지 알아보면. a 열을 사용하지 않도록 조건을 변경하면 인덱스를 사용할 수 없을 것이다.

EXPLAIN SELECT * FROM sample62 WHERE no > 10;

-- possible_keys와 key가 NULL이 되었다.
```

### 최적화

SELECT 명령을 실행할 때 인덱스의 사용 여부를 선택한다는 것을 알았다. 이는 데이터베이스 내부의 최적화에 의해 처리되는 부분이다. 내부 처리에서는 SELECT 명령을 실행하기에 앞서 실행계획을 세운다. 실행계획에서는 '인덱스가 지정된 열이 WHERE 조건으로 지정되어 있으니 인덱스를 사용하자'와 같은 처리가 이루어진다. EXPLAIN 명령은 이 실행계획을 확인하는 명령이다.

실행계획에서는 인덱스의 유무뿐만 아니라 인덱스를 사용할 것인지 여부에 대해서도 데이터베이스 내부의 최적화 처리를 통해 판단한다. 이때 판단 기준으로 인덱스의 품질도 고려한다. 데이터의 종류가 적으면 적을수록 인덱스의 효율도 떨어진다. 반대로 **서로 다른 값으로 여러 종류의 데이터가 존재하면 그만큼 효율은 좋아진다.** 이렇게 인덱스의 품질을 고려해 실행계획이 세워지는 것이다.



