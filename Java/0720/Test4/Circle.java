package orange.area;

public class Circle{

	double radius;

	public Circle(double radius){
		this.radius = radius;
	}
	public double getArea(){
		return 3.14*radius*radius;
	}
	
	
}


// javac -d . Circle.java
// -d : package가 있으면, 패키지 까지 다 컴파일 하라