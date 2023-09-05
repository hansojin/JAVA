package method;

import java.util.function.ToIntBiFunction;

class IBox {
	private int n; 

	public IBox(int i) { n = i; }

	public int larger(IBox b) {
		if(n > b.n)
			return n;
		else
			return b.n;
	}
}

class NoObjectMethodRef {
	public static void main(String[] args) {
		IBox ib1 = new IBox(5);
		IBox ib2 = new IBox(7);

		// �� ���ڿ� ����� �� ���Ͽ� �� ū �� ��ȯ
		ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
		int bigNum = bf.applyAsInt(ib1, ib2);
		System.out.println(bigNum);		// 7
	}
}



// ToIntBiFunction<T, U>	int applyAsInt(T t, U u)
/*

�ν��Ͻ� �޼ҵ��� ���� 2 : �ν��Ͻ� ���� �ν��Ͻ� �޼ҵ� ����

�� �������� ������ ���ٽ��� ������ ����.

ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);

�� ���ٽĿ��� ȣ���ϴ� �޼ҵ� larger�� 'ù ��° ���ڷ� ���޵� �ν��Ͻ��� �޼ҵ�'��� ��ǿ�
�ָ�����. �̷��� ��� ������ ���� �޼ҵ� ������ �̸� ����� �� �ִ�. (�̴� ������ ����̴�.)

ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
	-> ToIntBiFunction<IBox, IBox> bf = IBox::larger;	// �޼ҵ� ���� ���

�޼ҵ� ������ ���� IBox::larger�� ���� static �޼ҵ� ����ó�� ���δ�. �׷��� �̴� �ν��Ͻ� �޼ҵ��� �����̴�.

ClassName::instanceMethodName

������� ������ �ϰ� ���� ���� ������ ���� ���� ��찡 ��κ��̴�.

"�̷��� �� �ٿ��� �ſ�? ��� �̷� ������ ��������?"

�׷� ������ �����غ���. ���� ���� ���Ŀ�,

ToIntBiFunction<IBox, IBox> bf = IBox::larger;

������ ���� �޼ҵ� ȣ���� ������ �Ǿ��ٰ� �����غ���.

bf.applyAsInt(ib1, ib2);

�̶� bf�� �����ϴ� �޼ҵ�� IBox::larger�̴�. �׸��� �̴� ib1�� ib2�� ���� �ν��Ͻ� �޼ҵ��̴�.

�׷��� 'ù ��° �������ڸ� ������� �� �޼ҵ带 ȣ���ϱ�� ����Ͽ����Ƿ�' ������ ���� ���� ������
����ȴ�. (�Ʒ��� �ڵ�� �޼ҵ� ���ǰ� �ƴϴ�. applyAsInt �޼ҵ尡 ȣ��� �� ����Ǵ� ������ ǥ���� ���̴�.)

bf.applyAsInt(ib1, ib2) {
	ib1.larger(ib2);		// �̷��� ������ �����ϱ�� ����Ͽ���
}

�� ��� ������ ��ӿ� �ٰ��Ѵ�. �׸��� �ͼ������� �̷��� ������ �ſ� ���ϰ� �ٰ��´�. �׷��� ���
����� �׷��ϵ��� �ͼ����� ������ ���� �����ϴ�. ����� �׷���. �׷� �� ������ �޼ҵ� ���� �������
������ ����� ���� �����ε�, ���̰� ���� ���� ���� ������ �����̴� �� ������ ���� �����Ͽ� �� �����
Ȯ���ϵ��� ����.

ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
	-> ToIntBiFunction<IBox, IBox> bf = IBox::larger;	// �޼ҵ� ���� ���
 */