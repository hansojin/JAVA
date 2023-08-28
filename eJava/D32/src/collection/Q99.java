package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Q99 {
	public static String printBar(char ch, int value) { 
		char[] bar = new char[value]; 
		for(int i=0; i < bar.length; i++) { 
			bar[i] = ch; 
		} 
		return new String(bar); 
	} 
	
	static class ValueComparator implements Comparator<Entry<String, Integer>> {
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			Map.Entry<String, Integer> e1 = o1;
			Map.Entry<String, Integer> e2 = o2;

			int v1 = e1.getValue().intValue();
			int v2 = e2.getValue().intValue();

			return  v2 - v1;
		}
	}	
	
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		TreeMap<String, Integer> map = new TreeMap<>();

		for(int i=0; i < data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], Integer.valueOf(value.intValue() + 1));
			} else {
				map.put(data[i], Integer.valueOf(1));			
			}
		}

		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();

		System.out.println("= Before =");
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			int value = entry.getValue().intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value );
		}
		System.out.println();

		// map을 ArrayList로 변환한 다음에 Collectons.sort()로 정렬
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(set);	

		Collections.sort(list, new ValueComparator());

		it = list.iterator();

		System.out.println("= After =");		
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			int value = entry.getValue().intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value );
		}

	} 

}
