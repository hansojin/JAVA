import java.util.Random;

class RandomTest{
	public static void main(String[] args){
		Random rand = new Random();
		int num = rand.nextInt(100);		// 0 -99
		System.out.println(num);
	}
}