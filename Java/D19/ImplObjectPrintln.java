/*
1. System.out.println 오버로딩 된 메소드 중에 public void println(Object x)가 없다고 가정하고 폴더에 있는 ClassPrinter에 있는 class에 print 메소드를 만드시오.

2. 인터페이스 UpperCasePrintable을 구현하는 클래스의 인스턴스가 print 메소드의 인자로 전달되면 문자열을 전부 대문자로 출력한다
*/

class ClassPrinter {
	/*
	public static void print(Point point){
		System.out.println(point.toString());
	}
	*/
	public static void print(Object obj){
		if (obj instanceof UpperCasePrintable)
			System.out.println(obj.toString().toUpperCase());
		else
			System.out.println(obj.toString());
	}
}

interface UpperCasePrintable{
	String toString();
}

class Point{
	private int xPos, yPos;
	
	Point(int x, int y){
		xPos=x;
		yPos=y;
	}
	
	public String toString(){
		String posInfo="[x:"+xPos + ", y:"+yPos+"]";
		return posInfo;
	}
}
class Point2 extends Point implements UpperCasePrintable{
	private int x,y;
	Point2(int x, int y){
		super(x,y);
	}
}
class ImplObjectPrintln{
	public static void main(String[] args){
		Point pos1=new Point(1, 2);
		Point2 pos2=new Point2(5, 9);

		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);
	}
}