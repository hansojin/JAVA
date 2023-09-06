## 기본 SQL query문 

### SELECT

```
SELECT 컬럼 FROM 테이블

SELECT 컬럼 FROM 테이블 WHERE 조건

SELECT 컬럼 FROM 테이블 WHERE 조건 ORDER BY 컬럼 ASC or DESC

SELECT 컬럼 FROM 테이블 WHERE 조건 ORDER BY 컬럼 ASC or DESC LIMIT 개수
```

### INSERT

```
INSERT INTO 테이블 (컬럼..) VALUES(값..)

INSERT INTO 테이블 VALUES (모든 값..)
```

### UPDATE

```
UPDATE 테이블 SET 컬럼 = 변경할 값

UPDATE 테이블 SET 컬럼 = 변경할 값 WHERE 조건

UPDATE 테이블 SET 컬럼1 = 변경1, 칼럼2 = 변경2 WHERE 조건
```

### DELETE

```
DELETE FROM 테이블

DELETE FROM 테이블 WHERE 조건
```

----

### 데이터베이스 다루기

```
# 모든 DB 조회
    SHOW DATABASES;
# DB 생성
    CREATE DATABASE DB;
# DB 삭제
    DROP DATABASE DB;
# 해당 DB로 이동
    USE DB;
```

### 테이블 다루기

```
# 테이블 조회
    SHOW TABLES;
# 테이블 구조 확인
    DESC TB;
# 테이블 생성
    CREATE TABLE TB( 
        ... 
    ); 
# 테이블 삭제
    DROP TABLE TB;
```