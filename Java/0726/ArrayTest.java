import java.util.Scanner;

public class ArrayTest{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];	// num에 1000번지 주소가 담겼다면, 
		int[] num2 = num;		// 이렇게 표현해야 num2도 같은 1000에 담김
		
		for(int i=0;i<3;i++){
			System.out.print(i+1+"번째 숫자를 입력하세요.");
			num[i] = sc.nextInt();
		}
		
		for(int i=0;i<num.length;i++)
			System.out.print(num[i] + " ");
		for(int i=0;i<num2.length;i++)
			System.out.print(num2[i] + " ");

	}

}