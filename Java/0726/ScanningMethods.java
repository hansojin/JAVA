import java.util.Scanner;

class ScanningMethods{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		System.out.print("당신의 이름은? ");
		String str=sc.nextLine();
		System.out.println("안녕하세요 "+str+'님');
		
		System.out.println("당신 연봉이 1억이 넘는다는데 맞습니까? ");
		System.out.print("Enter 'true' if is true, else enter 'false' : ");

		boolean isTrue=sc.nextBoolean();

		if(isTrue==true)
			System.out.println("오 역시");
		else
			System.out.println("이런 아니었군요.");
	
		System.out.print("당신과 동생의 3대는 어떻게 되나요? ");
		double num1=sc.nextDouble();
		double num2=sc.nextDouble();

		double diff=num1-num2;
		if(diff>0)
			System.out.println("당신이 "+diff+"만큼 더 드는군요!");
		else
			System.out.println("당신이 "+(-diff)+"만큼 못 드는군요..");
	}
}