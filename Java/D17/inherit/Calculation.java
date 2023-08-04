import java.util.Scanner;

abstract class Calc {
	protected int a, b;
	public void setValue(int a, int b) {
		this.a = a; 
		this.b = b;
	}
	abstract int calculate();
}

class Add extends Calc {
	@Override
	public int calculate() {
		return a+b;
	}	
}

class Sub extends Calc {
	@Override
	public int calculate() {
		return a-b;
	}	
}

class Mul extends Calc {
	@Override
	public int calculate() {
		return a*b;
	}	
}

class Div extends Calc {
	@Override
	public int calculate() {
		return a/b;
	}	
}

public class Calculation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>> ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		char op = scanner.next().charAt(0);
		
		Calc cal;
		switch (op) {
		case '+': 
			cal = new Add(); 
			break;
		case '-': 
			cal = new Sub(); 
			break; 
		case '*': 
			cal = new Mul(); 
			break;
		case '/': 
			cal = new Div(); 
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
			scanner.close();
			return;
		}
		
		cal.setValue(a, b);
		System.out.println(cal.calculate());
		scanner.close();
	}
}