class NumberPrinter{	
	public static void showInt(int n){ 
		System.out.println(n); 
	}
	public static void showDouble(double n) { 
		System.out.println(n); 
	}
}

class ClassMethod {
	public static void main(String[] args){
		NumberPrinter.showInt(20);		//20
		
		NumberPrinter np=new NumberPrinter();
		np.showDouble(3.15);		//3.15
		// 근데 얘도 굳이 객체를 생성할 필요없이 그냥 class자체로 부를수 있지
	}
}