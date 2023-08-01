package orange.area;		//package must written on the top. 
				// also, can declare once.

public class Circle{
				// public class는 class명과 파일명이 동일해야 함 
				// public은 모든 접근을 허용하는 접근 제한자
	
				// 하나의 java 파일안에는 하나의 public class 만 존재 할 수 있음. 
				// as, public class 명과 파일명이 동일해야 하니까.
	
	double radius;
	public Circle(double radius){
		this.radius = radius;
	}
	public double getArea(){
		return 3.14*radius*radius;
	}
	
	
}

class Triangle{ 			// 일반 class는 괜찮지	
	
}