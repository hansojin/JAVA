# 가상의 테이블 : 뷰

뷰는 한 마디로 **가상의 테이블** 이라 부릅니다 **일반 사용자 입장에서는 테이블과 동일하게 보이기 때문** 입니다. 그렇다면 테이블이 있는데, 왜 뷰를 사용할까요? 

뷰를 사용하면 사용자에게 테이블의 필요한 내용만 보이도록 할 수 있습니다.

뷰(view)는 데이터베이스 개체 중에 하나입니다.

뷰는 **테이블처럼 데이터를 가지고 있지는 않습니다.** 뷰의 실체는 SELECT 문으로 만들어져 있기 때문에 **뷰에 접근하는 순간 SELECT가 실행되고 그 결과가 화면에 출력되는 방식** 입니다. 뷰는 단순 뷰와 복합 뷰로 나뉘는데, 단순 뷰는 하나의 테이블과 연관된 뷰를 말하고, 복합 뷰는 2개 이상의 테이블과 연관된 뷰를 말합니다.

뷰의 이름만 보고도 뷰인지 알아볼 수 있도록 **이름 앞에 v_를 붙이는 것이 일반적** 입니다.

```
USE market_db;

CREATE VIEW v_member
AS
	SELECT mem_id, mem_name, addr FROM member;

SELECT * FROM v_member;

SELECT mem_name, addr 
FROM v_member
WHERE addr IN('서울', '경기');
```

---

그렇다면 뷰는 수정이 가능할까요? 

뷰는 기본적으로 '읽기 전용'으로 사용되지만, **뷰를 통해서 원본 테이블의 데이터를 수정할 수도 있습니다.** 하지만 **무조건 가능한 것은 아니고 몇 가지 조건을 만족해야** 합니다.

**뷰를 사용하는 이유는?**
* **보안(security)** 에 도움이 됩니다.
* 복잡한 **SQL을 단순하게 만들 수 있습** 니다.

```
CREATE VIEW v_memberbuy
AS
	SELECT B.mem_id, M.mem_name, B.prod_name, M.addr,
		CONCAT(M.phone1, M.phone2) '연락처'
	FROM buy B
		INNER JOIN member M
			ON B.mem_id = M.mem_id;

-- 블랙핑크 구매기록 조회
SELECT * FROM v_memberbuy WHERE mem_name = '블랙핑크';
```

---

## 뷰의 실제 작동(생성, 수정, 삭제)

```
-- 뷰를 조회할 때는 열 이름에 공백이 있으면 백틱(`)으로 묶어줘야 합니다.
USE market_db;
CREATE VIEW v_viewtest1
AS
	SELECT B.mem_id 'Member ID', M.mem_name As 'Member Name',
		B.prod_name "Product Name",
			CONCAT(M.phone1, M.phone2) AS "Office Phone"
	FROM buy B
		INNER JOIN member M
			ON B.mem_id = M.mem_id;

SELECT DISTINCT `Member ID`, `Member Name` FROM v_viewtest1;

-- 뷰를 생성할 때 뷰의 열 이름을 테이블과 다르게 지정할 수 있으며, 띄어쓰기나 한글도 가능합니다.
-- 뷰의 수정은 ALTER VIEW 구문을 사용하며, 열 이름에 한글을 사용해도 됩니다.

ALTER VIEW v_viewtest1
AS
	SELECT B.mem_id '회원 아이디', M.mem_name AS '회원 이름',
		B.prod_name "제품 이름",
			CONCAT(M.phone1, M.phone2) AS "연락처"
		FROM buy B
			INNER JOIN member M
			ON B.mem_id = M.mem_id;

SELECT DISTINCT `회원 아이디`, `회원 이름` FROM v_viewtest1;

DROP VIEW v_viewtest1;
```

**CREATE OR REPLACE VIEW** 

뷰를 생성할 때 CREATE VIEW는 기존에 뷰가 있으면 오류가 발생하지만, CREATE OR REPLACE VIEW는 기존에 뷰가 있어도 **덮어쓰는 효과를 내기 때문에 오류가 발생하지 않습니다.** 즉, **DROP VIEW와 CREATE VIEW를 연속으로 작성한 효과** 를 갖습니다.

```
-- 뷰의 정보 확인 _ 기존에 생성된 뷰에 대한 정보를 확인할 수 있습니다.

USE market_db;

CREATE OR REPLACE VIEW v_viewtest2
AS
	SELECT mem_id, mem_name, addr FROM member;

DESCRIBE v_viewtest2;
DESC v_viewtest2;

SHOW CREATE VIEW v_viewtest2;
```

뷰도 테이블과 동일하게 정보를 보여줍니다. 주의할 점은 PRIMARY KEY 등의 정보는 확인되지 않습니다.

SHOW CREATE VIEW 문으로 뷰의 소스 코드도 확인할 수 있습니다.

---

### 뷰를 통한 데이터의 수정/삭제

```
UPDATE v_member SET addr = '부산' WHERE mem_id='BLK';

