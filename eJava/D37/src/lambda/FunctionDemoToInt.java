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

Function<T, R>에서 T와 R을 모두 기본 자료형으로 결정하여 정의한 인터페이스들은 다음과 같다.

IntToDoubleFunction			double applyAsDouble(int value)
DoubleUnaryOperator			double applyAsDouble(double operand)

이렇듯 반환형과 매개변수형이 동일한 인터페이스의 이름은 Operator로 끝나는 규칙이 있다. 더불어 매개변수가 하나이면 그 앞에 Unary가 붙는다. 
따라서 반환형과 매개변수형이 long인 추상 메소드를 갖는 인터페이스는 LongUnaryOperator라는 이름으로 찾으면 된다.
이어서 소개하는 인터페이스들은 Function<T, R>에 위치한 추상 메소드의 매개변수 선언과 반환형을 다양화 한 것들이다.

BiFunction<T, U, R>			R apply(T t, U u)
IntFunction<R>				R apply(int value)

DoubleFunction<R>			R apply(double value)
ToIntFunction<T>			int applyAsInt(T value)

ToDoubleFunction<T>			double applyAsDouble(T value)
ToIntBiFunction<T, U>		int applyAsInt(T t, U u)
ToDoubleBiFunction<T, U> 	double applyAsDouble(T t, U u)

*/
