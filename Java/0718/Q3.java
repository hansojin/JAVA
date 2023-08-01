class Q3{

	public static void mul(int n1,int n2){
		for (int i=n1;i<=n2;i++){
			System.out.println(i+"단");
			for(int j=1;j<10;j++){
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		mul(3,5);
	}
}
