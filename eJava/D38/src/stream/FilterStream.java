package stream;

import java.util.List;
import java.util.Arrays;

class FilterStream {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        Arrays.stream(ar)
            .filter(n -> n%2 == 1)
            .forEach(n -> System.out.print(n + "\t"));
        System.out.println();

        List<String> sl = Arrays.asList("Toy", "Robot", "Box");
        sl.stream()
            .filter(s -> s.length() == 3)
            .forEach(s -> System.out.print(s + "\t"));
        System.out.println();       
    }
}

//1	3	5	
//Toy	Box	

/*

필터링(Filtering)과 맵핑(Mapping)
스트림이 배열을 대상으로 생성되었건 커렉션 인스턴스를 대상으로 생성되었건, 이에 상관없이 동일한 방법으로
'중간 연산'과 '최종 연산'을 진행할 수 있다.(적용 가능한 연산의 종류에 약간의 차이는 있다.) 즉
지금부터 설명하는 중간 연산인 '필터링'과 '맵핑'은 모든 스트림에 적용 가능하다.

필터링(Filtering)
필터링은 그 이름처럼 스트림을 구성하는 데이터 중 일부를 조건에 따라 걸러내는 행위를 의미하는데,
필터링에 사용되는 메소드는 다음과 같다.

>> Stream<T> filter(Predicate<? super T> predicate)	// Stream<T>에 존재

위 메소드의 매개변수 선언에서 보이듯이 매개변수 형이 Predicate이다. 따라서 Predicate의 다음 추상
메소드의 구현에 해당하는 람다식을 인자로 전달해야 한다.

>> Predicate<T>	boolean test(T t)

그러면 filter 메소드는 내부적으로 스트림의 데이터를 하나씩 인자로 전달하면서 test를 호출한다.
그리고 그 결과 true가 반환되면 해당 데이터는 스트림에 남긴다. 
반면 false가 반환되면 해당 데이터는 거른다(버린다).
*/