import java.util.Arrays;
import java.util.Random;

class Lotto3{
	private int[][] lotto;
	private Random random;
	private final int MAX = 6;
	private int numOfLotto;
	
	Lotto3(int numOfLotto){
		this.numOfLotto = numOfLotto;
		lotto = new int[numOfLotto][MAX];
		random = new Random();
	} 

	public void execute(){
		makeLottos();
		sortLottos();
		printLottos();		
	}

	public void makeLottos(){
		for(int i=0;i<numOfLotto;i++){
			makeLotto(lotto[i]);
		}
	}

	public void sortLottos(){
		for(int i=0;i<numOfLotto;i++){
			sortLotto(lotto[i]);
		}
	}

	public void printLottos(){
		for(int i=0;i<numOfLotto;i++){
			printLotto(lotto[i]);
		}
	}
	
	public boolean chkNum(int idx, int[] lotto){
		for(int i=0;i<idx;i++){			
			if(lotto[idx]==lotto[i]){
				return false;
			}
		}
		return true;
	}

	public void makeLotto(int[] lotto){
		for(int i=0;i<lotto.length;i++){
			lotto[i] = random.nextInt(45)+1;
			if( !chkNum(i, lotto) ){
				i--;
			}
		}
	}

	public void sortLotto(int[] lotto){
		Arrays.sort(lotto);
	}

	public void printLotto(int[] lotto){
		System.out.println(Arrays.toString(lotto));
	}
}
	
class LottoMain3{
	public static void main(String[] args){	
		Lotto3 lotto = new Lotto3(5);
		lotto.execute();
	}
}