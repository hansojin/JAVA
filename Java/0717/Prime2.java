import java.util.Scanner;

class Prime2{
	public static void main(String[] args){
		int num=0, i=0;
		Scanner sc = new Scanner(System.in);

		System.out.println("소수 판별 프로그램");
		System.out.println("판별하기를 원하는 숫자를 입력하세요.");
		num = sc.nextInt();	

		if(num<=1) System.out.println(num + "소수가 아닙니다.");
		else{
			for(i=2;i<num;i++){
				if(num%i==0) break;	
			}
			if(num==i) 
				System.out.println(num + "은 소수입니다.");
			else 
				System.out.println(num + "은 소수가 아닙니다.");
		}
		sc.close();
	}
}
