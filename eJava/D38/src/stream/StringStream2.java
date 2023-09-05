package stream;

import java.util.Arrays;

class StringStream2 {
    public static void main(String[] args) {
        String[] names = {"YOON", "LEE", "PARK"};
        
        Arrays.stream(names)
            .forEach(s -> System.out.println(s));
    }
}

/*

Arrays 클래스에 정의되어 있는 다음 두 메소드를 보자

* public static IntStream stream(int[] array)
* public static IntStream stream(int[] array, int startInclusive, int endExclusive)

위의 두 메소드는 int형 배열을 대상으로 스트림을 생성한다. 특히 두 번째 메소드는 배열의 일부분을 대상으로 스트림을 생성한다. 
그리고 위의 두 메소드에 대한 double형 버전과 long형 버전은 다음과 같다. 마찬가지로 이들 모두 Arrays 클래스에 정의되어 있다.

public static DoubleStream stream(double[] array)
public static DoubleStream stream(double[] array, int startInclusive, int endExclusive)

public static LongStream stream(double[] array)
public static LongStream stream(double[] array, int startInclusive, int endExclusive)

*/
