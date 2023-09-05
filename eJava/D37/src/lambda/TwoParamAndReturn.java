package lambda;

interface Calculate1 {
	int cal(int a, int b);
}

class TwoParamAndReturn {
	public static void main(String[] args) {
		Calculate1 c;
		c = (a, b) -> { return a + b; };
		System.out.println(c.cal(4, 3));

		c = (a, b) -> a + b;
		System.out.println(c.cal(4, 3));
	}
}

/*

(a, b) -> { return a + b; }
�̷��� �޼ҵ� ��ü�� �ش��ϴ� ������ return���̸� �� ������ �ϳ��̴��� �߰�ȣ�� ������ �Ұ����ϴ�. 
�׷��� ���� ���ٽ��� ���� ���ٽ����� ����� �� �ִ�.

(a, b) -> a + b
�� ��� �޼ҵ� ��ü�� ������ �����ϴµ�, �� ������ ����Ǹ� �� ����� ���� ���� �ȴ�. 
�׷��� �� ���� ������ ������� �ʾƵ� ��ȯ�� ����� �ȴ�. 
���� return ���� �޼ҵ� ��ü�� �̷�� ������ �����̸� ���� ���� �ۼ��� �� �ֵ�.

  */
