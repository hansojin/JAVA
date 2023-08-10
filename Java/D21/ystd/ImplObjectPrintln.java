class ClassPrinter {
	public static void print(Object obj){
		if (obj instanceof UpperClass)
			System.out.println(obj.toString().toUpperCase()); 
		else
			System.out.println(obj.toString()); 
	}
}
interface UpperClass{
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
class Point2 extends Point implements UpperClass{
	private int xPos,yPos;
	Point2(int xPos, int yPos){
		super(xPos,yPos);
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