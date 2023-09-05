package optional;

import java.util.Optional;

class OptionalBase {
    public static void main(String[] args) {
        Optional<Integer> oi1 = Optional.of(3);
        Optional<Integer> oi2 = Optional.empty();
        
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

 == OptionalInt, OptionalLong, OptionalDouble 클래스 ==

앞서 Optional 클래스에 대한 많은 설명을 진행하였다. 따라서 이번에는 Optional 클래스와 성격 및
내용이 유사하여 Optional의 친구들로 소개할 수 있는 다음 클래스들을 소개하고자 한다.

>> OptionalInt, OptionalLong, OptionalDouble

이미 Optional 클래스를 알고 있으니 이들과 Optional 클래스와의 차이점만 확인해도 충분하리라 생각한다.
그리고 이하 위의 클래스들을 묶우서 지칭할 때는 OptionalXXX 클래스라 하겠다.

 == Optional과 OptionalXXX와의 차이점 ==
 
OptionalXXX 클래스들은 Optional 클래스보다 그 기능이 제한적이다. 
그래서 Optional을 대신하는 경우는 많지 않다. 

*/
