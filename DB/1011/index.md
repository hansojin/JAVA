## 인덱스 개념

인덱스는 **SELECT를 사용해서 테이블을 조회할 때 결과를 빠르게 추출하도록 도와주는 기능**

장점
* SELECT 문으로 **검색하는 속도가 매우 빨라짐**
* 그 결과 컴퓨터의 부담이 줄어들어서 결국 **전체 시스템의 성능이 향상**

단점
* 인덱스도 공간을 차지해서 **데이터베이스 안에 추가적인 공간이 필요**
    * 인덱스는 대략 테이블 크기의 10% 정도의 공간이 추가로 필요
* 처음에 인덱스를 만드는 데 시간이 오래 걸릴 수 있음
    * **생성 작업 시간이 필요**
* SELECT가 아닌 데이터의 변경 작업(INSERT, UPDATE, DELETE)이 자주 일어나면 오히려 성능이 나빠질 수도 있음
* 데이터베이스에 인덱스를 생성해 놓아도, 인덱스를 사용해서 검색하는 것이 빠를지 아니면 전체 테이블을 검색하는 것이 빠를지 MySQL이 알아서 판단함
    * 만약 인덱스를 사용하지 않는다면 사용하지도 않는 찾아보기를 만든 것이므로 쓸데없이 공간을 낭비한 셈

* 구분
    * 크게 두 가지로 나뉘는데, 클러스터형 인덱스(Clustered Index)와 보조 인덱스(Secondary Index)로 나뉨
    * 쉽게 비교하면 클러스터형 인덱스는 영어사전과 같고, 보조 인덱스는 책의 뒤에 찾아보기가 있는 일반적인 책과 같음
    * **클러스터형 인덱스(Clustered Index)**
        * 기본 키로 지정하면 자동(으로 클러스터형 인덱스가) 생성되며 테이블에 1개만 만들 수 있음
        * 기본 키로 지정한 열을 기준으로 자동 정렬됨 (하나만 지정 가능)
    * **보조 인덱스(Secondary Index)**
        * 고유 키로 지정하면 자동 생성되며 (테이블당) 여러 개를 만들 수도 있지만 자동 정렬되지는 않음
        
**SHOW INDEX 문**을 사용하면 **인덱스 정보가 확인** 됨

```
USE market_db;
CREATE TABLE table1(
	col1 INT PRIMARY KEY,
	col2 INT,
	col3 INT
);

SHOW INDEX FROM table1;
```

---

### 고유 인덱스

**고유 인덱스(Unique Index)** 는 **인덱스의 값이 중복되지 않는다** 는 의미고, **단순 인덱스(Non-Unique Index)** 는 **인덱스의 값이 중복되어도 된다** 는 의미입니다. **기본 키(Primary Key)나 고유 키(Unique)로 지정** 하면 값이 중복되지 않으므로 **고유 인덱스가 생성** 됩니다. **그 외의 인덱스는 단순 인덱스로 생성** 됩니다.

기본 키와 더불어 고유 키도 인덱스가 자동으로 생성됩니다. 고유 키로 생성되는 인덱스는 보조 인덱스입니다. 

```
CREATE TABLE table2(
col1 INT PRIMARY KEY,
col2 INT UNIQUE,
col3 INT UNIQUE
);
SHOW INDEX FROM TABLE2;
```

### 자동으로 정렬되는 클러스터형 인덱스

영어 사전의 가장 큰 특징은 단어가 알파벳 순서로 정렬되어 있다는 것입니다. 마찬가지로 **어떤 열을 기본 키로 지정하면(클러스터형 인덱스가 생성되면) 그 열을 기준으로 자동 정렬** 됨

