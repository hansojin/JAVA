package Generic;

class Fruit{}

class Orange2 extends Fruit{
	int sugarContent;

	public Orange2(int sugarContent) {
		this.sugarContent=sugarContent;
	}
	public void showSugarContent(){
		System.out.println("Orange sugarContent: " + sugarContent);
	}
}

class Apple2 extends Fruit{
	int weight;

	public Apple2(int weight) {
		this.weight = weight;
	}

	public void showApple2Weight(){
		System.out.println("Apple weight: " + weight);
	} 
}


class FruitBox{
	Fruit fr;
	public void store(Fruit fr) {
		this.fr=fr;
	}
	public Fruit pullOut() {
		return fr;
	}
}

public class FruitMain2 {
	public static void main(String[] args) {
		FruitBox oBox = new FruitBox();
		oBox.store(new Orange2(10));
		Orange2 or = (Orange2)oBox.pullOut();
		or.showSugarContent();
		
		FruitBox aBox = new FruitBox();
		aBox.store(new Apple2(200));
		Apple2 ap = (Apple2)aBox.pullOut();
		ap.showApple2Weight();
	}
}
