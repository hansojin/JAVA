package lambda;

import java.util.function.ObjIntConsumer;

class ConsumerDemoObjInt {
    public static void main(String[] args) {
        ObjIntConsumer<String> c = (s, i) -> System.out.println(i + ". " + s);

        int n = 1;
        c.accept("Toy", n++);
        c.accept("Book", n++);
        c.accept("Candy", n);
    }
}

/*
1. Toy
2. Book
3. Candy

Consumer<T>를 구체화하고 다양화 한 인터페이스들과, 매개변수의 선언을 다양화 한 인터페이스들은 다음과 같다.
(인터페이스의 종류와 이름에 대한 규칙을 파악하면 쉽게 눈에 들어온다.)
이들은 추상 메소드를 중심으로 이해하고, 필요할 때 참조할 수 있으면 된다.

IntConsumer				void accept(int value)
ObjIntConsumer<T>		void accept(T t, int value)

LongConsumer			void accept(long value)
ObjLongConsumer<T>		void accept(T t, long value)

DoubleConsumer			void accept(double value)
ObjDoubleConsumer<T>	void accept(T t, double value)

BiConsumer<T, U>		void accept(T t, U u)

*/