-- Active: 1693992872757@@127.0.0.1@3306@haksa

select * from fee;

-- 등록금 총액을 변경하라.
update fee
SET
    fee_total = ifnull(fee_enter,0) + fee_price;

-- 납입금 총액은 "등록금 총액 - 장학금 총액"이다. 납입금 총액을 변경하라.
update fee
set 
    fee_pay = fee_total - IFNULL(jang_total,0);

-- 재학생들의 등록 금액에 비례한 장학금의 비율은 몇 % 인가?
select fee_total "등록금액", jang_total "장학금액", round(ifnull(jang_total, 0) / fee_total*100, 2) "비율" from fee;

-- 우편번호가 150-051 인 동이름과 지역전화번호(동이름과 지역번호는 합쳐서)를 출력하라.

select * from post;

select post_no, CONCAT(post_dong,ddd)
from post
where post_no= '150-051';

----------------------------------

select round(123456.789, 2), truncate(123456.789, 2);

select round(12345678.901, -3), truncate(12345678.901, -3);

select floor(123456.789), ceil(123456.123);

select mod(10, 3), mod(5, 8);

select abs(124), abs(-124);

select pow(2,4), pow(-2.5, 2), pow(1.5, 6);

select greatest(15, 45, 32, 65), least(15, 45, 32, 65);

select concat('Data', 'Base');
select substring('Korea', 1, 3);
select length('lee_woo');
select instr('Korea', 'e');
select lpad('Korea', 15, '*');
select rpad('Korea', 15, '#');
select lower('Korea');
select upper('Korea');
-- select initcap('KOREA UNIVERSITY');  # in oracle _ Korea university

---------------------------------------------------

-- 학번이 20001001인 학생의 학번, 이름, 영문이름을 출력하라. 단, 영문이름은 대문자로 출력
select stu_no, stu_name, upper(stu_ename) "stu_ENAME"
from student
where stu_no ='20001001';

-- 2학년 학생의 번호와 이름, 영문이름 그리고 영문이름의 길이를 나타내어라.
SELECT stu_no, stu_name, stu_ename, length(rtrim(stu_ename)) "lenNAME"
from student
where grade=2;

-- 영문이름의 길이가 정확히 12자인 각 학생의 번호와 영문이름을 출력하라
select stu_no, stu_ename 
from student 
where length(rtrim(stu_ename)) = 12;

-- 현주소의 우편번호가 "550"으로 시작하는 전남 여수시에 거주하는 학생의 학번과 이름, 우편번호를 나타내어라.
SELECT stu_no, stu_name, post_no
from student
where substring(post_no,1,3)=550;

-- 학번이 '20001021'인 학생의 학번과 이름, 우편번호, 주소를 출력하라.
-- 단, 주소출력에는 공백 부분을 삭제하여 출력하고 concat함수를 이용한다.
select * from post;
select * from student;

select s.stu_no, s.stu_name, s.post_no, 
    concat(rtrim(p.post_address),rtrim(s.address)) "adrs"
from student s, post p
where stu_no=20001021 
    and s.post_no=p.post_no;

-- inner join syntax
select s.stu_no, s.stu_name, s.post_no, 
    concat(rtrim(p.post_address),rtrim(s.address)) "adrs"
from student s
    join post p
    on s.post_no=p.post_no
where stu_no=20001021 ;
