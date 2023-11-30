
create table bulletin (
no int auto_increment primary key,
id varchar(20),
tel varchar(20),
name varchar(20),
title varchar(100),
contents text,
wtime timestamp not null default CURRENT_TIMESTAMP,
hit int default 0,
groupNum int,
indentNum int default 0);

select * from bulletin order by groupNum desc, indentNum asc, no desc;

drop table bulletin;

insert into bulletin (name,title,contents,hit) values("KIM","JONG","HYUN",948);

create table member (
name varchar(20),
id varchar(20) primary key,
pw varchar(20),
nickname varchar(30),
tel varchar(20),
email varchar(40),
postcode varchar(10),
roadAddress varchar(100),
jibunAddress varchar(100),
detailAddress varchar(100),
extraAddress varchar(100),
bYear varchar(10),
bMonth varchar(10),
bDay varchar(10),
sex varchar(10)
);

select * from member;

drop table member;

select count(*) from member where id = 'test' and pw = 'test';

select * from Member where id = 'test'