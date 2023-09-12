-- Active: 1693992872757@@127.0.0.1@3306@haksa

CREATE TABLE sample62(no int, a varchar(10));
INSERT INTO sample62 VALUES(2, 'ABC');
INSERT INTO sample62 VALUES(1, 'DEF');
INSERT INTO sample62 VALUES(100, 'GHI');
INSERT INTO sample62 VALUES(3, 'JKL');
INSERT INTO sample62 VALUES(101, 'MNO');

select * from sample62;

-- 인덱스 작성하기
CREATE INDEX isample62 ON sample62(no);

-- 인덱스 보기
SHOW INDEX FROM sample62;

-- 인덱스 삭제하기
DROP INDEX isample62 ON sample62;

CREATE INDEX isample62 ON sample62(a);
SELECT * FROM sample62 WHERE a = 'a';
SELECT * FROM sample62 WHERE a = 'MNO';

-- EXPLAIN + 확인하고 싶은 SELECT 명령 등의 SQL 명령을 지정
-- 다만 해당 SQL 명령은 실제로는 실행 X, just 어떤 상태로 실행되는 지를 데이터베이스가 설명해줌
EXPLAIN SELECT * FROM sample62 WHERE a = 'a';
EXPLAIN SELECT * FROM sample62 WHERE a = 'MNO';
EXPLAIN SELECT * FROM sample62 WHERE a = 'MNO' or a= 'a';
EXPLAIN SELECT * FROM sample62 WHERE no > 10;

