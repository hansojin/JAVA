package ystd;

import java.math.BigInteger;
import java.util.Scanner;

public class BigInte {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n,m;
		System.out.print("Enter num1 : ");
		n=sc.nextBigInteger();
		System.out.print("Enter num2 : ");
		m=sc.nextBigInteger();
		
		System.out.println("두 실수의 차에 대한 절대값 : " + (n.subtract(m)).abs());
		
		long maxx = Long.MAX_VALUE;
		long minn = Long.MIN_VALUE;
		System.out.println(maxx+minn);
		sc.close();
	}
}
