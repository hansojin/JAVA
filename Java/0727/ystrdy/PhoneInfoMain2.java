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


class PhoneInfoMain2{

	public static final int INPUT_PHONEINFO = 1;			//for 가독성
	public static final int PROGRAM_QUIT = 2;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		
		while (true){
			System.out.println("1. add data ");
			System.out.println("2. EXIT" );
			System.out.print("Enter the number : ");
			String tmpNum = sc.nextLine();
			int num = Integer.parseInt(tmpNum);
			
			switch(num){
				case INPUT_PHONEINFO:
					System.out.print("Enter your name : " );
					String name = sc.nextLine();
					System.out.print("Enter your phoneNumber : " );
					String phoneNumber = sc.nextLine();
					System.out.print("Enter your birthday : " );
					String birthday = sc.nextLine();

					PhoneInfo info = new PhoneInfo(name,phoneNumber,birthday);
					System.out.println("== your info ==");
					info.showInfo();
					System.out.println();
					break;

				case PROGRAM_QUIT: 
					System.out.println("EXIT");
					return;			// break말고 return!
				
				default:
					System.out.println("You enter wrong number.");
			
			}

		}
		
	}
}