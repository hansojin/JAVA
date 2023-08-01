class Marble{
	int numOfMarble;

	public Marble(int numOfMarble){
		this.numOfMarble = numOfMarble;
	}

	public void game(Marble m,int n){
		this.numOfMarble += n;		// impossible as, player can get marbles as much as the other player has
		m.loseGame(n);
	}

	public void loseGame(int n){
		this.numOfMarble-=n;		// need more code, if the amount of marble is less than it needed
	}

	public void currentState(){
		System.out.println("구슬의 개수 : " + numOfMarble);
	}
}

class MarbleMain{
	public static void main(String[] args){
		Marble m1 = new Marble(15);
		Marble m2 = new Marble(9);

		System.out.println("== 초기 상태 ==");
		m1.currentState();
		m2.currentState();

		m1.game(m2,2);
		System.out.println();
		System.out.println("== 게임1 후 상태 ==");
		m1.currentState();
		m2.currentState();
	
		m2.game(m1,7);
		System.out.println();
		System.out.println("== 게임2 후 상태 ==");
		m1.currentState();
		m2.currentState();
		
	}
}