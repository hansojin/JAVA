## Select 명령문의 절(Clause)

* select문 구성 규칙
    * where, group by, order by 같은 절은 선택적으로 사용
    * 절의 순서는 고정
        * group by절은 where 또는 from절 앞에 올 수 없다
        * order by절이 사용된다면 이 절은 항상 가장 나중에 사용된다
        * having절은 group by 절이 사용되어야 만이 사용할 수 있다

---

    Q1. 등록 테이블("FEE")에서 장학금(jang_total)을 지급 받은 학생의 학번(stu_no)과 장학금 내역을 출력하라.

    >> select stu_no, jang_total from fee where jang_total > 0;

    Q2. 등록 테이블("FEE")에서 장학금(jang_total)을 1,000,000 이상 지급 받은 학생 중에서 2회 이상 지급받은 학생의 학번(stu_no)과, 지급받은 횟수를 학번 내림차순으로 출력하라.

    >> select stu_no, count(*) from fee where jang_total >= 1000000 group by stu_no having count(*) > 1 order by stu_no desc;

    Q3. 수강신청 테이블(attend)에서 2006 년도 1학기에 수강 신청한 학생의 학번(stu_no)과 수강년도(att_year), 학기(att_term), 교과목코드(sub_code), 교수코드(prof_code)를 교수코드 오름차순으로 나타내어라.

    >> select stu_no, att_year, att_term, sub_code, prof_code from attend where att_year = '2006' and att_term = 1 order by prof_code;

---

**SQL은 입력된 명령문과 다르게 절의 순서를 변경한다.**

 각 절이 수행되는 순서는 2번(FROM 절) -> 3번(WHERE 절) -> 4번(GROUP BY절) -> 5번(HAVING 절) -> 1번(SELECT 절) -> 6번(ORDER BY절) 순으로 처리가 진행된다. 각 절이 수행되면 0 또는 그 이상의 행과 1 또는 그 이상의 열로 구성된 하나의 결과 테이블(임시 테이블)이 생성된다. 첫번째 절을 제외한 모든 절은 0 또는 그 이상의 행과 1 또는 그 이상의 열로 구성된 테이블을 가진다는것이다. 첫 번째 절은 데이터베이스로부터 데이터를 찾아내고, FROM 절은 데이터베이스로부터 하나 이상의 테이블을 입력으로 취한다.

 다음절의 입력으로 사용되는 이러한 테이블을 중간 결과 테이블(intermediate result table)이라 한다. **SQL은 사용자에게 중간 결과 테이블을 보여주지는 않고 최종 결과 테이블만 보여 준다.** SQL은 여기서 설명한 것과 같이 SELECT 명령문을 처리하지는 않고 실제적으로 **SQL은 처리 속도를 증가시키기 위해서 가능하다면 필요한 만큼 동시에 절들을 처리한다.**

 **order by** 절은 마지막으로 수행되는 절로 **중간 결과 테이블의 내용에 영향을 주지 않는다.** 그러나 마지막까지 선택된 행을 정렬한다. order by prof_code는 오름차순 정렬인 **asc(ending)이 생략** 된 경우로 교수코드를 우선적으로 오름차순 정렬하여 결과 값을 출력한다.

 만약 order by 의 정렬 대상의 결과 값에 **null 값이 존재한다면** mysql에서는 **null 값이 가장 적은 값이 되어 오름차순 정렬에는 맨 처음에 출력되고, 내림차순인 경우에는 맨 마지막에 출력된다.**

---

#### 정렬 - ORDER BY

* SYNTAX 복수 열 정렬
    * SELECT 열명 FROM 테이블명 ORDER BY 열명1 [ASC|DESC], 열명2 [ASC|DESC];

#### 결과 행 제한 - LIMIT

* SELECT 명령 FROM 테이블명 LIMIT N [OFFSET 시작행]
* MySQL과 PostgreSQL에서 사용할 수 있는 문법
* SQL SERVER에서는 LIMIT와 비슷한 기능을 하는 'TOP'을 사용
    * SELECT TOP 3 * FROM sample33;
* Oracle에는 ROWNUM이라는 열을 사용해 WHERE 구로 조건을 지정하여 행을 제한
    * SELECT * FROM sample33 WHERE ROWNUM <= 3;


