class Q4_sol{
	public static void binaryNum(int num){
		if(num<2) System.out.print(num);
		else{
			binaryNum(num/2);
			System.out.print(num%2);
		}
	}

	public static void main(String[] args){
		binaryNum(25);
		System.out.println();
		binaryNum(0);
		System.out.println();
		binaryNum(1);
		System.out.println();
		binaryNum(11);
		System.out.println();
	}
}