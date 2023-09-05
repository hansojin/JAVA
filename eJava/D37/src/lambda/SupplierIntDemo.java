package lambda;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.function.IntSupplier;

class SupplierIntDemo {
    public static List<Integer> makeIntList(IntSupplier is, int n) {
        List<Integer> list = new ArrayList<>();    

        for(int i = 0; i < n; i++)
            list.add(is.getAsInt());

        return list;
    }
    
    public static void main(String[] args) {
        IntSupplier  ispr = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };

        List<Integer> list = makeIntList(ispr, 5);
        System.out.println(list);

        list = makeIntList(ispr, 10);
        System.out.println(list);
    }
}


/*
Supplier<T>를 구체화 한 인터페이스들 Supplier<T>에서 T를 기본 자료형으로 결정하여 정의한 인터페이스들은 다음과 같다.

IntSupplier			int getAsInt()
LongSupplier		long getAsLong()
DoubleSupplier		double getAsDouble()
Boolean Supplier	boolean getAsBoolean()
*/
