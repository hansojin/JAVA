package lambda;

import java.util.function.DoubleUnaryOperator;

public class FunctionDemoDoubleUnary {
	public static void main(String[] args) {
		DoubleUnaryOperator cti = d -> d * 0.393701;
		DoubleUnaryOperator itc = d -> d * 2.54;

		System.out.println("1cm = " + cti.applyAsDouble(1.0) + "inch");
		System.out.println("1inch = " + itc.applyAsDouble(1.0) + "cm");
	}
}

/*
Function<T, R>			R apply(T t)
BiFunction<T, U, R>		R apply(T t, U u)

T, R 또는 T, U, R의 자료형이 일치하는 경우도 있을 수 있다. 이러한 상황을 고려하여 정의된 인터페이스는 다음과 같다.

UnaryOperator<T>		T apply(T t)
BinaryOperator<T>		T apply(T t1, T t2)

참고로 UnaryOperator<T>는 Function<T, R>을, 그리고 BinaryOperator<T>은 BiFunction<T, U, R>을 상속하여 정의한 인터페이스이다.
*/