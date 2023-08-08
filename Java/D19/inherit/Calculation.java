import java.util.Scanner;

abstract class Cal{
	protected int n,m;
	public void setValue(int n,int m){
		this.n=n;
		this.m=m;
	}
	abstract int calculate();
}

class Add extends Cal{
	@Override
	public int calculate(){
		return n+m;
	}
}
class Sub extends Cal{
	@Override
	public int calculate(){
		return n-m;
	}
}
class Mul extends Cal{
	@Override
	public int calculate(){
		return n*m;
	}
}
class Div extends Cal{
	@Override
	public int calculate(){
		return n/m;
	}
}
public class Calculation{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n1,n2;
		char op;
		System.out.print("Enter num : ");
		n1=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter operator : ");
		op=sc.next().charAt(0);
		System.out.print("Enter num : ");
		n2=sc.nextInt();

		Cal cal;
		switch(op){
		case '+':
			cal=new Add();
			break;
		case '-':
			cal=new Sub();
			break;
		case '*':
			cal=new Mul();
			break;
		case '/':
			cal=new Div();
			break;
		default : 
			System.out.println("Enter proper operator");
			return;
		}

		cal.setValue(n1,n2);
		System.out.println(cal.calculate());
		sc.close();
		
	}
}