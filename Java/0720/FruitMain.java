class FruitSeller{

	int PRICE, numOfApples, money;

	public FruitSeller(int PRICE, int numOfApples, int money){		// 반환값 정의 X, 존재 X
		this.PRICE = PRICE;					// 상수는 메소드 내에서 초기화 할 수 없다. 생성자 내에서는 가능
		this.numOfApples = numOfApples;
		this.money = money;
	}

	public int sellApple(int money){
		this.money += money;
		int num = money / PRICE;
		this.numOfApples -= num;
		return num;
	}

	public void printCS(){
		System.out.println("사과가격 " + PRICE);
		System.out.println("사과개수 " + numOfApples);
		System.out.println("돈 " + money);	
	}
}

class FruitBuyer{

	int numOfApples, money;

	public FruitBuyer(int money){			//반환 자료형X, return X
		this.numOfApples = 0;
		this.money = money;
	}

	public void buyApple(FruitSeller seller, int money){
		this.money -= money;
		this.numOfApples += seller.sellApple(money);
	}

	public void printCS(){
		System.out.println("사과개수 " + numOfApples);
		System.out.println("돈 " + money);	
	}
}

class FruitMain{
	public static void main(String[] args){

		FruitSeller seller1 = new FruitSeller(2000, 50, 50000);
		FruitSeller seller2 = new FruitSeller(1000, 100, 100000);
		FruitBuyer buyer = new FruitBuyer(20000);
	
		seller1.printCS();
		seller2.printCS();
		buyer.printCS();

		System.out.println();
		buyer.buyApple(seller1, 6000);
		buyer.buyApple(seller2, 5000);
		
		seller1.printCS();
		seller2.printCS();
		buyer.printCS();
		
	}
}