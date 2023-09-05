package stream;

import java.util.Arrays;

class MyFirstStream2 {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(ar)
                        .filter(n -> n%2 == 1)
                        .sum();

        System.out.println(sum);	//9
    }
}



/*

	public static IntStream stream(int[] array)
	IntStream filter(intPredicate predicate)
	
	그리고 예제에서 호출한 filter와 sum은 IntStream의 인스턴스 메소드이다. 
	따라서 다음과 같이 스트림의 생성과 그에 따른 연산의 과정을 하나의 문장으로 완성할 수 있다.
	
	int sum = Arrays.stream(ar)		// 스트림 생성하고,
                .filter(n -> n%2 == 1)		// filter 통과시키고,
                .sum();			// sum을 통과시켜 그 결과 반환
                
    그리고 스트림의 연산은 효율과 성능을 고려하여 '지연(Lazy) 처리' 방식으로 동작한다. 위의 문장에서는
    메소드 호출시 filter에서 sum으로 이어지지만, 정작 sum이 호출될 때까지 filter의 호출 결과는
    스트림에 반영되지 않는다. 즉 최종 연산인 sum이 호출되어야 filter의 호출 결과가 스트림에 반영되고,
    이어서 sum의 호출 결과가 스트림에 반영된다. 따라서 '최종 연산'은 파이프에 물을 흘려보내기위한
    '잠금 밸브를 여는 행위'를 수반한다고 볼 수 있다.
    
    "만약에 중간 연산은 진행하고, 최종 연산은 진행하지 않는다면?"
    
    최종 연산이 생략되면 그전에 아무리 많은 중간 연산을 진행했다 하더라도 의미가 없다. 쉽게 말해서 아무런 결과도 보이지 않는다.

*/
