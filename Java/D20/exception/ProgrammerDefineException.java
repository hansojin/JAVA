import java.util.Scanner;

class AgeInputException extends Exception{
	public AgeInputException(){			// 생성자 _ getMessage에 출력
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}

class ProgrammerDefineException{	
	public static void main(String[] args){
		System.out.print("나이를 입력하세요: ");
		
		try{
			int age=readAge();
			System.out.println("당신은 "+age+"세입니다.");
		}
		catch(AgeInputException e){			// 받는 곳은 여기
			System.out.println(e.getMessage());
		}
	}
	
	public static int readAge() throws AgeInputException{	// 받지 않겟다 선언
		Scanner sc=new Scanner(System.in);
		int age=sc.nextInt();
		if(age<0){				// 개발자가 생각하는 예외 객체 생성
			AgeInputException excpt=new AgeInputException();
			throw excpt;
		}
		return age;
	}
}