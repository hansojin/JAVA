package collectionsCh11;

import java.util.ArrayList;
import java.util.Iterator;

class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> kyo = new ArrayList<>(); // 교집합
		ArrayList<Integer> cha = new ArrayList<>(); // 차집합
		ArrayList<Integer> hap = new ArrayList<>(); // 합집합
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		Iterator<Integer> it = list2.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			if(list1.contains(tmp))
				kyo.add(tmp);
		}
		
		it =list1.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			if(!list2.contains(tmp))
				cha.add(tmp);
		}
		
		it = list1.iterator();
		while(it.hasNext())
			hap.add(it.next());
		it=list2.iterator();
		while(it.hasNext())
			hap.add(it.next());
		
		System.out.println("list1="+list1);
		System.out.println("list2="+list2);
		System.out.println("kyo="+kyo);
		System.out.println("cha="+cha);
		System.out.println("hap="+hap);
	}
}
