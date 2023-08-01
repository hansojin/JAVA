import java.util.Arrays;
import java.util.Random;

class Lotto1{
	private int[] lotto;
	private Random rand;
	private final int MAX = 6;

	Lotto1(){
		lotto = new int[MAX];
		rand = new Random();
	}

	public void execute(){
		makeLotto();
		sortLotto();
		printLotto();
	}

	public boolean checkNum(int idx){
		for(int i=0;i<idx;i++){
			if(lotto[idx]==lotto[i])
				return false;
		}
		return true;
	}

	public void makeLotto(){
		for(int i=0;i<lotto.length;i++){
			lotto[i]=rand.nextInt(45)+1;
			if( !checkNum(i))
				i-=1;
		}
	}

	public void sortLotto(){
		Arrays.sort(lotto);
	} 

	public void printLotto(){
		System.out.println(Arrays.toString(lotto));
	}
}

class LottoMain1{
	public static void main(String[] args){
		Lotto1 lotto = new Lotto1();
		for(int i=0;i<5;i++){
			lotto.execute();
		}
	}
}