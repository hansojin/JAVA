package enumVarargs;

class AtFallThroughWarnings {
	@SuppressWarnings("fallthrough")
	public static void main(String[] args) {
		int n = 3;

		switch(n) {
		case 1:
			System.out.println(n);            
		case 2:
			System.out.println(n);
		case 3:
			System.out.println(n);
		}
	}
}

/*
	switch Fall Through란?
	switch 문에서 case 내에서 의도적으로 break문을 생략하여 다음 case로 이동 시키는 방법
	
	위의 방식은 의도적으로 사용할 때도 있다. 그럴 경우에는 무조건 주석을 달아줘야 한다.
	하지만 실수로 break문을 생략한 경우를 직접 겪어보니 에러가 어디에서 발생하는지 정말 찾기 힘들었다. 
	그러므로, 사용하지 말자
	
	javac -Xlint FallThroughWarnings.java
	옵션 -Xlint의 의미는 'enable recommended warnings'이다.
	경고 메시지의 다음 부분을 관찰하자. 여기서 [ ] 안에 위치한 것이 경고 유형이다.

	warning: [fallthrough] possible fall-through into case

	따라서 이 경고의 전달을 원치 않으면 다음과 같이 어노테이션 타입을 선언하면 된다.

	@SuppressWarnings("fallthrough")
	public static void main(String[] args) {...}

	그리고 둘 이상의 경고 유형에 대해 동시에 @SuppressWarnings 선언을 하고자 한다면 다음과 같이 문장을 구성하면 된다.

	@SuppressWarnings({"fallthrough", "deprecation"})
 */