```
USE market_db;
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member(
mem_id CHAR(8),
mem_name VARCHAR(10),
mem_number INT,
addr CHAR(2)
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울');
SELECT * FROM member;           -- 입력순서대로 정렬

ALTER TABLE member
	ADD CONSTRAINT
	PRIMARY KEY (mem_id);

SELECT * FROM member;       -- mem_id를 기준으로 정렬

ALTER TABLE member DROP PRIMARY KEY;

ALTER TABLE member
	ADD CONSTRAINT
	PRIMARY KEY(mem_name);

SELECT * FROM member;       -- mem_name을 기준으로 정렬
```

---

* 기본 키 변경 시 주의할 점
    * 이미 대용량의 데이터가 있는 상태에서 기본 키를 지정하면 시간이 엄청 오래 걸릴 수 있음. 노트에 단어가 4개라면 정렬하는 데 금방이지만, 노트에 단어가 4만 개라면 그것을 정렬하는 데는 오랜 시간이 소요되는 것 처럼. 
    * 또, 앞에서 회원 이름 열을 기본 키로 변경했는데, 실제라면 이건 논리적으로 위험함. 기본 키는 중복되지 않아야 하는데, 회원 이름은 당연히 중복될 수 있기 때문임

**정렬되지 않는 보조 인덱스** 

```
DROP TABLE IF EXISTS member;
CREATE TABLE member(
mem_id CHAR(8),
mem_name VARCHAR(10),
mem_number INT,
addr CHAR(2)
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울');
SELECT * FROM member;

ALTER TABLE member
	ADD CONSTRAINT
	UNIQUE(mem_id);

SELECT * FROM member;       -- mem_id 열을 고유 키로 설정해도 데이터의 순서에는 변화가 없다.

ALTER TABLE member
	ADD CONSTRAINT
	UNIQUE (mem_name);

SELECT * FROM member;       -- mem_name 열을 고유 키로 추가 설정해도 데이터의 순서에는 변화가 없다.

INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울');

SELECT * FROM member;   -- 데이터를 추가하면 제일 뒤에 추가가 된다.
```

* 보조 인덱스는 여러 개를 만들 수 있음 
     * 하지만 보조 인덱스를 만들 때마다 데이터베이스의 공간을 차지하게 되고, 전반적으로 시스템에 오히려 나쁜 영향을 미치게 되므로 꼭 필요한 열에만 적절히 보조 인덱스를 생성하자

---

### 인덱스의 내부 작동

클라스터형 인덱스와 보조 인덱스는 모두 **내부적으로 균형 트리로 만들어짐** 

균형 트리(Balanced tree, B-tree)는 '자료 구조'에 나오는 범용적으로 사용되는 데이터의 구조로, 나무를 거꾸로 표현한 형태로 트리에서 제일 상단의 뿌리를 루트, 줄기를 중간, 끝에 달린 잎을 리프라고 부름

#### 균형 트리의 개념

균형 트리 구조에서 **데이터가 저장되는 공간을 노드(node)** 라고 함. 루트 노트(root node)는 노드의 가장 상위 노드를 말하며, 모든 출발은 루트 노드에서 시작됨. 리프 노드(leaf node)는 제일 마지막에 존재하는 노드를 말함. 루트 노드와 리프 노드의 중간에 끼인 노드들은 중간 노드(internal node)라고 부름.  노드라는 용어는 개념적인 설명에서 주로 나오는 용어이며, **MySQL에서는 페이지(page)라고 부름** 페이지는 최소한의 저장 단위로, 16Kbyte(16384byte) 크기를 가짐. 예를 들어 데이터를 1건만 입력해도 1개 페이지(16Kbyte)가 필요함.

균형 트리는 **데이터를 검색할 때(SELECT 구문을 사용할 때) 아주 뛰어난 성능을 발휘** 하며 데이터를 처음부터 끝까지 검색하는 것을 전체 테이블 검색(Full Table Scan)이라고 부ㄹ므

인덱스를 구성하면 **데이터 변경 작업(INSERT, UPDATE, DELETE)시 성능이 나빠짐.** 특히 INSERT 작업이 일어날 때 더 느리게 입력될 수 있음. 이유는 **페이지 분할이라는 작업이 발생하기 때문** 임. 페이지 분할이란 새로운 페이지를 준비해서 데이터를 나누는 작업을 말함. 

