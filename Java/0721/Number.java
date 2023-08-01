public class Number{

	private int num;		// as, private -> need to make getter/setter method

	public Number(int num){
		this.num=num;
	}

	public void setNum(int num){	//'set+변수명'으로 작명
		this.num=num;
	}

	public int getNum(){		//'get+변수명'으로 작명
		return num;
	}

	


}

class NumberMain{
	public static void main(String[] args){
		Number n1 = new Number(10);
		System.out.println(n1.getNum());
		n1.setNum(20);
		System.out.println(n1.getNum());
	}
}