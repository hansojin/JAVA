import java.util.Scanner;
import java.lang.StringBuilder;

class Q4{
	static StringBuilder sb = new StringBuilder();	

	public static String toBinary(int n){

		if (n>0){
			sb.append(n%2);
			toBinary(n/2);
		}
		else
			return null;
		
		return sb.reverse().toString();
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = sc.nextInt();
		System.out.println(toBinary(num));
	}
}
