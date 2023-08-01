class Q1{
	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		char c = 'A'; 	

		System.out.println(1 + x << 33);		// 6
		System.out.println(y >= 5 || x < 0 && x > 2);	// true
		System.out.println(y += 10 - x++);		//13
		System.out.println(x+=2);			//5
		System.out.println( !('A' <= c && c <='Z') );	//false
		System.out.println('C'-c);			//2
		System.out.println('5'-'0');			//5
		System.out.println(c+1);			//66
		System.out.println(++c);			//B
		System.out.println(c++);			//B
		System.out.println(c);			//C
	}
}

/*

 1 + 2 << 33  == 3 << 33
 int는 32비트이므로 33번 shift하지 않고, 1번만 shift함
 따라서 3*2 = 6

 true || false && false 
 &&의 우선순위가 || 보다 높기 때문에 true || false -> true

 단항 연산자 같은 경우 형변환이 일어나지 않음.
 이항 연산자는 (char + int) 계산으로, 연산이 안되니까 char가 integer로 바뀌어서 연산

*/