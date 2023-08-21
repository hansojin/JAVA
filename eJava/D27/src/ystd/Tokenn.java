package ystd;

import java.util.StringTokenizer;

public class Tokenn {
	public static void main(String[] args) {
		String tk = "11:22:33:44:55";
		StringTokenizer strTok = new StringTokenizer(tk,":");
		
		while (strTok.hasMoreTokens())
			System.out.println(strTok.nextToken());
	}
}
