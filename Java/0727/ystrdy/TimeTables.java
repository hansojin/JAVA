class TimeTables{
	public static void main(String[] args){
		for (int i=1;i<=9;i++){
			for (int j=2;j<=9;j++){
				System.out.printf("%d*%d=%d\t",j,i,i*j);
			}
			System.out.println();
		}

		double num = 1.234567;
		System.out.printf("%.2f\n%10.2f",num,num);
		//문자 출력 %c
		 
	}
}