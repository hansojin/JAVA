package optional;

import java.util.OptionalInt;

class OptionalIntBase {
    public static void main(String[] args) {
        OptionalInt oi1 = OptionalInt.of(3);
        OptionalInt oi2 = OptionalInt.empty();
        
        System.out.print("[Step 1.] : ");
        oi1.ifPresent(i -> System.out.print(i + "\t"));
        oi2.ifPresent(i -> System.out.print(i));
        System.out.println();

        System.out.print("[Step 2.] : ");
        System.out.print(oi1.orElse(100) + "\t");
        System.out.print(oi2.orElse(100) + "\t");
        System.out.println();
    }
}

//[Step 1.] : 3	
//[Step 2.] : 3	100	

/*
두 예제(OptionalBase.java와 OptionalIntBase.java)를 통해서 Optional<T>에서 T를 Integer로 구체화한 것이 
OptionalInt 임을 짐작할 수 있을 것이다. 이로써 OptionalXXX 클래스들에 대한 설명을 마치고자 한다. 
Optional<T>에서 T를 int로 구체화한 것을 OptionalInt인 것처럼 OptionalLong과 OptionalDouble을 이해하고 활용하면 된다.
(단 OptionalXXX 클래스들에는 map과 flatMap 메소드가 정의되어 있지 않다.)
*/