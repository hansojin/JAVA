/*
class SimpleMath{
	public static final double PI=3.1415;	
	public double add(double n1, double n2){ return n1+n2; }
	public double min(double n1, double n2){ return n1-n2; }
	public double mul(double n1, double n2){ return n1*n2; }
}
// as, instance 변수를 건들이는게 없으니까 static을 추가 할 수 있음
*/

class SimpleMath{
	public static final double PI=3.1415;	
	public static double add(double n1, double n2){ return n1+n2; }
	public static double min(double n1, double n2){ return n1-n2; }
	public static double mul(double n1, double n2){ return n1*n2; }
}

/*
class AreaMath{	
	public double calCircleArea(double rad){
		SimpleMath sm=new SimpleMath();
		double result=sm.mul(rad, rad);
		result=sm.mul(result, SimpleMath.PI);
		return result;
	}
	public double calRectangleArea(double width, double height){
		SimpleMath sm=new SimpleMath();
		return sm.mul(width, height);
	}
}
// class 변수니까, 객체 생성 없이, class 이름으로 호출 가능
// 아래 나머지도 다 마찬가지
*/

class AreaMath{	
	public static double calCircleArea(double rad){
		double result=SimpleMath.mul(rad, rad);
		result=SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public static double calRectangleArea(double width, double height){
		return SimpleMath.mul(width, height);
	}
}

/*
class PerimeterMath{	
	public double calCirclePeri(double rad){
		SimpleMath sm=new SimpleMath();
		double result=sm.mul(rad, 2);
		result=sm.mul(result, SimpleMath.PI);
		return result;
	}
	public double calRectanglePeri(double width, double height){
		SimpleMath sm=new SimpleMath();
		return sm.add(sm.mul(width, 2), sm.mul(height, 2));
	}
}
*/

class PerimeterMath{	
	public static double calCirclePeri(double rad){
		double result=SimpleMath.mul(rad, 2);
		result=SimpleMath.mul(result, SimpleMath.PI);
		return result;
	}
	public static double calRectanglePeri(double width, double height){
		return SimpleMath.add(SimpleMath.mul(width, 2), SimpleMath.mul(height, 2));
	}
}

/*
class HowMethod{
	public static void main(String[] args){
		AreaMath am=new AreaMath();
		PerimeterMath pm=new PerimeterMath();
		
		System.out.println("원의 넓이: "+am.calCircleArea(2.4));
		System.out.println("직사각형 둘레: "+pm.calRectanglePeri(2.0, 4.0));
	}
}
*/

class HowMethod{
	public static void main(String[] args){
		System.out.println("원의 넓이: "+AreaMath.calCircleArea(2.4));
		System.out.println("직사각형 둘레: "+PerimeterMath.calRectanglePeri(2.0, 4.0));
	}
}
