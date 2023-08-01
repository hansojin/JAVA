import orange.area.Circle;
// import orange.perimeter.Circle;	<- ambiguous error as, 동일한 클래스명 사용


public class CircleMain{
	public static void main(String[] args){
		orange.area.Circle c1 = new orange.area.Circle(5);
		System.out.println(c1.getArea());
		
		orange.perimeter.Circle c2 = new orange.perimeter.Circle(5);
		System.out.println(c2.getPerimeter());

	
		Circle c3 = new Circle(10);		// this is from orange.area.Circle;
		System.out.println(c3.getArea());
		/*
		
		just like declaring
		' import java.util.Scanner; ' at the top, and then use 
		' Scanner sc = new Scanner(System.in); ' 

		*/

	
	}
}