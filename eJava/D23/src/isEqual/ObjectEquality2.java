package isEqual;

// �����ڴ� ���������� ���� ���� ���Ѵ�. ���� �ν��Ͻ��� ����Ǿ� �ִ� �� ��ü�� ���Ϸ��� ������ ����� ����ؾ� �Ѵ�. 
// �� ��ü�� ���� �� �ֵ��� public boolean isEquals(IntNumber numObj) �޼ҵ带 �����Ͻÿ�.
// �ش� ������ Object Ŭ������ equals ��� �޼ҵ带 �̿��Ͽ� �����Ͻÿ�.(�޼ҵ� �������̵�)
class IntNumber2{
	int num;

	public IntNumber2(int num){
		this.num=num;
	}
	
}

class ObjectEquality2{
	public static void main(String[] args){
		IntNumber2 num1=new IntNumber2(10);
		IntNumber2 num2=new IntNumber2(12);
		IntNumber2 num3=new IntNumber2(10);

		if(num1.equals(num2))
			System.out.println("num1�� num2�� ������ ����");
		else
			System.out.println("num1�� num2�� �ٸ� ����");

		if(num1.equals(num3))
			System.out.println("num1�� num3�� ������ ����");
		else
			System.out.println("num1�� num3�� �ٸ� ����");		
	}
}
