import java.util.Scanner;

class Rectangle{
	private int ulx, uly, lrx, lry;
	
	public Rectangle(int ulx, int uly, int lrx, int lry){
		this.ulx = ulx;
		this.uly = uly;
		this.lrx = lrx;
		this.lry = lry;
	}
	public void showArea(){
		int xLen = lrx-ulx;
		int yLen = uly-lry;
		System.out.println("넓이 : " + (xLen*yLen));
	}
	
}

class RectangleMain{
	public static void main(String[] args){

		int ulx=0,uly=0,lrx=0,lry=0;
		Scanner sc = new Scanner(System.in);
		
		while (true){
			System.out.print("Enter ulx : ");
			ulx = sc.nextInt();
			System.out.print("Enter uly : ");
			uly = 	sc.nextInt();
			System.out.print("Enter lrx : ");
			lrx = sc.nextInt();
			System.out.print("Enter lry : ");
			lry = sc.nextInt();
			
			if( 0<= ulx && ulx <= 100 && 0<= lrx && lrx <= 100 && 0<= uly && uly <= 100 && 0<= lry && lry <= 100 && ulx <lrx && lry<uly)
				break;
			else{
				System.out.println("조건에 맞는 숫자를 입력하시오");
			}
		}

		Rectangle rec = new Rectangle(ulx, uly, lrx, lry);
		rec.showArea();
	}
}