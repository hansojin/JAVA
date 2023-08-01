class Circle{

	double radius,area,perimeter,pi;

	public Circle(double radius){
		this.radius = radius;
		pi = 3.14;
		perimeterOfCircle();
		areaOfCircle();
		printCS();
	}

	public void perimeterOfCircle(){
		perimeter = 2 * pi * radius;
	}

	public void areaOfCircle(){
		area = pi * radius * radius;
	}

	public void printCS(){
		System.out.println("반지름 " + radius);
		System.out.println("둘레 " + perimeter);
		System.out.println("면적 " + area);
	}
}
class CircleMain{
	public static void main(String[] args){
		// Circle c1 = new Circle();
		// c1.initCircle(5);			<- we don't need this anymore
		Circle c1 = new Circle(5);		<- just call class with containing parameters
		Circle c2 = new Circle(10);
		Circle c3 = new Circle(30);
	}
}