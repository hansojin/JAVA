package VectorTest2;

class Product {
	int price;			
	int bonusPoint;		

	Product() {}

	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
}

class Tv extends Product {
	Tv() {
		super(100);	
	}

	public String toString() { 
		return "Tv"; 
	}
}

class Computer extends Product {
	Computer() { 
		super(200); 
	}

	public String toString() { 
		return "Computer"; 
	}
}

class Audio extends Product {
	Audio() { 
		super(50); 
	}

	public String toString() { 
		return "Audio"; 
	}
}

public class Vector {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		b.summary();
	}

}
