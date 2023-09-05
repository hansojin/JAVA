package optional;

import java.util.Optional;

class StringOptional2 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1"));
        Optional<String> os2 = Optional.ofNullable(new String("Toy2"));

        // 람다식 버전
        os1.ifPresent(s -> System.out.println(s));

        // 메소드 참조 버전
        os2.ifPresent(System.out::println);
    }
}


/*

위 예제에서 호출하고 있는 메소드 ifPresent의 매개변수 형은 Consumer이다.

>> public void ifPresent(Consumer<? super T> consumer)

따라서 다음 메소드 accept의 구현에 해당하는 람다식을(또는 메소드 참조를) ifpresent 호출 시 인자로 전달해야 한다.

Consumer<T>		void accept(T t)
	-> Optional<String>의 T 가 String이므로 void accept(String t)
	
그러면 ifPresent가 호출되었을 때, Optional인스턴스가 저장하고 있는 내용물이 있으면, 이 내용물이
인자로 전달되면서 accept 메소드가 호출된다. (다시 말해서 전달된 람다식이 실행된다.) 반면 내용물이 없으면
아무 일도 일어나지 않는다. 따라서 다음의 if문을

if(os1.isPresent())
	System.out.println(os1.get());

다음과 같이 줄일 수 있따. 그리고 이렇듯 if문이 사라졌다는 것에는 큰 의미가 있다.

os1.ifPresent(s->System.out.println(s));

*/