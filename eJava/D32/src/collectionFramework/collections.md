## TreeSet

- 이진탐색트리 형태로 데이터 저장하는 컬렉션 클래스
	- 범위 검색 및 정렬에 유리
	- 최대 두개의 자식 노드
		- 부모보다 작은 값은 왼쪽,큰 값은 오른쪽
		- 데이터가 많아질 수록 데이터 추가/삭제에 시간이 더 걸림 (부모와 비교하는 횟수 증가)
		- 중복 저장 X
	- linked list의 변형
	- compare()를 호출해서 기존에 같은 객체가 있는지 확인 (= 중복 저장X)
		- like, HashSet()이 equals(), hashCode()로 비교하듯
	- 트리 순회
		- 모든 노드를 한번씩 읽는 법
		- 전위, 중위, 후위법
			- 중위 순회 -> 오름차순 정렬
	- Red-Black tree
		- 자가 균형 이진 탐색 트리
	

```
class TreeNode{
	TreeNode left;		// 왼쪽 자식 노드
	Object element; // 저장할 객체
	TreeNode right;	// 오른쪽 자식 노드
}
```

---

## HashMap

- Key, Value의 쌍으로 저장 -> entry
	- key는 unique
	- key,value에 null 값 허용
	- 쌍으로 관리하므로, iteration 객체 사용 X
		- 해당 key에서 데이터 값 바로 추출 가능
- hashing을 사용하기 때문에 빠른 검색 가능
	- hash function -> hash table에 데이터를 저장/검색
	- key와 데이터가 저장된 위치(index)를 이용함
		- 같은 hash code에 대해서는 linked list 사용
- 순서 X
	- 저장 순서를 유지하려면, LinkedHashMap class 사용
		- 입력된 순서대로 key가 보장되는 FIFO 방식
		- Map<K,V> linkedHashMap = new LinkedHashMap<>();
- hashCode(), equals()를 오버라이딩해서 동등 객체가 될 조건을 정함

---

## Properties

- Hashmap의 구버전인 HashTable을 상속 받아 구현한 것
	- Iterator가 아닌, Enumeration 사용
- key와 value를 String으로 저장
	- key = value 형태로 된 파일이름.properties 파일 또는 Xml 파일
	- key를 주면 value를 반환하는 기능을 가짐
	- DB 연결 정보 등을 저장해두는 용도로 많이 쓰임
- 주로 어플리케이션의 환경 설정에 관련된 속성을 저장하는데 사용
- 파일로부터 편리하게 값을 읽고 쓸 수 있는 메소드를 제공
	- void list(PrintStream out)
	- void list(PrintWriter out)
	- String getProperty(String key)
	- String getProperty(String key, String defaultValue)
	
---

## Collections

**Collections class는 컬렉션을 위한 static method 제공**

- Arrays
	- fill(), copy(), sort(), binarySearch()
- 동기화
	- synChronizedXXX()
	- 하나의 객체를 여러 쓰레드가 동시에 접근할 수 있기 때문에, 일관성을 유지하기 위해 동기화는 필요
-  변경 불가 (=readOnly)
	- unmodifiableXXX()
	- 데이터 보호하기 위함 (멀티 쓰레드 프로그래밍에서)
- 싱글톤 컬렉션
	- singletonXXX()
	- 하나의 객체만을 저장
- 한 종류의 객체만 저장하는 컬랙션
	- checkedXXX()
	- 컬랙션에 저장할 요소의 타입을 제한하는 것은 제너릭으로 간단히 처리할 수 있지만, 
	- 해당 메서드를 제공하는 이유는 호환성 때문임
	
---

![40  컬렉션 클래스 정리   요약](https://github.com/hansojin/JAVA/assets/112622663/532d125b-0975-4ea6-8070-05720976277e)




