-- Active: 1693992872757@@127.0.0.1@3306@haksa

-- 현재 사용자/DB 확인
select user();

select DATABASE();

-- 화면 지우기
system cls;

-- 사용자 ID를 "sky", 암호(PASSWORD) "sky1234"로 생성하시오.
create user sky identified by 'sky1234';

-- 사용자 "sky"의 암호를 "sky5678"로 변경하시오.
alter user 'sky' identified with mysql_native_password by 'sky5678';

-- 사용자 "SKY"에게 모든 데이터베이스를 관리할 수 있는 모든 권한을 부여하시오
grant all PRIVILEGES on *. * to sky;

-----------------------------------------------------------------------

create table zerotest( 
    seq int AUTO_INCREMENT PRIMARY KEY,
    fz1 int(1) zerofill,
    nz1 int(1),
    fz2 int(2) zerofill,
    nz2 int(2),
    fz3 int(3) zerofill,
    nz3 int(3) 
);

insert zerotest value(1,1,1,1,1,1,1);

select * from zerotest;

--------------------------------------

-- student 테이블과 동일한 테이블 구조와 데이터를 가지고 있는 student1 테이블을 복사
create table student1 as 
    select * 
    from student;

-- post 테이블에서 post_no와 post_address로 구성된 신규 post1 테이블을 생성하라
create table post1 as
    select post_no, post_address 
    from post;

-- "post1" 테이블을 "postt" 테이블명으로 변경하라.
alter table post1 rename postt;

----------------------------------------------------

--뷰 만들기
create view profView 
as select prof_name, `Create_date`
from professor
where substring(`Create_date`,1,4)>1999;

select * from profView;

drop view profView;

--뷰 만들기2
create view profView2 
as 
select prof_name 'name', Create_date 'date'
from professor
where substring(`Create_date`,1,4)>1999;

select * from profView2;
drop view profview2;

--뷰 만들기3
create view profView3 (name, date)
as 
select  prof_name, `Create_date`
from professor
where substring(`Create_date`,1,4)>1999;

select * from profView3;

------ 뷰 목록 조회 --------

show full tables in haksa;

show full tables in haksa where Table_type like 'VIEW';

select TABLE_NAME,`TABLE_TYPE` 
from information_schema.TABLES
where `TABLE_TYPE` like 'VIEW'
    and `TABLE_SCHEMA` like 'haksa'



-------------- 쿼리결과가 길때 -------------
select * from student

select * from student\g