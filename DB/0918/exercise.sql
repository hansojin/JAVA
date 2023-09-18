-- Active: 1693992872757@@127.0.0.1@3306@market_db
--1. market_db가 존재하면 삭제한다.
drop DATABASE if exists market_db;

-- 2. SQL 주석

-- 3. market_db의 member 테이블에 있는 모든 내용을 보여주시오.
select * from market_db.member;


--3-1. 회원(MEMBER)테이블에서 주소(addr)을 별칭 주소, 데뷔 날짜(debut_date)를 별칭 "데뷔 일자", 이름(mem_name)을 출력한다.
select addr "주소", debut_date "데뷔 일자", mem_name "이름"
from member;

-- 3-2. 회원(member)테이블에서 회원이름이 '블랙핑크'인 것의 모든 열을 출력한다.
select *
from member
where mem_name = '블랙핑크';

-- 3-3. 회원(MEMBER)테이블에서 인원(MEM_NUMBER)가 4인 것의 모든 열을 출력한다.
select * from member
where mem_number=4;

-- 3-4. 회원(MEMBER)테이블에서 회원 키가(HEIGHT) 162이하인 것의 아이디(MEM_ID), 이름(MEM_NAME)을 출력하시오.
select mem_id, mem_name
from member
where height<=162;

-- 3-5. 회원(MEMBER)테이블에서 키(HEIGHT)가 165이상이고 멤버 수(MEM_NUMBER)가 6초과인것의 이름(MEM_NAME), 키(HEIGHT), 멤버 수(MEM_NUMBER)를 조회하시오.
select mem_name, height, mem_number
from member
where height>=165 and mem_number>6;

-- 3-6. 회원(MEMBER)테이블에서 키(HEIGHT)가 165이상이거나 멤버 수(MEM_NUMBER)가 6초과인것의 이름(MEM_NAME), 키(HEIGHT), 멤버 수(MEM_NUMBER)를 조회하시오.
select mem_name, height, mem_number
from member
where height>=165 and mem_number>6;

-- 3-7. 회원 테이블(member)에서 키가 163이상 165이하인 것의 이름(mem_name), 키(height)를 출력하시오.(두 가지 방법으로)
select mem_name, height
from member
where height between 163 and 165;

select mem_name, height
from member
where height in (163,164,165);

select mem_name, height
from member
where height>=163 and height<=165;

-- 4. member 테이블에서 addr이 '경기' 이거나 '전남'이거나 '경남' 인것의 mem_name, addr을 보여주시오.(두 가지 방법으로)
SELECT mem_name, addr FROM member 
WHERE addr = '경기' OR addr = '전남' OR addr = '경남';

-- 4-1. 회원 테이블(member)에서 이름(mem_name)이 '우'로 시작하는 것의 모든 열을 조회하시오.
select * from member
where mem_name like '우%';

-- 4-2. 회원 테이블(member)에서 이름(mem_name)이 4글자 이고 끝에 두 글자는 '핑크'로 끝나는 것의 모든 열을 조회하시오.
select * from member
where mem_name like '__핑크';

-- 5. 회원(member) 테이블에서 이름(mem_name)이 '에이핑크'인 회원의 키(height)보다 큰 회원의 이름(mem_name)과 키(height)를 출력하시오.
select mem_name, height from member
where height> (select height from member where mem_name = "에이핑크");

-- 6-1. 회원(member) 테이블에서 아이디(mem_id), 이름(mem_name), 데뷔 날짜(debut_date)를 데뷔 날짜 순으로 정렬하여 출력하시오.
select mem_id, mem_name, debut_date from member order by debut_date;

-- 6-2. 회원(member) 테이블에서 아이디(mem_id), 이름(mem_name), 데뷔 날짜(debut_date)를 데뷔 날짜 내림차순으로 정렬하여 출력하시오.
select mem_id, mem_name, debut_date from member order by debut_date desc;

-- 6-3. 회원(member) 테이블에서 키가 164이상인 회원의 아이디(mem_id), 이름(mem_name), 데뷔날짜(debut_date), 키(height)를 키 내림차순으로 조회하시오.
SELECT mem_id, mem_name, debut_date, height FROM member
where height>=164 order by height desc;

-- 6-4. 회원(member) 테이블에서 키가 164이상인 회원의 아이디(mem_id), 이름(mem_name), 데뷔날짜(debut_date), 키(height)를 키 내림차순, 데뷔날짜 오름차순으로 정렬하여 출력하시오.
SELECT mem_id, mem_name, debut_date, height FROM member
where height>=164 order by height desc, debut_date asc;

-- 7-1. 회원(member) 테이블에 상위 3개를 조회한다.
select * from member limit 3;

