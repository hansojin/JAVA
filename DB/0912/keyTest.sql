-- Active: 1693992872757@@127.0.0.1@3306@haksa

-- between ----------------------------------------------
create table sample200(
    no int
);
INSERT INTO sample200 (no) VALUES
(1),(2),(3),(4),(5),(6),(7);

select * from sample200;

select * from sample200 where no in (3,4,5);
select * from sample200 where no between 3 and 5;
select * from sample200 where no >=3 and no <=5;

-- PK UNIQUE ------------------------------------------------------

create table sample631(
    a int not null,
    b int not null,
    c varchar(10)
);
DESC sample631;

-- PK로 지정한게 없으면 b가 PK가 됌 
alter table sample631 add unique(b);

/*
 < PRIMARY KEY > 
유일한 레코드를 만들려면 다른 컬럼과 구별하고자 특별한 속성을 설정해야 한다.
특징 : X 중복, not null, 고유 인식번호

 < UNIQUE KEY > 
 특징 : X 중복, O null
*/

CREATE TABLE sample632(
    no INTEGER NOT NULL,
    sub_no INTEGER NOT NULL,
    name VARCHAR(30),
    PRIMARY KEY(no, sub_no)
);
DESC sample632;

-- 기존 테이블에도 나중에 제약을 추가할 수 있다.
-- 이때 열 제약과 테이블 제약은 조금 다른 방법으로 추가됨

-- 열 제약 추가 : ALTER TABLE ------------------------
ALTER TABLE sample631 MODIFY c VARCHAR(30) NOT NULL;
DESC sample631;

-- 기본키는 테이블에 하나만  설정할 수 있다.
-- 이미 기본키가 설정되어 있는 테이블에 추가로 기본키를 작성할 수는 없다.
-- 아래는, B가 unique라 pk로 임의로 설정되어 있었기 때문에 가능한 쿼리문
ALTER TABLE sample631 ADD CONSTRAINT PRIMARY KEY(a);
DESC sample631;

-- 열 제약 삭제하기 -------------------------------------
-- 사실 그냥 다시 modfiy로 수정하는거임
alter table sample631 modify c varchar(30);

-- 한편 테이블 제약은 ALTER TABLE의 DROP 하부명령으로 삭제할 수 있다. 
-- 제약키 조회
SELECT constraint_name, constraint_type 
FROM information_schema.table_constraints 
WHERE table_name = 'sample631';

-- 테이블 제약 삭제하기
-- 기본키 제약 삭제하기
alter table sample631 drop Primary Key;
-- 그럼 A의 PK가 사라지니까, 다시 uniuqe였던 b가 PK가 됨

-------------------------------------------------------------------

CREATE TABLE sample634(
    p INTEGER NOT NULL,
    a VARCHAR(30),
    PRIMARY KEY(p)
);

INSERT INTO sample634 VALUES(1, '첫째줄');
INSERT INTO sample634 VALUES(2, '둘째줄');
INSERT INTO sample634 VALUES(3, '셋째줄');

select * from sample634;

-- PK는 중복 불가능. 아래는 에러
insert into sample634 values(1,'error');
 
-- 복수 열로 기본키 지정하기 ------------------------------
CREATE TABLE sample635(
    a int,
    b int,
    CONSTRAINT PRIMARY KEY(a, b)
);

DESC sample635;
INSERT INTO sample635 values(1, 1);
INSERT INTO sample635 values(1, 2);
INSERT INTO sample635 values(1, 3);
INSERT INTO sample635 values(2, 1);
INSERT INTO sample635 values(2, 2);
select * from sample635;
-- 위에서 a열만을 봤을 때는 중복하는 값이 있지만, 
-- b열이 다르면 키 전체로서는 중복하지 않는다고 간주되기 때문에 기본키 제약에 위반되지 않는다

-- 중복된 데이터 에러
INSERT INTO sample635 values(1, 1);	