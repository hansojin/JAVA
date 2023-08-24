package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;

class ListIteratorCollection2 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		list = new ArrayList<>(list);

		ListIterator<String> iter = list.listIterator();
		String str; 

		// 왼쪽에서 오른쪽으로 
		while(iter.hasNext()) {
			str = iter.next();
			System.out.println(str + "\t"+ iter.nextIndex()+ "\t");
			
			// Toy	Box	Robot	Box
			if(str.equals("Toy"))
				iter.add("Toy2");
			System.out.print(iter.nextIndex()+ "\t");
		}
		System.out.println();

		while(iter.hasPrevious()) {
			str = iter.previous();
			System.out.println(str + "\t" + iter.nextIndex() + "\t" );
			
			if(str.equals("Robot"))
				iter.add("Robot2");
			System.out.print(iter.nextIndex()+ "\t");
		}
		// Box	Robot	Robot2	Box	Toy2	Toy	
		System.out.println();
		

		// 다시 왼쪽에서 오른쪽으로
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
			System.out.println(iter.next() + "\t" + iter.nextIndex() );
		System.out.println();
		// Toy	Toy2	Box	Robot2	Robot	Box
	}
}


