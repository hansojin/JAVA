package Generic;

class Orange22{
	int sugarContent;

	public Orange22(int sugarContent) {
		this.sugarContent=sugarContent;
	}
	public void showSugarContent(){
		System.out.println("Orange sugarContent: " + sugarContent);
	}
}

class Apple22{
	int weight;

	public Apple22(int weight) {
		this.weight = weight;
	}

	public void showApple22Weight(){
		System.out.println("Apple weight: " + weight);
	} 
}


class FruitBox2{
	Object obj;
	public void store(Object obj) {
		this.obj=obj;
	}
	public Object pullOut() {
		return obj;
	}
}

public class FruitMain22 {
	public static void main(String[] args) {
		FruitBox2 oBox = new FruitBox2();
		oBox.store(new Orange22(10));
		Orange22 or = (Orange22)oBox.pullOut();
		or.showSugarContent();
		
		FruitBox2 aBox = new FruitBox2();
		aBox.store(new Apple22(200));
		Apple22 ap = (Apple22)aBox.pullOut();
		ap.showApple22Weight();
	}
}
