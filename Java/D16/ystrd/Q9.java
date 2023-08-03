import java.util.Scanner;

class Q9{
	public static boolean isNumber(String str){
		boolean flag = false;
		if(str==null || str==""){
			return false;
		}
			
		char chs[]  = str.toCharArray();
		for (int i=0;i<chs.length;i++){
			if( chs[i]>='0' && chs[i]<='9')
				flag=true;
			else{
				flag=false;
				break;
			}
		}
		
		return flag;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter : ");
		String str = sc.nextLine();
		if (isNumber(str))
			System.out.print("숫자로만 이루어진 문자열입니다.");
		else
			System.out.print("문자열에 숫자 이외의 문자가 포함되어 있습니다.");	
	}
}