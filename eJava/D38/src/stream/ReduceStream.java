package stream;

import java.util.List;
import java.util.Arrays;
import java.util.function.BinaryOperator;

class ReduceStream {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");
        
        BinaryOperator<String> lc = 
            (s1, s2) -> { 
               if(s1.length() > s2.length())
                   return s1;
               else 
                   return s2;                   
            };
        
        String str = ls.stream()
                      .reduce("", lc);
      
        System.out.println(str);	//Complex
    }
}



/*
	리덕션(Reduction), 병렬 스트림(Parallel Streams)
	
	앞서 최종 연산 sum과 forEach를 사용해 보았다. 이에 이어서 최종 연산을 대표하는 reduce 메소드를 소개하고자 한다.
	
	리덕션과 reduce 메소드
	
	'리덕션(Reduction)'은 데이터를 축소하는 연산'을 뜻한다. 앞서 보인 sum도 리덕션 연산에 해당한다.
	다수의 데이터를 더하여 '합'이라는 하나의 데어터만 남겼으니 sum도 리덕션 연산이다. 이렇듯 대부분의 리덕션 연산은 사용하기 쉬운 편이다. 
	그러나 여기 조금 다른 리덕션을 진행하는 메소드가 있어 소개하고자 한다.
	
	T reduce(T identity, BinaryOperator<T> accumulator)		// stream<T>에 존재
	
	이 메소드는 다른 리덕션 연산에 비해 활용도가 높다. 다른 리덕션 연산의 경우 연산의 내용이 이미 정해진
	상태이지만 reduce는 전달하는 람다식에 의해 연산의 내용이 결정되기 때문이다. 이 메소드의 동작 원리를
	설명하기 위해 두 번째 매개변수의 형인 BinaryOperator<T>의 추상 메소드를 보이겠다.
	
	BinaryOperator<T>	T apply(T t1, T t2)
	
	reduce 호출 시 위의 메소드 apply에 대한 람다식을 인자로 전달해야 한다. 그러면 reduce는 내부적으로
	apply를 호출하면서 스트림에 저장된 데이터를 다음과 같은 방식으로 줄여 나간다.
	
	위 그림은 스트림에 총 4개의 데이터가 존재하는 상황을 표현하였다. 이 상황에서 reduce는 내부적으로 apply를
	호출하면서 data-1과 data-2를 인자로 전달하고 그 결과로 result-1을 얻는다. 그리고 이어서 
	result-1과 data-3을 apply에 전달하고 결과로 result-2를 얻는다. 마지막으로 result-2와 data-4를
	apply에 전달하고 그 결과로 result-3을 얻는데, 이것이 최종 결과이다. 따라서 result-3은 reduce가
	반환하는 최종 값이 된다.
	
	다음은 위 예제에서 작성한 람다식이다. 이 람다식이 reduce 메소드가 호출하는 apply 메소드의 몸체가 된다.
	
	BinaryOperator<String> lc = (s1, s2) -> {
		if(s1.length() > s2.length())
			return s1;
		else
			return s2;
	};
	
	일단 두 개의 문자열을 전달받아서 그 길이를 비교하여 긴 문자열을 반환하는 람다식이다.(두 문자열의 길이가
	동일할 대는 두 번째 문자열을 반환하도록 작성하였다.) 그리고 이 람다식을 다음과 같이 reduce 메소드를
	호출하면서 인자로 전달하였다.
	
	String str = ls.stream()
					.reduce("", lc);	// 스트림이 빈 경우 빈 문자열 반환
					
	따라서 reduce는 내부적으로 스트림을 구성하는 문자열의 길이를 비교해 나간다. 그리고 마지막에는 가장 긴 문자열을 반환하게 된다.
	
	한가지 더 살표볼 내용은 reduce 메소드의 첫 번째 인자이다. 첫 번째 인자로 전달되는 값은 스트림을
	구성하는 데이터가 하나도 없을 때 반환이 된다. 즉 위 예제의 경우 ls가 참조하는 컬렉션 인스턴스에
	저장된 문자열이 없을 경우 빈 문자열이 반환된다. 그런데 이 정도만 알고 있으면 위의 문장을 다음과 같이
	구성하는 오류를 범할 수 있다.
	
	String str = ls.stream()
					.reduce("Empty Stream", lc);	// 스트림이 빈 경우 "Empty Stream" 반환
					
	의도가 좋다. 스트림이 비어 있을 경우 이를 알리기 위한 문자열이 반환되도록 문장을 작성한 것이다.
	그런데 이 문장으로 대체하고 예제를 실행할 경우 reduce 메소드는 "Empty Stream"을 반환한다.
	스트림이 비어 있지 않아도 말이다.
	
	reduce 메소드는 '첫 번째 인자로 전달된 값'을 스트림이 빈 경우에 반환을 한다. 뿐만 아니라 스트림이
	비어 있지 않은 경우엔 이를 스트림의 첫 번째 데이터로 간주하고 리덕션을 진행한다. 때문에 "Empty Stream"이
	가장 긴 문자열이 되어 reduce 메소드의 반환 값이 될 수 있다. 참고로 이러한 reduce 메소드의 특성은 의외로
	유용하다. 예를 들어서 조건을 충족하는 데이터가 스트림에 없을 때, 이를 대신할 데이터를 지정할 수 있다.
*/
