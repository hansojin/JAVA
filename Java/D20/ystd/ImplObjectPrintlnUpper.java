class ClassPrinter {
	public static void print(Object obj){
		if (obj instanceof UpperCasePrintable)
			System.out.println(obj.toString().toUpperCase());
		else
			System.out.println(obj.toString());
	}
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
interface UpperCasePrintable{
}
class Point2 extends Point implements UpperCasePrintable{
	private int xPos, yPos;
	Point2(int x, int y){
		super(x,y);
	}
}
class ImplObjectPrintlnUpper{
	public static void main(String[] args){
		Point pos1=new Point(1, 2);
		Point2 pos2=new Point2(5, 9);
		
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);
	}
}