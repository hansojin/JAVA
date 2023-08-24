package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class ListToSet {
	public static void main(String[] args) {
		List<String> lst = Arrays.asList("Box", "Toy", "Box", "Toy");
        ArrayList<String> list = new ArrayList<>(lst);
        
        for(String s : list)
            System.out.print(s.toString() + '\t');
        System.out.println();
        
        //ConvertCollection !!
        HashSet<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);
		
		for(Iterator<String> iter = list.iterator();iter.hasNext();)
			System.out.print(iter.next()+ '\t');
	}
}

