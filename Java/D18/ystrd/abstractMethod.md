## Abstract Method

* Abstract Class란 구체적이지 않은 Class를 의미한다.
	* [EX] 독수리, 타조는 구체적인 새를 지칭하는데 새, 포유류 같은 것은 구체적이지 않다.
* 주로 클래스들의 공통되는 필드와 메소드를 정의한 클래스를 말한다.

### 특징
* 추상 클래스는 클래스 앞에 **abstract 키워드**를 이용해서 정의
* 추상 클래스는 미완성의 추상 메소드를 포함할 수 있다.
* 추상 메소드란, 내용이 없는 메소드, 즉 구현이 되지 않은 메소드이다
* 추상 메소드는 리턴 타입 앞에 abstract라는 키워드를 붙여야 한다.
* 추상 클래스는 인스턴스를 생성할 수 없다.
	* 자체적으로 객체를 생성할 수 없다.
	* 따라서 상속을 통해 자식 클래스에서 인스턴스를 생성해야 한다.
* 일반적인 상속의 특성과 동일하다.
	* extends 이용, 단일 상속, 생성자 호출 등
* 추상 클래스를 상속받은 클래스는 추상 클래스가 갖고 있는 __추상 메소드를 반드시 구현(Overriding)__ 해야 한다.
* 추상 클래스를 상속받고, 추상 클래스가 갖고 있는 추상 메소드를 구현하지 않으면 해당 클래스도 추상 클래스가 된다.

### abstract class 사용 이유
* 공통 필드와 메소드 통일 목적
	* 유지보수 및 관리 등에서 공통된 내용(메소드, 필드)들을 추출하여 통일된 내용으로 작성하도록 규격화
	* 상속받은 클래스들은 자기 클래스의 필요한 메소드나 필드만 추가로 정의하고, 추상 메소드를 오버라이딩하여 클래스마다 다르게 실행될 로직을 작성
* 시간절약
* 객체지향적인 설계
	* 추상클래스를 상속받아서 미리 정의된 공통 기능들을 구현하고, 실체클래스에서 필요한 기능들을 클래스별로 확장 시킬 수 있다.
	* 코드 수정시, 영향도를 적게 가져가면서 유지보수성을 높일 수 있다.


