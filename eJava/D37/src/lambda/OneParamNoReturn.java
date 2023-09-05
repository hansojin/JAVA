package lambda;

interface Printable {
	void print(String s);    // �Ű����� �ϳ�, ��ȯ�� void
}

class OneParamNoReturn {
	public static void main(String[] args) {
		Printable p;

		p = (String s) -> {System.out.println(s);};    // ���� ���� ǥ��
		p.print("Lambda exp one.");

		p = (String s) -> System.out.println(s);    // �߰�ȣ ����
		p.print("Lambda exp two.");

		p = (s) -> System.out.println(s);    // �Ű����� �� ����
		p.print("Lambda exp three.");

		p = s -> System.out.println(s);    // �Ű����� �Ұ�ȣ ����
		p.print("Lambda exp four.");
	}
}

/*
�Ű������� �ְ� ��ȯ���� �ʴ� ���ٽ�

�������� ���̵��� ������ ���� ���ٽ��� ������ ����. �Ű����� ������ �Ұ�ȣ�� �ϰ� �޼ҵ� ��ü�� �߰�ȣ�� �Ѵ�.

(String s) -> { System.out.println(s); }

�׷��� �޼ҵ��� ��ü�� �ϳ��� �������� �̷��� �ִٸ� ������ ���� �߰�ȣ�� ������ �����ϴ�.
(String s) -> System.out.println(s)

�� �߰�ȣ�� ������ �� �ش� ������ ���� ��ġ�� �����ݷе� �Բ� ������ �Ѵ�.(�޼ҵ��� ��ü�� �̷�� �ϳ��� ������ return ���̶�� �߰�ȣ�� ������ �Ұ����ϴ�.
�׸��� �Ű����� ������ �־ s�� String�� ���� �����Ϸ� ���忡�� ���߰� �����ϴ�.(�ش� ���ٽ��� ä��� �� �޼ҵ� ������ ���ؼ� ���߰� �����ϴ�.) ���� ������ ���� �Ű������� �ڷ��� ������ ���� �����ϴ�.

(s) -> System.out.println(s)

�׸��� �Ű������� ���� ���� �ϳ��� ��쿡�� ������ ���� �Ұ�ȣ�� ������ �� �ִ�.

s-> System.out.println(s)

���� �޼ҵ� ��ü�� �� �̻��� �������� �̷��� �ְų�, �Ű������� ���� �� �̻��� ��쿡�� ���� �߰�ȣ�� �Ұ�ȣ�� ������ �Ұ����ϴ�.
 */
