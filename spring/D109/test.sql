-- Active: 1693992872757@@127.0.0.1@3306@springdb
CREATE TABLE BOARD(
SEQ INT AUTO_INCREMENT PRIMARY KEY,
TITLE VARCHAR(200),
WRITER VARCHAR(20),
CONTENT VARCHAR(2000),
REGDATE DATETIME DEFAULT CURRENT_TIMESTAMP,
CNT INT DEFAULT 0
);

CREATE TABLE USERS(
    ID VARCHAR(8) PRIMARY KEY,
    PASSWORD VARCHAR(8),
    NAME VARCHAR(20),
    ROLE VARCHAR(5)
);

INSERT INTO USERS VALUES('test', 'test123', '관리자', 'Admin');
INSERT INTO USERS VALUES('user1', 'user1', '홍길동', 'User');

INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES(1, '가입인사', '관리자', '안녕');

SELECT * FROM USERS;
SELECT * FROM BOARD;