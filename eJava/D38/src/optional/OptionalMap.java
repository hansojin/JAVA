package optional;

import java.util.Optional;

class OptionalMap {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of("Optional String");
        Optional<String> os2 = os1.map(s -> s.toUpperCase());
        System.out.println(os2.get());		//OPTIONAL STRING

        Optional<String> os3 = os1.map(s -> s.replace(' ', '_')).map(s -> s.toLowerCase());
        System.out.println(os3.get());	//optional_string
    }
}

/*

위 예제에서 호출한 map 메소드의 매개변수 형은 다음과 같이 Function이다. 그리고 자세히 보면
map은 제네릭 클래스에 정의된 제네릭 메소드임을 알 수 있따.(T는 제네릭 클래스의 멤버임을 알려주고, U는 제네릭 메소드임을 알려준다.)

>> public <U> Optional<U> map(Function<? super T, ? extends U> mapper)

따라서 다음 메소드 apply의 구현에 해당하는 람다식을 map 호출 시 인자로 전달해야 한다.

>> Function<T, U> U apply(T t)

그런데 예제에서는 Optional<String>의 인스턴스를 대상으로 map 메소드를 호출하므로, 다음 메소드의 
구현에 대한 람다식을 작성하면 된다. 즉 T는 Optional<String> 인스턴스 생성 시 String으로 이미 결정이 난 상태이다.

>> U apply(String t)

그리고 map 메소드는 <U>에 대한 제네릭 메소드이므로, 이 U는 메소드를 호출하는 시점에서 결정이 된다.
그렇다면 map 메소드가 하는 일은 무엇일까? (사실 이 내용이 제일 중요하다.)

"apply 메소드가 반환하는 대상을 Optional 인스턴스에 담아서 반환한다."

예를 들어서 위 예제의 다음 문장을 보자.

Optional<String> os2 = os1.map(s->s.toUpperCase());

위 문장의 람다식은 String 인스턴스의 참조 값을 반환한다. 따라서 위 문장의 map이 호출되는 순간
반환형 U가 String으로 결정되어 위의 람다식은 다음 apply 메소드의 몸체를 구성하게 된다. 그리고
위 문장의 map이 호출되면 아래의 apply 메소드의 인자로는 참조변수 os1이 지니는 인스턴스가 전달이 된다.

String apply(String s) {
	return s.toUpperCase();	// 문자열의 모든 문자를 대문자로 바꿔서 반환
}
	
그리고 위 메소드가 호출되었을 때 반환하는 값을 map은 그냥 반환하지 않고 Optional 인스턴스로 감싸서 반환한다.

---

[참고] 제네릭 클래스에 정의된 제네릭 메소드

Optional<T>는 제레릭 클래스이다. 따라서 Optional<String>의 인스턴스 메소드인 map은 다음과 같은 상황이다.

>> public <U> Optional<U> map(Function<? super String, ? extends U> mapper)

그리고 이는 제네릭 메소드이므로 U는 메소드 호출시 결정된다. 예를 들면 다음과 같다.

>> Optional<String> os2 = os1.<String>map(s->toUpperCase());

위 문장에서는 map 호출 시 U를 String으로 지정하였다. 그러나 String 인스턴스의 참조 값이 반환된다는
사실이 이미 람다식에 반영되어 있으므로 위 문장에서 U에 대한 정보를 생략하여 다음과 같이 문장을 구성할 수 있다.
그러면 컴파일러가 문장을 분석하여 U를 String으로 결정해준다.

>> Optional<String> os2 = os1.map(s->s.toUpperCase());
*/