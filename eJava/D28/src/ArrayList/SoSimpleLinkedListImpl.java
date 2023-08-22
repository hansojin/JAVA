package ArrayList;

class Node<T>{
	public Node<T> nextNode;
	T item;

	public void store(T item) { 
		this.item=item; 
	}
	public T pullOut() { 
		return item; 
	}
}

class SoSimpleLinkedListImpl{
	public static void main(String[] args)	{
		Node<String> NodeHead=new Node<String>();
		NodeHead.store("First String");

		NodeHead.nextNode=new Node<String>();
		NodeHead.nextNode.store("Second String");

		NodeHead.nextNode.nextNode=new Node<String>();
		NodeHead.nextNode.nextNode.store("Third String");

		Node<String> tempRef;

		/* 두 번째 박스에 담긴 문자열 출력 과정 */
		tempRef=NodeHead.nextNode;
		System.out.println(tempRef.pullOut());

		/* 세 번째 박스에 담긴 문자열 출력 과정 */
		tempRef=NodeHead.nextNode;
		tempRef=tempRef.nextNode;
		System.out.println(tempRef.pullOut());
	}
}
