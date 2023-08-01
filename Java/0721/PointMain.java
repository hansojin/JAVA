* DO NOT compile this file;

class Point{
	private int xPos, yPos;

	public Point(int x, int y){
		xPos = x;
		yPos = y;
	}
	public void showPointInfo(){
		System.out.println("[" + xPos + ", " + yPos + "]");
	}
}

class Circle{
	
}

class Ring{
	private int x1, y1, r1, x2, y2, r2;
	private Circle circle;
	private Point point;


	public Ring(int x1, int y1, int x2, int y2, int r1, int r2){
		this.x1=x1; this.x2=x2; this.y1=y1; this.y2=y2; this.r1=r1; this.r2=r2;
		point = new Point(x1,y1);
	}

	
	public String toPoint(int x,int y){
		return point.showPointInfo(x,y);
	}

	

	public void showRingInfo(){
		System.out.println("Inner Circle Info...");
		System.out.println("radius : " + r1);
		//System.out.println(point.toPoint(x1,y1));
		System.out.println("Outer Circle Info...");
		System.out.println("radius : " + r2);
		//System.out.println(point.toPoint(x2,y2));
	}
}

class PointMain{
	public static void main(String[] args){
		Ring ring = new Ring(1, 1, 4, 2, 2, 9);
		ring.showRingInfo();
	}
}