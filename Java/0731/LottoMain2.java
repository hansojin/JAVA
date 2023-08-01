import java.util.Arrays;
import java.util.Random;

// 빈 배열에 1부터 45까지 순서대로 넣은 후, 섞기(shuffle)

class Lotto2{
	private int[] lotto;
	private int[] number;
	private Random random;
	private final int MAX = 6;
	private final int RANGE = 45;
	
	Lotto2(){
		number = new int[RANGE];
		lotto = new int[MAX];
		random = new Random();
		for(int i=0;i<number.length;i++)
			number[i] = i+1;	
	}

	public void execute(){
		shuffle();
		sortLotto();
		printLotto();		
	}

	public void shuffle(){
		for(int i=0;i<RANGE;i++){
			for(int j=0;j<5;j++){
				int k = random.nextInt(45);
				int temp = 0;
				temp = number[i];
				number[i] = number[k];
				number[k]= temp;
			}
		}

		System.arraycopy(number, 0, lotto, 0, MAX);

		/*
		for(int i=0;i<MAX;i++)
		{
			lotto[i] = number[i];
		}
		*/
	}	

	public void sortLotto(){
		Arrays.sort(lotto);
	}

	public void printLotto(){
		System.out.println(Arrays.toString(lotto));
	}
}
	
class LottoMain2{
	public static void main(String[] args){	
		Lotto2 lotto = new Lotto2();
		for(int i=0;i<5;i++)
			lotto.execute();
	}
}