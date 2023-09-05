package optional;

import java.util.function.BiFunction;

class Node<T, U>{
	private T id;
	private U con;
	public Node(T i, U c) {
		id = i;
		con = c;
	}
	public void showIt() {
		System.out.println("ID: " + id + ", " + "Contents: " + con);
	}
}

public class NodeMaker {

	public static void main(String[] args) {
		// BiFunction<T, U, R> 인터페이스를 기반으로 작성된 '람다식'을 포함한 참조변수 bf의 선언
		// BiFunction<T, U, R> R apply(T t, U u)
		
//		BiFunction<Integer,String,Node<Integer,String>> bf = (i,c)-> new Node<Integer,String>(i,c);
		BiFunction<Integer,String,Node<Integer,String>> bf = Node<Integer,String>::new;

		Node<Integer, String> n1 = bf.apply(1, "Toy");	// 1과 "Toy" 저장된 상자 반환
		Node<Integer, String> n2 = bf.apply(2, "Robot"); // 2와 "Robot" 저장된 상자 반환
		n1.showIt();
		n2.showIt();
	}
}	
