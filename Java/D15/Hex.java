import java.util.*;

class Hex{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("16진수 입력 : ");
		String str = sc.nextLine();
		char[] chs = str.toCharArray();
		for (int i=0;i<chs.length;i++){
			if (chs[i]>='0' && chs[i]<='9'){
				System.out.print(Integer.toBinaryString(chs[i]).substring(2));
				
			}
			else if (chs[i]>='A' && chs[i]<='F'){
				int diff = 'A'-('9'+1);
				System.out.print(Integer.toBinaryString(chs[i]-diff).substring(2));
			}
			else if (chs[i]>='a' && chs[i]<='f'){
				int diff = 'a'-('9'+1);
				System.out.print(Integer.toBinaryString(chs[i]-diff).substring(2));
			}
			else{
				System.out.println("It's not hex");
				break;
			}
		}	
	}
}