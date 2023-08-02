import java.util.*;

class Morse{
	public static void main(String[] args){
		String str;
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		str = sc.nextLine();
		String[] morse = {".-", "-...", "-.-.","-..", "."
				,"..-.", "--.", "....","..",".---"
				, "-.-", ".-..", "--", "-.", "---"
				, ".--.", "--.-",".-.","...","-"
				, "..-", "...-", ".--", "-..-","-.--", "--.." };
		String result="";
		int len = str.length();
		for (int i=0; i < len ; i++ ) {	
			char ch = str.charAt(i);
			if(ch >='A' && ch <='Z') {
				result +=morse[ch-'A'];	   
			} else if(ch >= 'a' && ch <='z'){	
				result +=morse[ch-'a']; 
			} else if( ch==' '){
				result+=" ";
			}else {
				flag = false;
				break;
			}
		}
		if(flag) System.out.println(result);
		else System.out.println("알파벳이 아닌 입력값이 포함되어 있습니다. ");	
	}
}