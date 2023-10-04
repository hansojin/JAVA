**테이블(table)**은 표 형태로 구성된 2차원 구조로, 행과 열로 구성되어 있다. **행은 로우(row)나 레코드(record)** 라고 부르며, **열은 컬럼(column)또는 필드(field)** 라고 부른다.

---

### DB 및 테이블

```
DROP DATABASE IF EXISTS naver_db;
CREATE DATABASE naver_db;
USE naver_db;

CREATE TABLE `naver_db`.`buy` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `mem_id` CHAR(8) NOT NULL,
  `prod_name` CHAR(6) NOT NULL,
  `group_name` CHAR(4) NULL,
  `price` INT UNSIGNED NOT NULL,
  `amout` SMALLINT NOT NULL,
  PRIMARY KEY (`num`),
FOREIGN KEY(mem_id) REFERENCES member(mem_id)
);

-- AUTO_INCREMENT로 지정한 열은 PRIMARY KEY나 UNIQUE로 꼭 지정해야 한다는 것

DROP TABLE IF EXISTS member;
CREATE TABLE member(
	mem_id		CHAR(8) NOT NULL PRIMARY KEY,
	mem_name	VARCHAR(10) NOT NULL,
	mem_number	TINYINT NOT NULL,
	addr		CHAR(2) NOT NULL,
	phone1		CHAR(2) NULL,
	phone2		CHAR(8)	NULL,
	height		TINYINT UNSIGNED NULL,
	debut_date	DATE NULL
);

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016-8-8');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015-1-15');

-- DATE로 지정된 열엔는 연, 월, 일 또는 연-월-일 형식으로 값을 입력

```
---

### 제약조건으로 테이블을 견고하게

테이블에는 기본 키, 외래 키와 같은 제약조건을 설정할 수 있다. 

제약조건은 테이블을 구성하는 핵심 개념으로, 이를 잘 이해하고 활용하면 데이터의 오류를 줄여 완전무결한 코드를 만들 수 있다.

테이블을 만들 때는 테이블의 구조에 필요한 제약조건을 설정해줘야 합니다. **기본 키(PRIMARY KEY)와 외래 키(FOREIGN KEY)가 대표적인 제약조건** 입니다. 기본 키는 학번, 아이디, 사번 등과 같은 고유한 번호를 의미하는 열에 지정합니다.

이메일, 휴대폰과 같이 **중복되지 않는 열에는 고유 키(UNIQUE)를 지정할 수** 있습니다. 회원의 평균 키는 당연히 200CM를 넘지 않겠죠? 이때 **실수로 200을 입력하는 것을 방지하는 제약조건이 체크(CHECK)** 입니다. 회원 테이블에 국적을 입력한다면 99%는 대한민국일 것입니다. **매번 입력하기 귀찮다면 제약 조건으로 기본값(DEFAULT)을 설정할 수** 있습니다. 또한, **값을 꼭 입력해야 하는 NOT NULL 제약조건** 도 있습니다.

---

### 제약조건의 기본 개념과 종류

제약조건(CONSTRAINT)은 **데이터의 무결성을 지키기 위해 제한하는 조건** 입니다. 일단 데이터의 무결성이란 '데이터에 결함이 없음'이란 의미입니다. 

간단한 예로 네이버 회원의 아이디가 중복되면 어떤 일이 일어날까요?

이메일, 블로그, 쇼핑 기록 등 상당한 혼란이 일어날 것입니다. 이런 것이 바로 데이터의 결함이고, 이런 결함이 없는 것을 데이터의 무결성이라고 표현합니다.

```
-- CREATE TABLE에서 설정하는 기본 키 제약 조건
USE naver_db;
DROP TABLE IF EXISTS buy, member;

CREATE TABLE member(
	mem_id CHAR(8) NOT NULL PRIMARY KEY,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL
);
```

---

### 테이블을 삭제하는 순서

