import java.util.Scanner;

class AgeInputException extends Exception{
	public AgeInputException(){
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}

class ProgrmrDefExcptnThrowsFromMain{	
	public static void main(String[] args) throws AgeInputException{
		System.out.print("나이를 입력하세요: ");
		int age=readAge();
		System.out.println("당신은 "+age+"세입니다.");
	}
	
	public static int readAge() throws AgeInputException{
		Scanner sc=new Scanner(System.in);
		int age=sc.nextInt();
		if(age<0){
			AgeInputException excpt=new AgeInputException();
			throw excpt;
		}		
		return age;
	}
}

/*
나이를 입력하세요: -5
Exception in thread "main" AgeInputException: 유효하지 않은 나이가 입력되었습니다.
        at ProgrmrDefExcptnThrowsFromMain.readAge(ProgrmrDefExcptnThrowsFromMain.java:20)
        at ProgrmrDefExcptnThrowsFromMain.main(ProgrmrDefExcptnThrowsFromMain.java:12)
*/