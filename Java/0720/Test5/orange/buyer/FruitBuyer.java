package orange.buyer;
import orange.seller.FruitSeller;	// as we use FruitSeller in code

public class FruitBuyer{		// 'public' keyword for main class to access 
	int myMoney;
	int numOfApple;
	
	public FruitBuyer(int money){
		myMoney=money;
		numOfApple=0;
	}
	
	public void buyApple(FruitSeller seller, int money){
		numOfApple+=seller.saleApple(money);
		myMoney-=money;
	}
	public void showBuyResult(){
		System.out.println("현재 잔액: " + myMoney);
		System.out.println("사과 개수: " + numOfApple);		
	}
}