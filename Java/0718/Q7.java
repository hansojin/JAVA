import java.util.Scanner;

class Q7{

	public static boolean prime(int n){
		boolean flag = true;
		for(int i=2;i<n;i++){
			if (n%i==0){
				flag=false;
				break;
			}			
		}
		return flag;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num= sc.nextInt();
		System.out.println(prime(num));
	}
}
