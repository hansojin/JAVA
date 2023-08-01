public class MemoryUnderflow{
	public static void main(String[] args) {
		byte num = -128;
		num--;
		System.out.println(num);	// 127
//		num-=2;
//		System.out.println(num);	// 126
//		num-=3;
//		System.out.println(num);	// 125
	}
}
