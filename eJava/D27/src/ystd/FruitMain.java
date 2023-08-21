package ystd;

class Orange{
	int sugarContent;

	public Orange(int sugarContent) {
		this.sugarContent = sugarContent;
	}

	public void showSugar() {
		System.out.println("Orange sugar-content : " + sugarContent);
	}
}

class Apple{
	int weight;

	public Apple(int weight) {
		this.weight = weight;
	}

	public void showWeight() {
		System.out.println("Apple weight : " + weight);
	}
}

/*
class OrangeBox{
	Orange org;
	public void store(Orange org) {
		this.org = org;
	}
	public Orange pullOut() {
		return org;
	}
}

class AppleBox{
	Apple ap;
	public void store(Apple ap) {
		this.ap = ap;
	}
	public Apple pullOut() {
		return ap;
	}
}
*/

/*
class FruitBox<T>{
	T obj;
	public void store(T obj) {
		this.obj = obj;
	}
	public T pullOut() {
		return obj;
	}
}

public class FruitMain {
	public static void main(String[] args) {
		FruitBox<Orange> ob = new FruitBox<Orange>();
		ob.store(new Orange(10));
		Orange org = ob.pullOut();
		org.showSugar();
		
		FruitBox<Apple> ab = new FruitBox<Apple>();
		ab.store(new Apple(200));
		Apple ap = ab.pullOut();
		ap.showWeight();
	}
}
*/

class FruitBox<T>{
	T obj;
	public FruitBox(T obj) {
		this.obj = obj;
	}
	
	public T pullOut() {
		return obj;
	}
}

public class FruitMain {
	public static void main(String[] args) {
		FruitBox<Orange> ob = new FruitBox<Orange>(new Orange(10));
		Orange org = ob.pullOut();
		org.showSugar();
		
		FruitBox<Apple> ab = new FruitBox<Apple>(new Apple(200));
		Apple ap = ab.pullOut();
		ap.showWeight();
	}
}