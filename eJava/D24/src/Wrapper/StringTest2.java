package Wrapper;

import java.util.Arrays;

public class StringTest2 {
	public static char[] destInit() {
		char[] dest = new char[10];
		for(int i=0;i<dest.length;i++)
			dest[i]='0';
		return dest;
	}
	
	public static void main(String[] args) {
		
		char[] src = {'1', '2', '3', '4'};
		int slen= src.length;
		char[] dest = destInit();
		int dlen = dest.length;
		
		System.arraycopy(src, 0, dest, 0, slen);
		System.out.println(dest);	//1234000000
		
		dest = destInit();
		System.arraycopy(src, 0, dest, dlen-slen, slen);
		System.out.println(dest);	//0000001234

//		dest = destInit(); 아니면 Arrays.fill 써도 돼!
		Arrays.fill(dest, '0');
		System.arraycopy(src, 0, dest, (dlen-slen)/2, slen);
		System.out.println(dest);	//0001234000
		
	}
}

