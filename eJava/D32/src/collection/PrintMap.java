package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintMap {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		
		// 1. map.entrySet()
		for (Entry<Integer,String> entrySet : map.entrySet())
			System.out.println(entrySet.getKey()+"\t"+entrySet.getValue());
		
		// 2. map.keySet(), map.get(key)
		Set<Integer> keys = map.keySet();
		for(Integer key : keys)
			System.out.println(key + "\t" + map.get(key));
		
		// 3. Iterator
		Iterator<Entry<Integer,String>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Integer,String> entrySet = (Entry<Integer,String>)iter.next();
			System.out.println(entrySet.getKey() + "\t" + entrySet.getValue());
		}
		
		// 4. forEach
		map.forEach((key,value)->{
			System.out.println(key + "\t" + value);
		});
		
		// 5. map.values() 
		Collection<String> values = map.values();
		System.out.println(values);
		
	} 
}
