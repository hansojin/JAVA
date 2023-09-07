-- Active: 1693992872757@@127.0.0.1@3306@haksa

# 인사 테이블 생성
create table insa(
    bunho int auto_increment,
    name char(8) not null,
    e_name char(10) not null,
    town char(6) not null,
    primary key(bunho)
);

# 데이터 삽입
insert into insa values(1, '홍길동', 'Hong', '순천');
insert into insa values(2, '제갈공명', 'Je', '여수');
insert into insa values(3, '순자', 'Soon', '부산');
insert into insa values(4, '이순신', 'Lee', '여수');
insert into insa(name, e_name, town) values('배트맨', 'batman', '고담');

# 데이터 확인
select * from insa;

# 인사 테이블 내용 변경
update insa set town = '여수' where bunho = 4;
update insa set town = '한양' where bunho = 1;

# savepoint 설정 
SAVEPOINT aa;

# savepoint 확인
delete from insa where bunho=3;
rollback to aa;

# COMMIT / ROLLBACK
set autocommit = 0;
# 1은 활성화 0은 비활성화
select @@autocommit;
# on은 활성화 off는 비활성화
show variables like 'autocommit';

commit;
rollback;

set autocommit = 1;

# 인사 테이블 삭제 처리
truncate table insa;







