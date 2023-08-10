import java.util.Scanner;

class AgeInputException extends Exception{
	public AgeInputException(){
		super("age can NOT be negative");
	}
}

class AgeInfo3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.print("Enter age : ");
		try{
			age = sc.nextInt();
			if (age<0){
				AgeInputException exc = new AgeInputException();
				throw exc;
			}
			System.out.println("Age : " + age);
		} catch(AgeInputException e){
			e.printStackTrace();
		}
		
		
		
	}
}