class Circle{
	int radius;
	double area, round;
	static double pi=3.14;

	public void init(int radius){
		this.radius = radius;
		circleArea();
		circleRound();
		currentState();
	}
	public void circleArea(){
		area = radius*radius*pi;
	}
	public void circleRound(){
		round = 2*pi*radius;
	}
	public void currentState(){
		System.out.println("반지름 = " + radius + "\t둘레 = " + round + "\t넓이 = " + area);
	}
}

class CircleMain{
	public static void main(String[] args){
		Circle c1 = new Circle();
		c1.init(5);	
		Circle c2 = new Circle();
		c2.init(10);
		Circle c3 = new Circle();
		c3.init(30);
	}
}