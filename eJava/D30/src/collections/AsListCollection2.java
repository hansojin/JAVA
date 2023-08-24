package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

class AsListCollection2 {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		// list.add()는 하나씩 추가하는 방법이고 이처럼 여러개를 한번에 만들려면, Arrays.aslist 사용
		// 다만 이건 고정된 리스트 생성 = 삭제/추가 불가능
		list = new ArrayList<>(list);
		// ArrayList에 복사 -> 이후 remove 작업을 수행하기 위해
		// 만약 이 줄을 주석 처리 한다면, 두번째 iterator에서 remove 시 오류 발생

		Iterator<String> itr;
		
		for (itr=list.iterator();itr.hasNext();)
			System.out.print(itr.next()+ '\t');

		for(itr = list.iterator(); itr.hasNext(); ) {
			if(itr.next().equals("Box"))
				itr.remove();
		}
		System.out.println();
		for(itr = list.iterator(); itr.hasNext(); )
			System.out.print(itr.next() + '\t');
		
	}
}
