class CircleFinal{
	public static final double PI = 3.14;

	/*
	public static final 은 순서가 상관없다.
	static public final
	final public static
	*/

	public static double areaOfCircle(double radius){
		return PI * radius * radius;
	}
	public static double perimeterOfCircle(double radius){
		return 2 * PI * radius;
	}
}

class CircleFinalMain{
	public static void main(String[] args){
		System.out.println(CircleFinal.areaOfCircle(5));
		System.out.println(CircleFinal.perimeterOfCircle(5));
	}
}


/*

class Student
{
	private String name;
	private String major;
	public Student(String name, String major)
	{
		this.name = name;
		this.major = major;
	}
	public void printStudentInfo()
	{
		System.out.println(name + " " + major);
	}
}

이 경우 final 로 받으면, 한명밖에 입력 받을 수 없으니까
final 을 쓰지 않지! 이제 구분하면서 코드를 보도록 하자

*/