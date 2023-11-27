create table mvcboard (
no int auto_increment primary key,
name varchar(20),
title varchar(100),
contents text,
wtime timestamp not null default CURRENT_TIMESTAMP,
hit int default 0,
groupNum int,
stepNum int default 0,
indentNum int default 0);

select * from mvcboard order by groupNum desc, indentNum asc, no desc;

drop table mvcboard;

insert into mvcboard (name,title,contents,hit) values("KIM","JONG","HYUN",948);