import java.util.Scanner;

class Q10{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter : ");
		String str = sc.nextLine();
		String[] binary = {   "0000", "0001", "0010", "0011"
				   , "0100", "0101", "0110", "0111"
				   , "1000", "1001", "1010", "1011"
				   , "1100", "1101", "1110", "1111" };

		String ans="";
		char[] chs= str.toCharArray();
		boolean flag = true;
		for(int i=0;i<chs.length;i++){
			if (chs[i]>='a' && chs[i]<='f'){
				ans+=binary[chs[i]-'a'+10];
			}
			else if (chs[i]>='A' && chs[i]<='F'){
				ans+=binary[chs[i]-'A'+10];
			}
			else if(chs[i]>='0' && chs[i]<='9'){
				ans+=binary[chs[i]-'0'];
			}
			else{
				System.out.println("16진수가 아닙니다.");
				flag=false;
				break;
			}
			
		}
		if (flag)
			System.out.print(ans);
	}
}