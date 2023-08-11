package OOP2;

abstract class Shape {
	Point p;
	
	Shape() {
		this(new Point(0,0));
	}
	Shape(Point p) {
		this.p = p;
	}
	
	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드
	
	Point getPosition() {
		return p;
	}
	void setPosition(Point p) {
		this.p = p;
	}
}

class Circle extends Shape{
	Point p;
	double r; 
	
	public Circle(double r) {
		super();
		this.r=r;
	}
	public Circle(Point p,double r) {
		super(p);
		this.r=r;
	}
	double calcArea() {
		return r*r*Math.PI;
	}
}

class Rectangle extends Shape{
	Point p;
	double width,heigth;
	
	public Rectangle(double width,double heigth) {
		super();
		this.width=width;
		this.heigth=heigth;
	}
	public Rectangle(Point p,double width,double heigth) {
		super(p);
		this.width=width;
		this.heigth=heigth;
	}
	
	public boolean isSquare() {
		if (width==heigth)
			return true;
		return false;
	}
	double calcArea() {
		return width*heigth;
	}

}


class Point {
	int x;
	int y;
	Point() {
		this(0,0);
	}
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return "["+x+","+y+"]";
	}
}


class Exercise7_23
{
	public static double sumArea(Shape...shapes) {
		double sum=0;
		for (Shape shape : shapes) {
			sum+=shape.calcArea();
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println("면적 합:" + sumArea(arr));
	}
}