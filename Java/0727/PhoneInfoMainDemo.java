DO NOT compile this

import java.util.Scanner;

class Manager{
	private static Manager manager = new Manager();

	public static int arrIdx;
	public static String[][] arr;
	
	private Manager(){
		arr= new String[100][];
	}

	public static Manager getManagerInst(){
		return manager;
	}
	
	public void addInfo(String name,String phoneNumber, String birthday){
		
		arr[arrIdx][0]=name;
		arr[arrIdx][1]=phoneNumber;
		arr[arrIdx][2]=birthday;

		arrIdx+=1;
	}

	public void printAll(){
		System.out.print(arrIdx);
		/*
		for (String[] i : arr){
			for(String info : i)
				System.out.print(info + " " );
			System.out.println();
		}
		*/
			
		
	}
}


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


class PhoneInfoMainDemo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("1. add data ");
		System.out.println("2. search data ");
		System.out.println("3. delete data ");
		System.out.println("4. print all data ");
		System.out.println("5. EXIT" );
		System.out.print("Enter number : ");
		String tmpNum = sc.nextLine();
		int num = Integer.parseInt(tmpNum);
		while (true){
			if (num==5){
				System.out.println("EXIT");
				break;
			}
			if (num==1){
				System.out.print("Enter your name : " );
				String name = sc.nextLine();
				System.out.print("Enter your phoneNumber : " );
				String phoneNumber = sc.nextLine();
				System.out.print("Enter your birthday : " );
				String birthday = sc.nextLine();

				Manager manager = Manager.getManagerInst();
				
				manager.addInfo(name,phoneNumber,birthday);
				System.out.println("Thanks" );
			}
			if (num==4){
				Manager manager = Manager.getManagerInst();
				manager.printAll();
			}
			System.out.println();
			System.out.print("Enter the number : ");
			tmpNum = sc.nextLine();
			num = Integer.parseInt(tmpNum);
		}
		
	}
}


