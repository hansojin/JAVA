import java.util.Scanner;

public class InfoBookUI{
	
	private static InfoBook book = InfoBook.getInfoBook(100);
	public static Scanner sc = new Scanner(System.in);

	private InfoBookUI(){}

	public static void printOptions(){
		System.out.println();
		System.out.println(" -- OPTIONs --");
		System.out.println("1. add data");
		System.out.println("2. search data");
		System.out.println("3. delete data");
		System.out.println("4. print all data");
		System.out.println("5. exit program");
		System.out.print("Enter number : ");
	}

	public static void addData(){
		boolean result = book.checkSize();
		if (result==false){
			System.out.println("stack full");
			return;
		}
		String name,phone,birth;
		System.out.print("Name : ");
		name=sc.nextLine();
		System.out.print("Phone : ");
		phone=sc.nextLine();
		System.out.print("Birth : ");
		birth=sc.nextLine();
		book.addData(name,phone,birth);
		System.out.println("Data added");
		
	}

	public static void searchData(){
		String name;
		System.out.print("Enter searcher's name : ");
		name = sc.nextLine();
		int idx = book.searchData(name);
		if (idx==-1)
			checkNameMsg();		
	}
	
	public static void deleteData(){
		String name;
		System.out.print("Enter searcher's name : ");
		name = sc.nextLine();
		boolean found = book.deleteData(name);
		if(found)
			System.out.println("Data deleted");
		else
			checkNameMsg();
	}
	
	public static void printAllData(){
		book.printAllData();
	}
	
	public static void printQuitProgram(){
		System.out.println("EXIT");
		sc.close();
	}

	public static void printDefault(){
		System.out.println("Enter between 1-5");
	}

	public static void checkNameMsg(){
		System.out.println("Please check the name again.");
	}

}