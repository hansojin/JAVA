public class MemoryOverflow{
	public static void main(String[] args) {
		byte num = 127;		// -128 ~ 127
//		num = (byte)(num + 1);		
//		System.out.println(num);	// -128
		num++;
		System.out.println(num);
	}
}

// NaN Not a Number
// Infinity	[수학] 무한대