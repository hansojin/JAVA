package lambda;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Predicate;

class RemoveIfDemo {
    public static void main(String[] args) {
        List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
        ls1 = new ArrayList<>(ls1);

        List<Double> ls2 = Arrays.asList(-1.1, 2.2, 3.3, -4.4, 5.5);
        ls2 = new ArrayList<>(ls2);
        
        Predicate<Number> p = n -> n.doubleValue() < 0.0;
        ls1.removeIf(p);
        ls2.removeIf(p);

        System.out.println(ls1);
        System.out.println(ls2);
    }
}

/*
< removeIf 메소드 >

Collection<E> 인터페이스에 다음 디폴트 메소드가 정의되어 있다.

>> default boolean removeIf(Predicate<? super E> filter)

위의 메소드 removeIf의 매개변수 선언은 다음과 같다. >> Predicate<? super E> filter

따라서 ArrayList<Integer> 인스턴스를 생성하면, 그 안에 존재하는 removeIf 메소드의 E는 다음과 같이 Integer로 결정된다.

public boolean removeIf(Predicate<? super Integer> filter) {...}

매개변수 선언에 <? super Integer>가 존재하므로, 다음 참조변수를 대상으로 람다식을 작성하여 위 메소드의 인자로 전달할 수 있다.

Predicate<Integer> f = ...
Predicate<Number> f = ...
Predicate<Object> f = ...

그렇다면 removeIf 메소드의 기능은 무엇일까? 이에 대한 자바 문서의 설명은 다음과 같다.

"Removes all of the elements of this collection that satisfy the given predicate"

보충을 해서 의역을 하면, 컬렉션 인스턴스에 저장된 인스턴스를 다음 test 메소드의 인자로 전달했을 때, "true가 반환되는 인스턴스는 모두 삭제하겠다"는 뜻이다.

public interface Predicate<T> {
	boolean test(T t);
}

위 예제(class RemoveIfDemo)에서는 다음 람다식을 구성하여,

Predicate<Number> p = n -> n.doubleValue() < 0.0;

이를 List<Integer> 인스턴스, 그리고 List<Double> 인스턴스의 removeIf 메소드에 인자로 전달을 하였다. 
이것이 가능한 이유는 removeIf 메소드의 매개변수 선언이 다음과 같기 때문이다.

Predicate<? super E> filter

*/
