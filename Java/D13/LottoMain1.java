import java.util.Arrays;
import java.util.Random;

// Lotto 자동생성기(1차원 배열) 5 set

class Lotto1{
	private int[] lotto;
	private Random random;
	private final int MAX = 6;
	
	Lotto1(){
		lotto = new int[MAX];
		random = new Random();	
	}

	public void execute(){
		makeLotto();
		sortLotto();
		printLotto();		
	}

	public boolean chkNum(int idx){
		for(int i=0;i<idx;i++){			
			if(lotto[idx]==lotto[i]){
				return false;
			}
		}
		return true;
	}

	public void makeLotto(){
		for(int i=0;i<lotto.length;i++){
			lotto[i] = random.nextInt(45)+1;
			if( !chkNum(i) ){
				i--;
			}
		}
	}

	public void sortLotto(){

		Arrays.sort(lotto);

		/*
		int tmp=0;
		for(int i=0;i<lotto.length-1;i++){
			for(int j=i+1;j<lotto.length;j++){
				if(lotto[i]>lotto[j]){
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		*/
	}

	public void printLotto(){

		System.out.println(Arrays.toString(lotto));

		/*
		for(int i : lotto)
			System.out.print(i + " ");
		*/
	}
}
	
class LottoMain1{
	public static void main(String[] args){	
		Lotto1 lotto = new Lotto1();
		for(int i=0;i<5;i++)
			lotto.execute();
	}
}