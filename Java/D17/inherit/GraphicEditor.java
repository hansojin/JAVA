/*
=>  "삽입", "삭제", "모두 보기", "종료" 의 4가지 그래픽 편집 기능을 가진 클래스 GraphicEditor 작성
[동작]
그래픽 에디터 beauty를 실행합니다.
삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> 1
Line(1), Rect(2), Circle(3) >> 2
삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> 1
Line(1), Rect(2), Circle(3) >> 3
삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> 3
Rect
Circle
삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> 2
삭제할 도형의 위치 >> 3
삭제할 수 없습니다.
삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> 4
beauty을 종료합니다.

[Hint] 
Shape을 추상 클래스로 작성한 사례는 다음과 같다.
abstract class Shape {
   private Shape next;
   public Shape() { next = null; }
   public void setNext(Shape obj) { next = obj; } // 링크 연결
   public Shape getNext() { return next; }
   public abstract void draw();
}
*/


import java.util.Scanner;

abstract class Shape {
	private Shape next;

   	public Shape() { 
		next = null; 
	}

   	public void setNext(Shape obj) { 
		next = obj; 	
	} // 링크 연결

   	public Shape getNext() { 
		return next; 
	}

   	public abstract void draw();
}

class Line extends Shape {
	String name ="line";
   	public void draw() {
      		System.out.println("Line");
   	}
}

class Rect extends Shape {
   	String name ="Rect";
   	public void draw() {
      		System.out.println("Rect");
   	}
}

class Circle extends Shape {
   	String name ="circle";
   	public void draw() {
      		System.out.println("Circle");
   	}
}

public class GraphicEditor{
   	private Shape head, tail;
   	private Scanner sc; 
   	public GraphicEditor() {
     		head = null;  
      		tail = null; 
      		sc = new Scanner(System.in);
   	}

   	public void run() {
      		System.out.println("그래픽 에디터 beauty를 실행합니다.");
      		while(true) {
         			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
         			int num = sc.nextInt();
         			switch(num) {
         			case 1:
            			System.out.print("Line(1), Rect(2), Circle(3) >> ");
           				num = sc. nextInt();
            			insert(num);
            			break;
         			case 2:
            			System.out.print("삭제할 도형의 위치 >> ");
            			num = sc.nextInt();
            			delete(num);
            			break;
         			case 3:
            			print();
            			break;
         			case 4:
            			System.out.println("beauty을 종료합니다.");
            			sc.close();
            			return;
         			}
      		}
   	}
   	public void insert(int draw) {
      		Shape grapic;
      		switch(draw) {
      		case 1:
         			grapic = new Line();
         			break;
      		case 2:
         			grapic = new Rect();
         			break;
      		case 3:
         			grapic = new Circle();
         			break;
      		default:
         			System.out.println("다시 입력해 주세요.");
         			return;
      		}

      		if(head == null) { 		// head가 아무것도 가리키지 않으면
         			head = grapic; 	// head랑 tail이 새로운 노드를가리킴
         			tail = grapic;
      		}
      		else {
         			tail.setNext(grapic); // 끝 노드에 새로운 노드를 연결하고,
         			tail = grapic; 	// 끝 노드는 새로 만들어진 노드를 가리키게 함
      		}
   	}

   	public void print() { 		// 전체 노드 출력
      		Shape s = head;
      		while(s != null) {
         			s.draw();
         			s = s.getNext();
      		}
   	}

   	public void delete(int num) { 	// num은 몇번째 노드인지
      		Shape cur = head; 		// 현재 노드
      		Shape tmp = head;

      		if( num == 1) { 		// 첫번째 노드를 삭제하는 경우 
         			if(head == tail) { 	// 노드가 한개일 경우 
            			head = null;
            			tail = null;
            			return;
         			}
         			else { 		// 노드가 두개 이상
            			head = head.getNext();
            			return;
         			}
      		}
		int i;
      		for(i=1; i<num; i++) {
         			tmp = cur; 		// 현재 노드를 저장 후  (즉, 이전 노드)
         			cur = cur.getNext(); 	// 다음 노드로 이동
         			if(cur == null) { 		// 노드 수가 입력 값보다 적을때
            			System.out.println("삭제할 수 없습니다.");
            			return;
         			}
      		}
      		if(i==num) { 			// 끝 노드를 가리킬때
         			tmp.setNext(cur.getNext());
         			tail = tmp;
      		}
      		else 	// 끝노드가 아니라면 이전노드가 다음 노드를 가리킴 (즉, 현재 노드 삭제)
         			tmp.setNext(cur.getNext());
   	}

   	public static void main(String[] args) {
         		GraphicEditor editor = new GraphicEditor();
         		editor.run();
   	}
}