---

### 인덱스의 구조

```
-- 클러스터형 인덱스 구성하기
USE market_db;
CREATE TABLE cluster  -- 클러스터형 테이블 
( mem_id      CHAR(8) , 
  mem_name    VARCHAR(10)
 );

INSERT INTO cluster VALUES('TWC', '트와이스');
INSERT INTO cluster VALUES('BLK', '블랙핑크');
INSERT INTO cluster VALUES('WMN', '여자친구');
INSERT INTO cluster VALUES('OMY', '오마이걸');
INSERT INTO cluster VALUES('GRL', '소녀시대');
INSERT INTO cluster VALUES('ITZ', '잇지');
INSERT INTO cluster VALUES('RED', '레드벨벳');
INSERT INTO cluster VALUES('APN', '에이핑크');
INSERT INTO cluster VALUES('SPC', '우주소녀');
INSERT INTO cluster VALUES('MMU', '마마무');

SELECT * FROM cluster;

ALTER TABLE cluster
    ADD CONSTRAINT 
    PRIMARY KEY (mem_id);

SELECT * FROM cluster;  -- 기본 키로 지정하면 클러스터형 인덱스가 생성되고 데이터가 자동으로 정렬됨

-- 보조 인덱스 구성하기
USE market_db;
CREATE TABLE second  -- 보조 인덱스 테이블 
( mem_id      CHAR(8) , 
  mem_name    VARCHAR(10)
 );
INSERT INTO second VALUES('TWC', '트와이스');
INSERT INTO second VALUES('BLK', '블랙핑크');
INSERT INTO second VALUES('WMN', '여자친구');
INSERT INTO second VALUES('OMY', '오마이걸');
INSERT INTO second VALUES('GRL', '소녀시대');
INSERT INTO second VALUES('ITZ', '잇지');
INSERT INTO second VALUES('RED', '레드벨벳');
INSERT INTO second VALUES('APN', '에이핑크');
INSERT INTO second VALUES('SPC', '우주소녀');
INSERT INTO second VALUES('MMU', '마마무');

ALTER TABLE second
    ADD CONSTRAINT 
    UNIQUE (mem_id);

SELECT * FROM second;       -- 보조 인덱스를 구성하면 인덱스가 별도의 공간에 만들어짐. 
                            -- 책 뒤에 별도로 찾아보기가 만들어지는 것과 같은 개념
```

---

### 인덱스의 실제 사용

* 인덱스 생성과 제거 문법
    * Primary Key 문법을 사용하면 클러스터형 인덱스가, Unique 문법을 사용하면 보조 인덱스가 자동으로 생성됨. 
    * 외에 직접 인덱스를 생성하려면 CREATE INDEX 문을 사용해야 함
    * CREATE INDEX로 생성되는 인덱스는 보조 인덱스

* 인덱스 제거
    * 하나의 테이블에서 인덱스를 제거할 때 클러스터형 인덱스와 보조 인덱스가 모두 있는 경우, 보조 인덱스부터 제거하는 것이 더 좋음. 
    * 클러스터형 인덱스부터 제거하면 내부적으로 데이터가 재구성되기 때문임
    * 또한, 인덱스가 많이 생성되어 있는 테이블의 경우 사용하지 않는 인덱스는 과감히 제거해주는 것이 좋음

* 인덱스를 효과적으로 사용하는 방법
    * 인덱스는 열 단위에 생성됨
    * WHERE 절에서 사용되는 열에 인덱스를 만들어야함
    * WHERE 절에 사용되더라도 자주 사용해야 가치가 있음
    * 데이터의 중복이 높은 열은 인덱스를 만들어도 별 효과가 없음
    * 클러스터형 인덱스는 테이블당 하나만 생성할 수 있음
    * 사용하지 않는 인덱스는 제거

