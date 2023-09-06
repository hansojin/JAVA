### path 설정하기

* path 설정을 해야  **window + r키** , 또는 cmd 에 mysql로 바로 접속 가능
* path : C:\Program Files\MySQL\MySQL Server 8.1\bin
* 방법 :  설정 > 정보 > 고급 시스템 설정 > 환경 변수 > 시스템 변수 > path > 편집 > 새로 만들기 > path 추가

---

##  DDL, DML

![op](https://github.com/hansojin/JAVA/assets/112622663/cc36989b-106c-4514-a273-c74212c9d70f)

### DDL(Data Definition Language)
* DDL을 사용하여 테이블 구조 자체를 새롭게 생성, 수정, 삭제를 합니다.
* DDL, DCL은 자동 COMMIT 됩니다.
    *  COMMIT : 명령을 주고나면 자동으로 DB에 저장됨을 의미

#### CREATE
    * 식별자 명명 규칙
        * 반드시 문자로 시작
        * 대, 소문자와 숫자, (_, $, #) 특수기호만 가능
        * 오라클에서 사용되는 예약어나 다른 객체명과는 중복이 불가
        * 공백 불가
        * 1 ~ 30 자 까지 가능


#### ALTER
    *  테이블의 구조를 변경
    * alter table 테이블명 add(컬럼명 타입);
    * alter table 테이블명 modify(컬럼명 타입);
    * alter table 테이블명 rename column x to y;
    * alter table 테이블명 drop column C;
        * 레코드가 있어도 삭제 가능
    * alter table 테이블명 set unused(x);
        * 컬럼 비활성화
    * alter table 테이블명 drop unused columns;
        * unused 컬럼 삭제

#### DROP
    * 테이블을 삭제
    * drop table 테이블명;
        * 쓰레기값 남음(삭제된 테이블 정보)
    * drop table 테이블명 purge;
        * 쓰레기값 남기지 않고 완전 삭제
    * truncate table 테이블명;  
    * rename A to B;  
        * 테이블 이름 변경 (레코드 있어도 가능)

### DML(Data Manipulation Language)
* 테이블의 데이타를 조작하는 언어
    * 새로운 데이타를 입력하는 **insert**
        * insert into .. values ..
    * 존재하는 데이타를 수정하는 **update**
        * update set ...
    * 기존 데이터를 삭제하는 **delete**
        * delete from ...

----

[참고]

* mysql -u root -p : user 계정을 root로
* -u for user
* -h for host
* -p for port/DBname
* varchar VS char
    * varchar 
        * 가변길이 문자열
        * 공간 절약면에서 효율적
    * char
        * 크기 고정
        * 검색속도 빠름



