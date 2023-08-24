package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;

class ListIteratorCollection {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
		list = new ArrayList<>(list);

		ListIterator<String> iter = list.listIterator();
		// ListIterator는 Iterator의 확장 버전
		// 양방향으로 이동이 가능
		String str; 

		// 왼쪽에서 오른쪽으로 
		while(iter.hasNext()) {
			str = iter.next();
			System.out.print(str + '\t');
			// Toy	Box	Robot	Box
			if(str.equals("Toy"))
				iter.add("Toy2");
			// ListIterator는 리스트 요소에 접근하면서 추가,수정,삭제 등 작업을 수행하는 interface
			// iter가 toy를 가리킬때 toy2가 조건에 맞아 add되었고, iter는 toy2를 가리킴
			// while문을 돌아서, str은 toy2의 next를 가리키므로 print문에서 4개만 출력
		}
		System.out.println();

		while(iter.hasPrevious()) {
			str = iter.previous();
			System.out.print(str + '\t');
			
			if(str.equals("Robot"))
				iter.add("Robot2");
		}
		// Box	Robot	Robot2	Box	Toy2	Toy	
		System.out.println();
		

		// 다시 왼쪽에서 오른쪽으로
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); )
			System.out.print(itr.next() + '\t');
		System.out.println();
		// Toy	Toy2	Box	Robot2	Robot	Box
	}
}


/*
	연결 리스트만 갖는 양방향 반복자
	Collection<E>를 구현하는 클래스의 인스턴스는 iterator 메소드의 호출을 통해서 '반복자'를 얻을 수 있다. 
	그런데 List<E>를 구현하는 클래스의 인스턴스들만 얻을 수 있는 '양방향 반복자'라는 것이 있는데, 이는 List<E>의 다음 메소드 호출을 통해서 얻을 수 있다.

	public ListIterator<E> listIterator()
		-> ListIterator<E>는 Iterator<E>을 상속한다.

	위의 메소드가 반환하는 반복자는 양쪽 방향으로 이동이 가능하다는 특징이 있는데, 이는 배열이나 연결 리스트와 같은 자료구조의 특성상 가능한 일이다. 
	그리고 위 메소드가 반환하는 반복자를 대상으로호출할 수 있는 대표 메소드들은 다음과 같다.

	E next()			다음 인스턴스의 참조 값을 반환
	boolean hasNext()		next 메소드 호출 시 참조 값 반환 가능 여부 확인
	void remove()		next 메소드 호출을 통해 반환했던 인스턴스를 삭제

	E previous()		next 메소드와 기능은 같고 방향만 반대
	boolean hasPrevious()	hasNext 메소드와 기능은 같고 방향만 반대

	void add(E e)		인스턴스의 추가
	void set(E e)		인스턴스의 변경

	ListIterator<E>는 Iterator<E>를 상속한다.

	실행 결과를 통해서 add 메소드가 어느 위치에 인스턴스를 추가하는지 확인할 수 있다. 
	즉 이를 통해 다음 사실을 알 수 있다.

	"next 호출 후에 add 호출하면, 앞서 반환된 인스턴스 뒤에 새 인스턴스 삽입된다."
	"previous 호출 후에 add 호출하면, 앞서 반환된 인스턴스 앞에 새 인스턴스가 삽입된다."
 */