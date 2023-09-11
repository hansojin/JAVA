-- Active: 1693992872757@@127.0.0.1@3306@haksa
CREATE TABLE sample54(no int AUTO_INCREMENT PRIMARY KEY, a int);
INSERT INTO sample54 (a) values(100);
INSERT INTO sample54 (a) values(90);
INSERT INTO sample54 (a) values(20);
INSERT INTO sample54 (a) values(80);

SELECT * FROM sample54;
SELECT MIN(a) FROM sample54;


DELETE FROM sample54 WHERE a = (SELECT MIN(a) FROM sample54); 	# MySQL Error

-- table 명에는 ' '을 넣으면 에러 발생 (추측)
-- 그래서 x는 그냥 써야해
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) AS a FROM SAMPLE54) AS x);
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) a FROM SAMPLE54) x );
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) 'a' FROM SAMPLE54) x );
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) as 'a' FROM SAMPLE54) as x);

-- 아래 처럼 적으면 모든 행이 날아감
-- 왜냐면, 원본 테이블에 조건을 만족하는 열(=b)이 없으니 전체가 삭제되는거야
-- 그러니 별칭을 똑같이 적어주자
DELETE FROM sample54 WHERE a = (SELECT a FROM (SELECT MIN(a) as b FROM SAMPLE54) as x);



-------------------------------------------------

SELECT * FROM sample54;
-- 패턴 ① 하나의 값을 반환하는 패턴
SELECT MIN(a) FROM sample54;

-- 패턴 ② 복수의 행이 반환되지만 열은 하나인 패턴
SELECT no FROM sample54;

-- 패턴 ③ 하나의 행이 반환되지만 열이 복수인 패턴
SELECT MIN(a), MAX(no) FROM sample54;

-- 패턴 ④ 복수의 행, 복수의 열이 반환되는 패턴
SELECT no, a FROM sample54;

--------------------------------

-- nested
SELECT * FROM(SELECT * FROM sample54) AS sq;
SELECT * FROM (SELECT * FROM (SELECT * FROM sample54) sq1) sq2;



----- EXISTS ----------------------------------

CREATE TABLE sample551(no int, a char(10));
INSERT INTO sample551 VALUES(1, NULL);
INSERT INTO sample551 VALUES(2, NULL);
INSERT INTO sample551 VALUES(3, NULL);
INSERT INTO sample551 VALUES(4, NULL);
INSERT INTO sample551 VALUES(5, NULL);

CREATE TABLE sample552(no2 int);
INSERT INTO sample552 VALUES(3);
INSERT INTO sample552 VALUES(5);

select * from sample551;
select * from sample552;

UPDATE sample551 SET a = '있음' WHERE 
	EXISTS(SELECT * FROM sample552 WHERE no2 = no);

UPDATE sample551 SET a = '없음' WHERE
	NOT EXISTS(SELECT * FROM sample552 WHERE no2 = no);

-----  IN  ----------------------------     

SELECT * FROM sample551 WHERE no IN (3, 5);
SELECT * FROM sample551 WHERE no IN (SELECT no2 FROM sample552);

select * from sample551;
SELECT * FROM SAMPLE551 WHERE NO IN(3, 5);
SELECT * FROM SAMPLE551 WHERE NO NOT IN(3, 5);