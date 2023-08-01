class Rectangle2{
	private int ulx, uly;		// 좌 상단 x, y 좌표
	private int lrx, lry;		// 우 하단 x, y 좌표

	private boolean isProperRange(int pos){
		if(0<=pos && pos <= 100)
			return true;
		else
			return false;
	}
	public void setRectanglePoint(int lx, int ly, int rx, int ry){
		if(lx>=rx || ly>=ry){
			System.out.println("좌표 지정이 잘못되었습니다.");
			return;
		}
		if( !isProperRange(lx) || !isProperRange(ly) ){
			System.out.println("좌 상단 좌표의 범위가 잘못되었습니다.");
			return;
		}
		if( !isProperRange(rx) || !isProperRange(ry) ){
			System.out.println("우 하단 좌표의 범위가 잘못되었습니다.");
			return;
		}

		ulx = lx;
		uly = ly;
		lrx = rx;
		lry = ry;
	}

	public void showArea(){
		int xLen = lrx - ulx;
		int yLen = lry - uly;
		System.out.println("넓이 : " + (xLen*yLen) );
	}
}

class RectangleMain2{
	public static void main(String[] args){
		Rectangle2 rec = new Rectangle2();
		rec.setRectanglePoint(-3, -1, 2, 7);
		rec.showArea();

		rec.setRectanglePoint(2, 2, 8, 8);
		rec.showArea();
	}
}