package langUtilCh9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise9_13 {
	static int stringCount(String src, String key) {
		return stringCount(src, key, 0);
		
	}

//	1.
//	static int stringCount(String src, String key, int pos) {
//		int count = 0;
//		int index = 0;
//		if (key == null || key.length() == 0)
//			return 0;
//		
//		while ((index=src.indexOf(key,pos))!=-1) {
//			count+=1;
//			pos=index+key.length();
//		}
	
//		return count;
//	}
	
//	2.
	static int stringCount(String src, String key, int pos) {
		int count = 0;
		if (key == null || key.length() == 0)
			return 0;
		
		Pattern p = Pattern.compile(key);
		Matcher m = p.matcher(src);
		while(m.find()) {
			count+=1;
		}
		

		return count;
	}
	
	
	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("aa를 " + stringCount(src, "aa") +"개 찾았습니다."); 
	}
}
