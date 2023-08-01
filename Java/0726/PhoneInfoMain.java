import java.util.Scanner;

class PhoneInfo{
	private String name;
	private String phoneNumber;
	private String birthday;
	
	public PhoneInfo(String name,String phoneNumber, String birthday){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday=birthday;
	}
	
	public PhoneInfo(String name,String phoneNumber){
		this(name,phoneNumber,"");
	}
	public void showInfo(){
		if (birthday=="")
			System.out.println("name : " + name + ", phoneNumber :  " + phoneNumber);
		else
			System.out.println("name : " + name + ", phoneNumber :  " + phoneNumber + ", birthday :  " + birthday);
	}
}
class PhoneInfoMain{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println(" 1. 데이터 입력 " );
		System.out.println(" 2. 프로그램 종료 " );
		System.out.print("Enter the number : ");
		int num=sc.nextInt();
		while (num==1){
			sc.nextLine();
			System.out.print("name : ");
			String name = sc.nextLine();

			System.out.print("phone number : ");
			String phoneNumber = sc.nextLine();

			System.out.print("birthday : ");
			String birthday = sc.nextLine();

			System.out.println("Thanks for entering!");
			System.out.println("");

			System.out.println("== your info ==");
			PhoneInfo info = new PhoneInfo(name,phoneNumber,birthday);
			info.showInfo();
			System.out.println("");

			System.out.print("Enter the number : ");
			num=sc.nextInt();
		}
		if (num==2)
			System.out.println("BYE");
		else
			System.out.println("You enter the wrong number");
		/*
		PhoneInfo JH = new PhoneInfo("JH","01011112222");
		PhoneInfo SJ = new PhoneInfo("SJ","01033334444","991011");
		JH.showInfo();
		SJ.showInfo();
		*/
	}
}