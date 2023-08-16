package ystd;

class Point implements Cloneable{
	int xPos, yPos;
	public Point(int x, int y){
		xPos = x;
		yPos = y;
	}
	public void showPosition(){
		System.out.printf("[%d, %d]", xPos, yPos);
	}
	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	@Override
	protected Point clone() throws CloneNotSupportedException {
		return (Point)super.clone();
	}

}

class Rectangle implements Cloneable{
	Point upperLeft, lowerRight;
	public Rectangle(int x1, int y1, int x2, int y2){
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	public void showPosition(){
		System.out.println("직사각형 위치정보...");
		System.out.print("좌 상단 : ");
		upperLeft.showPosition();
		System.out.println("");
		System.out.print("우 하단 : ");
		lowerRight.showPosition();
		System.out.println("\n");
	}
	public void changePos(int x1,int y1,int x2,int y2) {
		upperLeft.changePos(x1,y1);
		lowerRight.changePos(x2,y2);
	}
	@Override
	protected Rectangle clone() throws CloneNotSupportedException {
		Rectangle copy = (Rectangle)super.clone();
		copy.upperLeft = upperLeft.clone();
		copy.lowerRight = lowerRight.clone();
		return copy;
	}

}

public class CopyTest {
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(1, 1, 9, 9);
		rec.showPosition();

		try {
			Rectangle copy= rec.clone();
			copy.changePos(2, 2, 8, 8);
			copy.showPosition();
		}catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}


	}

}
