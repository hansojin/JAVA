1. 프레임워크(Framework) 란?

	* 잘 정의된 약속된 구조나 골격.
	
2. 자바에서 말하는 프레임워크?

	* 잘 정의된 약속된 구조의 클래스 틀
	
3. 자료구조(Data Structures)?

	* 자료구조는 데이터의 저장과 관련이 있는 학문으로서, 검색 등 다양한 측면을 고려하여 효율적인 데이터의 저장 방법을 연구하는 학문.
	
4. 알고리즘(Algorithms)

	* 알고리즘은 저장된 데이터의 일부 또는 전체를 대상으로 진행하는 각종 연산을 연구하는 학문.
	
5. 자료구조에서 정형화하고 있는 데이터의 저장방식 예.

	* 배열(Array), 리스트(List), 스택(Stack), 큐(Queue), 트리(Tree), 해시(Hash) 등
	
6. 알고리즘 예?

	* 정렬(Sort), 탐색(Search), 최대(Max) 최소(Min) 검색
	
7. 컬렉션?

	* 컬렉션은 데이터의 저장, 그리고 이와 관련있는 알고리즘을 구조화 해 놓은 프레임워크이다. 
	* 쉽게는 자료구조와 알고리즘을 클래스로 구현해  놓은 것 정도로 생각해도 좋다. 때문에 컬렉션 클래스들을 가리켜 ‘컨테이너 클래스’라고도 한다.

8. 컬렉션 프레임 워크의 인터페이스 구조

	* Collection<E>	<- 		Set<E>		List<E>		Queue<E>		
	* Map<K,V>

9. 컬렉션이 프레임워크인 이유?

	* 인터페이스 구조를 기반으로 클래스들이 정의되어 있기 때문에 프레임워크라 하는 것이다.

10. List<E> 인터페이스와 이를 구현하는 제네릭 클래스

	* ArrayList<E>, LinkedList<E>

11. List<E> 인터페이스를 구현하는 제네릭 클래스들은 다음 두 가지 특성을 공통으로 지닌다.

	1. 동일한 인스턴스의 중복저장을 허용한다.
	2. 인스턴스의 저장순서가 유지된다.

15. ArrayList<E>의 특징

	* 저장소의 용량을 늘리는 과정에서 많은 시간이 소요된다. 
	* 데이터의 삭제에 필요한 연산과정이 길다. 
	* 데이터의 참조가 용이해서 빠른 참조가 가능하다.

17. LinkedList<E> 특징

	* 저장소의 용량을 늘리는 과정이 간단하다. 
	* 데이터의 삭제가 매우 간단하다. 
	* 데이터의 참조가 다소 불편하다. 

18. [ArrayList<E> vs. LinkedList<E>]

	* 저장하게 되는 데이터의 수가 대략적으로 예측 가능하며, 빈번한 데이터의 참조가 일어나는 상황에서 유용하게 사용할 수 있는 컬렉션 클래스는 무엇인가? ArrayList<E>
	* 저장하게 되는 데이터의 수가 예측 불가응하며, 빈번한 데이터의 저장 및 삭제가 일어나는 상황에서 유용하게 사용할 수 있는 컬렉션 클래스는 무엇인가? LinkedList<E>

20. 다음 메소드를 API에서 참고

	* **boolean hasNext()** 참조할 다음 번 요소(element)가 존재하면 true를 반환
	* **E next()** 다음 번 요소를 반환
	* **void remove()** 현재 위치의 요소를 삭제


22. Iterable<E> 인터페이스

	* Collection<E> 인터페이스는 Iterable<E> 인터페이스를 상속하는데,  Iterable<E>에 정의되어 있는 유일한 메소드가 iterator 이다. 즉 Collection<E>에 정의되어 있는 iterator 메소드는 인터페이스간 상속에 의한 것이다.

23. **반복자** 의 의미

“컬렉션 클래스의 종류에 상관없이 동일한 형태의 데이터 참조 방식을 유지한다.”

반복자는 저장된 데이터 전부를 참조할 때 매우 유용하다. 

그리고 ‘데이터 전부의 참조’라는 것은 데이터의 저장방식과는 상관없이 매우 빈번하게 요구되는 기능이다. 

때문에 대부분의 컬렉션 클래스들은 반복자를 반환하는 iterator 메소드를 구현하고 있다.

26. List<E> 인터페이스를 구현하는 클래스들과 Set<E> 인터페이스를 구현하는 클래스들의 차이점.

	* List<E>를 구현하는 클래스들과 달리 Set<E>를 구현하는 클래스들은 데이터의 저장순서를 유지하지 않는다.
	* List<E>를 구현하는 클래스들과 달리 Set<E>를 구현하는 클래스들은 데이터의 중복저장을 허용하지 않는다.
	* Set<E>의 특성은 수학에서 말하는 ‘집합’의 특성이다. 즉 Set<E> 인터페이스를 구현하는 클래스는 Set이라는 단어의 의미처럼 ‘집합’의 특성을 지닌다.



