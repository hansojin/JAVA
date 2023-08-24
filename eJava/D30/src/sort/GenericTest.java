package sort;

import java.util.ArrayList;
import java.util.List;

interface Comp<T>{
}

class Gen{
	public static <T extends Comp<T>> void sort(List<T> list){	
	}	
}

class Carr implements Comp<Carr>{}
class ECarr extends Carr{}

public class GenericTest {
	public static void main(String[] args) {
		List<ECarr> list = new ArrayList<>();
//		Gen.sort(list);		// Error
	}
}

/*
public static <T extends Comp<T>> void sort(List<T> list)
	-> T가 ECarr인 경우 ECarr는 Comp<ECarr>를 구현해야 한다.
*/