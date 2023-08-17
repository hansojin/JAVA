package langUtilCh9;

class Exercise9_1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3,true);
		SutdaCard c2 = new SutdaCard(3,true);
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c1.equals(c2):"+c1.equals(c2));
	}
}
class SutdaCard {
	int num;
	boolean isKwang;
	SutdaCard() {
		this(1, true);
	}
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public boolean equals(Object obj) {
		
//		1.
		SutdaCard card = (SutdaCard)obj;
		return this.num==card.num && this.isKwang==card.isKwang;

//		2.
//		if(obj instanceof SutdaCard) {
//			SutdaCard c = (SutdaCard)obj;
//			return num==c.num && isKwang==c.isKwang;
//		}
//		return false;
		
//		3.
//		if(obj instanceof SutdaCard card)
//			return num == card.num && isKwang == card.isKwang;
//		return false;

	}
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}