-- 7-2. 회원 테이블(member)에서 데뷔날짜가 빠른 회원의 이름(mem_name), 데뷔 날짜(debut_date)를 데뷔순으로 3건을 출력하자.
select mem_name, debut_date from member order by debut_date limit 3;

-- 7-3. 회원(member)테이블에서 이름(mem_name), 키(height) 키로 내림차순 정렬해서 3번째 2개를 가져와서 출력하자.
SELECT mem_name, height FROM member order by height desc limit 3,2;

-- 8. 회원(member)테이블로 부터 중복된 값을 제외하고 주소를 출력하자.
select distinct addr
from member;

-- 9. 구매(buy) 테이블로 부터 회원 아이디( mem_id), 개수 (amount) 를  회원 아이디(mem_id) 오름차순으로 정렬하자.
select mem_id, amount 
from buy
order by mem_id asc;

-- 10. 집계 함수(aggregate function)
-- GROUP BY와 함께 주로 사용되는 집계 함수
-- sum() avg() min() max() count() count(distinct)

-- 11. 구매(buy)테이블에서 아이디(mem_id)별로 그룹화하여 아이디(mem_id) (별칭 "회원 아이디") 와 개수(amount)를 합친 것을 (별칭 "총 구매 개수")  출력하자.
select mem_id "회원아이디", sum(amount) "총구매개수" from buy group by mem_id;

-- 12. 구매(buy)테이블에서 아이디(mem_id)별로 그룹화하여 아이디(mem_id) (별칭 "회원 아이디") 와 "총 구매 금액"(별칭) (price*amount)을  출력하자.
select mem_id "회원아이디", sum(price*amount) "총구매금액" from buy group by mem_id;

-- 13. 구매(buy) 테이블의 물품 개수(amount)의 평균(별칭 평균 구매 개수)을 출력하자.
select avg(amount) from buy;

-- 14. 구매 테이블(buy)로 부터 회원 아이디별(mem_id) 평균 구매 개수(amount)를 출력하자.
select avg(amount) from buy group by mem_id;

-- 15. 회원(member)테이블로 부터 전체 회원의 수를 출력하자.
select count(*) from member;

-- 16. 회원(member)테이블로 부터 연락처가 있는 회원의 수를 출력하자.
select count(phone1) from member;

-- 17-1. 구매(buy)에서 회원 아이(mem_id)로 그룹핑 했을 때, 아이(mem_id) 별칭 "회원 아이디", 총 구매 금액(price * amount의 합계) 별치 "총 구매 금액"을 출력하시오.
select mem_id, sum(price*amount) from buy group by mem_id;

-- 17-2. 구매(buy)에서 회원 아이(mem_id)로 그룹핑 했을 때, 총 구매 금액(price * amount의 합계)이 1000이상인 것의 ,아이디(mem_id) 별칭 "회원 아이디", 총 구매 금액(price * amount의 합계) 별칭 "총 구매 금액"을 출력하시오.
select mem_id, sum(price*amount) from buy group by mem_id having sum(price*amount)>1000;

-- 17-3. 구매(buy) 테이블에서 회원 아이디(mem_id)로 그룹핑 했을 때 총 구매 금액(price * amount)가 1000 이상인 회원의 회원 아이디(mem_id - 별칭 "회원 아이디"), 총 구매 금액(price * amount)를 출력 하는데 총 구매 금액의 내림차순으로 출력 하시오.
select mem_id, sum(price*amount) from buy group by mem_id having sum(price*amount)>1000 order by sum(price*amount) desc;

-- 18. market_db 데이터베이스 선택
use market_db;

-- 19. 테이블 hongong1 을 만든다
CREATE TABLE hongong1(toy_id INT, toy_name CHAR(4), age INT);

-- 20. 다음 데이터를 삽입한다.
INSERT INTO hongong1 VALUES(1, '우디', 25);
INSERT INTO hongong1 (toy_id, toy_name) VALUES(2, '버즈');
INSERT INTO hongong1 (toy_name, age, toy_id) VALUES('제시', 20, 3);
select * from hongong1;
-- 22. hongong2 테이블을 다음의 자료형을 가지고 만든다.
CREATE TABLE hongong2(
    toy_id INT AUTO_INCREMENT PRIMARY KEY,
    toy_name CHAR(4),
    age INT
);
-- 23. 자동 증가하는 부분을 NULL 값으로 채워 놓으면 1부터 차례대로 채워진다.
INSERT INTO hongong2 VALUES (NULL, '보핍', 25);
INSERT INTO hongong2 VALUES (NULL, '슬랭키', 22);
INSERT INTO hongong2 VALUES (NULL, '렉스', 21);
select * from hongong2;

