
## view 

    뷰의 의미는 하나의 select문과 같다고 생각하면 된다. 물론 뷰를 통해 insert, update, delete가 가능하지만 대개의 경우는 select를 위해 사용한다. 뷰란 한개 이상의 기본 테이블이나 다른 뷰를 이용하여 생성되는 가상 테이블(virtual table)이다. 즉, 뷰는 저장장치 내에 물리적으로 존재하지 않지만 사용자에게 있는 것처럼 간주된다.

    뷰는 기존에 생성된 테이블 또는 다른 뷰에서 접근할 수 있는 전체 데이터 중에서 일부만 접근할 수 있도록 제한하기 위한 기법이다. 뷰를 가상 테이블이라하는 이유는 테이블은 디스크 공간이 할당되어 데이터를 저장할 수 있지만, 뷰는 데이터 딕셔너리 테이블에 뷰에 대한 정의만 저장하고 디스크에 저장 공간이 할당하지 않기 때문이다. 

    뷰 자체는 데이터를 갖지 않지만, 기초 테이블의 데이터를 조회하고 수정할 수 있는 창과 같다.

### view 사용 방법

* 단일 테이블을 이용한 단순 View
    * 하나의 테이블에서 특정한 조건에 맞는 레코드 들만 질의(QUERY)가능
        * create view 뷰명 as select * from 테이블 where 조건;
    * 하나의 테이블에서 특정한 컬럼들만 질의(QUERY)가능
        * create view 뷰명 as select 컬럼 from 테이블 where 조건;
* 복합 테입블을 이용한 복합 View
    * 여러 테이블의 칼럼을 모아서(JOIN) 하나의 테이블처럼 질의(QUERY)할 수 있도록 한 데이터베이스 오브젝트   
* WITH CHECK OPTION / WITH READ ONLY 옵션
    * with check option
        * 조건 컬럼값을 변경하지 못하게 하는 옵션
        * WHERE절에 WITH CHECK OPTION을 기술하면 그 조건에 의해 기본 테이블에서 정보가 추출하는 것이므로 조건에 사용 되어진 컬럼 값은 뷰를 통해서는 변경이 불가능
    * with read only
        * 기본 테이블의 어떤 컬럼에 대해서도 뷰를 통한 내용 수정을 불가능하게 만드는 옵션
* 삭제
    * 뷰는 ALTER문을 사용하여 변경할 수 없으므로 필요한 경우는 삭제한 후 재생성
        * DROP VIEW 뷰이름 RESTRICT or CASCADE
            * RESTRICT : 뷰를 다른곳에서 참조하고 있으면 삭제가 취소
            * CASCADE : 뷰를 참조하는 다른 뷰나 제약 조건까지 모두 삭제

### view의 장단점

* 장점
    * DB의 선택적인 부분만 보여주므로 접근을 제한
    * 다양한 접근 경로 설정
    * 복잡한 질의를 단순화
    * 논리적 데이터의 독립성 제공
    * 동일한 데이터를 또 다른 뷰로 표현
    * 한 개의 뷰에 여러 테이블의 데이터를 검색 가능
    * 한 개의 테이블로부터 여러 뷰를 생성 가능
* 단점
    * 뷰의 정의를 변경할 수 없음
        * 즉, ALTER VIEW문을 사용할 수 없음
    * 뷰로 구성된 내용에 대한 삽입, 삭제, 갱신, 연산에 제약이 따름
        * insert, delete, update에 많은 제한
    * 독립적인 인덱스를 가질 수 없음

---

### view를 사용하는 이유
    * 자주 쓰는 쿼리문을 안쓰고 테이블만 조회하면 된다.
    * 보안에 유리하다.
    * 뷰 테이블에 자료가 추가되는 것은 실체 테이블에 반영되지 않기 때문에 주의를 요한다.
    * 참고) 뷰는 엄청난 쿼리를 사용자들로부터 가리는데 훌륭하지만, 하나의 뷰 안에 또 다른 뷰와 내부에 있는 다른 뷰를 (계속해서) 중첩시키다 보면 심각한 성능 저하를 유발할 수 있다.

### view가 사용되는 상황
    * 반복되는 명령문이나 루틴(routine)을 간단히 사용하고자 할 때
    * 테이블의 출력 방법을 재구성하고자 할 때
    * 여러 단계에서 select 명령문이 사용될 때
    * 데이터를 보호하고자 할 때