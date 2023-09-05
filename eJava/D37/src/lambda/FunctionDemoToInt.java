package lambda;

import java.util.function.ToIntFunction;

class FunctionDemoToInt {
    public static void main(String[] args) {
        ToIntFunction<String> f = s -> s.length();

        System.out.println(f.applyAsInt("Robot"));
        System.out.println(f.applyAsInt("System"));
    }
}

/*

Function<T, R>���� T�� R�� ��� �⺻ �ڷ������� �����Ͽ� ������ �������̽����� ������ ����.

IntToDoubleFunction			double applyAsDouble(int value)
DoubleUnaryOperator			double applyAsDouble(double operand)

�̷��� ��ȯ���� �Ű��������� ������ �������̽��� �̸��� Operator�� ������ ��Ģ�� �ִ�. ���Ҿ� �Ű������� �ϳ��̸� �� �տ� Unary�� �ٴ´�. 
���� ��ȯ���� �Ű��������� long�� �߻� �޼ҵ带 ���� �������̽��� LongUnaryOperator��� �̸����� ã���� �ȴ�.
�̾ �Ұ��ϴ� �������̽����� Function<T, R>�� ��ġ�� �߻� �޼ҵ��� �Ű����� ����� ��ȯ���� �پ�ȭ �� �͵��̴�.

BiFunction<T, U, R>			R apply(T t, U u)
IntFunction<R>				R apply(int value)

DoubleFunction<R>			R apply(double value)
ToIntFunction<T>			int applyAsInt(T value)

ToDoubleFunction<T>			double applyAsDouble(T value)
ToIntBiFunction<T, U>		int applyAsInt(T t, U u)
ToDoubleBiFunction<T, U> 	double applyAsDouble(T t, U u)

*/
