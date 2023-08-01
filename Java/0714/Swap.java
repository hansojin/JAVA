class Swap{
	public static void main(String[] args){
		int num1=10, num2=15;
		System.out.println(num1 + " " + num2);
		
		int tmp=0;
		tmp=num1; num1=num2; num2=tmp;
		
		System.out.println("after swap");
		System.out.println(num1 + " " + num2);
	}
}
