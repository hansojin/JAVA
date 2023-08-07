import java.util.Scanner;

class Number{
	public static void strLen(String num){
		char[] chs = num.toCharArray();
		if (numCheck(chs)) {
			System.out.println(num+"은 " +chs.length+"자리 숫자입니다.");
		}
		else{
			System.out.println("숫자가 아닌 문자가 포함되어 있습니다.");
		}
	}

	public static boolean numCheck(char[] chs){
		boolean flag = true;
		for (int i=0;i<chs.length;i++){
			if (chs[i]>='0' && chs[i]<='9')
				continue;
			else{
				flag=false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		String num = sc.nextLine();
		strLen(num);
	}
}