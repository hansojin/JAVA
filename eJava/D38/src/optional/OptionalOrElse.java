package optional;

import java.util.Optional;

class OptionalOrElse {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.empty();
        Optional<String> os2 = Optional.of("So Basic");

        String s1 = os1.map(s -> s.toString()).orElse("Empty");
        String s2 = os2.map(s -> s.toString()).orElse("Empty");

        System.out.println(s1);		//Empty
        System.out.println(s2);		//So Basic
    }
}

/*

Optional 클래스를 사용하면 if ~ else문을 대신할 수 있다 >> orElse 메소드

Optional 클래스에는 "Optional 인스턴스에 저장된 내용물을 반환하는 get 메소드가 존재"한다.
그리고 이와 유사한 기능의 orElse 메소드도 존재한다. 즉 orElse 메소드도 Optional
인스턴스에 저장된 내용물을 반환한다. 단 저장된 내용물이 없을 때, 대신해서 반환할 대상을 지정할 수
있다는 점에서 get 메소드와 차이가 있다.

다음과 같이 empty 메소드를 호출하면 저장하고 있는 내용물이 없는, 빈 Optional 인스턴스가
생성되어 반환된다.(그 아래의 ofNullable 메소드의 호출 문장과 동일한 문장이다.)

Optional<String> os1 = Optional.empty();
	-> Optional<String> os1 = Optional.ofNullable(null);
	
그리고 이 참조변수를 대상을 다음 문장을 실행하면 map 메소드가 호출되고, 이어서 orElse 메소드가 호출되어 그 반환 값이 s1에 저장된다.

>> String s1 = os1.map(s->s.toString()).orElse("Empty");

그런데 os1이 참조하는 Optional 인스턴스는 비어 있다. 이러한 경우 map은 빈 Optional 인스턴스를 생성하여 반환한다. 

결국 위의 문장은 map이 반환한 빈 Optional 인스턴스를 대상으로 orElse메소드를 호출하게 된다. 
그리고 이렇듯 빈 Optional 인스턴스를 대상으로 orElse 메소드를 호출하면, orElse를 호출하면서 전달된 인스턴스가 대신 반환된다. 
즉 위의 문장이 실행되면 s1은 문자열 "Empty"를 참조하게 된다.

*/