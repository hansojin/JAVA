class Q6{
	static double getDistance(int x, int y, int X, int Y){
		return Math.sqrt(Math.pow((X-x),2)+Math.pow((Y-y),2));
	}
	
	public static void main(String[] args){
		System.out.println(getDistance(1,1,2,2));
	}
}