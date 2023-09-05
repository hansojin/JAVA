package optional;

import java.util.Optional;

class OptionalFlatMap {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of("Optional String");

        Optional<String> os2 = os1.map(s -> s.toUpperCase());
        System.out.println(os2.get());		//OPTIONAL STRING

        Optional<String> os3 = os1.flatMap(s -> Optional.of(s.toLowerCase()));
        System.out.println(os3.get());		//optional string
    }
}


/*

위 예제에서 보이는 다음 두 문장을 비교하자. 이 두 문장의 비교를 통해 flatMap을 이해할 수 있다.

>> Optional<String> os2 = os1.map(s->s.toUpperCase());
>> Optional<String os3 = os1.flatMap(s->Optional.of(s.toLowerCase()));

위의 두 문장에서 호출하는 map과 flatMap 모두 Optional 인스턴스를 반환한다. 다만 map은 람다식이
반환하는 내용물을 Optional 인스턴스로 감싸는 일을 알아서 해주지만, flatMap은 알아서 해 주지 않기
때문에 이 과정을 람다식이 포함하고 있어야 한다. 이것이 두 메소드의 차이점이다.

그렇다면 flatMap은 언제 유용하게 사용할 수 있을까? 
다음 예제에서(FlatMapElseOptional.java) 보이듯이 Optional 인스턴스를 클래스의 멤버로 두는 경우에 유용하게 사용할 수 있다.
*/