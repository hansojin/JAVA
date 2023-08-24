package sort;

import java.util.ArrayList;
import java.util.List;

interface Cmp<T>{
}
class Gene{
	public static <T extends Cmp<? super T>> void sort(List<T> list){
	}
}

class Cor implements Cmp<Cor>{}
class ECor extends Cor{}

public class GenericTest2 {
	public static void main(String[] args) {
		List<ECor> list = new ArrayList<>();
		Gene.sort(list);		
	}
}

/*
public static <T extends Cmp<? super T>> void sort(List<T> list)
	-> T가 ECor인 경우 ECor는 Comparable<? super ECor>를 구현해야 함
	
따라서 List<ECor> 인스턴스를 전달하면서 sort 메소드를 호출하는 순간 T는 ECor가 되어
위의 메소드는 다음 형태로 호출이 되고,

public static void sort(List<ECor> list)

메소드의 선언에서 T가 구현해야 할 인터페이스를 Comparable<? super T>로 명시했으므로
ECor 클래스는 다음 인터페이스 중 하나만 구현해도 위의 sort 메소드 호출은 성공한다.

 Cmp<Object>, Cmp<Cor>, Cmp<ECor>
*/
