-- Active: 1693992872757@@127.0.0.1@3306@sample

SELECT * FROM sample72_x; # 행 : 3
SELECT * FROM sample72_y; # 행 : 3

-- FROM구에 테이블 두 개를 지정해 곱집합 구하기 _ 행 9개
SELECT * FROM sample72_x, sample72_y;

SELECT * FROM 상품;     # 행 : 3
SELECT * FROM 재고수;   # 행 : 3
SELECT * FROM 상품, 재고수;     # 행 : 9

-- 상품코드가 같은 행을 검색하기
SELECT * FROM 상품, 재고수 WHERE 상품.상품코드 = 재고수.상품코드;

-- inner JOIN
SELECT 상품.상품명, 재고수.재고수
	FROM 상품 
        INNER JOIN 재고수
		    ON 상품.상품코드 = 재고수.상품코드
	WHERE 상품.상품분류 = '식료품';

SELECT S.상품명, M.메이커명
	FROM 상품2 S 
        INNER JOIN 메이커 M
	        ON S.메이커코드 = M.메이커코드;    

-- 상품 테이블을 자기결합 하기
SELECT S1.상품명, S2.상품명
	FROM 상품 S1 INNER JOIN 상품 S2
	ON S1.상품코드 = S2.상품코드;

-- 내부결합에서는 상품코드가 0009인 상품이 제외된다.
SELECT 상품3.상품명, 재고수.재고수
	FROM 상품3 INNER JOIN 재고수
	ON 상품3.상품코드 = 재고수.상품코드
	WHERE 상품3.상품분류 = '식료품';

SELECT 상품3.상품명, 재고수.재고수
	FROM 상품3 LEFT JOIN 재고수
	ON 상품3.상품코드 = 재고수.상품코드
	WHERE 상품3.상품분류 = '식료품';

