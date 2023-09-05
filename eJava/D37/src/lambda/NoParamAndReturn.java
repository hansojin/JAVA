package lambda;

import java.util.Random;

interface Generator {
	int rand();    // �Ű����� ���� �޼ҵ�
}

class NoParamAndReturn {
	public static void main(String[] args) {
		Generator gen = () -> {
			Random rand = new Random();
			return rand.nextInt(50);
		};

		System.out.println(gen.rand());
	}
}


/*

�Ű����� ������ ���� ����� �Ű����� ������ ��� �Ұ�ȣ�� ��� �ִ�. 
�׸��� �̷��� �� �̻��� �������� �̷��� ���ٽ��� �߰�ȣ�� �ݵ�� ���ξ� �ϸ�, ���� ��ȯ�� ������ return ���� �ݵ�� ����ؾ� �Ѵ�.

* �Լ��� �������̽�(Functional Interfaces)�� ������̼� 

>> ������ ���ǵǾ� �ִ� �������̽����� �߻� �޼ҵ尡 �� �ϳ��� �����Ѵ�.

�̷��� �������̽��� ������ '�Լ��� �������̽�(Functional Interfaces)'�� �Ѵ�. 
�׸��� ���ٽ��� �̷��� �Լ��� �������̽��� ������θ� �ۼ��� �� �� �ִ�.

@FunctionalInterface
interface Calculate {
	int cal(int a, int b);
}

@FunctionalInterface�� �Լ��� �������̽��� �����ϴ����� Ȯ���ϱ� ���� ������̼� Ÿ���̴�. 
���� �������̽��� �� �̻��� �߻� �޼ҵ尡 �����ϸ�, �̴� �Լ��� �������̽��� �ƴϱ� ������ ������ ������ �̾�����. 
�׷��� static, default ������ ���� �޼ҵ��� ���Ǵ� �Լ��� �������̽��� ���ǿ� �ƹ��� ������ ��ġ�� �ʴ´�. 
���� ���� �������̽��� �Լ��� �������̽��̴�.

@FunctionalInterface
interface Calculate {
	int cal(int a, int b);
	default int add(int a, int b) { return a + b; }
	static int sub(int a, int b) { return a - b; }
}

���� �������̽��� ������ε� ���ٽ��� ������ �� �ִ�. ������ ä���� �� �޼ҵ�� �ϳ��̱� �����̴�.
 */
