import java.util.Scanner;

class RandomGame{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] str = {"주먹", "가위", "보"};
		int computer = (int)(Math.random()*3+0);	// 컴퓨터 RSP
		System.out.print("주먹(0) 가위(1) 보(2) 중 하나를 입력하세요 : ");
		int user = sc.nextInt();
		
		System.out.println("당신은 "+ str[user]);
		System.out.println("컴퓨터는 "+ str[computer]);
		
		switch(user-computer){
			case 0:
				System.out.println("비겼습니다.");
				break;
			case 2: case -1:
				System.out.println("당신이 이겼습니다.");
				break;
			case 1: case -2: 	
				System.out.println("당신이 졌습니다.");
				break;
			default:	
				break;
		} 
		
	}
}