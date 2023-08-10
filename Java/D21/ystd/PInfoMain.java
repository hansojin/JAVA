import java.util.Scanner;

class AgeInputException extends Exception{
	public AgeInputException(){
		super("age can NOT be negative");
	}
}

class NameInputException extends Exception{
	public NameInputException(){
		super("Name must be longer than 1 word");
	}
}

class PInfo{
	private String name;
	private int age;

	PInfo(String name, int age){
		this.name=name;
		this.age = age;
	}
	public void showInfo(){
		System.out.println(name + "\t" +age);
	}
}

class PInfoMain{
	public static Scanner sc = new Scanner(System.in);

	public static String readName() throws NameInputException{
		System.out.print("Enter name : ");
		String name = sc.nextLine();
		if (name.length()<2)
			throw new NameInputException();
		return name;
	}

	public static int readAge() throws AgeInputException{
		System.out.print("Enter age : ");
		int age = sc.nextInt();
		if (age<0)
			throw new AgeInputException();
		return age;					
	}

	public static PInfo PInfoGet() throws AgeInputException, NameInputException{
		String name = readName();
		int age = readAge();
		return new PInfo(name,age);
	}

	public static void main(String[] args){
		try{
			PInfo info = PInfoGet();
			info.showInfo();
		} catch (NameInputException e){
			System.out.println(e.getMessage());
		} catch (AgeInputException e){
			System.out.println(e.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}

