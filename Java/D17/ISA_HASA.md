### IS_A
---
* 상속은 IS-A관계에서 사용하는 것이 가장 효율적
* IS-A 관계(is a relationship, inheritance)는 일반적인 개념과 구체적인 개념의 관계
	* animal <- human
	* animal <- cow
	* animal <- bird
* 상속을 코드 재사용의 개념으로만 이해하면 안됨
* 상속을 사용하면 클래스간 결합도가 높아져 상위 클래스를 수정해야 할 때 하위 클래스에 미치는 영향이 매우 크기 때문에, IS-A 관계에서 사용해야함

### HAS_A
---
* HAS-A 관계에서는 상속을 사용하지 않음
* HAS-A 관계는 다른 클래스의 기능(변수 혹은 메서드)을 받아들여 사용
* HAS-A 관계(has a relationship, association)는 일반적인 포함 개념의 관계
	* computer ⊃ CPU
	* computer ⊃ RAM
	* computer ⊃ MainBoard

