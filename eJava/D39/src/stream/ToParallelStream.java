package stream;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.function.BinaryOperator;

class ToParallelStream {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");
        
        Stream<String> ss = ls.stream();	//이미 스트림을 생성한 상태에서
        
        BinaryOperator<String> lc = 
            (s1, s2) -> s1.length() > s2.length()? s1:s2;
            
        String str = ss.parallel()
                      .reduce("", lc);	//이를 기반으로 병렬 스트림을 생성하기를 원한다면
      
        System.out.println(str);	//Complex
    }
}
/*
지난 코드는, 아래와 같이 list에 대해서 stream을 생성하면서 비교
BinaryOperator<String> lc = (s,t) -> s.length()>t.length() ? s : t ;

//String longestWord = ls.stream().reduce("",lc);
String longestWord = ls.parallelStream().reduce("",lc);

System.out.println(longestWord);
*/

/*

병렬 스트림으로 변경
이미 스트림을 생성한 상태에서, 이를 기반으로 병렬 스트림을 생성하기를 원한다면 다음 메소드를 호출하면 된다.

>> Stream<T> parallel()		// Stream<T>의 메소드

마찬가지로 다음 메소드들도 병렬 스트림으로의 변경을 목적으로 호출하는 메소드들이다.

DoubleStream parallel()		// IntStream의 메소드
IntStream parallel()		// IntStream의 메소드
LongStream parallel()		// LongStream의 메소드

참고로 parallel 메소드는 Stream<T>, DoubleStream과 같이 스트림을 참조할 수 있는 형의 인터페이스들이 상속하는 BaseStream 인터페이스의 추상 메소드이다.

*/