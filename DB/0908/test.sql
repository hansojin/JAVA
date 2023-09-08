-- Active: 1693992872757@@127.0.0.1@3306@haksa

CREATE TABLE sample34(no int, price int, quantity int);
INSERT INTO SAMPLE34 VALUES(1, 100, 10);
INSERT INTO SAMPLE34 VALUES(2, 230, 24);
INSERT INTO SAMPLE34 VALUES(3, 1980, 1);
select * from sample34;

-- SELECT 구에서 식에 별명 붙이기
SELECT *, price * quantity AS amount FROM sample34;
SELECT *, price * quantity AS amount FROM sample34 WHERE price * quantity >= 2000;

-- NULL 값의 연산 ------------------------------------------------------------
-- 다음 연산결과는 모두 NULL 이다.
select null+1;
select 2*null;
select 1/null;

-- DECIMAL--------------------------------------------------------------
SELECT 10%3;
SELECT MOD(10, 3);

CREATE TABLE sample341(amount decimal(7, 2));
INSERT INTO sample341 VALUES(5961.60);
INSERT INTO sample341 VALUES(2138.40);
INSERT INTO sample341 VALUES(1080.00);
select * from sample341

-- ROUND 반올림
SELECT amount, ROUND(amount) FROM sample341;

-- ROUND 함수의 두 번째 인수를 지정해, 소수점 둘째 자리를 반올림
SELECT amount, ROUND(amount, 1) FROM sample341;

-- ROUND 함수의 두 번째 인수를 지정해 10단위를 반올림
SELECT amount, ROUND(amount, -2) FROM sample341;

----------------------------------------------------------------------

CREATE TABLE sample35(no int, price int, quantity int, unit char(10));
INSERT INTO sample35 VALUES(1, 100, 10, '개');
INSERT INTO sample35 VALUES(2, 230, 24, '캔');
INSERT INTO sample35 VALUES(3, 1980, 1, '장');

select * from sample35

-- 문자열 결합으로 단위를 연결해 결과 얻기
SELECT CONCAT(quantity, unit) FROM sample35;

-- 공백추가
SELECT CONCAT(quantity,' ', unit) FROM sample35;

-- 자리수 추출 SUBSTRING

-- 앞 4자리(년) 추출
SELECT SUBSTRING('20140125001', 1, 4);		# 2014

--5째 자리부터 2자리(월) 추출
SELECT SUBSTRING('20140125001', 5, 2);		# 01

-- TRIM 함수

SELECT LENGTH('  ABC     ');    # 10
SELECT LENGTH(TRIM('  ABC     '));  #3

-----------------------------------------------------------------

CREATE TABLE sample41(
no int,
a varchar(10),
b date
);

select * from sample41;

insert into sample41 values(1, "ABC", "2014-01-25");
insert into sample41 (no, a) values(2, "XYZ");

-- 값이 NULL인 것을 검색할려면 
SELECT * FROM sample41 WHERE b IS NULL;

-- 컬럼 b의 값이 NULL인 것을 모두 '2014-09-07'로 변경할려면
UPDATE sample41 SET b = '2014-09-07' WHERE b IS NULL;

-- 모든 행의 번호에 1을 더한다.
UPDATE sample41 SET no = no + 1;

-- 복수열 갱신
UPDATE sample41 SET a = 'xxx', b = '2014-01-01' WHERE no = 2;

-- 물리삭제와 논리삭제 -----------------------------------------------------------

CREATE TABLE sample42(
no int AUTO_INCREMENT PRIMARY KEY,
a varchar(10),
flag int default 0
);

INSERT INTO sample42(a) values('ABC');
INSERT INTO sample42(a) values('XYZ');
INSERT INTO sample42(a) values('GHI');
INSERT INTO sample42(a) values('JKL');

SELECT * FROM sample42;

CREATE TABLE SAMPLE421(
no INT AUTO_INCREMENT PRIMARY KEY,
a DATETIME DEFAULT CURRENT_TIMESTAMP,
b varchar(10)
);

INSERT INTO sample421(b) VALUES('HI');
INSERT INTO sample421(b) VALUES('GOOD');
INSERT INTO sample421(b) VALUES('NICE');

