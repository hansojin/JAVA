package stream;

import java.util.Arrays;
import java.util.stream.Stream;

class StringStream {
    public static void main(String[] args) {
        String[] names = {"YOON", "LEE", "PARK"};
        
        // 스트림 생성
        Stream<String> stm = Arrays.stream(names);
        
        // 최종 연산 진행
        stm.forEach(s -> System.out.println(s));
    }
}



/*
* 스트림의 생성 방법 : 배열 및 컬렉션 인스턴스 대상으로 스트림을 생성하는 방법
* 중간 연산의 종류와 내용 : 필터링(Filtering) 및 맵핑(Mapping) 곤련 연산
* 최종 연산의 종류와 내용 : 리덕션(Reduction) 관련 연산

배열에 저장된 데이터를 대상으로 스트림을 생성할 때 호출하는 대표 메소드는 다음과 같다.

public static <T> stream <T> stream(T[] array)	// Arrays 클래스에 정의

Iterable<T> 이터페이스에 forEach 디폴트 메소드가 정의되어 있다.

default void forEach(Consumer<? super T> action) {
	for(T t: this)
		action.accept(t);
}

그러나 위 예제에서 호출한 forEach는 인스턴스 메소드이다. 즉 이 두 메소드는 이름과 매개변수 선언이
같지만 존재하는 위치가 다르다. 그러나 두 메소드의 기능은 동일하니 존재하는 위치 때문에 혼란스러워 하지
않았으면 좋겠다. 어쨌든 forEach의 매개변수 형이 Consumer<T>이니 다음 추상 메소드의 구현에
해당하는 람다식을 인자로 전달해야 한다. 그러면 forEach는 내부적으로 스트림의 데이터를 하났기 인자로
전달하면서 accept 메소드를 호출한다.

Consumer<T> void accept(T t)

그리고 forEach는 '최종 연산'이기도 하다. 그래서 예제에서는 스트림 생성 이후에 이 메소드를 통해서
스트림을 이루고 있는 문자열들을 출력하였다. (이렇듯 '중간 연산' 없이 바로 '최종 연산'을 진행할 수도
있다.) 그리고 지금은 스트림의 생성 방법을 소개하는 시간이지만, 최종 연산에 해당하는 forEach에 대해서도
알고 있어야 한다.
*/