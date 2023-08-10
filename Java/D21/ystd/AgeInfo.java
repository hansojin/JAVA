import java.util.Scanner;

class AgeInputException extends Exception{
	public AgeInputException(){
		super("age can NOT be negative");
	}
}

class AgeInfo{
	public static int AgeInput() throws AgeInputException{
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age<0)
			throw new AgeInputException();
		return age;
	}

	public static void main(String[] args){
		System.out.print("Enter age : ");
		try{
			int age = AgeInput();
			System.out.println("Age : " + age);
		} catch (AgeInputException e){
			System.out.println(e.getMessage());
		}
		
	}
}