import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MyBaseBall2{
	private int[] game;
	private Random rand;
	private final int SIZE;
	private int ball, strike;
	Scanner sc = new Scanner(System.in);

	public MyBaseBall2(int SIZE){
		this.SIZE=SIZE;
		game= new int[SIZE];
		rand= new Random();
		ball = 0; 
		strike = 0;
	}

	public void execute(){
		makeNum();
		playGame();
	}
	
	public boolean checkNum(int idx){
		if (idx==0 && game[idx]==0)
			return false;

		for(int i=0;i<idx;i++){
			if (game[idx]==game[i])
				return false;
		}
		return true;
	}

	public void makeNum(){
		for(int i=0;i<game.length;i++){
			game[i]=rand.nextInt(10);
			if (!checkNum(i))
				i-=1;
		}
	}
	public int[] changeToArr(int num){
		String strNum = Integer.toString(num);
		int[] arrNum = new int[SIZE];
		for(int i=0;i<SIZE;i++)
			arrNum[i]=strNum.charAt(i)-'0';
		return arrNum;
	}
	
	public boolean printScore(int num){
		boolean result = false;
		int cnt=0, same=0;
		int[] tmp = changeToArr(num);
	
		for (int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				if (tmp[i]==game[j]){
					cnt+=1;
					if(i==j)
						same+=1;
				}
			}
		}

		if(same==SIZE){
			System.out.println("HOME RUN");
			result = true;
		}

		else if(cnt==0){
			System.out.println("OUT");
		}

		else {
			System.out.print((cnt-same)+ " Ball\t");
			System.out.print(same + " Strike");
			System.out.println();
		}	

		return result;
	}

	public void playGame(){
		int num;
		boolean score;

		while(true){
			System.out.print("Enter number : ");
			num = sc.nextInt();
			if(num>=Math.pow(10,SIZE) || num<Math.pow(10,(SIZE-1))){
				System.out.println("Invalid range.");
				continue;
			}

			score = printScore(num);
			if (score){
				break;	
			}
		}
	}


}

class MyBaseBallMain2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter level : ");
		int level = sc.nextInt();
		MyBaseBall2 game = new MyBaseBall2(level);
		game.execute();
	}
}