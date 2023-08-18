package Generic;

class Orange{
	int sugarContent;

	public Orange(int sugarContent) {
		this.sugarContent=sugarContent;
	}
	public void showSugarContent(){
		System.out.println("Orange sugarContent: " + sugarContent);
	}
}

class Apple{
	int weight;

	public Apple(int weight) {
		this.weight = weight;
	}

	public void showAppleWeight(){
		System.out.println("Apple weight: " + weight);
	} 
}

class OrangeBox{
	Orange org;
	public void store(Orange org) {
		this.org=org;
	}
	public Orange pullOut() {
		return org;
	}
}

class AppleBox{
	Apple apl;
	public void store(Apple apl) {
		this.apl=apl;
	}
	public Apple pullOut() {
		return apl;
	}
}
public class FruitMain {
	public static void main(String[] args) {
		OrangeBox oBox = new OrangeBox();
		oBox.store(new Orange(10));
		Orange or = oBox.pullOut();
		or.showSugarContent();
		
		AppleBox aBox = new AppleBox();
		aBox.store(new Apple(200));
		Apple ap = aBox.pullOut();
		ap.showAppleWeight();
	}
}