29. Hash<E> 클래스는 해시 알고리즘을 적용하여 데이터를 저장하고 검색한다. 그럼 그 방식을 어떠한 방법으로 진행하나?
	1. Object 클래스의 hashCode 메소드의 반환 값을 해시 값으로 활용. -> **public int hashCode();**
	2. Object 클래스의 equals 메소드의 반환 값을 이용해서 내용비교. -> **public boolean equals(Object obj);**
	* Object 클래스의 hashCode 메소드는 인스턴스가 다르면 구성 내용에 상관없이 전혀 다른 해시값을 반환하도록 정의되어 있다. 
	* equals 메소드도 내용비교가 아닌, 참조 값만 비교하도록 정의되어 있다.


문제40. 오름차순의 반복자를 반환하는 iterator. 그럼 내림차순의 반복자를 반환하는 메소드는?

	* Iterator<E> descendingIterator() 
	
문제41. TreeSet<String> 인스턴스! 사전편찬 순서 말고, 길이 순으로 문자열을 정렬하라는 등의 요구를 위해 정의된 것이 **Comparator<T>** 인터페이스이다.

```
interface Comparator<T>{
	int compare(T obj1, T obj2);
	boolean equals(Object obj);
}
```

위의 인터페이스 중에서 equals 메소드는 신경 쓰지 않아도 된다. 

이 인터페이스를 구현하는 모든 클래스는 Object 클래스를 상속하기 때문에, Object 클래스의 equals 메소드가 위의 equals 메소드를 구현하는 꼴이 되기 때문이다.



문제44. **Collection<E>** 를 구현하는 컬렉션 클래스들이 value만 저장하는 구조였다면,  **Map<K, V>** 를 구현하는 컬렉션 클래스들은 value를 저장할 때, 이를 찾는데 사용되는 **key를 함께 저장** 하는 구조이다.

문제45.  Map<K, V> 인터페이스를 구현하는 대표적인 클래스로 **HashMap<K, V>와 TreeMap<K, V>** 가 정의되어 있다.


문제47. Hash<K, V>를 구현하는 컬렉션 클래스들의 특징.

	* value에 상관없이 중복된 key의 저장은 불가능하다.
	* value는 같더라도 key가 다르면 둘 이상의 데이터 저장도 가능하다.

	HashSet<E>가 해시 알고리즘을 기반으로 구현되어 있듯이, HashMap<K, V> 역시 해시 알고리즘을 기반으로 구현되어 있다. 따라서 HashSet<E>의 장점인 ‘매우 빠른 검색속도’는 HashMap<K, V>에도 그대로 반영이 된다. 마찬가지로 TreeMap<K, V> 역시 ‘트리’ 자료구조를 기반으로 구현이 되어 있다. 따라서 데이터는 정렬된 상태로 저장이 된다.

문제48. navigableKeySet 메소드가 호출되면, 인터페이스 (NavigableSet<E>)를 구현하는 인스턴스가(인스턴스의 참조 값이) 반환된다.

NavigableSet<E> 인터페이스는 (Set<E>) 인터페이스를 상속한다. 즉 navigableKeySet 메소드가 반환하는 인스턴스를 대상으로 반복자를 얻기 위해서 iterator 메소드의 호출이 가능하다. 그리고 이렇게 해서 얻은 반복자로, 저장된 모든 key에 접근이 가능하다.

TreeMap<K, V>의 전체 데이터 검색

	TreeMap<K, V>는 Collection<E>가 아닌 (Map<K, V>)를 구현하는 컬렉션 클래스이니, 저장되어 있는 전체 데이터를 검색하는 방식에 차이가 있음은 당연한 일이다. 그리고 참으로 재미있는 것은 TreeMap<K, V>에 저장된 전체 데이터의 참조 과정에서 호출한 navigableKeySet 메소드가 반환하는 인스턴스가 Set<E> 인터페이스를 구현한다는 사실이다. key는 중복이 불가능하기 때문에 ‘집합’의 성격을 띤다. 때문에 이러한 key를 저장하는 인스턴스는 Set<E> 인터페이스를 구현하고 있는 것이다.

문제49. TreeMap을 이용하여 (1, “data1”), (3. “data3”),(5, “data5”),(2, “data2”),(4, “data4”)을 저장하고 모든 데이터를 오름차순 및 내림차순 출력을 하시오.

```
import java.util.TreeMap;
import java.util.Iterator;
import java.util.NavigableSet;

class IntroTreeMap{
	public static void main(String[] args){
		TreeMap<Integer, String> tMap=new TreeMap<Integer, String>();

		tMap.put(1, "data1");		
		tMap.put(3, "data3");	
		tMap.put(5, "data5");	
		tMap.put(2, "data2");	
		tMap.put(4, "data4");	
		
		NavigableSet<Integer> navi=tMap.navigableKeySet();
		
		System.out.println("오름차순 출력...");
		Iterator<Integer> itr=navi.iterator();
		while(itr.hasNext())
			System.out.println(tMap.get(itr.next()));
		
		System.out.println("내림차순 출력...");
		itr=navi.descendingIterator();
		while(itr.hasNext())
			System.out.println(tMap.get(itr.next()));	
	}
}
```