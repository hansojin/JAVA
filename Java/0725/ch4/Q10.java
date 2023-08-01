public class Q10{
	public static void main(String[] args){
		int num = 12345;
		int sum=0;
		
		while (num/10>0){
			sum+=num%10;
			num/=10;
		}
		sum+=num;
		System.out.println("sum : " + sum);
	}
}