회원 테이블과 구매 테이블은 기본 키-외래 키로 연결되어 있습니다. 

즉 회원 테이블의 회원만 구매 테이블에 입력될 수 있습니다. 만약 구매 테이블이 있는데 회원 테이블을 삭제(DROP)하면 어떻게 될까요?

예를 들어, 구매 테이블의 BLK 이름과 연락처를 알고 싶어도 회원 테이블은 이미 삭제되었기 때문에 알 수 있는 방법이 없습니다. 그러므로 기본 키-외래 키 관계로 연결된 테이블은 외래 키가 설정된 테이블을 먼저 삭제해야 합니다.

```
DESCRIBE member;

-- way1
DROP TABLE IF EXISTS member;
CREATE TABLE member(
	mem_id CHAR(8) NOT NULL,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL,
	PRIMARY KEY(mem_id)
);

-- way2
DROP TABLE IF EXISTS member;
CREATE TABLE member(
	mem_id CHAR(8) NOT NULL,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL
);
ALTER TABLE member
	ADD CONSTRAINT
	PRIMARY KEY (mem_id);


-- way3_기본 키에 이름 지정하기
DROP TABLE IF EXISTS member;
CREATE TABLE member(
	mem_id CHAR(8) NOT NULL,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL,
	constraint PRIMARY KEY PK_member_mem_id(mem_id)
);
```

---

### 외래 키 제약조건

**외래 키(Foreign Key) 제약조건은 두 테이블 사이의 관계를 연결** 해주고, 그 결과 **데이터의 무결성을 보장해주는 역할** 을 합니다. **외래 키가 설정된 열은 꼭 다른 테이블의 기본 키와 연결** 됩니다.

기본 키가 있는 테이블을 **기준 테이블** 이라고 부르며, 외래 키가 있는 테이블을 **참조 테이블** 이라고 부릅니다. 참조 테이블이 참조하는 **기준 테이블의 열은 반드시 기본 키(Primary Key)나, 고유 키(Unique)로 설정되어 있어야** 합니다.

```
-- CREATE TABLE에서 설정하는 외래 키 제약조건
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member(
	mem_id	CHAR(8) NOT NULL PRIMARY KEY,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL
);
CREATE TABLE buy(
	num	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	mem_id	CHAR(8) NOT NULL,
	prod_name CHAR(6) NOT NULL,
	FOREIGN KEY(mem_id) REFERENCES member(mem_id)
);
```

'네이버 쇼핑'의 예에서는 기준 테이블의 열 이름(mem_id)과 참조 테이블의 열 이름(mem_id)이 동일합니다. 하지만 꼭 같아야 하는 것은 아닙니다. 즉, 참조 테이블(buy)의 아이디 **열 이름이** user_id와 같이 기준 테이블(member)의 mem_id와 **달라도 상관없습니다**

```
-- way1
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member(
	mem_id CHAR(8) NOT NULL PRIMARY KEY,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL
);
CREATE TABLE buy(
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	user_id CHAR(8) NOT NULL,
	prod_name CHAR(6) NOT NULL,
	FOREIGN KEY(user_id) REFERENCES member(mem_id)
);

-- way2 _ ALTER TABLE에서 설정하는 외래 키 제약조건
DROP TABLE IF EXISTS buy;
CREATE TABLE buy(
	num	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	mem_id	CHAR(8) NOT NULL,
	prod_name CHAR(6) NOT NULL
);
ALTER TABLE buy
	ADD CONSTRAINT
	FOREIGN KEY(mem_id)
	REFERENCES member(mem_id);

```

---

### CASCADE


기준 테이블의 열 이름이 변경될 때 참조 테이블의 열 이름이 자동으로 변경되게 **ON UPDATE CASCADE**

기준 테이블의 데이터가 삭제되면 참조 테이블의 데이터도 삭제되게 **ON DELETE CASCADE**

