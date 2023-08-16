package ystd;

class Productt
{
	Productt(){}
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수
	Productt(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
}
class Tvv extends Productt {
	Tvv() {}
	public String toString() {
		return "Tvv";
	}
}
class Exercise7_5 {
	public static void main(String[] args) {
		Tvv t = new Tvv();
	}
}