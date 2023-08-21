package ystd;

public class Q3 {

	public static int count(String src, String key) {
		int cnt=0;
		int pos=0;

		while (true) {
			pos = src.indexOf(key,pos);
			if (pos!=-1) {
				cnt+=1;
				pos+=key.length();
			}
			else
				break;
		}

		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	}
}
