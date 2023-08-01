// 십진 정수를 입력받아 4바이트의 이진수로 출력하시오.
// 총 숫자 : 4*8=32bit

import java.util.Scanner;

public class LangString7{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num=sc.nextInt();
		String tmp= Integer.toBinaryString(num);
		int zero = 32-tmp.length();
		for(int i=0;i<zero;i++){
			System.out.print("0");
		}
		System.out.print(tmp);
	}
}


// Integer.parseInt("숫자",진수) 
// 숫자형의 문자열을 인자값으로 받으면 해당 값을 N진수의 integer 형으로 반환해줌
// 진수값의 default는 10진수

// String strNum = "5";
// int num = Integer.parseInt(strNum);
// 문자열을 "5"를 int 5로 바꿔서 반환한다.