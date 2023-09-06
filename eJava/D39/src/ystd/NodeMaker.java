package ystd;

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
		// BiFunction<T, U, R> R apply(T t, U u)
//		BiFunction<Integer,String,Node<Integer,String>> bf = (i,s)->new Node<>(i,s);
		BiFunction<Integer,String,Node<Integer,String>> bf = Node<Integer,String>::new;

		
		Node<Integer, String> b1 = bf.apply(1, "Toy");	// 1과 "Toy" 저장된 상자 반환
		Node<Integer, String> b2 = bf.apply(2, "Robot"); // 2와 "Robot" 저장된 상자 반환
		b1.showIt();
		b2.showIt();
	}
}	



