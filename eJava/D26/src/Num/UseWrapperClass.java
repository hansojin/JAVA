package Num;

class UseWrapperClass{
	public static void showData(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args){
		Integer intInst=Integer.valueOf(3);
		showData(intInst);
		showData(Integer.valueOf(7));		
	}
}