import java.util.Scanner;

class Q2{

	public static int addNum(int n){
		if (n>0) {
			return n+addNum(n-1); 
		}		
		else	
			return 0;
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = sc.nextInt();
		System.out.println(addNum(num));
	}
}
