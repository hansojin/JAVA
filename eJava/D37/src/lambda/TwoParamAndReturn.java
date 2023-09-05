package lambda;

interface Calculate1 {
	int cal(int a, int b);
}

class TwoParamAndReturn {
	public static void main(String[] args) {
		Calculate1 c;
		c = (a, b) -> { return a + b; };
		System.out.println(c.cal(4, 3));

		c = (a, b) -> a + b;
		System.out.println(c.cal(4, 3));
	}
}

/*

(a, b) -> { return a + b; }
이렇듯 메소드 몸체에 해당하는 내용이 return문이면 그 문장이 하나이더라도 중괄호의 생략이 불가능하다. 
그러나 위의 람다식은 다음 람다식으로 대신할 수 있다.

(a, b) -> a + b
이 경우 메소드 몸체에 연산이 등장하는데, 이 연산이 진행되면 그 결과로 값이 남게 된다. 
그러면 이 값은 별도로 명시하지 않아도 반환의 대상이 된다. 
따라서 return 문이 메소드 몸체를 이루는 유일한 문장이면 위와 같이 작성할 수 있따.

  */
