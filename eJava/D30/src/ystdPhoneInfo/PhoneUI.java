package ystdPhoneInfo;
import java.util.Scanner;

public class PhoneUI {
	private static final int MAX_CNT=100;
	public static Scanner sc = new Scanner(System.in);
	private static PhoneBook pb = PhoneBook.getPhoneBookInst(MAX_CNT);


	private PhoneUI(){}
	public static void mainMenu()
	{
		System.out.println("占쏙옙占쏙옙占싹쇽옙占쏙옙...");
		System.out.println("1. 占쏙옙占쏙옙占쏙옙 占쌉뤄옙");
		System.out.println("2. 占쏙옙占쏙옙占쏙옙 占싯삼옙");
		System.out.println("3. 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙");
		System.out.println("4. 占쏙옙占� 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙");
		System.out.println("5. 占쏙옙占싸그뤄옙 占쏙옙占쏙옙");
		System.out.print("占쏙옙占쏙옙 : ");
	}

	public static void inputMenu()
	{
		System.out.println("1. 占싹뱄옙, 2. 占쏙옙占쏙옙, 3. 회占쏙옙");
	}
	public static void inputMenuChoice() throws MenuChoiceException
	{
		int choice=0;
		choice = sc.nextInt();
		sc.nextLine();
		if(choice < PhoneMenuString.GENERAL || choice > PhoneMenuString.COMPANY)
			throw new MenuChoiceException(choice);
		switch(choice)
		{
		case PhoneMenuString.GENERAL:
			inputGeneralPhoneInfo();
			break;
		case PhoneMenuString.UNIVERCITY:
			inputUniversityPhoneInfo();
			break;
		case PhoneMenuString.COMPANY:
			inputCompanyPhoneInfo();
			break;
		}
	}

	public static void inputGeneralPhoneInfo()
	{
		String name;
		String phone;

		System.out.println("占쏙옙占쏙옙占쏙옙 占쌉뤄옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.");
		System.out.print("占싱몌옙 : ");
		name = sc.nextLine();
		System.out.print("占쏙옙화占쏙옙호 : ");
		phone = sc.nextLine();
		System.out.println("占쏙옙占쏙옙占쏙옙 占쌉뤄옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
		pb.inputPhoneInfo( new PhoneInfo(name, phone) );
	}

	public static void inputUniversityPhoneInfo()
	{
		String name;
		String phone;
		String major;
		int year;

		System.out.println("占쏙옙占쏙옙占쏙옙 占쌉뤄옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.");
		System.out.print("占싱몌옙 : ");
		name = sc.nextLine();
		System.out.print("占쏙옙화占쏙옙호 : ");
		phone = sc.nextLine();
		System.out.print("占쏙옙占쏙옙 : ");
		major = sc.nextLine();
		System.out.print("占싻놂옙 : ");
		year = sc.nextInt();
		sc.nextLine();
		System.out.println("占쏙옙占쏙옙占쏙옙 占쌉뤄옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
		pb.inputPhoneInfo( new PhoneUnivInfo(name, phone, major, year) );
	}

	public static void inputCompanyPhoneInfo()
	{
		String name;
		String phone;
		String company;

		System.out.println("占쏙옙占쏙옙占쏙옙 占쌉뤄옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.");
		System.out.print("占싱몌옙 : ");
		name = sc.nextLine();
		System.out.print("占쏙옙화占쏙옙호 : ");
		phone = sc.nextLine();
		System.out.print("회占쏙옙 : ");
		company = sc.nextLine();
		System.out.println("占쏙옙占쏙옙占쏙옙 占쌉뤄옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
		pb.inputPhoneInfo( new PhoneCompanyInfo(name, phone, company) );
	}

	public static void searchPhoneInfo()
	{
		String name;
		System.out.println("占쏙옙占쏙옙占쏙옙 占싯삼옙占쏙옙 占쏙옙占쏙옙占쌌니댐옙.");
		System.out.println("占싯삼옙占싹시곤옙占쏙옙 占싹댐옙 占싱몌옙占쏙옙 占쌉뤄옙占싹쇽옙占쏙옙.");
		name = sc.nextLine();
		pb.searchPhoneInfo(name);			
	}
	public static void deletePhoneInfo()
	{
		String phone;
		
		System.out.println("占싯삼옙占싹시곤옙占쏙옙 占싹댐옙 占싱몌옙占쏙옙 占쌉뤄옙占싹쇽옙占쏙옙.");		
		phone = sc.nextLine();		
		pb.deletePhoneInfo(phone);
	}
	public static void showAllPhoneInfo()
	{
		pb.showAllPhoneInfo();
	}
}
