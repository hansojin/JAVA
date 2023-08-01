class Final{
	public static void main(String[] args){

		final int MAX = 10;			
		// final 은 초기화를 한번만 가능
		// if 변수가 all captialize -> 상수
		
		System.out.println("-> START");
		for (int i=0; i<MAX; i+=2){
			System.out.println(i+" : Hi");
		}
		System.out.println("-> END");
	}
}
