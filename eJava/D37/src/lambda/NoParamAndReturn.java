package lambda;

import java.util.Random;

interface Generator {
	int rand();    // 매개변수 없는 메소드
}

class NoParamAndReturn {
	public static void main(String[] args) {
		Generator gen = () -> {
			Random rand = new Random();
			return rand.nextInt(50);
		};

		System.out.println(gen.rand());
	}
}


/*

매개변수 선언이 없는 관계로 매개변수 정보를 담는 소괄호가 비어 있다. 
그리고 이렇듯 둘 이상의 문장으로 이뤄진 람다식은 중괄호로 반드시 감싸야 하며, 값을 반환할 때에도 return 문을 반드시 사용해야 한다.

* 함수형 인터페이스(Functional Interfaces)와 어노테이션 

>> 예제에 정의되어 있는 인터페이스에는 추상 메소드가 딱 하나만 존재한다.

이러한 인터페이스를 가리켜 '함수형 인터페이스(Functional Interfaces)'라 한다. 
그리고 람다식은 이러한 함수형 인터페이스를 기반으로만 작성이 될 수 있다.

@FunctionalInterface
interface Calculate {
	int cal(int a, int b);
}

@FunctionalInterface은 함수형 인터페이스에 부합하는지를 확인하기 위한 어노테이션 타입이다. 
위의 인터페이스에 둘 이상의 추상 메소드가 존재하면, 이는 함수형 인터페이스가 아니기 때문에 컴파일 오류로 이어진다. 
그러나 static, default 선언이 붙은 메소드의 정의는 함수형 인터페이스의 정의에 아무런 영향을 미치지 않는다. 
따라서 다음 인터페이스도 함수형 인터페이스이다.

@FunctionalInterface
interface Calculate {
	int cal(int a, int b);
	default int add(int a, int b) { return a + b; }
	static int sub(int a, int b) { return a - b; }
}

위의 인터페이스를 대상으로도 람다식을 구성할 수 있다. 어차피 채워야 할 메소드는 하나이기 때문이다.
 */
