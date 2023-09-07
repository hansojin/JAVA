-- Active: 1693992872757@@127.0.0.1@3306@haksa

select * from student;

-- STUDENT 테이블로부터 성별이 남자인 각 학생의 학번, 이름, 영문이름, 학년, 
-- 주민등록번호를 영문이름 순서로 출력하라.
select stu_no, stu_name, stu_ename, grade, id_num
from student
where substring(id_num,8,1)=1 
order by stu_ename asc;

-- 학년이 1학년이고 성별이 남자인 각 학생의 학번과 이름을 출력하는데, 
-- 출력 순서는 학번 내림차순
select stu_no,stu_name
from student
where grade=1 
    and substring(id_num,8,1)=1
order by stu_no desc;

-- 교과목 테이블에 관한 모든 정보를 출력
select * from subject;

-- 교과목 중 운영체제의 생성년도를 2006년으로 변경하라
update subject 
set create_year = 2006
where sub_name='운영체제'

-- "SAMPLE"이라는 테이블의 모든 행을 삭제
delete from sample;
-- sample 테이블의 모든 정보를 완전히 없애버릴때는 
DROP TABLE SAMPLE;

-- 학적 테이블의 학번, 이름, 나이로 구성된 AGES 뷰 테이블을 생성
create view ages (stu_no, stu_name, age)
as 
select stu_no,stu_name, (year(now()) - birth_year+1) 
from student;

select * from ages;

drop view ages;

-- sol2
create view agess as
    select stu_no, stu_name, year(now()) - birth_year +1 as age
    from student

select * from agess;

drop view agess;

-- sol3
create view agesss as
    select stu_no, stu_name, year(now()) - birth_year +1 'age'
    from student

select * from agesss;

