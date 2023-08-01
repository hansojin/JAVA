class Recur1{

	public static void reHi(int n){
		if(n==0) return;
		System.out.println(" Hi~");
		reHi(n-1);
		System.out.println(" Bye~");
		
	}
	public static void main(String[] args){
		
		System.out.println("== START ==");
		reHi(3);
		System.out.println("== END ==");

	}
}
