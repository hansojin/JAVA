### stack 

	- LIFO
	
### queue

	- FIFO
	- ArrayList << LinkedList 
		- as, 데이터 추가 삭제 용이
	- method
		- boolean empty()
		- Object peek() _ 맨 위 객체 반환 (empty -> EmptyStackException 발생)
		- Object pop()
		- Object push(Object item)
		- int search(Object o) _ o 위치 반환 (else -1)
		- boolean add(Object o) _ (overflow -> illegalStateException 발생)
		- Object remove() _ (empty -> NoSuchElementException 발생)
		- boolean offer(Object o) 
		- boolean poll()_ (empty -> null)
		- boolean peek() _ (empty-> null)

---

| Deque | Queue |Stack |
| ----- | ----- |------|
|offerLast()|offer()|push()|
|pollLast()||pop()|
|pollFirst()|poll()||
|peekFirst()|peek()||
|peekLast()||peek()|

---

- Collections Data Acess

	- Iterator
		- Map은 collection의 자손이 아니므로 Iterator()가 없음
		- ∴ keySet(), entrySet()_K,V출력, values()를 호출한 뒤, Iterator 호출
	- ListIterator
	- ~~Enumeration~~
	
---

### Arrays

**Arrays 에 정의된 method는 모두 static method**

- 배열 복사
	- copyOf(), copyOfRange()
		- 복사 후 새로운 배열 반환
- 배열 채우기
	- fill(),setAll()
		- use lambda in setAll() method

- 배열 정렬과 검색
	- sort(), binarySearch()
	
- 배열 비교와 출력
	- equals(), toString()
	
- 배열의 List 변환
	- asList(Object o)
		- 크기 고정 = list 추가 및 삭제 불가 
		- 저장된 내용 변경은 가능
		
- thread 처리
	- parallelXXX(), spliterator(), stream()
		
---

### Set

#### HashSet
- 순서 X, 중복 X
	- as, HashMap 이용
	- 만약 저장 순서 유지하고 싶다면, LinkedHashSet class 사용
- set은 정렬 불가
	- 정렬을 원한다면, List에 요소들을 담아 Collections.sort() 사용
- add()
	- hashCode(), equals() @Overriding필요
		- return Objects.hash(a,b,c);
		- return x.hashCode();

#### TreeSet
- 이진탐색트리 자료 구조 형태
	- as, TreeMap 이용
	- 범위 검색과 정렬에 유리
		- HashSet보다 데이터 추가,삭제에 시간 더 소요

	
	

