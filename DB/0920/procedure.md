## Stored Procedure

**Stored Procedure** 는 MySQL에서 프로그래밍 기능이 필요할 때 사용하는 데이터베이스 개체이다.

SQL 프로그래밍은 기본적으로 스토어드 프로시저 안에 만들어야 한다.

스토어드 프로시저는 다음과 같은 구조를 갖는다.

```
DELIMITER $$
CREATE PROCEDURE 스토어드_프로시저_이름()
BEGIN
	-- 이 부분에 SQL 프로그래밍 코딩
END $$
DELIMETER ;		-- 종료 문자를 다시 세미콜론(;)으로 변경

CALL 스토어드_프로시저_이름();	-- 스토어드 프로시저 실행
```

*참고. 일반적으로 구분 문자(DELIMITER)는 $$를 많이 사용하지만, 원한다면 /, &, @등을 사용해도 상관없다. 다른 기호와 중복될 수 있으므로 기호 2개를 연속해서 사용하는 것이 좋다.*

---
#### Procedure를 정의할 때 왜 Delimiter를 사용한 걸까?

Delimiter는 직역하면 '구문 문자'로 C나 JAVA의 ';'(세미콜론)라고 생각하시면 됩니다.

즉, **문법의 끝을 나타내는 역할** 을 합니다.

Delimiter 명령어는 이러한 **구문 문자를 정의하는 기능** 을 합니다.

Delimiter 명령어를 사용하는 방법은 간단합니다.

다음과 같이 **Delimiter 명령어 뒤에 구문 문자로 사용하고자 하는 문자를 넣어주면 됩니다.**

```
mysql> DELIMITER $$
mysql> SELECT * FROM account$$
```

그럼 Procedure를 정의할 때는 왜 Delimiter를 사용했을까요?

```
mysql> DELIMITER $$ 
mysql> CREATE PROCEDURE insert_test() 
    -> BEGIN 
    -> DECLARE i INT; 
    -> SET i = 0; 
    -> WHILE i < 100000 DO 
    -> INSERT INTO account(createDatetime) VALUES(now()); 
    -> SET i = i + 1; 
    -> END WHILE; 
    -> END $$
mysql> DELIMITER ;
```

SQL문을 보시면 Procedure를 정의할 때 **내부에 세미콜론을 사용** 하는 것을 알 수 있습니다.

만약 Delimiter를 설정하지 않으면 **문장을 구분하기가 어렵기 때문에** 위와 같이 Delimiter를 세미콜론이 아닌 $$로 설정한 것입니다.

또한 마지막에 Delimiter 명령어를 다시 사용한 이유는 다시 세미콜론을 이용하여 문장을 구분하기 위해서이며 Procedure 정의에 필수적인 요소는 아닌셈입니다

---

## IF 문

IF 문의 기본 형식

```
IF <조건식> THEN
	-- SQL 문장들
END IF;
```

'SQL문장들'이 한 문장이라면 그 문장만 써도 되지만, 두 문장 이상이 처리되어야 할 때는 **BEGIN~END로 묶어줘야 한다.** 

현재는 한 문장이더라도 나중에 추가될 수 있으니 습관적으로 BEGIN~END로 묵어주는 것을 권장한다.

```
DROP PROCEDURE IF EXISTS ifProc1;

DELIMITER $$
CREATE PROCEDURE ifProc1()
BEGIN
	IF 100 = 100 THEN
		SELECT '100은 100과 같습니다.';
	END IF;
END $$
DELIMITER ;

CALL ifProc1();
```

## IF ~ ELSE문

```
DROP PROCEDURE IF EXISTS ifProc2;

DELIMITER $$
CREATE PROCEDURE ifProc2()
BEGIN
	DECLARE myNum INT;
	SET myNum = 200;
	IF myNum = 100 THEN
		SELECT '100입니다.';
	ELSE
		SELECT '100이 아닙니다.';
	END IF;
END $$
DELIMITER ;

CALL ifProc2();
```

