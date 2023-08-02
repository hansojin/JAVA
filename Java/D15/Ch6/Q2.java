class SutdaCard{
	int num;
	boolean isKwang;

	SutdaCard(int num, boolean isKwang){
		this.num=num;
		this.isKwang = isKwang;
	}

	SutdaCard(){
		this(0,true);
	}

	public String info(){
		String ret ="";
		if (num>=1 && num<=10)	
			ret+= num;
		if (isKwang)
			ret+= "1K";
		return ret;
	}
}

class Q2{
	public static void main(String args[]) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		System.out.println(card1.info());
		System.out.println(card2.info());
	}
}