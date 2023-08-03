import java.util.Scanner;

class Q5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter : ");
		String str = sc.nextLine();
		
		char[] abcCode =
		{ '`','~','!','@','#','$','%','^','&','*','(',')','-','_','+','=','|','[',']','{','}',';',':',',','.','/'};
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};

		for (int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if (ch>='a' && ch<='z')
				System.out.println(abcCode[ch-'a']);
			else if (ch>='0' && ch<='z')
				System.out.println(numCode[ch-'0']);
		}		
	}
}