package lambda;

import java.util.function.Consumer;

class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        
        c.accept("Pineapple");    // ����̶�� ����� ����
        c.accept("Strawberry");
    }
}


/*
Consumer<T> �������̽����� ���� �߻� �޼ҵ尡 �����Ѵ�. 
Consumer��� �̸�ó�� ���� ���ڸ� �Һ��ϴ� ���·� �Ű������� ��ȯ���� ����Ǿ� �ִ�.(���ڴ� ���޹����� ��ȯ�� ���� �ʴ´ٴ� ���̴�.)
>> void accept(T t);	// ���޵� ���� ������� '��ȯ'�̿��� �ٸ� �����  ���� ��
*/