SELECT * FROM sample421;

insert into sample421 VALUES(100,'2023-09-08 16:02:22','HI');
INSERT INTO sample421(b) VALUES('TEST');    # 100 다음이라 101 

---- COUNT ---------------------------------------------------

CREATE TABLE sample51(no int, name char(3), quantity int);
INSERT INTO sample51 VALUES(1, 'A', 1);
INSERT INTO sample51 VALUES(2, 'A', 2);
INSERT INTO sample51 VALUES(3, 'B', 10);
INSERT INTO sample51 VALUES(4, 'C', 3);
INSERT INTO sample51 VALUES(5, NULL, NULL);

SELECT COUNT(*) FROM sample51;
SELECT COUNT(*) FROM sample51 WHERE name = 'A'; 

-- 집계함수는 집합 안에 NULL 값이 있을 경우 무시한다
SELECT COUNT(no), COUNT(name) FROM sample51;    # 5 4

-- DISTINCT로 중복 제거 -------------

select * from sample51;
SELECT ALL name FROM sample51;  # 아래랑 동일
SELECT name FROM sample51;

SELECT DISTINCT name FROM sample51; # null 도 포함

---------------------------------
-- SUM 집계함수도 COUNT와 마찬가지로 NULL 값을 무시
SELECT SUM(quantity) FROM sample51;

-- AVG 집계함수도 NULL 값은 무시
SELECT AVG(quantity), SUM(quantity) / COUNT(quantity) FROM sample51;
-- 만약 NULL을 0으로 간주해서 평균을 내고 싶다면 CASE를 사용해 NULL을 0으로 변환한 뒤에 AVG 함수로 계산
SELECT AVG(CASE WHEN quantity IS NULL THEN 0 ELSE quantity END) AS avgnull0 FROM sample51;

SELECT AVG(IFNULL(quantity, 0)) AS avgnull0 FROM sample51;

SELECT MIN(quantity), MAX(quantity), MIN(name), MAX(name) FROM sample51;

--- 그룹화 - GROUP BY -------------------------------------------------------------

select * from sample51;
SELECT name, COUNT(name), sum(quantity) FROM sample51 GROUP BY name;

SELECT MIN(no), name, SUM(quantity) FROM sample51 GROUP BY name;

SELECT name, quantity FROM sample51 GROUP BY name, quantity;

--- 시스템 날짜 -------------------------------------------------------------

SELECT CURRENT_TIMESTAMP;

SELECT now();

SELECT DATE_FORMAT(now(), '%Y/%M/%D');
SELECT DATE_FORMAT(now(), '%Y/%m/%D');

-- 날짜형 간의 뺄셈

SELECT DATEDIFF('2014-02-28', '2014-01-01');

-- 시스템 날짜의 1일 후를 검색
SELECT CURRENT_DATE + INTERVAL 1 DAY;



create table sample111(
	a int auto_increment primary key, 
	b timestamp default current_timestamp on update current_timestamp, 
	c varchar(20)
);

select * from sample111;
insert into sample111(c) values('haha');     
update sample111 set c='hoho';   
  
-- 날짜 및 시간 관련 함수 ------------------

-- 현재 날짜와 시간을 반환
select sysdate(), now();
-- 현재 날짜를 반환
select curdate(), current_date();

-- 현재 시간을 반환
select curtime(), current_time();

-- 년,월 반환
select year(now()), month(now());

-- 몇일인지를 리턴
select dayofmonth(now());
-- 숫자로 요일을 리턴 한다.(0 = Monday, 1 = Tuesday,..... 6 = Sunday)
select dayofweek(now());

-- 요일의 이름을 반환하는 함수
SELECT DAYNAME(now());

-- 1년 중 며칠이 지났는가를 리턴
select dayofyear(now());

-- date_add 함수는 날짜에서 기준값만큼 더한 값이고 
-- date_sub 함수는 날짜에서 기준값 만큼 뺀값
-- (기준값 : YEAR, MONTH, DAY, HOUR, MINUTE, SECOND)
select date_add(now(), interval 3 day), date_sub(now(), interval 3 day);



