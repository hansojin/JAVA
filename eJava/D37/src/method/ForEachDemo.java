package method;

import java.util.List;
import java.util.Arrays;

class ForEachDemo {

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        
        // 람다식 기반
        ls.forEach(s -> System.out.println(s));

        // 메소드 참조 기반
        ls.forEach(System.out::println);
    }
}

/*

Collection<E> 인터페이스는 Iterable<T>를 상속한다. 따라서 컬렉션 클래스들은 Iterable<T>를
대부분 구현하게 되는데, 이 인터페이스에는 다음 디폴트 메소드가 정의되어 있다.

default void forEach(Consumer<? super T> action) {
	for(T t: this)		// this는 이 메소드가 속한 컬렉션 인스턴스를 의미함
		action.accept(t);	// 모든 저장된 데이터들에 대해 이 문장 반복
}

즉 위의 메소드가 호출되면 컬렉션 인스턴스에 저장되어 있는 모든 인스턴스들을 대상으로 다음 문장을 실행하게 된다.

>> action.accept(t);		// 이때 t는 저장되어 있는 인스턴스 각각을 의미함

따라서 우리는 forEach 메소드 호출을 위해서 Consumer<T> 인터페이스에 대한 람다식 또는 메소드
참조를 전달해야 한다. 그런데 Consumer<T>의 추상 메소드는 다음과 같다.

>> void accept(T t);		// 반환하지 않고, 전달된 인자를 대상으로 어떤 결과를 보임

그리고 이에 딱 맞는 메소드 중 하나가 System.out.println이다. 이는 아래에서 보이듯이
accept와 반환형 및 매개변수 선언이 동일하다.(물론 accept의 T가 String일 경우에 매개변수 선언이
동일하다.)

>> public void println(String x)

System.out이 PrintStream 인스턴스를 참조하는 참조변수임을 설명하였다. 따라서 다음과 같이
람다식 또는 메소드 참조를 통한 forEach문의 호출을 진행할 수 있다.

ls.forEach(s -> System.out.println(s));
	-> ls.forEach(System.out::println);

*/