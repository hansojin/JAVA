package method;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

class JustSort {
	public void sort(List<?> lst) {    // 인스턴스 메소드
		Collections.reverse(lst);
	}
}

class ArrangeList3 {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
		ls = new ArrayList<>(ls);
		JustSort js = new JustSort();

		Consumer<List<Integer>> c = e -> js.sort(e);
		c.accept(ls);
		System.out.println(ls);	//[9, 7, 5, 3, 1]
	}
}



/*

인스턴스 메소드의 참조 1 : 인스턴스가 존재하는 상황에서 참조 
앞서 static 메소드를 참조하였듯이 인스턴스 메소드도 참조할 수 있다.

예제에서 먼저 보아야 할 것은 다음 람다식이다.

public static void main(String[] args) {
	...
	JustSort js = new JustSort();
	Consumer<List<Integer>> c = e->js.sort(e);
	...
}

위의 람다식에서는 다음 내용의 독특한 점을 확인할 수 있다.

"람다식에서 같은 지역 내에 선언된 참조변수 js에 접근하고 있다."

코드만 보면 문제가 없어 보인다. 그러나 람다식이 인스턴스의 생성으로 이어진다는 사실을 고려하면
이는 다소 특이한 일이 될 수 있다. 어찌 되었든 결론을 말하면, 위의 코드에서 보이듯이 람다식에서
같은 지역에 선언된 참조변수에 접근하는 것은 가능하다. 단 다음 조건을 만족해야 가능하다.

"람다식에서 접근 가능한 참조변수는 final로 선언되었거나 effectively final이어야 한다."

변수가 effectively final이라는 것은 '사실상 final 선언이 된 것과 다름없음'을 뜻한다. 위
예제에서 참조변수 js는 effectively final이다. js가 참조하는 대상을 수정하지 않기 때문이다.
그렇다면 위 예제의 main 메소드를 다음과 같이 수정하면 어떻게 될까? 컴파일 오류가 발생한다.
왜냐하면 이 경우 참조변수 js가 effectively final이 아니기 때문이다.

public static void main(String[] args) {
	...
	JustSort js = new JustSort();
	js = new JustSort();		// 다른 인스턴스를 참조하게 했다.
	Consumer<List<Integer>> c = l -> js.sort(l);
	...
}

다음과 같이 main 메소드의 마지막 문장에서 js에 null을 대입해도 컴파일 오류로 이어진다. 이유는
마찬가지로 js가 effectively final이 아니기 때문이다.

public static void main(String[] args){
	...
	JustSort js = new JustSort();	
	Consumer<List<Integer>> c = l -> js.sort(l);
	...
	js = null;	// 이로 인해 js는 effectively final이 아니다.
}

람다식으로 생성된 인스턴스 내에서 final로 선언되지 않았거나 effectively final이 아닌 참조변수를
참조하게 하는 것은 논리적 혼란을 일으키거나 예측 불가능한 상황으로 이어질 수 있어서 이러한 제한을
두고 있는 것이다. 그럼 다시 본론으로 돌아와서 위 예제에서 등장한 람다식은 다음과 같이 '메소드 참조'로
대신할 수 있다.

Consumer<List<Integer>> c = e -> js.sort(e);
	-> Consumer<List<Integer>> c = js::sort;

이렇듯 인스턴스 메소드는 다음과 같이 참조한다.

ReferenceName::instanceMethodName

 */