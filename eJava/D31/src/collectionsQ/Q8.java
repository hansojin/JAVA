package collectionsQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Q8 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };
		Integer[] ch = new Integer[26];
		Arrays.fill(ch, 0);
		for (String alpha : data) {
			ch[alpha.charAt(0)-65]+=1;
		}
		//System.out.println(Arrays.toString(ch));

		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<26;i++) {
			if (ch[i]!=0) {
				hm.put((char) ((char)i+65), ch[i]);
			}
		}
		
		for(Entry <Character,Integer> set : hm.entrySet()) {
			System.out.print(set.getKey() +"("+ set.getValue() + ") >> ");
			for (int i=0;i<set.getValue();i++)
				System.out.print("*");
			System.out.println();
		}
	}
}
