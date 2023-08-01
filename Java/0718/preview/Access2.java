class Access2{

	public void brand(){
		System.out.println("Mercedes-Benz");
	}

	public void color(){
		System.out.println("BLACK");
	}

	public void speed(int num){
		System.out.println(num);
	}

	public static void main(String[] args){
		
		Access2 myCar = new Access2();	// create 'myCar' object
		myCar.brand();
		myCar.color();
		myCar.speed(200);
		
	}
}