import java.util.Arrays;
import java.util.Random;

class Lotto2{
	private int[] lotto;
	private int[] number;
	private Random rand;
	private final int MAX = 6;
	private final int RANGE = 45;

	Lotto2(){
		lotto = new int[MAX];
		number = new int[RANGE];
		rand = new Random();
		for(int i=0;i<number.length;i++)
			number[i]=i+1;
	}

	public void execute(){
		shuffle();
		sortLotto();
		printLotto();
	}

	public void shuffle(){
		for(int i=0;i<RANGE;i++){
			for(int j=0;j<5;j++){
				int k= rand.nextInt(45);
				int tmp=number[i];
				number[i]=number[k];
				number[k]=tmp;
			}
		}
		System.arraycopy(number,0,lotto,0,MAX);
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
		for(int i=0;i<5;i++){
			lotto.execute();
		}
	}
}