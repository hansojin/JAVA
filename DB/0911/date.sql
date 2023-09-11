-- 1. 현재의 시스템 날짜 확인?  ---------------------------------------------
SELECT CURRENT_TIMESTAMP;

-- 2. 오라클은 FROM구를 생략할 수 없다?없다. ---------------------------------------------

-- 3. 지금 시각을 다음의 출력결과처럼 출력하자. 2023/02/22nd  ---------------------------------------------
SELECT DATE_FORMAT(now(), '%Y/%m/%D');

-- 4. 다음 두 날짜 사이의 간격을 일수로 출력할려면? '2014-02-28' - '2014-01-01' : 예 58   ---------------------------------------------
SELECT DATEDIFF('2014-02-28', '2014-01-01');

-- 5. 시스템 날짜의 1일 후를 계산하기  ---------------------------------------------
SELECT CURRENT_DATE + INTERVAL 1 DAY;

-- 6.   ---------------------------------------------

create table sample1111(
	a int auto_increment primary key, 
	b timestamp default current_timestamp on update current_timestamp, 
	c varchar(20)
);
insert into sample1111(c) values('haha');   
select * from sample1111;   
update sample1111 set c='hoho';   
select * from sample1111;  

-- 7. 현재 날짜와 시간을 반환하여 출력.  ---------------------------------------------
select sysdate(), now();

-- 8. 현재 날짜를 반환하여 출력.  ---------------------------------------------
select curdate(), current_date();

-- 9. 현재 시간을 반환하여 출력  ---------------------------------------------
select curtime(), current_time();

-- 10. 오늘이 몇일인지를 출력.  ---------------------------------------------
select dayofmonth(now());

-- 11. 오늘이 무슨 요일인지를 출력  ---------------------------------------------
select dayofweek(now());
SELECT DAYNAME(now());

-- 12. 일년 중 며칠이 지났는지 출력  ---------------------------------------------
select dayofyear(now());

-- 13. 오늘부터 3일 후와 오늘부터 3일 전을 출력  ---------------------------------------------
select date_add(now(), interval 3 day), date_sub(now(), interval 3 day);

-- 14. 현재 년도와 현재 달을 출력  ---------------------------------------------
select year(now()), month(now()), day(now()), time(now()), hour(now()), minute(now()), second(now()), MICROSECOND(now());

SET @T = '2020-03-13 09:20:11.123456';
SELECT DATE(@T), YEAR(@T), MONTH(@T), DAY(@T);
SELECT DAYOFWEEK(@T), DAYOFYEAR(@T);
SELECT TIME(@T), HOUR(@T), MINUTE(@T), SECOND(@T), MICROSECOND(@T);
SELECT MONTHNAME(@T), DAYNAME(@T);

-- 15. 교수테이블에서 교수코드, 교수이름, 임용일자를 년도(4자리), 월(영문), 일(0이 포함된 날짜) 형식으로 출력하라.(haksa_database)   ---------------------------------------------
use haksa_database;
select prof_code, prof_name, date_format(create_date, '%Y %M %d') from professor;