-- 24. 가장 마지막 증가값 가져오기
select LAST_INSERT_ID();

-- 25. hongong2 테이블 자동 증가로 입력되는 다음 값을 100부터 시작하도록 변경하기
ALTER TABLE hongong2 AUTO_INCREMENT=100;

-- 26. hongong2 테이블에 다음 값 삽입
INSERT INTO hongong2 VALUES(NULL, '재남', 35);

-- 27. hongong2 테이블에 모든 값 조회
SELECT * FROM hongong2;

-- 28. hongong3 테이블을 다음의 자료형을 가지고 만든다.
CREATE TABLE hongong3(
    toy_id INT AUTO_INCREMENT PRIMARY KEY,
    toy_name CHAR(4),
    age INT
);

-- 29. hongong3 테이블 자동 증가값 1000부터 시작하기
ALTER TABLE hongong3 AUTO_INCREMENT=1000;

-- 30. 자동 증가값을 3씩 증가하게 하기
set @@AUTO_INCREMENT_increment=3;

-- 31. 전체 시스템 변수의 종류 조회
SHOW GLOBAL VARIABLES

-- 32. 다음 SQL을 실행해 처음 시작되는 값과 증가값을 추측해보자.
INSERT INTO hongong3 VALUES (NULL, '토마스', 20);
INSERT INTO hongong3 VALUES (NULL, '제임스', 23);
INSERT INTO hongong3 VALUES (NULL, '고든', 25);
SELECT * FROM hongong3;

-- 33. 한번에 3행의 값을 입력하자.
INSERT INTO HONGONG3 VALUES(NULL, '토마스', 20), (NULL, '제임스', 23), (NULL, '고든', 25);

-- 34. WORLD 디비의 CITY 테이블의 행수 조회
SELECT COUNT(*) FROM world.city;

-- 35. city_popul 테이블을 다음의 자료형을 가지고 만들기
CREATE TABLE city_popul (city_name CHAR(35), population INT);

-- 36.world.city 테이블의 Name과 Population 데이터를 city_popul 테이블에 city_name과 population에 넣기
INSERT INTO city_popul SELECT Name, Population FROM world.city;

-- 37. market_db 선택
USE market_db;

-- 38. city_popul 테이블의 도시 이름(city_name)이 'Seoul'인 것을 도시 이름(city_name)을 '서울'로 변경하자.
UPDATE city_popul SET city_name = '서울' WHERE city_name = 'Seoul';

-- 39. city_popul 테이블에서 도시 이름(city_name)이 'New York'인 도시의 도시 이름(city_name)을 '뉴욕' 인구(population)을 0으로 바꾸자. 그리고 그 결과를 확인하자.
UPDATE city_popul SET city_name = '뉴욕', population = 0 WHERE city_name = 'New York';

-- 40. city_popul 테이블의 인구(population)을 10,000 단위로 바꾸고, 그것을 확인해 보자
UPDATE city_popul SET population = population / 10000;

-- 41. city_popul 테이블에서 도시 이름(city_name)이 'New'로 시작하는 도시를 삭제하시오.
DELETE FROM city_popul WHERE city_name LIKE 'New%';

-- 42. city_popul 테이블에서 도시 이름(city_name)이 'New'로 시작하는 도시의 상위 5건을 삭제하시오.
DELETE FROM city_popul WHERE city_name LIKE 'New%' LIMIT 5;

-- 43. world.city 테이블과 sakila.county 테이블을 cross join한 big_table1, big_table2, big_table3을 만들고, big_table1의 행수를 출력하시오.
CREATE TABLE big_table1(SELECT * FROM world.city, sakila.country);
CREATE TABLE big_table2(SELECT * FROM world.city, sakila.country);
CREATE TABLE big_table3(SELECT * FROM world.city, sakila.country);
SELECT COUNT(*) FROM big_table1;

-- 44. big_table1을 DELETE로 삭제, big_table2을 DROP으로 삭제, big_table3을 TRUNCATE로 삭제하고 걸린 시간 비교해보기
DELETE FROM big_table1;
DROP TABLE big_table2;
TRUNCATE TABLE big_table3;

-- TRUNCATE는 DELETE와 달리 WHERE문을 사용할 수 없다. 
-- 그러므로 TRUNCATE는 조건 없이 전체 행을 삭제할 때만 사용된다.
-- 대용량 테이블의 전체 내용을 삭제할 때 테이블 자체가 필요 없을 경우에는 DROP으로 삭제하고,
-- 테이블의 구조는 남겨놓고 싶다면 TRUNCATE로 삭제하는 것이 효율적이다.