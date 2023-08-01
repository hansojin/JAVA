import java.util.Scanner;
import java.lang.StringBuilder;

class Notation{

	public static String convert(int n, int m){
		StringBuilder sb = new StringBuilder();

		while (n>0){
			if (n%m<10)
				sb.append(n%m);
			else
				sb.append((char)(n%m-10+'A'));
			n/=m;
		}	
		return sb.reverse().toString();
	
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.print("enter n : ");
			int n=sc.nextInt();
			if (n==0) break;
			System.out.print("enter m: ");
			int m=sc.nextInt();
			String res=convert(n,m);
			System.out.println(n + "을 " + m+"진수로 표현하면 " + res + " 이다.");
		}	
	}
}