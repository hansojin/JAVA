class BitShift{
	public static void main(String[] args){
		System.out.println(2<<1);	// 4
		System.out.println(2<<2);	// 8
		System.out.println(2<<3);	// 16
		// 넘어가는 비트는 버리고 비는 비트는 0으로 채움	

		System.out.println(8>>1);	// 4
		System.out.println(8>>2);	// 2
		System.out.println(8>>3);	// 1

		System.out.println(-8>>1);	// -4
		System.out.println(-8>>2);	// -2
		System.out.println(-8>>3);	// -1
		// 넘어가는 비트는 버리고 비는 비트는 음수는 1로 양수는 0으로 채움

		System.out.println(8>>>1);	// 4
		// 넘어가는 비트는 버리고 비는 비트는 0으로 채움
	}
}
