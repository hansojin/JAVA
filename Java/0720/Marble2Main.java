class Marble2{
	int numOfMarble;
	String player;

	public Marble2(String player, int numOfMarble){
		this.player=player;
		this.numOfMarble = numOfMarble;
	}

	public void winGame(Marble2 player, int n){
		this.numOfMarble += player.loseGame(n);		
	}

	public int loseGame(int n){
		if(this.numOfMarble < n){
			int tmp = this.numOfMarble;
			this.numOfMarble = 0;
			return tmp;
		}
		
		this.numOfMarble-=n;
		return n;		
	}

	public void currentState(){
		System.out.println(player + " 구슬의 개수 : " + numOfMarble);
	}
}

class Marble2Main{
	public static void main(String[] args){
		Marble2 m1 = new Marble2("player1",15);
		Marble2 m2 = new Marble2("player2",9);

		System.out.println(" == 초기 상태 ==");
		m1.currentState();
		m2.currentState();

		m1.winGame(m2,2);
		System.out.println();
		System.out.println(" == 게임1 후 상태 ==");
		m1.currentState();
		m2.currentState();
	
		m2.winGame(m1,7);
		System.out.println();
		System.out.println(" == 게임2 후 상태 ==");
		m1.currentState();
		m2.currentState();
		
	}
}