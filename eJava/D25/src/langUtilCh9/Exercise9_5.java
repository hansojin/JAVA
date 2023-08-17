package langUtilCh9;

import java.util.HashSet;
import java.util.Set;

class Exercise9_5 {
	public static int count(String src, String target) {
		Set<Integer> set = new HashSet<Integer>();		
		int pos = 0; // 찾기 시작할 위치
		pos = src.indexOf(target);
		if (pos==-1)
			return 0;
		while(pos<src.length()-target.length()) {			
			if(src.indexOf(target,pos)!=-1) {
				set.add(src.indexOf(target,pos));
				pos+=target.length();
			}
			else
				pos+=1;
		}
		return set.size();
	}
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	}
}
