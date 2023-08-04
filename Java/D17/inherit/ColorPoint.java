class Point {

	private int x, y;

	public Point(int x, int y) {
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

public class ColorPoint extends Point{

	private String color;

	public ColorPoint(int x, int y, String color){
		super(x,y);
		this.color = color;
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
		ColorPoint cp = new ColorPoint(4,8,"orange");
		cp.printPoint();
		cp.move(5,25);
		cp.setColor("mint");
		cp.printPoint();
			
	}
}