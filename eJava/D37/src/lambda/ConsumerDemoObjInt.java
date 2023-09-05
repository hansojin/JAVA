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

Consumer<T>�� ��üȭ�ϰ� �پ�ȭ �� �������̽����, �Ű������� ������ �پ�ȭ �� �������̽����� ������ ����.
(�������̽��� ������ �̸��� ���� ��Ģ�� �ľ��ϸ� ���� ���� ���´�.)
�̵��� �߻� �޼ҵ带 �߽����� �����ϰ�, �ʿ��� �� ������ �� ������ �ȴ�.

IntConsumer				void accept(int value)
ObjIntConsumer<T>		void accept(T t, int value)

LongConsumer			void accept(long value)
ObjLongConsumer<T>		void accept(T t, long value)

DoubleConsumer			void accept(double value)
ObjDoubleConsumer<T>	void accept(T t, double value)

BiConsumer<T, U>		void accept(T t, U u)

*/