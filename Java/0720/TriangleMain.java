class Triangle{
	int width,height,area;

	public Triangle(int width, int height){		//this is constructor !
		this.width = width;
		this.height = height;
	}

	public void areaOfTriangle(){
		area = width * height / 2;
	}
	
	public void printCS(){
		System.out.println("밑변 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓이 : " + area);
	}
}

class TriangleMain{
	public static void main(String[] args){
		Triangle t1 = new Triangle(10,5);
		// t1.initTriangle(10, 5);		< 이게 이제 필요없음
		t1.areaOfTriangle();
		t1.printCS();

		Triangle t2 = new Triangle(4,2);	// <- 원래 new Triangle(); default로 부르던걸 이제 여기에 parameter 넣어서 호출
		t2.areaOfTriangle();
		t2.printCS();

		Triangle t3 = new Triangle(20,10);
		t3.areaOfTriangle();
		t3.printCS();
	}
}