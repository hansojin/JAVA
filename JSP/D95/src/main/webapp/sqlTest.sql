-- Active: 1693992872757@@127.0.0.1@3306@myjsp
CREATE TABLE mem(
name VARCHAR(20) NOT NULL,
id varchar(20) PRIMARY KEY,
nickname VARCHAR(20) NOT NULL, 					#nickname VARCHAR(20) UNIQUE,
pw VARCHAR(20) NOT NULL,
email varchar(50) NOT NULL,
postcode VARCHAR(6) NOT NULL,
roadAddress VARCHAR(40) NOT NULL,
jibunAddress VARCHAR(40) NOT NULL,
detailAddress VARCHAR(40) NOT NULL,
extraAddress VARCHAR(40) NOT NULL,
birthYear INT NOT NULL,
birthMonth INT NOT NULL,
birthDate INT NOT NULL,
cellphone CHAR(11) NOT NULL,
gender CHAR(6) NOT NULL
);

select * from mem;

create table memboard(
	no int auto_increment primary key,
	id varchar(20) not null,
	title varchar(100) not null,
	contents text not null,
	hit int not null default 0,
	wtime timestamp not null default CURRENT_TIMESTAMP,
	groupNum int not null default 0,
	stepNum int not null default 0,
	indentNum int not null default 0,
    foreign key (id) references member (id) on delete cascade
);

select * from memboard;

-- 페이징 > limit 시작위치, 반환갯수;
-- "select * from board order by num desc limit " + curPage*sizeOfPage + ", " + sizeOfPage;

