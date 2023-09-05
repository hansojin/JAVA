package ystd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;

class SupplierDemo {
//    public static List<Integer> makeIntList(Supplier<Integer> s, int n) {
    public static List<Integer> makeIntList(IntSupplier s, int n) {
        List<Integer> list = new ArrayList<>();    
        for(int i = 0; i < n; i++)
            list.add(s.getAsInt());
        return list;
    }
    
    public static void main(String[] args) {
    	IntSupplier spr = ()->{
        	Random rand = new Random();
        	return rand.nextInt(50);
        };

        List<Integer> list = makeIntList(spr, 5);
        System.out.println(list);

        list = makeIntList(spr, 10);
        System.out.println(list);
    }
}
