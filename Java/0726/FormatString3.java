import java.util.Scanner;

class FormatString3{
	public static void main(String[] args){
		String str = "1010";
		int num = Integer.parseInt(str);
		System.out.printf("%32d\n", num);	//             1010
		System.out.printf("%032d\n", num);	//00000....001010

		double dnum = 1.234567;
		System.out.printf("%.2f\n", dnum);	//1.23
		System.out.printf("%10.2f\n", dnum);	//      1.23

		char ch = 'A';
		System.out.printf("%c\n", ch);	//A	
	}
}