-- Active: 1693992872757@@127.0.0.1@3306@testdb
create table user(
userName varchar(20),
userAge int,
userGender varchar(20),
userEmail varchar(40));

insert into user values('이진기', 30, '남자',  'jinki@shine.com');
insert into user values('김종현', 29, '남자',  'bling@shine.com');
insert into user values('김기범', 28, '남자',  'key@shine.com');
insert into user values('최민호', 28, '남자',  'minho@shine.com');
insert into user values('이태민', 26, '남자',  'adorable@shine.com');
insert into user values('태연', 30, '여자',  'eleven@shine.com');
insert into user values('소정', 31, '여자', 'always@shine.com');

select * from user;
SELECT * FROM user WHERE userName like "%%";

#SET SQL_SAFE_UPDATES = 0;