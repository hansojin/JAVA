class Marvel{
	int numOfMarvel;
	String name;

	public Marvel(String name,int numOfMarvel){
		this.name= name;
		this.numOfMarvel= numOfMarvel;
	}
	
	public void winGame(Marvel player,int n){
		this.numOfMarvel +=player.loseGame(n);
	}

	public int loseGame(int n){
		if (n>this.numOfMarvel){
			int tmp=this.numOfMarvel;
			this.numOfMarvel=0;
			return tmp;
		}
		this.numOfMarvel-=n;
		return n;
	}

	public void currentState(){
		System.out.println(name + " has " + numOfMarvel + " marvels.");
	}	
}

class MarvelMain{
	public static void main(String[] args){
		Marvel child1 = new Marvel("Child1", 15);
		Marvel child2 = new Marvel("Child2", 9);
		child1.currentState();
		child2.currentState();

		child1.winGame(child2,2);		
		child1.currentState();
		child2.currentState();

		child2.winGame(child1,7);		
		child1.currentState();
		child2.currentState();
	}
}