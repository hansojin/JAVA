class Point2 {

	private int x, y;

	public Point2(){}

	public Point2(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected void move(int x, int y) {
		this.x = x; 
		this.y = y;
	}
}

public class ColorPoint2 extends Point2{

	private String color = "white";

	public ColorPoint2(){
		this.color="black";
	}

	public ColorPoint2(int x, int y){
		super(x,y);
	}

	public void setXY(int x, int y){
		move(x,y);
	}
	public void setColor(String color){
		this.color = color;
	}
	public void printPoint(){
		System.out.println(" [ " + getX() + ", " + getY() + " ] : " + color);
	}

	public static void main(String[] args){
		ColorPoint2 cp = new ColorPoint2();
		cp.printPoint();			// 0 0 black
		ColorPoint2 cp2 = new ColorPoint2(10,11);
		cp2.printPoint();			// 10 11 white
		cp2.setXY(5,25);
		cp2.setColor("mint");
		cp2.printPoint();			// 5 25 mint
			
	}
}