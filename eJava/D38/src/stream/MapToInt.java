package stream;

import java.util.List;
import java.util.Arrays;

class MapToInt {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot", "Simple");
        
        ls.stream()
          .map(s -> s.length())
          .forEach(n -> System.out.print(n + "\t"));
        
        System.out.println();	//3	5 6	
    }
}



/*

맵핑(Mapping) 

맵핑도 필터링과 마찬가지로 중간 연산이다. 그리고 맵핑의 개념을 설명하면 이렇다. 
예를 들어서 다음 문자열을 담고 있는 배열이 있다.

String[] as = {"Box", "Robot", "Simple"};

그리고 이 배열에 저장된 데이터를 대상으로 다음과 같이 스트림을 생성하였다.
(스트림이 눈으로 보이는 실체가 아니기에 그냥 문자열을 나열하고 이를 스트림이라 하였다.)

"Box", "Robot", "Simple"

이 스트림을 기반으로 다음 스트림을 생성한다면 이것이 바로 맵핑이다. (아래의 숫자는 문자열의 길이다.)

3, 5, 6

즉 문자열 스트림을 숫자 스트림으로 맵핑하였고, 이때 사용된 맵핑의 기준은 문자열의 길이이다. 이렇듯
맵핑을 진행하면 스트림의 데이터 형이 달라지는 특징이 있다.

맵핑에 사용되는 대표적인 메소드는 다음과 같으며, 이는 보이는 바와 같이 제네릭 메소드이다.(맨 앞의
<R>은 제네릭 메소드임을 알린다. 그리고 편의상 화살표가 가리키는 수준으로 이해해도 괜찮다.)

<R> Stream<R> map(Function<? super T, ? extends R> mapper)	// Stream<T>에 존재
	-> <R> Stream<R> map(Function<T, R> mapper)		// 편의상
	
위 메소드의 매개변수 형이 Function이다. 따라서 다음 메소드의 구현에 해당하는 람다식을 인자로 전달해야 한다.

Function<T, R>	R apply(T t)

그러면 map은 내부적으로 스트림의 데이터를 하나씩 인자로 전달하며 apply 메소드를 호출한다. 그리고
그 결과로 반환되는 값을 모아 새로운 스트림을 생성한다. 위 예제의 경우 apply 메소드에 문자열이
전달되고, 그 문자열의 길이가 반환되도록 하는 것이 목적이니 다음 메소드의 구현에 해당하는 람다식을 인자로 전달하면 된다.

Integer apply(String t)

문법의 이해 정도에 따라 위에서 보인 map 메소드의 매개변수 선언이 복잡해 보일 수도 있다. 그러나
apply메소드에 무엇이 전달되고, 또 무엇이 반환되어야 하는지를 알면 map에 전달할 람다식을 쉽게 작성할 수 있다.
*/