import java.util.Scanner;

class PhoneInfo{
	private String name;
	private String phoneNumber;
	private String birthday;

	public PhoneInfo(String name, String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber=phoneNumber;
		this.birthday=birthday;
	}
	public PhoneInfo(String name, String phoneNumber){
		this(name,phoneNumber,"");
	}
	
	public void showInfo(){
		if (birthday=="")
			System.out.println("Name : " + name + " Phone Number : " + phoneNumber);
		else
			System.out.println("Name : " + name + " Phone Number : " + phoneNumber + " Birthday : " + birthday);
	}
		
}


class PhoneInfoMain{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("1. add data ");
		System.out.println("2. EXIT" );
		System.out.print("Enter the number : ");
		String tmpNum = sc.nextLine();
		int num = Integer.parseInt(tmpNum);
		while (num==1 || num==2){
			if (num==2){
				System.out.println("EXIT");
				break;
			}
			System.out.print("Enter your name : " );
			String name = sc.nextLine();
			System.out.print("Enter your phoneNumber : " );
			String phoneNumber = sc.nextLine();
			System.out.print("Enter your birthday : " );
			String birthday = sc.nextLine();

			PhoneInfo info = new PhoneInfo(name,phoneNumber,birthday);
			info.showInfo();
			System.out.println();
			System.out.print("Enter the number : ");
			tmpNum = sc.nextLine();
			num = Integer.parseInt(tmpNum);
		}
		
	}
}


/*

다 sc.nextInt만 쓴다면 아무런 문제가 없지만,  
nextInt 랑 next랑 같이 쓸때만 문제가 돼!!

sc.nextInt()를 쓴 뒤에 sc.nextLine()이나 sc.next()를 쓰게되면, 
버퍼에, 숫자를 입력받고 뒤에 남은 enter가 남아있기때문에, 
다음 sc.next를 담는 변수에 enter가 들어감

이걸 방지하기위해서는, 
1. 해당 코드 처럼 String으로 받고, num으로 받아주던가, 
2. nextInt()를 쓰고 sc.next()를써서 enter를 버퍼에서 지우던가

*/