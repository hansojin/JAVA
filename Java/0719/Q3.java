import java.util.Scanner;

class Q3{

	public static int mulTwo(int n){
		if (n>0) {
			return 2*mulTwo(n-1); 
		}		
		else	
			return 1;
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = sc.nextInt();
		System.out.println(mulTwo(num));
	}
}
