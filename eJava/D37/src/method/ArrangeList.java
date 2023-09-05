package method;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

class ArrangeList {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);

        Consumer<List<Integer>> c = l -> Collections.reverse(l);	// 람다식
        c.accept(ls);	// 순서 뒤집기 진행
        System.out.println(ls);		// [9, 7, 5, 3, 1]
    }
}

/*

메소드 참조(Method References)

람다식은 결국 메소드의 정의이다. 따라서 다음과 같이 생각해 볼 수 있다. "이미 정의되어 있는 메소드가 있다면, 이 메소드의 정의가 람다식을 대신할 수 있지 않을까?

실제로 메소드 정의는 람다식을 대신할 수 있다. 자바 8에서 소개된 '메소드 참조'라는 방법을 통해서 이러한 일이 가능하다.

@ 메소드 참조의 4가지 유형과 메소드 참조의 장점
 
 - 메소드 참조의 유형 -
* static 메소드의 참조
* 참조변수를 통한 인스턴스 메소드 참조
* 클래스 이름을 통한 인스턴스 메소드 참조
* 생성자 참조

과거에는 코드 자체에 대한 가독성을 중시하는 분위기였다. 따라서 읽기 쉬운 코드라면 양이 조금 늘어나도
괜찮다는 분위기였다. 그러나 근래에는 코드의 양을 줄이는데 초점이 맞춰지고 있다. 코드의 양을 줄이면
코드의 생산성도 향상되고, 이는 결국 코드의 가독성 개선으로 이어진다는 논리이다. 이러한 흐름에 어울리게
'메소드 참조'는 람다식으로 줄어든 코드의 양을 조금 더 줄일 수 있게 한다. 따라서 메소드 참조가 유용한
상황이 연출되면 프로그래머들은 이를 람다식이 아닌 메소드 참조를 통해 해결할 것이다.

위 예제의 핵심 문장은 다음과 같다.

Consumer<List<Integer>> c = l -> Collections.reverse(l);

그리고 만약에 Collections 클래스의 다음 메소드를 몰랐다면, 위와 같이 간단한 람다식의 작성은 불가능했을 것이다.

public static void reverse(List<?> list)	// 저장 순서를 뒤집는다.

이렇듯 람다식을 작성할 때, 이미 정의되어 있는 메소드를 사용하는 것에는 큰 의미가 있다. 그리고 이러한
경우를 고려하여 자바 8에서부터는 람다식을 작성할 필요 없이 다음과 같이 메소드 정보만 전달할 수 있도록
하고 있다.

Consumer<List<Integer>> c = Collections::reverse;

즉 static 메소드의 참조 방법은 다음과 같다. 그리고 아래에서 ::은 자바 8에서 추가된, 메소드 참조를 의미하는 연산자이다.

ClassName::staticMethodName

정리하면, 다음과 같이 '메소드 참조'를 기반으로 람다식을 대신할 수 있다.

Consumer<List<integer>> c = l -> Collections.reverse(l);
	-> Consumer<List<Integer>> c = Collections::reverse;
	
위의 '메소드 참조'에서 람다식에 있는 인자 전달에 대한 정보를 생략할 수 있는 이유는 다음 약속에 근거한다.

"accept 메소드 호출 시 전달되는 인자를 reverse 메소드를 호출하면서 그대로 전달한다."

이러한 약속이 없었다면 메소드 참조라는 것이 존재할 수 없다.
*/
