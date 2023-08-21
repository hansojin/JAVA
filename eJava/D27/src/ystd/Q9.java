package ystd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q9 {

	static int stringCount(String src, String key) {
		int pos =src.indexOf(key);
		if (pos==-1)
			return 0;
		return stringCount(src,key,pos);
	}

//	static int stringCount(String src, String key, int pos) {
//		int cnt=0,idx=0;
//		while((idx=src.indexOf(key,pos))!=-1) {
//			cnt+=1;
//			pos+=idx+key.length();
//
//		}
//		return cnt;
//	}
	
	static int stringCount(String src, String key, int pos) {
		int cnt=0;
		Pattern p = Pattern.compile(key);
		Matcher m = p.matcher(src);
		while(m.find())
			cnt+=1;
		return cnt;
		
	}

	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa를" + stringCount(src, "aa") +"개 찾았습니다."); 
	}
}
