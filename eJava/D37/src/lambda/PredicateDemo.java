package lambda;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

class PredicateDemo {
	public static int sum(Predicate<Integer> p, List<Integer> lst) {
		int s = 0;

		for(int n : lst) {
			if(p.test(n))
				s += n;
		}       

		return s;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 5, 7, 9, 11, 12);

		int s;
		s = sum(n -> n%2 == 0, list);
		System.out.println("¦�� ��: " + s);

		s = sum(n -> n%2 != 0, list);
		System.out.println("Ȧ�� ��: " + s);

	}
}


/*

>> �̸� ���ǵǾ� �ִ� �Լ��� �������̽�

������ Collection<E> �������̽��� ���ǵǾ� �ִ� ����Ʈ �޼ҵ� �� �ϳ��� removeIf �޼ҵ��̴�.

default boolean removeIf(Predicate<? super E> filter)

�� �޼ҵ带 ����ϱ� ���ؼ��� ���� �Ű����� ������ �ǹ��ϴ� �ٸ� �˾ƾ� �Ѵ�.

Predicate<? super E> filter

���� ��Ȯ���� Predicate�� �������� �˾ƾ� �Ѵ�. Predicate�� ������ ���� ���ǵǾ� �ִ� '���׸� �������̽�'���� '�Լ��� �������̽�'�̴�.
(�Ʒ��� �������̽� ���ǿ��� static, default ������ ���� �޼ҵ��� ���Ǵ� �����Ͽ���.)

@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}

ǥ������ ���ǵ� ��ǥ���� �Լ��� �������̽� �� ���� �� �ȿ� ��ġ�� �߻� �޼ҵ�� ������ ����. �׸��� �̵��� ��� java.util.function ��Ű���� ���� �ִ�.

* Predicate<T> boolean test(T t)
 	* IntPredicate 		boolean test(int value)
	* LongPredicate		boolean test(long value)
	* DoublePredicate		boolean test(double value)
	* BiPredicate<T, U>		boolean(T t, U u)
		* �� ���� ���ڸ� �޾Ƽ� true �Ǵ� false�� ������ �� �ִ� ���� ���׸� �������̽�
* Supplier<T> T get()
	* �Է� ���� ��¸� �־� �ð����ڶ�� �̸� ���
	* get method ���
* Consumer<T> void accept(T t)
	* ���� Ÿ�� void
	* ���� ���� ��û ���� ���� ó��
* Function<T, R> R apply(T t)
	* T�� �μ��� �޾Ƽ� R�� ����

 */
