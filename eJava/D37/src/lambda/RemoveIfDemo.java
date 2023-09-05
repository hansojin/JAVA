package lambda;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Predicate;

class RemoveIfDemo {
    public static void main(String[] args) {
        List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
        ls1 = new ArrayList<>(ls1);

        List<Double> ls2 = Arrays.asList(-1.1, 2.2, 3.3, -4.4, 5.5);
        ls2 = new ArrayList<>(ls2);
        
        Predicate<Number> p = n -> n.doubleValue() < 0.0;
        ls1.removeIf(p);
        ls2.removeIf(p);

        System.out.println(ls1);
        System.out.println(ls2);
    }
}

/*
< removeIf �޼ҵ� >

Collection<E> �������̽��� ���� ����Ʈ �޼ҵ尡 ���ǵǾ� �ִ�.

>> default boolean removeIf(Predicate<? super E> filter)

���� �޼ҵ� removeIf�� �Ű����� ������ ������ ����. >> Predicate<? super E> filter

���� ArrayList<Integer> �ν��Ͻ��� �����ϸ�, �� �ȿ� �����ϴ� removeIf �޼ҵ��� E�� ������ ���� Integer�� �����ȴ�.

public boolean removeIf(Predicate<? super Integer> filter) {...}

�Ű����� ���� <? super Integer>�� �����ϹǷ�, ���� ���������� ������� ���ٽ��� �ۼ��Ͽ� �� �޼ҵ��� ���ڷ� ������ �� �ִ�.

Predicate<Integer> f = ...
Predicate<Number> f = ...
Predicate<Object> f = ...

�׷��ٸ� removeIf �޼ҵ��� ����� �����ϱ�? �̿� ���� �ڹ� ������ ������ ������ ����.

"Removes all of the elements of this collection that satisfy the given predicate"

������ �ؼ� �ǿ��� �ϸ�, �÷��� �ν��Ͻ��� ����� �ν��Ͻ��� ���� test �޼ҵ��� ���ڷ� �������� ��, "true�� ��ȯ�Ǵ� �ν��Ͻ��� ��� �����ϰڴ�"�� ���̴�.

public interface Predicate<T> {
	boolean test(T t);
}

�� ����(class RemoveIfDemo)������ ���� ���ٽ��� �����Ͽ�,

Predicate<Number> p = n -> n.doubleValue() < 0.0;

�̸� List<Integer> �ν��Ͻ�, �׸��� List<Double> �ν��Ͻ��� removeIf �޼ҵ忡 ���ڷ� ������ �Ͽ���. 
�̰��� ������ ������ removeIf �޼ҵ��� �Ű����� ������ ������ ���� �����̴�.

Predicate<? super E> filter

*/
