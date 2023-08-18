package Generic;

class Orange4{
	int sugarContent;

	public Orange4(int sugarContent) {
		this.sugarContent=sugarContent;
	}
	public void showSugarContent(){
		System.out.println("Orange sugarContent: " + sugarContent);
	}
}

class Apple4{
	int weight;

	public Apple4(int weight) {
		this.weight = weight;
	}

	public void showApple4Weight(){
		System.out.println("Apple weight: " + weight);
	} 
}


class FruitBox4<T>{
	T obj;
	public FruitBox4(T obj){
		this.obj=obj;
	}
	public void store(T obj) {
		this.obj=obj;
	}
	public T pullOut() {
		return obj;
	}
}

public class FruitMain4 {
	public static void main(String[] args) {
		FruitBox4<Orange4> oBox=new FruitBox4<Orange4>(new Orange4(10));
		Orange4 org = oBox.pullOut();
		org.showSugarContent();
		
		FruitBox4<Apple4> aBox = new FruitBox4<Apple4>(new Apple4(200));
		Apple4 ap = aBox.pullOut();
		ap.showApple4Weight();
	}
}

