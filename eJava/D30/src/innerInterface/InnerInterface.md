## 인터페이스란?

인터페이스란 추상클래스의 확장개념으로, 서비스 공급자(서버)와 사용자(클라이언트)간의 계약을 표현하는 것입니다.**인터페이스의 모든 필드(변수)는 모두 final static이 붙은 상수로 간주** 됩니다.(생략되어 표시되지 않습니다.) 메소드는 추상메소드만 구현할 수 있었으나, JAVA9부터는 구현메소드와 정적메소드, private 메소드가 작성될 수 있게 되었습니다.(private메소드는 default메소드에서 호출하여 사용할 수 있습니다.)
	
### 중첩인터페이스

```
public interface MainConstants {
    //inner interface (중첩 인터페이스)
    interface View{
        void showResult(int result);
    }
}
```
이처럼 인터페이스 내부에 또 다른 인터페이스를 사용하는 것으로, JAVA의 특성인 캡슐화를 강화하며, 인터페이스를 논리적으로 묶어 사용하기 위해 이처럼 중첩 인터페이스를 사용합니다. 논리적으로 용도가 비슷한 인터페이스끼리 묶여있으므로, 코드의 가독성이 좋아집니다.

이를 이해하기 위해서는 중첩 클래스와 비교를 해야할 필요가 있습니다. 

```
class A {
    private int x; 
    //1. static 내부클래스
    static class B {
        void showX(){
            System.out.println(new A().x+"");
        }
    }
    //2. 일반 내부클래스
    class C{
        void showX(){
            System.out.println(x+"");
        }
    }
}
```

내부클래스 특성상 자신의 외부에 있는 클래스 A의 모든 것들에 접근할 수 있습니다. 하지만 static클래스의 경우 static인 것에만 접근할 수 있기 때문에 A클래스를 인스턴스화시켜서 x에 접근할 수 있는 반면, 일반 내부클래스는 바로 접근이 가능하기 때문에 x로 접근합니다.

하지만 인터페이스는 모두 final static이 붙은 상수로 간주됩니다. 그렇기 때문에 모두 static한 친구들이고, 인터페이스 특성상 인스턴스화 시킬 수 없기 때문에

```
public interface MainConstants {
    //inner interface (중첩 인터페이스)
    interface View{
        void showResult(int result);
    }

    void clear();
}
```

위와 같은 중첩인터페이스가 있을 경우 사용은 다음과 같이 할 수 있습니다

```
class A implements MainConstants{
    void clear(){
        //clear구현내용
    }

    class B implements MainConstants.View{
            void showResult(int result){
                //showResult 구현 내용
            }
    }
}
```

---

## What is an Inner Interface in Java?

**inner interface** is also called **nested interface** , which means declare an interface inside of another interface. For example, the entry interface is declared in the map interface.

```
public interface map {
	interface entry{
		int getkey();
	}
 
	void clear();
}
```

### why use inner interface?

there are several compelling reasons for using inner interface:

	* a way of logically grouping interfaces that are only used in one place.
	* increases encapsulation.
	* lead more readable and maintainable code.
	
One example of inner interface used in java standard library is java.util.map and java.util.map.entry. Here java.util.map is used also as a namespace. Entry does not belong to the global scope, which means there are many other entities that are entries and are not necessary map’s entries. This indicates that entry represents entries related to the map.

### how inner interface works?

To figure out how inner interface works, we can compare it with nested classes. Nested classes can be considered as a regular method declared in outer class. Since a method can be declared as static or non-static, similarly nested classes can be static and non-static. Static class is like a static method, it can only access outer class members through objects. Non-static class can access any member of the outer class.

![java-nested-classes](https://github.com/hansojin/JAVA/assets/112622663/d8bf892a-e55d-46ca-8ccb-2a8bb3484c3b)

Because an interface can not be instantiated, the inner interface only makes sense if it is static. Therefore, by default inter interface is static, no matter you manually add static or not.

### a simple example of inner interface?

```
public interface map {
	interface entry{
		int getkey();
	}
 
	void clear();
}

public class mapimpl implements map {
 
	class implentry implements map.entry{
		public int getkey() {
			return 0;
		}		
	}
 
	@override
	public void clear() {
		//clear
	}
}
```
