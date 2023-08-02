class MyPoint{
	int x,y;

	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int X, int Y){
		//return Math.sqrt(Math.pow((this.x-X),2)+Math.pow((this.y-Y),2));
		return Math.sqrt(Math.pow((x-X),2)+Math.pow((y-Y),2));
	}
	
}

class Q7{
	public static void main(String[] args){
		MyPoint p = new MyPoint(1,1);
		System.out.println(p.getDistance(2,2));
	}
}