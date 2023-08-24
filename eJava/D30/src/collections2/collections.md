### collections Framework

* List 
	* ArrayList
	* LinkedList
	* Vector < Stack
* Set
	* HashSet > List
	* TreeSet > SortedSet > List
* Map
	* HashMap
	* TreeMap 
	* Hashtable
	* Properties
	
---

* stack
	* LIFO
	* 수식 계산, 수식 괄호 검사, 실행 취소, 다시 실행(redo, undo), 뒤로/앞으로(웹 브라우저)
	
* queue
	* FIFO
	* 최근 사용 문서, 인쇄 작업 대기 목록, 버퍼
	* queue는 interface 
	
* deque
	* queue의 변형 -> deque도 interface 
		* 구현체 : ArrayDeque, LinkedList
	* 양 끝에서 저장(offer)과 삭제(poll)이 가능
		* offerFirst, offerLast, pollFirst, pollLast
	* priority queue
		* 저장 순서 상관없이 우선순위가 높은 것(작은 값)부터 꺼냄
		* null은 저장 할 수 없음(as, 우선순위 판단 불가)
		* heap 형태로 요소 저장