-- Active: 1693992872757@@127.0.0.1@3306@market_db
use market_db;

-- 테이블1의 index 정보를 확인하자.
CREATE TABLE table1
(
	col1 INT PRIMARY KEY,
	col2 INT,
	col3 INT
);
SHOW INDEX FROM table1;

-- 테이블2의 index 정보를 확인하자.
CREATE TABLE table2
(
col1 INT PRIMARY KEY,
col2 INT UNIQUE,
col3 INT UNIQUE
);
SHOW INDEX FROM TABLE2;

---------------------------------------------------------

-- 다음을 실행하고 실행결과를 보자.

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

SELECT * FROM member;       -- 입력순서대로 출력

-- member 테이블에 mem_id를 기본키로 만들자.
ALTER TABLE member
	ADD CONSTRAINT
	PRIMARY KEY (mem_id);

SELECT * FROM member;       -- mem_id를 기준으로 정렬

-- member 테이블의 기본키를 삭제하고 mem_name을 기본키로 하자.

ALTER TABLE member DROP PRIMARY KEY;
ALTER TABLE member
	ADD CONSTRAINT
	PRIMARY KEY(mem_name);
SELECT * FROM member;       -- mem_name을 기준으로 정렬

-- 다음 내용을 실행하고 결과를 보자.

INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울');
SELECT * FROM member;       -- mem_name을 기준으로 정렬

-- 다음을 실행하자.
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
SELECT * FROM member;           -- 입력 순 정렬

-- 그리고 member 테이블의 mem_id를 고유키로 하자.

ALTER TABLE member
	ADD CONSTRAINT
	UNIQUE (mem_name);
SELECT * FROM member;       -- mem_name 열을 고유 키로 추가 설정해도 데이터의 순서에는 변화가 없다.

INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울');
SELECT * FROM member;       --데이터가 제일 뒤에 추가됨


-- 클러스터형 테이블 
CREATE TABLE cluster  ( 
    mem_id      CHAR(8) , 
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
SELECT * FROM cluster;      -- 넣은 순서대로 정렬

-- cluster 테이블에 mem_id를 기본키로 하자.
ALTER TABLE cluster
    ADD CONSTRAINT 
    PRIMARY KEY (mem_id);

SELECT * FROM cluster;  -- 기본 키로 지정하면 클러스터형 인덱스가 생성되고 데이터가 자동으로 정렬

-- 보조 인덱스 테이블 
CREATE TABLE second  ( 
    mem_id      CHAR(8) , 
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

-- second 테이블에 mem_id에 고유키로 하자.
ALTER TABLE second
    ADD CONSTRAINT 
    UNIQUE (mem_id);

SELECT * FROM second;   -- 넣은 대로 정렬

-- 보조 인덱스를 구성하면 인덱스가 별도의 공간에 만들어짐. (책의 맨 뒤 찾아보기 처럼)

---------------------------------------

-- member 테이블의 인덱스를 확인하자.
USE market_db;
SELECT * FROM member;
SHOW INDEX FROM member;
-- member 테이블에 인덱스가 얼마나 용량을 차지하고 있는지 확인하자. 
-- 결과 중에 Data_length는  클러스터형 인덱스(또는 데이터)의 크기를 Byte 단위로 표기한 거
-- 그런데 MySQL의 1페이지 크기는 기본적으로 16KB이므로 클러스터형 인덱스는 16384/(16*1024) = 1 페이지가 할당되어 있음
-- Index_length는 보조 인덱스의 크기인데 member는 보조 인덱스가 없기 때문에 표기되지 않음
SHOW TABLE STATUS LIKE 'member';

-- member 테이블의 주소(addr)에 중복을 허용하는 단순 보조 인덱스를 생성.
CREATE INDEX idx_member_addr ON member(addr);

-- member 테이블의 인덱스를 확인하자.
SHOW INDEX FROM member;

-- member 테이블의 전체 인덱스의 크기를 확인하자.
SHOW TABLE STATUS LIKE 'member';

--바로 앞에서 보조 인덱스 idx_member_addr이 생성된 것을 확인했는데, 생성한 인덱스를 실제로 적용시키려면 ANALYZE TABLE 문으로 먼저 테이블을 분석/처리해줘야 보조 인덱스가 생성된 거 확인 가능
ANALYZE TABLE member;
SHOW TABLE STATUS LIKE 'member';

-- member 테이블의 기본키를 삭제하자.
ALTER TABLE member DROP PRIMARY KEY;

-- 오류 발생
-- member의 mem_id 열을 buy가 참조하고 있기 때문
-- 기본 키를 제거하기 전에 외래 키 관계를 제거해야 함

-- 구매(buy) 테이블의 외부키를 삭제하고  member 테이블의 기본키를 삭제
ALTER TABLE buy DROP FOREIGN KEY buy_ibfk_1;
ALTER TABLE member DROP PRIMARY KEY;
