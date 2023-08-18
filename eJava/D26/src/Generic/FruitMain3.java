package Generic;

class Orange3{
	int sugarContent;

	public Orange3(int sugarContent) {
		this.sugarContent=sugarContent;
	}
	public void showSugarContent(){
		System.out.println("Orange sugarContent: " + sugarContent);
	}
}

class Apple3{
	int weight;

	public Apple3(int weight) {
		this.weight = weight;
	}

	public void showApple3Weight(){
		System.out.println("Apple weight: " + weight);
	} 
}


class FruitBox3<T>{
	T obj;
	public void store(T obj) {
		this.obj=obj;
	}
	public T pullOut() {
		return obj;
	}
}

public class FruitMain3 {
	public static void main(String[] args) {
		FruitBox3<Orange3> oBox = new FruitBox3<Orange3>();
		oBox.store(new Orange3(10));
		Orange3 org=oBox.pullOut();
		org.showSugarContent();
		
		FruitBox3<Apple3> aBox = new FruitBox3<Apple3>();
		aBox.store(new Apple3(200));
		Apple3 ap = aBox.pullOut();
		ap.showApple3Weight();
	}
}