```
DROP PROCEDURE IF EXISTS ifProc3;

DELIMITER $$
CREATE PROCEDURE ifProc3()
BEGIN
    DECLARE debutDate DATE;		-- 데뷔 일자
    DECLARE curDate DATE;		-- 오늘
    DECLARE days INT;			-- 활동한 일수
    
    SELECT debut_date INTO debutDate
		FROM market_db.member
        WHERE mem_id = 'APN';
        
    SET curDATE = CURRENT_DATE();	    -- 현재 날짜
    SET days = DATEDIFF(curDATE, debutDate);	-- 날짜의 차이, 일 단위
    
    IF (days/365) >= 5 THEN		-- 5년이 지났다면
		SELECT CONCAT('데뷔한 지 ', days, '일이나 지났습니다. 핑순이들 축하합니다!');
	ELSE
		SELECT '데뷔한 지 ' + days + '일밖에 안되었네요. 핑순이들 화이팅~';
	END IF;
END $$
DELIMITER ;

CALL ifProc3();
```

---

## 날짜 관련 함수

* CURRENT_DATE() : 오늘 날짜를 알려준다.
* CURRENT_TIMESTAMP() : 오늘 날짜 및 시간을 함께 알려준다.
* DATEDIFF(날짜1, 날짜2) : 날짜2부터 날짜1까지 일수로 몇일인지 알려준다.

```
SELECT CURRENT_DATE(), DATEDIFF('2021-12-31', '2000-1-1');

DROP procedure IF EXISTS HAHA;

DELIMITER $$
CREATE PROCEDURE HAHA()
BEGIN
	IF 100 = 100 THEN
		SELECT '100';
	ELSEIF 200 = 200 THEN
		SELECT '200';
	ELSEIF 300 = 300 THEN
		SELECT '300';
	ELSE
		SELECT '그 밖에 숫자';
	END IF;
END $$

CALL HAHA();
```

---

## CASE 문

*참고. SQL의 CASE문은 다른 프로그래밍 언어의 SWITCH ~ CASE 문과 비슷한 기능을 한다.*

```
-- CASE 문의 형식
CASE
	WHEN 조건1 THEN
		SQL 문장들1
	WEHN 조건2 THEN
		SQL 문장들2
	WHEN 조건3 THEN
		SQL 문장들3
	ELSE
		SQL 문장들4
END CASE;
```
```
DROP PROCEDURE IF EXISTS caseProc;

DELIMITER $$
CREATE PROCEDURE caseProc()
BEGIN
    DECLARE point INT;
    DECLARE credit CHAR(1);
    SET point = 88;
    
    CASE
		WHEN point >= 90 THEN
			SET credit = 'A';
		WHEN point >= 80 THEN
			SET credit = 'B';
		WHEN point >= 70 THEN
			SET credit = 'C';
		WHEN point >= 60 THEN
			SET credit = 'D';
		ELSE
			SET credit = 'F';
	END CASE;
    SELECT CONCAT('취득점수==>', point), CONCAT('학점==>', credit);
END $$
DELIMITER ;

CALL caseProc();
```
```
SELECT M.mem_id, M.mem_name, SUM(price*amount) "총 구매액",
	CASE
	    WHEN (SUM(PRICE*amount) >= 1500) THEN '최우수고객'
        WHEN (SUM(PRICE*amount) >= 1000) THEN '우수고객'
        WHEN (SUM(PRICE*amount) >= 1) THEN '일반고객'
        ELSE '유령고객'
	END "회원등급"
FROM buy B
	RIGHT OUTER JOIN member M
    ON B.mem_id = M.mem_id
GROUP BY M.mem_id
ORDER BY SUM(price*amount) DESC;
```

---

## WHILE문

```
-- WHILE문 형식
WHILE <조건식> DO
	-- SQL 문자들
END WHILE;
```

```
DROP PROCEDURE IF EXISTS whileProc;

DELIMITER $$
CREATE PROCEDURE whileProc()
BEGIN
    DECLARE i INT;	-- 1에서 100까지 증가할 변수
    DECLARE hap INT;	-- 더한 값을 누적할 변수
    SET i = 1;
    SET hap = 0;
    
    WHILE (i<=100) DO
        SET hap = hap + i;
        SET i = i + 1;
	END WHILE;
    SELECT '1부터 100까지의 합 ==>', hap;
END $$
DELIMITER ;

CALL whileProc();
```

