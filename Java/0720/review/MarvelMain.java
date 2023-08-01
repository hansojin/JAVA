class Marvel{
	int marvels;
	String name;

	public Marvel(String name, int marvels){
		this.marvels=marvels;
		this.name = name;
	}
	
	public void winGame(Marvel player,int n){
		this.marvels+=player.loseGame(n);
	}

	public int loseGame(int n){
		if (this.marvels < n){
			int tmp=this.marvels;
			this.marvels = 0;
			return tmp;
		}
		this.marvels-=n;
		return n;
	}

	public void currentState(){
		System.out.println(name + " has " + marvels + " marvels");
	}
}

class MarvelMain{
	public static void main(String[] args){
		Marvel child1 = new Marvel("Child1", 15);
		Marvel child2 = new Marvel("Child2", 9);

		System.out.println("== current state ==");
		child1.currentState();
		child2.currentState();
		
		child1.winGame(child2,2);
		System.out.println();
		System.out.println("== current state ==");
		child1.currentState();
		child2.currentState();

		child2.winGame(child1,7);
		System.out.println();
		System.out.println("== current state ==");
		child1.currentState();
		child2.currentState();

	}
}