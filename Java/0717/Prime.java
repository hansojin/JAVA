import java.util.Scanner;

class Prime{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the number : ");
		
		int num = sc.nextInt();
		int  cnt=0;

		for (int i=1;i<=num;i++){
			if (num%i==0){ 
				cnt+=1;
			}
		}

		if (cnt==2){
			System.out.println(num + "은 소수");
		}
		else{
			System.out.println(num + "은 소수가 아님");	
		}
	
	}
}
