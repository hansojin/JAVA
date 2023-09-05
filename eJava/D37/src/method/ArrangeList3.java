package method;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

class JustSort {
	public void sort(List<?> lst) {    // �ν��Ͻ� �޼ҵ�
		Collections.reverse(lst);
	}
}

class ArrangeList3 {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
		ls = new ArrayList<>(ls);
		JustSort js = new JustSort();

		Consumer<List<Integer>> c = e -> js.sort(e);
		c.accept(ls);
		System.out.println(ls);	//[9, 7, 5, 3, 1]
	}
}



/*

�ν��Ͻ� �޼ҵ��� ���� 1 : �ν��Ͻ��� �����ϴ� ��Ȳ���� ���� 
�ռ� static �޼ҵ带 �����Ͽ����� �ν��Ͻ� �޼ҵ嵵 ������ �� �ִ�.

�������� ���� ���ƾ� �� ���� ���� ���ٽ��̴�.

public static void main(String[] args) {
	...
	JustSort js = new JustSort();
	Consumer<List<Integer>> c = e->js.sort(e);
	...
}

���� ���ٽĿ����� ���� ������ ��Ư�� ���� Ȯ���� �� �ִ�.

"���ٽĿ��� ���� ���� ���� ����� �������� js�� �����ϰ� �ִ�."

�ڵ常 ���� ������ ���� ���δ�. �׷��� ���ٽ��� �ν��Ͻ��� �������� �̾����ٴ� ����� ����ϸ�
�̴� �ټ� Ư���� ���� �� �� �ִ�. ���� �Ǿ��� ����� ���ϸ�, ���� �ڵ忡�� ���̵��� ���ٽĿ���
���� ������ ����� ���������� �����ϴ� ���� �����ϴ�. �� ���� ������ �����ؾ� �����ϴ�.

"���ٽĿ��� ���� ������ ���������� final�� ����Ǿ��ų� effectively final�̾�� �Ѵ�."

������ effectively final�̶�� ���� '��ǻ� final ������ �� �Ͱ� �ٸ�����'�� ���Ѵ�. ��
�������� �������� js�� effectively final�̴�. js�� �����ϴ� ����� �������� �ʱ� �����̴�.
�׷��ٸ� �� ������ main �޼ҵ带 ������ ���� �����ϸ� ��� �ɱ�? ������ ������ �߻��Ѵ�.
�ֳ��ϸ� �� ��� �������� js�� effectively final�� �ƴϱ� �����̴�.

public static void main(String[] args) {
	...
	JustSort js = new JustSort();
	js = new JustSort();		// �ٸ� �ν��Ͻ��� �����ϰ� �ߴ�.
	Consumer<List<Integer>> c = l -> js.sort(l);
	...
}

������ ���� main �޼ҵ��� ������ ���忡�� js�� null�� �����ص� ������ ������ �̾�����. ������
���������� js�� effectively final�� �ƴϱ� �����̴�.

public static void main(String[] args){
	...
	JustSort js = new JustSort();	
	Consumer<List<Integer>> c = l -> js.sort(l);
	...
	js = null;	// �̷� ���� js�� effectively final�� �ƴϴ�.
}

���ٽ����� ������ �ν��Ͻ� ������ final�� ������� �ʾҰų� effectively final�� �ƴ� ����������
�����ϰ� �ϴ� ���� ���� ȥ���� ����Ű�ų� ���� �Ұ����� ��Ȳ���� �̾��� �� �־ �̷��� ������
�ΰ� �ִ� ���̴�. �׷� �ٽ� �������� ���ƿͼ� �� �������� ������ ���ٽ��� ������ ���� '�޼ҵ� ����'��
����� �� �ִ�.

Consumer<List<Integer>> c = e -> js.sort(e);
	-> Consumer<List<Integer>> c = js::sort;

�̷��� �ν��Ͻ� �޼ҵ�� ������ ���� �����Ѵ�.

ReferenceName::instanceMethodName

 */