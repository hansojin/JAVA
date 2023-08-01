class FruitSeller{
	int price,apple,money;
	
	public void initSeller(int price, int apple, int money){
		this.price = price;
		this.apple = apple;
		this.money = money;		
	}
	public int sellApple(int money){
		this.money+=money;
		int num=money/price;
		this.apple-=num;
		return num;
	}
	public void currentState(){
		System.out.println(money +"원__  " + price + "원짜리 사과 : " + apple);
	} 
}

class FruitBuyer{
	int apple,money;

	public void initBuyer(int apple, int money){ 
		this.apple = apple;
		this.money = money;		
	}
	
	public void buyApple(FruitSeller seller, int money){
		this.money-=money;
		this.apple+=seller.sellApple(money);
	}

	public void currentState(){
		System.out.println(money+"원__  사과 : " + apple );
	} 

}

class FruitMain{
	public static void main(String[] args){
		FruitSeller s1 = new FruitSeller();
		FruitSeller s2 = new FruitSeller();
		FruitBuyer b1 = new FruitBuyer();

		s1.initSeller(2000,50,50000);
		s2.initSeller(1000,100,100000);
		b1.initBuyer(0,20000);

		System.out.println("== 초기 상태 ==");
		System.out.println("1번 과일장수 아저씨 : ");
		s1.currentState();
		System.out.println("2번 과일장수 아저씨 : ");
		s2.currentState();
		System.out.println("구매자 : ");
		b1.currentState();

		b1.buyApple(s1,6000);
		b1.buyApple(s2,5000);

		System.out.println();
		System.out.println("== 구매 후 ==");
		System.out.println("1번 과일장수 아저씨 : ");
		s1.currentState();
		System.out.println("2번 과일장수 아저씨 : ");
		s2.currentState();
		System.out.println("구매자 : ");
		b1.currentState();
	}
}