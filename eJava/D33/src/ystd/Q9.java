package ystd;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Q9 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		HashMap<String,Integer> map = new HashMap<>();
		for (int i=0;i<data.length;i++) {
			if (map.containsKey(data[i])) 
				map.put(data[i], (Integer)map.get(data[i])+1);
			else
				map.put(data[i], 1);
		}

		List<Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(new Comparator<Map.Entry<String,Integer>>(){
			public int compare(Map.Entry<String,Integer> one, Map.Entry<String,Integer> two) {
				return two.getValue()-one.getValue();
			}
		});

		for(Map.Entry <String,Integer> set : list) {
			System.out.print(set.getKey() +"("+ set.getValue() + ") >> ");
			for (int i=0;i<set.getValue();i++)
				System.out.print("*");
			System.out.println();
		}
		
	}
}
