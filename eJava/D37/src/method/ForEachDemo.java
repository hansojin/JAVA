package method;

import java.util.List;
import java.util.Arrays;

class ForEachDemo {

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Robot");
        
        // ���ٽ� ���
        ls.forEach(s -> System.out.println(s));

        // �޼ҵ� ���� ���
        ls.forEach(System.out::println);
    }
}

/*

Collection<E> �������̽��� Iterable<T>�� ����Ѵ�. ���� �÷��� Ŭ�������� Iterable<T>��
��κ� �����ϰ� �Ǵµ�, �� �������̽����� ���� ����Ʈ �޼ҵ尡 ���ǵǾ� �ִ�.

default void forEach(Consumer<? super T> action) {
	for(T t: this)		// this�� �� �޼ҵ尡 ���� �÷��� �ν��Ͻ��� �ǹ���
		action.accept(t);	// ��� ����� �����͵鿡 ���� �� ���� �ݺ�
}

�� ���� �޼ҵ尡 ȣ��Ǹ� �÷��� �ν��Ͻ��� ����Ǿ� �ִ� ��� �ν��Ͻ����� ������� ���� ������ �����ϰ� �ȴ�.

>> action.accept(t);		// �̶� t�� ����Ǿ� �ִ� �ν��Ͻ� ������ �ǹ���

���� �츮�� forEach �޼ҵ� ȣ���� ���ؼ� Consumer<T> �������̽��� ���� ���ٽ� �Ǵ� �޼ҵ�
������ �����ؾ� �Ѵ�. �׷��� Consumer<T>�� �߻� �޼ҵ�� ������ ����.

>> void accept(T t);		// ��ȯ���� �ʰ�, ���޵� ���ڸ� ������� � ����� ����

�׸��� �̿� �� �´� �޼ҵ� �� �ϳ��� System.out.println�̴�. �̴� �Ʒ����� ���̵���
accept�� ��ȯ�� �� �Ű����� ������ �����ϴ�.(���� accept�� T�� String�� ��쿡 �Ű����� ������
�����ϴ�.)

>> public void println(String x)

System.out�� PrintStream �ν��Ͻ��� �����ϴ� ������������ �����Ͽ���. ���� ������ ����
���ٽ� �Ǵ� �޼ҵ� ������ ���� forEach���� ȣ���� ������ �� �ִ�.

ls.forEach(s -> System.out.println(s));
	-> ls.forEach(System.out::println);

*/