package optional;

import java.util.Optional;

class StringOptional1 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1"));
        Optional<String> os2 = Optional.ofNullable(new String("Toy2"));

        if(os1.isPresent())
            System.out.println(os1.get());

        if(os2.isPresent())
            System.out.println(os2.get());
    }
}

/*

Optional 클래스의 기본적인 사용 방법

Optional 클래스는 java.util 패키지로 묶여 있으며, 다음과 같이 정의되어 있다.

public final class Optional<T> extends Object {
	private final T value;	// 이 참조변수를 통해 저장을 한다.
	...
}

Optional은 멤버 value에 인스턴스를 저장하는 일종의 래퍼(Wrapper)클래스이다.

다음 두 문장은 Optional 인스턴스의 생성 방법 두 가지를 보여준다.

Optional<String> os1 = Optional.of(new String("Toy1"));
	-> String 인스턴스를 저장한 Optional 인스턴스 생성, of 메소드 호출
	
Optional<String> os2 = Optional.ofNullable(new String("Toy2"));
	-> String 인스턴스를 저장한 Optional 인스턴스 생성, ofNullable 메소드 호출
	
두 메소드 of와 ofNullable의 차이점은 null의 허용 여부에 있다. 

ofNullable의 인자로는 null을 전달할 수 있다. 즉 비어 있는 Optional 인스턴스를 생성할 수 있다. 
반면 of 메소드에는 null을 인자로 전달할 수 없다. null을 전달할 경우 NullPointerException이 발생한다.
그리고 Optional 인스턴스르 대상으로 다음과 같이 내용물의 존재 여불르 확인할 수 있고, 또 해당 내용물을 꺼낼 수도 있다.

if(os1.isPresent())		// 내용물 존재하면 isPresent는 true 반환
	System.out.println(os1.get());	// get을 통한 내용물 반환
	
그런데 위의 예제에서는 Optional의 매력을 찾을 수 없다. 
그러나 다음 예제에서는 Optional의 매력을 조금 보여준다.(StringOptional2.java)

*/
