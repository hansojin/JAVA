package stream;

import java.util.List;
import java.util.Arrays;
import java.util.function.BinaryOperator;

class ReduceParallelStream {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");
        
        BinaryOperator<String> lc = 
            (s1, s2) -> { 
               if(s1.length() > s2.length())
                   return s1;
               else 
                   return s2;                   
            };
        
        String str = ls.parallelStream()
                      .reduce("", lc);
      
        System.out.println(str);	//Complex
    }
}


/*
병렬 스트림(Parallel STreams)

하나의 작업을 둘 이상의 작업으로 나누어서 동시에 진행하는 것을 가리켜 '병렬 처리'라 하는데, 이는 속도 측면에서의 장점은 있지만, 
작업 구성이 어려워 과거에는 프로그래머들이 쉽게 적용하지 못하는 기술이었다. 그러나 멀티 코어 CPU가 대중화된 이 시점에서 자바는 언어 차원에서 '병렬 처리'를 지원한다. 
따라서 프로그래머들은 작업 구성을 신경 쓰지 않고 별령 처리를 진행할 수 있게 되었다.

위 예제와 이전 예제의 유일한 차이점은 다음 문장에서 stream이 아닌 parallelStream 메소드를 호출했다는 것이다.

String str = ls.parallelStream()		// 병령 처리를 위한 '병렬 스트림' 생성
				.reduce("", lc);

이렇듯 병렬 스트림을 생성하면 이어지는 연산들은 CPU의 코어 수를 고려하여 적절하게 병렬로 처리가 된다. 
image1.png도 병렬 스트림을 기반으로 하면 다음과 같이 달라진다. (image2.png 참고)

image2.png에서는 각각 다른 코어를 기반으로 data-1과 data-2, 그리고 data-3과 data-4를 대상으로 연산이 진행되는 상황을 표현하였다.
결과적으로 둘 이상의 연산을 동시에 진행하기 때문에 '연산의 단계'를 줄일 수 있고, 이로 인해 속도 측면에서 이점을 얻을 수 있다. 
참고로(지금부터 설명하는 내용은 지적인 즐거움을 위한 참고 내용이다) 앞서 보인 예제의 경우 스트림을 구성하는 문자열은 다음과 같았는데,

"Box", "Simple", "Complex", "Robot"

reduce 메소드의 첫 번째 인자로 빈 문자열이 전달되었으니, CPU의 코어가 넷 이상이라면 가상머신은 네 개의
코어를 활용하여 다음과 같은 방법으로 첫 번째 연산을 동시에 진행한다.

"빈 문자열" vs. "Box"
"빈 문자열" vs. "Simple"
"빈 문자열" vs. "Complex"
"빈 문자열" vs. "Robot"

그리고 나서 얻은 네 개의 결과물을 가지고 두 개의 코어를 활용하여 다음 연산을 동시에 진행한다.

"Box" vs. "Simple"
"Complex" vs. "Robot"

그리고 마지막으로 하나의 코어를 활용하여 다음 연산을 진행하고 최종 결과를 얻게 된다. 이렇듯 병렬
처리의 핵심은 연산의 횟수를 줄이는데 있지 않고 연산의 단계를 줄이는데 있다.

"Simple" vs. "Complex"
*/