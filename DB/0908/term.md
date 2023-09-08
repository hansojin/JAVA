* SQL
    * Structured Query Language

* DDL (Data Definition Language)
    - create
    - drop
    - alter
    - truncate
    - rename

* DML (Data Manipulation Language)
    - insert
    - delete
    - select
    - update

* DCL (Data Control Langauge)
    - grant
    - revoke

* TCL (Transaction Control Language)
    - commit 
    - rollback
    - savepoint
        
--- 

### COMMIT & ROLLBACK 

INSERT, UPDATE, DELETE같은 데이터를 조작하는 명령어 DML이 실행되는 것과 동시에 트랜잭션이 진행이 된다. *오라클은 오토커밋 기능이 꺼져있다(옵션)*

*transaction : 논리적인 일의 단위, 물리적으로 보이는 처리단위가 아니라 시스템상의 처리단위*

```
show autocommit
set autocommit on
set autocommit off
```

MySQL의경우 오토커밋이기 때문에 상당한 주의를 기울여야한다.

* COMMIT
    * 모든 작업을 정상적으로 처리하겠다고 확정하는 명령어
    * 트랜잭션의 처리과정을 데이터베이스에 반영하기 위해서, 변경된 내용을 모두 영구 저장
    * COMMIT 명령어를 수행하게되면 하나의 트랜잭션 과정을 종료
* ROLLBACK
    * 작업중 문제가 생겼을 때, 트랜잭션의 처리과정에서 발생한 변경사항을 취소하여 트랜잭션 과정을 종료시킴
    * 즉, 트랜잭션으로 인한 하나의 묶음 처리가 시작되기 이전의 상태로 되돌림
    * DML(INSERT DELETE UPDATE)가능하지만 DDL(CREATE,DROP 등) 불가능

#### *GRANT*
```
-- 사용자 "SKY"에게 모든 데이터베이스를 관리할 수 있는 모든 권한을 부여하시오
-- 보통 DB. table 의 형태로 표현함
grant all PRIVILEGES on *. * to sky;

GRANT ALL PRIVILEGES ON mydatabase.* TO sky;
GRANT ALL PRIVILEGES ON mydatabase.mytable TO sky;
```

---

### DBMS (Database Management System)

* strucuture 
    * applications -> DBMS -> DB
* role
    * DB 구축 
    * 데이터 검색/저장 기능
    * DB 접근 API 제공
    * 장애 복구 기능
    * 보안 유지 기능

---

### Database Schema

* DB에서의 자료 구조, 자료 표현 방법, 자료 간의 관계를 형식 언어로 정의한 구조
    * **외부** 스키마(External Schema) 
        * 프로그래머나 **사용자의 입장에서** 데이터베이스의 모습으로 조직의 일부분을 정의한 것
    * **개념** 스키마(Conceptual Schema) 
        * 모든 응용 시스템과 사용자들이 필요로하는 데이터를 통합한 조직 **전체의 데이터베이스 구조** 를 논리적으로 정의한 것
    * **내부** 스키마(Internal Schema) 
        * 전체 데이터베이스의 **물리적 저장 형태** 를 기술하는 것

---   

### RDBMS     

* R은(Relational)의 약자로 RDBMS는 관계형 데이터베이스 관리 시스템을 의미함
* RDBMS는 RDB를 관리하는 시스템이며 RDB는 관계형 데이터 모델을 기초로 두고 모든 데이터를 2차원 테이블 형태로 표현하는 데이터베이스
    * 테이블이 다른 테이블들과 관계를 맺고(join) 모여있는 집합체
    * 관계를 나타내기 위해 외래 키(foreign key) 사용

* pros
    * 정해진 스키마에 따라 데이터를 저장하여야 하므로 명확한 데이터 구조를 보장
    * 각 데이터를 중복없이 한 번만 저장할 수 있음
* cons
    * 시스템이 커질 경우 JOIN문이 많은 복잡한 쿼리가 만들어질 수 있음
    * 성능 향상을 위해서는 서버의 성능을 향상 시켜야하는 Scale-up만을 지원
        * 비용이 기하급수적으로 늘어날 수 있음
    * 스키마로 인해 데이터가 유연하지 못함
        * 스키마 변경 및 유지보수가 어려움

--- 

* 관계형 데이터베이스의 릴레이션 구조
    * 릴레이션(Relation)은 데이터들의 표(Table)의 형태로 표현한 것으로, 구조를 나타내는 릴레이션 스키마와 실제 값들인 릴레이션 인스턴스로 구성

    ![struc](https://github.com/hansojin/JAVA/assets/112622663/b1863654-8aca-43df-a775-ea9f95836f79)

* 튜플(Tuple)
    * 튜플은 릴레이션을 구성하는 각각의 행을 말하며 속성의 모임으로 구성
    * 파일 구조에서 레코드에 해당
    * 튜플의 수 :  카디널리티(Cardinality)  또는 기수, 대응수

* 속성(Attribute)
    * 속성은 데이터베이스를 구성하는 가장 작은 논리적 단위이며 개체의 특성을 기술
    * 파일 구조상의 데이터 항목 또는 데이터 필드에 해당
    * 속성의 수 :  디그리(Degree) 또는 차수

* 도메인(Domain)
    * 도메인은 하나의 속성(attribute)이 취할 수 있는 같은 타입의 원자값들의 집합
    * 실제 속성 값이 나타날 때 그 값의 합법 여부를 시스템이 검사하는데에도 이용됨

* 릴레이션의 특징
    - 한 릴레이션에는 똑같은 튜플이 포함될 수 없음
    - 한 릴레이션에 포함된 튜플 사이에는 순서가 없음
    - 튜플들의 삽입, 삭제 등의 작업으로 인해 릴레이션은 시간에 따라 변함
    - 릴레이션 스키마를 구성하는 속성들 간의 순서는 중요하지 않음
    - 속성의 유일한 식별을 위해 속성의 명칭은 유일해야 함
    - 하지만, 속성을 구성하는 값은 동일한 값이 있을 수 있음
    - 릴레이션을 구성하는 튜플을 유일하게 식별하기 위해 속성들의 부분집합을 키로 설정
    - 속성의 값은 논리적으로 더 이상 쪼갤 수 없는 원자값만을 저장

 