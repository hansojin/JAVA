public class Q5{
	public static void main(String[] args){
		for(int i=0;i<=10;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		int n=0;
		while(n<=10){
			int m=0;
			while(m<=n){
				System.out.print("*");
				m++;
			}
			System.out.println();
			n++;
		
		}
	}
}