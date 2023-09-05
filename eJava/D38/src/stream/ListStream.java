package stream;

import java.util.List;
import java.util.Arrays;

class ListStream {
    public static void main(String[] args) {
        
        List<String> list = Arrays.asList("Toy", "Robot", "Box");
        
        list.stream()
          .forEach(s -> System.out.print(s + "\t"));

        System.out.println();
    }
}

/*

스트림 생성하기 : 컬렉션 인스턴스

컬렉션 인스턴스를 대상으로 스트림을 생성하고 싶다면, 마찬가지로 stream 메소드를 찾으면 된다.

그리고 이를 목적으로 정의된 stream 메소드는 java.util.Collection<E>에 디폴트 메소드로 다음과
같이 정의되어 있따.

>> default Stream<E> stream()

즉 컬렉션 인스턴스를 대상으로도 stream 메소들르 호출하여 스트림을 생성할 수 있다.

*/