```
ALTER TABLE buy
	ADD CONSTRAINT
	FOREIGN KEY(mem_id) REFERENCES member(mem_id)
	ON UPDATE CASCADE
	ON DELETE CASCADE;
```

---

### 고유 키 제약조건

**고유 키(Unique) 제약조건은 '중복되지 않는 유일한 값'을 입력해야 하는 조건** 입니다. 이것은 기본 키 제약조건과 거의 비슷하지만, 차이점은 고유 키 제약조건은 **NULL 값을 허용** 한다는 것입니다. NULL 값은 여러 개가 입력되어도 상관없습니다. 또, 기본 키는 테이블에 1개만 설정해야 하지만, **고유 키는 여러 개를 설정해도 됩니다.**

```
DROP TABLE IF EXISTS buy, member;
CREATE TABLE member(
	mem_id CHAR(8) NOT NULL PRIMARY KEY,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL,
	email CHAR(30) NULL UNIQUE
);

INSERT INTO member VALUES('BLK', '블랙핑크', 163, 'pink@gmail.com');
INSERT INTO member VALUES('TWC', '트와이스', 167, NULL);
INSERT INTO member VALUES('APN', '에이핑크', 164, 'pink@gmail.com');	-- 에러

-- 고유 키로 설정할 열을 NOT NULL로 지정하면 고유 키도 기본 키와 동일하게 중복도 안 되고 비어 있어도 안됨
```

---

### 체크 제약조건

**체크(Check) 제약조건은 입력되는 데이터를 점검하는 기능** 을 합니다. 예를 들어 평균 키(height)에 마이너스 값이 입력되지 않도록 하거나, 연락처의 국번에 02, 031, 041, 055 중 하나만 입력되도록 할 수 있다.

```
DROP TABLE IF EXISTS member;
CREATE TABLE member(
	mem_id CHAR(8) NOT NULL PRIMARY KEY,
	mem_name VARCHAR(10) NOT NULL,
	height TINYINT UNSIGNED NULL CHECK(height >= 100),
	phone1 CHAR(3) NULL
);
INSERT INTO member VALUES('BLK', '블랙핑크', 163, NULL);
INSERT INTO member VALUES('TWC', '트와이스', 99, NULL);		-- 에러

ALTER TABLE member ADD CONSTRAINT CHECK(phone1 IN('02', '031', '032', '054', '055', '061'));

INSERT INTO member VALUES('TWC', '트와이스', 167, '02');
INSERT INTO member VALUES('OMY', '오마이걸', 167, '010');		-- 에러
```

---

### 기본값 정의

**기본값(Default)** 정의는 값을 입력하지 않았을 때 **자동으로 입력될 값을 미리 지정해 놓는 방법** 이다.

```
DROP TABLE IF EXISTS member;
CREATE TABLE member(
	mem_id	CHAR(8) NOT NULL PRIMARY KEY,
	mem_name VARCHAR(10) NOT NULL,
	height	TINYINT UNSIGNED NULL DEFAULT 160,
	phone1	CHAR(3) NULL
);

ALTER TABLE member ALTER COLUMN phone1 SET DEFAULT '02';

INSERT INTO member VALUES('RED', '레드벨벳', 161, '054');
INSERT INTO member VALUES('SPC', '우주소녀', default, default);
SELECT * FROM member;

-- INSERT INTO member(mem_id, mem_name) VALUES('aaa', '하하하');
-- SELECT * FROM member;
```

---

### 널 값 허용

**널(Null) 값을 허용하려면 생략하거나 NULL을 사용하고, 허용하지 않으려면 NOT NULL을 사용합니다.**

다만 PRIMARY KEY가 설정된 열에는 NULL 값이 있을 수 없으므로 생략하면 자동으로 NOT NULL로 인식됩니다. NULL 값은 '아무 것도 없다'라는 의미입니다. 공백(' ')이나 0과는 다르다는 점에 주의하세요.

NULL은 빈 값을 허용, NOT NULL은 빈 값을 허용하지 않는다는 의미입니다.


