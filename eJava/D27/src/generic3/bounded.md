### 제네릭 클래스의 타입 인자 제한하기

앞서 정의한 Box<T>에는 무엇이든 담을 수 있다. 

String 인스턴스를 담고 싶으면 다음과 같이 상자를 생성하면 되고,

> Box<String> sBox = new Box<>();


Apple 인스턴스를 담고 싶으면 다음과 같이 상자를 생성하면 된다.

> Box<Apple> sBox = new Box<>();


그러나 상자에도 특성과 용도가 있다. 따라서 담고 싶은 것을 제한할 수 있어야 한다. 

그리고 이때 사용하는 것이 extends 이다. 

예를 들어서 Number 클래스를 상속하는 클래스의 인스턴스만 담고 싶다면 다음과 같이 클래스를 정의하면 된다.

>  class Box<T extends Number> {...}
	-> 인스턴스 생성 시 타입 인자로 Number 또는 이를 상속하는 클래스만 올 수 있음

위 예제에서는 제네릭 클래스의 타입 인자를 Number 또는 이를 상속하는 하위 클래스로 제한을 하였다. 

그리고 이렇게 제한을 하면 또 다른 특성이 생긴다. Box<T> 클래스에는 다음과 같은 코드를 넣을 수 없다.

```
class Box<T>{
	private T ob;
	...
	public int toIntValue() {
		return ob.intValue();	// Error!
	}
}
```

참조변수 ob가 참조하게 될 것은 인스턴스이다. 하지만 **어떠한 클래스의 인스턴스를 참조하게 될지 알수 없기 때문에 ob를 통해서 호출할 수 있는 메소드는 Object 클래스의 메소드로 제한이 된다.**

반면 다음과 같이 타입 인자를 제한하면 Number 클래스의 intValue 메소드를 호출할 수 있다. 

ob가 참조하는 인스턴스는 intValue 메소드를 가지고 있음을 100퍼센트 보장할 수 있기 때문이다.

```
class Box<T extends Number> {
	private T ob;
	...
	public int toIntValue() {
		return ob.intValue();	// OK!
	}
}
```

이렇듯 타입 인자를 제한했을 때 얻게 되는 특성 때문에 타입 인자를 제한하는 경우도 많다.

---

### 제네릭 클래스의 타입 인자를 인터페이스로 제한하기

다음과 같이 타입 인자를 제한할 수 있음을 위에서 설명하였다.

> class Box<T extends Number> {...}

이와 유사하게 인터페이스로도 타입 인자를 제한할 수 있다.

예제에서 보이듯이, 제네릭 클래스의 타입 인자를 다음과 같이 인터페이스의 이름으로 제한할 수 있다. 그리고 제한할 때에는 클래스와 마찬가지로 extends를 사용한다.

> class Box<T extends Eatable> {...}

그리고 Eatable 인터페이스를 구현하는 클래스로 타입 인자를 제한했기 때문에 다음과 같이 인터페이스에 선언되어 있는 메소드 eat의 호출이 가능하게 되었다.

```
class Box<T extends Eatable> {
	...
	public T get(){
		System.out.println(ob.eat());	// Eatable로 제한하였기에 eat 호출 가능
		return ob;
	}
}
```

그리고 타입 인자를 제한할 때에는 하나의 클래스와 하나 이상의 인터페이스에 대해 **동시에 제한을 할수가 있**으며 그 방법은 다음과 같다.

> class Box<T extends Number & Eatable> {...}

이 경우 Number를 상속하면서 동시에 Eatable 인터페이스를 구현하는 클래스만이 타입 인자로 올 수 있다.