---

### iterate, leave

* **ITERATE** [레이블] : 지정한 레이블로 가서 계속 진행한다.
* **LEAVE** [레이블] : 지정한 레이블을 빠져나간다. 즉 WHILE 문이 종료된다.

*참고. ITERATE 문은 프로그래밍 언어의 CONTINUE와, LEAVE 문은 BREAK 문과 비슷한 역할을 한다.*

```
DROP PROCEDURE IF EXISTS whileProc2;

DELIMITER $$
CREATE PROCEDURE whileProc2()
BEGIN
	DECLARE i INT;		-- 1에서 100까지 증가할 변수
    DECLARE hap INT;	-- 더한 값을 누적할 변수
    SET i = 1;
    SET hap = 0;
    
    myWhile:
    WHILE(hap<=1000) DO
		IF (i%4 = 0) THEN
			SET i = i + 1;
            ITERATE myWhile; -- 지정한 label 문으로 가서 계속 진행 
		END IF;
        SET hap = hap + i;
        IF (hap > 1000) THEN
			LEAVE myWhile; -- 지정한 label 문을 떠남. 즉 While 종료 
		END IF;
        SET i = i + 1;
	END WHILE;
    
    SELECT '1부터 100까지의 합(4의 배수 제외), 1000 넘으면 종료 ==>', hap;
END $$
DELIMITER ;

call whileProc2();
```

```
DROP PROCEDURE IF EXISTS whileProc2;

DELIMITER $$
CREATE PROCEDURE whileProc2()
BEGIN
	DECLARE i INT;		-- 1에서 100까지 증가할 변수
    DECLARE hap INT;	-- 더한 값을 누적할 변수
    SET i = 1;
    SET hap = 0;
    
    WHILE(hap<=1000) DO
	IF (i%4 != 0) THEN
		SET hap = hap + i;
	END IF;
      SET i = i + 1;
   END WHILE;
    SELECT '1부터 100까지의 합(4의 배수 제외), 1000 넘으면 종료 ==>', hap;
END $$
DELIMITER ;

call whileProc2();
```

---

## 동적 SQL 

SQL 문은 내용이 고정되어 있는 경우가 대부분이다. 하지만 상황에 따라 내용 변경이 필요할 때 동적 SQL을 사용하면 **변경되는 내용을 실시간으로 적용시켜 사용할 수 있다.**

**PREPARE와 EXECUTE**

PREPARE는 SQL문을 실행하지는 않고 미리 준비만 해놓고, EXECUTE는 준비한 SQL문을 실행한다. 그리고 실행 후에는 DEALLOCATE PREFARE로 문장을 해제해주는 것이 바람직하다.(*PREPARE는 워크벤치를 재실행하면 없어진다.*)

```
PREPARE myQuery FROM 'SELECT * FROM member WHERE mem_id = "BLK"';
EXECUTE myQuery;
DEALLOCATE PREPARE myQuery;
```


**PREPARE 문에서는 ?로 향후에 입력될 값을 비워 놓고, EXECUTE에서 USING으로 ?에 값을 전달할 수 있다.**

그러면 실시간으로 필요한 값들을 전달해서 동적으로 SQL이 실행된다.

```
DROP TABLE IF EXISTS gate_table;
CREATE TABLE gate_table(id INT AUTO_INCREMENT PRIMARY KEY, entry_time DATETIME);
SET @curDate = CURRENT_TIMESTAMP();		-- 현재 날짜와 시간 

PREPARE myQuery FROM 'INSERT INTO gate_table VALUES(NULL, ?)';
EXECUTE myQuery USING @curDate;
deallocate PREPARE myQuery;

SELECT * FROM gate_table;
```

*참고. 일반 SQL 에서는 변수는 @변수명으로 지정하는데 별도의 선언은 없어도 된다. 스토어드 프로시저에서 변수는 DECLARE로 선언한 후에 사용해야 한다.*

---