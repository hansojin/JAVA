package lambda;

interface Printable {
	void print(String s);    // 매개변수 하나, 반환형 void
}

class OneParamNoReturn {
	public static void main(String[] args) {
		Printable p;

		p = (String s) -> {System.out.println(s);};    // 줄임 없는 표현
		p.print("Lambda exp one.");

		p = (String s) -> System.out.println(s);    // 중괄호 생략
		p.print("Lambda exp two.");

		p = (s) -> System.out.println(s);    // 매개변수 형 생략
		p.print("Lambda exp three.");

		p = s -> System.out.println(s);    // 매개변수 소괄호 생략
		p.print("Lambda exp four.");
	}
}

/*
매개변수가 있고 반환하지 않는 람다식

예제에서 보이듯이 줄임이 없는 람다식은 다음과 같다. 매개변수 정보에 소괄호를 하고 메소드 몸체에 중괄호를 한다.

(String s) -> { System.out.println(s); }

그러나 메소드의 몸체가 하나의 문장으로 이뤄져 있다면 다음과 같이 중괄호의 생략이 가능하다.
(String s) -> System.out.println(s)

단 중괄호를 생략할 때 해당 문장의 끝에 위치한 세미콜론도 함께 지워야 한다.(메소드의 몸체를 이루는 하나의 문장이 return 문이라면 중괄호의 생략은 불가능하다.
그리고 매개변수 정보에 있어서 s가 String형 임은 컴파일러 입장에서 유추가 가능하다.(해당 람다식이 채우게 될 메소드 정보를 통해서 유추가 가능하다.) 따라서 다음과 같이 매개변수의 자료형 정보도 생략 가능하다.

(s) -> System.out.println(s)

그리고 매개변수가 위와 같이 하나일 경우에는 다음과 같이 소괄호도 생략할 수 있다.

s-> System.out.println(s)

물론 메소드 몸체가 둘 이상의 문장으로 이뤄져 있거나, 매개변수의 수가 둘 이상인 경우에는 각각 중괄호와 소괄호의 생략이 불가능하다.
 */