INSERT INTO v_member(mem_id, mem_name, addr) VALUES('BTS', '방탄소년단', '경기'); -- 에러
```

v_member(뷰)가 참조하는 member(테이블)의 열 중에서 mem_number 열은 NOT NULL로 설정되어서 반드시 입력해줘야 합니다. 하지만 현재의 v_member에서는 mem_number 열을 참조하고 있지 않으므로 값을 입력할 방법이 없습니다.

만약 v_member 뷰를 통해서 member 테이블에 값을 입력하고 싶다면 v_member에 mem_number 열을 포함하도록 뷰를 재정의하거나, 아니면 member에서 mem_number 열의 속성을 NULL로 바꾸거나, 기본값(Default)을 지정해야 합니다.

```
CREATE VIEW v_height167
AS
	SELECT * FROM member WHERE height >= 167;

SELECT * FROM v_height167;

-- v_height167 뷰에서 키가 167미만인 데이터를 삭제
DELETE FROM v_height167 WHERE height < 167;

-- 결과 메시지
0 row(s) affected
```

당연히 v_height167 뷰에는 167 미만인 데이터가 없습니다. 그러므로 삭제될 데이터도 없는 것입니다.

---

### 뷰를 통한 데이터의 입력

이번에는 v_height167 뷰에서 키가 167미만인 데이터를 입력해보자.

```
INSERT INTO v_height167 VALUES('TRA', '티아라', 6, '서울', NULL, NULL, 159, '2005-01-01');
```

일단 입력은 되었습니다. 그런데 생각해보니 약간 이상합니다. v_height167 뷰는 167이상만 보이도록 만든 뷰인데, 167미만인 데이터가 입력되었습니다. 일단 뷰의 데이터를 확인해봅시다. 역시 167이상만 조회가 되므로 방금 전에 입력한 티아라는 보이지 않습니다.

```
SELECT * FROM v_height167;

SELECT * FROM member; 
-- member를 확인해 보면 들어가 있다.
```

이번 예를 보면 키가 167이상인 뷰에 키가 159인 데이터를 입력한 것은 별로 바람직해 보이지 않습니다. 즉, 예상치 못한 경로를 통해서 입력되면 안 되는 데이터가 입력된 듯한 느낌입니다. 키가 167이상인 뷰이므로 167이상의 데이터만 입력되도록 하는 것이 논리적으로 바람직합니다.

이럴 때, **WITH CHECK OPTION을 통해 뷰에 설정된 값의 범위가 벗어나는 값은 입력되지 않도록 할 수 있습니다.**

```
ALTER VIEW v_height167
AS
	SELECT * FROM member WHERE height >= 167
		WITH CHECK OPTION;

INSERT INTO v_height167 VALUES('TOB', '텔레토비', 4, '영국', NULL, NULL, 140, '1995-01-01');
```

이제 키가 167 미만인 데이터는 입력되지 않고, 167이상의 데이터만 입력됩니다. 

이러한 방식이 좀 더 합리적입니다.

---

### 단순 뷰와 복합 뷰

**하나의 테이블로 만든 뷰를 단순 뷰** 라 하고, **두 개 이상의 테이블로 만든 뷰를 복합 뷰** 라고 합니다. **복합 뷰는 주로 두 테이블을 조인한 결과를 뷰로 만들 때 사용** 합니다. 복합 뷰의 예는 다음과 같습니다.

```
CREATE VIEW v_complex
AS
	SELECT B.mem_id, M.mem_name, B.prod_name, M.addr
		FROM buy B
			INNER JOIN member M
			ON B.mem_id = M.mem_id;
```

**복합 뷰는 읽기 전용** 입니다. 복합 뷰를 통해 **테이블에 데이터를 입력/수정/삭제할 수 없습니다.**

---

### 뷰가 참조하는 테이블의 삭제

```
DROP TABLE IF EXISTS buy, member;
```

현재 여러 개의 뷰가 두 테이블과 관련이 있는데도 테이블이 삭제되었습니다. 두 테이블 중 아무거나 연관되는 뷰를 다시 조회해봅시다.

```
SELECT * FROM v_height167;
```

당연히 참조하는 테이블이 없기 때문에 조회할 수 없다는 메시지가 나옵니다. 바람직하지는 않지만, **관련 뷰가 있더라도 테이블은 쉽게 삭제됩니다.**

**뷰가 조회되지 않으면 CHECK TABLE 문으로 뷰의 상태를 확인해볼 수** 있습니다. 뷰가 참조하는 테이블이 없어서 오류가 발생하는 것을 확인할 수 있습니다.

```
CHECK TABLE v_height167;
```