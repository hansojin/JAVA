### 객체 생성을 막을 때는 private 생성자를 사용하라
---
* 객체를 만들 생각이 없다고 생성자를 만들지 않으면,  객체 생성을 막을 수 있는 것이 아니라 디폴트 생성자(컴파일러가 자동으로 생성)가 만들어진다.
* 클래스를 abstract로 추상 클래스로 만든다고 해도 소용없다. 
	* 하위 클래스를 정의하면 객체 생성이 가능해지기 때문
* 그니까, private 생성자를 만들어서 외부에서 객체 생성을 못하게 막아버리자
* private 생성자를 가지고 있으므로 **하위 클래스 상속도 불가능하고, 외부에서 호출도 불가능**하다

```
public final class Math {

    private Math() {}

    public static final double E = 2.7182818284590452354;
    ...
    
    public static int max(int a, int b) {
        return (a >= b) ? a : b;
    }
    ....
}
```
- final class이기 때문에 상속 불가
- private 생성자로 외부에서 생성 불가
- static 변수/메소드로 클래스 레벨에서 공유되어 사용 



#### FINAL keyword
---
* final 키워드는 값을 한번 할당한 이후에는 변경 불가능(immutable)함을 뜻한다.
* final 클래스: 상속할 수 없는 클래스
* final 메서드: 오버라이딩 불가능한 메소드
* final 변수: 수정 불가능한 변수. static final 조합으로 상수로 많이 쓰임

* "불변함" 이라는 것의 이점이 상당히 많다! 
* final 변수는 변수 선언 시에 or 생성자를 통해서만 할당해줄 수 있다.
* final 클래스라도 내부 변수가 final이 아니라면 setter 등을 통해서 값을 변경해줄 수 있다.