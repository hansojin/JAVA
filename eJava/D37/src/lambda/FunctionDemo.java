package lambda;

import java.util.function.Function;

class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();

        System.out.println(f.apply("Robot"));
        System.out.println(f.apply("System"));
    }
}

/*
Function<T, R> 인터페이스에는 다음 추상 메소드가 존재한다.

>> R apply(T t);		// 전달 인자와 반환 값이 모두 존재할 때
이렇듯 Function<T, R>의 추상 메소드는 전달 인자와 반환 값이 있는 가장 보편적인 형태이다. 
따라서 프로그래머가 흔히 사용할 수 있는 인터페이스라 할 수 있다.
*/
