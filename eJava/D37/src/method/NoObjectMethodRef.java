package method;

import java.util.function.ToIntBiFunction;

class IBox {
	private int n; 

	public IBox(int i) { n = i; }

	public int larger(IBox b) {
		if(n > b.n)
			return n;
		else
			return b.n;
	}
}

class NoObjectMethodRef {
	public static void main(String[] args) {
		IBox ib1 = new IBox(5);
		IBox ib2 = new IBox(7);

		// 두 상자에 저장된 값 비교하여 더 큰 값 반환
		ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
		int bigNum = bf.applyAsInt(ib1, ib2);
		System.out.println(bigNum);		// 7
	}
}



// ToIntBiFunction<T, U>	int applyAsInt(T t, U u)
/*

인스턴스 메소드의 참조 2 : 인스턴스 없이 인스턴스 메소드 참조

위 예제에서 등장한 람다식은 다음과 같다.

ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);

위 람다식에서 호출하는 메소드 larger가 '첫 번째 인자로 전달된 인스턴스의 메소드'라는 사실에
주목하자. 이러한 경우 다음과 같이 메소드 참조가 이를 대신할 수 있다. (이는 일종의 약속이다.)

ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
	-> ToIntBiFunction<IBox, IBox> bf = IBox::larger;	// 메소드 참조 방식

메소드 참조를 위한 IBox::larger만 보면 static 메소드 참조처럼 보인다. 그러나 이는 인스턴스 메소드의 참조이다.

ClassName::instanceMethodName

여기까지 설명을 하고 끝을 내면 다음과 같이 묻는 경우가 대부분이다.

"이렇게 막 줄여도 돼요? 어떻게 이런 생략이 가능하죠?"

그럼 역으로 생각해보자. 다음 문장 이후에,

ToIntBiFunction<IBox, IBox> bf = IBox::larger;

다음과 같이 메소드 호출이 진행이 되었다고 가정해보자.

bf.applyAsInt(ib1, ib2);

이때 bf가 참조하는 메소드는 IBox::larger이다. 그리고 이는 ib1도 ib2도 갖는 인스턴스 메소드이다.

그런데 '첫 번째 전달인자를 대상으로 이 메소드를 호출하기로 약속하였으므로' 다음과 같이 위의 문장이
실행된다. (아래의 코드는 메소드 정의가 아니다. applyAsInt 메소드가 호출될 때 실행되는 내용을 표현한 것이다.)

bf.applyAsInt(ib1, ib2) {
	ib1.larger(ib2);		// 이렇게 문장을 구성하기로 약속하였음
}

즉 모든 생략은 약속에 근거한다. 그리고 익숙해지면 이러한 생략이 매우 편하게 다가온다. 그러나 모든
약속이 그러하듯이 익숙하지 않으면 조금 불편하다. 사실이 그렇다. 그럼 위 예제를 메소드 참조 기반으로
수정한 결과를 보일 차례인데, 차이가 나는 것은 다음 문장이 전부이니 위 예제를 직접 수정하여 그 결과를
확인하도록 하자.

ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
	-> ToIntBiFunction<IBox, IBox> bf = IBox::larger;	// 메소드 참조 방식
 */