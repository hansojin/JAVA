import java.util.Random;
import java.util.Scanner;

class Q14{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		Random rand = new Random();
		int number = rand.nextInt(100)+1; //1~100
		int input=0,cnt=0;

		do{
			cnt++;
			System.out.print("1-100 사이 값을 입력하세요 : ");	
			input = sc.nextInt();
			
			if ( input >number )
				System.out.println("입력하신 숫자보다 작습니다.");	
			else if ( input <number )
				System.out.println("입력하신 숫자보다 큽니다.");	
			else
				break;
		}while(true);
		
		System.out.println(cnt + "번 만에 맞추셨습니다." );
	}
}