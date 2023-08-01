class Triangle{

	int width, height, area;
	
	public void init(int width, int height){
		this.width = width;		//this.width 는 멤버변수 width를 가리킴
		this.height = height;	//물론 매개변수를 (int w, int h)로 받아와서 width = w; 로 둬도 돼
					// width = width라고 쓰지 못하는 이유는, 지역변수와 멤버변수가 같은 경우에, 지역변수가 우선되기 때문에, 
					// 멤버변수에 담아온 매개변수가 담기지 못함. 그래서 "this." (instance 자기자신(의 주소값)) 를 써줌 
	}

	public void baseXheight(){
		area = (width*height)/2;
	}
	
	public void currentState(){
		System.out.println("가로 : " +width + "\t세로 : " + height + "\t넓이 : " + area);
	}

	
}

class TriangleMain{
	public static void main(String[] args){
		Triangle tri1 = new Triangle();
		tri1.init(10,5);
		tri1.baseXheight();
		tri1.currentState();

		Triangle tri2 = new Triangle();
		tri2.init(4,2);
		tri2.baseXheight();
		tri2.currentState();

		Triangle tri3 = new Triangle();
		tri3.init(20,10);
		tri3.baseXheight();
		tri3.currentState();
	}
}