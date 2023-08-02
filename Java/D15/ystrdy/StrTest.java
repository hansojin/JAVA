import java.util.*;
import java.lang.*;

class StrTest{
	public static void main(String[] args){
		int num = 10;
		String numStr = String.valueOf(num);		//num을 문자열로
		System.out.println(numStr);

		String str = "20";
		int strNum = Integer.parseInt(str);		//문자열을 int로
		System.out.println(strNum);
	
		String str1 = "0123456789";
		System.out.println(str1.substring(3));		//3456789
		System.out.println(str1.substring(4,7));		//456

		String str2 = "123";
		char[] chs = str2.toCharArray();		//문자열을 array로
		System.out.println(chs[0]);			//1

		double num1 = 3.5;
		System.out.println(Math.round(num1));		//4
		System.out.println(Math.ceil(num1));		//4.0
		num1=3.1;
		System.out.println(Math.floor(num1));		//3.0

		int[] nums = {5,4,1,3,2};
		Arrays.sort(nums);				// sort
		System.out.println(Arrays.toString(nums));	// print

		int[] src = {5,4,1,3,2};
  		int[] dest = new int[10];
		System.arraycopy(src,0,dest,3,src.length);	//arraycopy
		System.out.println(Arrays.toString(dest));
		
		
	}
}