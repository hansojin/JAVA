class Triangle
{
	int width;
	int height;
	int area;

	public Triangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public void areaOfTriangle()
	{
		area = width * height / 2;
	}
	public void printCS()
	{
		System.out.println("밑변 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓이 : " + area);
	}
}
class TriangleMain
{
	public static void main(String[] args)
	{
		Triangle t1 = new Triangle(10, 5);

		t1.areaOfTriangle();
		t1.printCS();

	}
}