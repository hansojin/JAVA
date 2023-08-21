package ystd;

class Point3D{
	int x,y,z;
	Point3D(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	Point3D() {
		this(0,0,0);
	}
	public String toString() {
		return "[" + x +", "+ y +", "+ z +"]";
	}
	
	public boolean equals(Point3D p) {
		return p.x==x && p.y==y && p.z==z;
	}
}

public class Q1 {
	public static void main(String[] args) {
		Point3D one = new Point3D(1,2,3);
		Point3D two = new Point3D(1,2,3);
		System.out.println(one);
		System.out.println(two);
		
		System.out.println("one==two ? : " + (one==two));
		System.out.println("one.equals(two) ? : " + one.equals(two));
		
	}

	
}
