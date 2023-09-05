package stream;

import java.util.List;
import java.util.Arrays;

class MapToInt2 {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot", "Simple");
        
        ls.stream()
          .mapToInt(s -> s.length())
          .forEach(n -> System.out.print(n + "\t"));
        
        System.out.println();	//3	5	6	
    }
}



/*
앞서 보인 예제 MapToInt.java는 잘 동작하지만, 
map의 인자로 다음 메소드에 대한 람다식을 전달하기 때문에 정수의 반환 과정에서 "오토 박싱이 진행"된다.

>> R apply(T t)

그래서 자바에서는 기본 자료형의 값을 반환하는 경우를 고려하여 다음 맵핑 관련 메소드들도 제공하고 있다.
(편의상 화살표가 가리키는 수준으로 이해해도 괜찮다.)

IntStream mapToInt(ToIntFunction<? super T> mapper)
	->IntStream mapToInt(ToIntFunction<T> mapper)
	
LongStream mapToLong(ToLongFunction<? super T>mapper)
	-> LongStream mapToLong(ToLongFunction<T>mapper)
	
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
	-> DoubleStream mapToDouble(ToDoubleFunction<T> mapper)

이전 예제와의 유일한 차이점은 map을 대신하여 mapToInt를 호출한 것이다. 
그리고 이로 인해 이전 예제와 달리 오토 박싱이 진행되지 않았다.

*/
