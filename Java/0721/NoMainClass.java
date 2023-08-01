class Employer{
	private int myMoney;
	
	public Employer(int money){
		myMoney=money;
	}

	public void payForWork(Employee emp, int money){
		if(myMoney<money)
			return;
		emp.earnMoney(money);
		myMoney-=money;
	}

	public void showMyMoney(){
		System.out.println(myMoney);
	}	
}

class Employee{
	private int myMoney;
	
	public Employee(int money){
		myMoney=money;
	}

	public void earnMoney(int money){
		myMoney+=money;
	}

	public void showMyMoney(){
		System.out.println(myMoney);
	}	
}

/*

두 class 내에 main method를 넣을 수 있지만,
관리상의 목적으로 보통은 main method를 따로 만든다...

*/