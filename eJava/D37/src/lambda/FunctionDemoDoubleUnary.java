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

T, R �Ǵ� T, U, R�� �ڷ����� ��ġ�ϴ� ��쵵 ���� �� �ִ�. �̷��� ��Ȳ�� ����Ͽ� ���ǵ� �������̽��� ������ ����.

UnaryOperator<T>		T apply(T t)
BinaryOperator<T>		T apply(T t1, T t2)

����� UnaryOperator<T>�� Function<T, R>��, �׸��� BinaryOperator<T>�� BiFunction<T, U, R>�� ����Ͽ� ������ �������̽��̴�.
*/