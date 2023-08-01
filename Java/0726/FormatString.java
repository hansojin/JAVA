class FormatString{
	public static void main(String[] args){
		int age=20;
		double tall=175.7;
		String name="홍자바";
		
		System.out.printf("제 이름은 %s입니다. \n", name);
		System.out.printf("나이는 %d이고, 키는 %.1f입니다. \n", age, tall);

		System.out.printf("%d %o %x \n", 77, 77, 77);		// 10 8 16진수
		System.out.printf("%g %g \n", 0.00014, 0.000014);	
		// 0.000140000 1.40000e-05

		/*
		%g _ 실수 길이에 따라 %f 나 %e 방식으로 출력
		%f _ 실수를 소수점 6자리까지 출력
		%e _ (그 이후는) 실수를 e 표기법으로 출력
		%% _ % 출력시

		%.1f _ 소수점 한자리까지
		%10f _ 총 10자리
		%010f _ 총 10자리, 나머지 앞부분은 0
		*/ 
	}
}