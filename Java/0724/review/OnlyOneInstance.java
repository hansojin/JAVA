class SimpleNumber{
	int num=0;
	private static SimpleNumber onlyInstance= new SimpleNumber();	// 생성자 private
	public void addNum(int n) { num += n; }
	public void showNum() 
	{ 
		System.out.println(num); 
	}
	
	public static SimpleNumber getSimpleNumberInst()
	{
		return onlyInstance;
	}
}

class OnlyOneInstance{
	public static void main(String[] args)
	{
		SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();
		num1.addNum(20);

		SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
		num2.addNum(30);

		num1.showNum();
		num2.showNum();
	}
}