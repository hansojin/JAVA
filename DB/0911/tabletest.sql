-- Active: 1693992872757@@127.0.0.1@3306@haksa

-- 테이블 작성.삭제.변경 ---------------------

/*
    CREATE TABLE 테이블명(열 정의1, 열 정의2, ...)
    DROP TABLE 테이블명
    ALTER TABLE 테이블명 하부명령
*/

-- 1. 테이블 작성 ---------------------
CREATE TABLE sample62(
no INTEGER NOT NULL,
a VARCHAR(30),
b DATE);

DESC sample62;

-- 2. 테이블 삭제 ---------------------

DROP TABLE sample62; 
TRUNCATE TABLE sample62; 

-- 3. 테이블 변경 ---------------------
/*
    1. 열 추가, 삭제, 변경
    2. 제약 추가, 삭제
*/
-- 테이블에 열을 추가
ALTER TABLE sample62 ADD newcol INTEGER;

--자료형이나 기본값, NOT NULL 제약 등의 속성은 변경
ALTER TABLE sample62 MODIFY newcol VARCHAR(20);

-- 열 이름 변경
ALTER TABLE sample62 CHANGE newcol c VARCHAR(20);

-- 열 삭제
ALTER TABLE sample62 DROP c;

-- cf. 최대길이 연장
-- 기존의 행에 존재하는 데이터의 길이보다 작게 지정할 수는 없다.(문법적으로는 가능)
-- 작게 지정하면 저장된 데이터의 일부가 잘려나가므로 에러가 발생하기 때문
