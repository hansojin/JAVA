import java.util.Scanner;

class ExceptionHandleUseIf{	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[100];
		
		for(int i=0; i<3; i++){
			System.out.print("나누어지는 수 입력: ");
			int num1=sc.nextInt();
			
			System.out.print("나누는 수 입력: ");
			int num2=sc.nextInt();
			
			if(num2==0){
				System.out.println("나누는 수는 0이 될 수 없습니다.");
				i-=1;
				continue;
			}
			
			System.out.print("연산결과를 저장할 배열의 인덱스 입력: ");
			int idx=sc.nextInt();
			
			if(idx<0 || idx>99){
				System.out.println("유효하지 않은 인덱스 값입니다.");
				i-=1;
				continue;
			}
			
			arr[idx]=num1/num2;
			System.out.println("나눗셈 결과는 "+arr[idx]);
			System.out.println("저장된 위치의 인덱스는 "+idx);				
		}
	}
}