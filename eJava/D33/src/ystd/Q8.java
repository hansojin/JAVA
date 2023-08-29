package ystd;

import java.util.HashMap;

public class Q8 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };
		
		HashMap<String,Integer> map = new HashMap<>();
		for (int i=0;i<data.length;i++) {
			if (map.containsKey(data[i])) 
				map.put(data[i], (Integer)map.get(data[i])+1);
			else
				map.put(data[i], 1);
		}
		map.forEach((key,value)->{
			System.out.print(key + " : ");
			for(int i=0;i<value;i++)
				System.out.print("*");
			System.out.println(" " + value);
		});
	}
}
