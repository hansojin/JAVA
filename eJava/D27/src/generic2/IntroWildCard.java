package generic2;

class Fruiit{
	public void showYou(){ 
		System.out.println("난 과일입니다.");
	}
}

class Cherry extends Fruiit{
	public void showYou(){
		super.showYou();
		System.out.println("난 붉은 과일입니다.");
	}	
}

class FruiitBox<T>{
	T item;
	public void store(T item) { 
		this.item=item; 
	}
	public T pullOut() {
		return item; 
	}
}

class IntroWildCard{
	public static void openAndShowFruiitBox(FruiitBox<? extends Fruiit> box)	{
		Fruiit fr=box.pullOut();
		fr.showYou();
	}
	public static void main(String[] args){
		FruiitBox<Fruiit> box1=new FruiitBox<Fruiit>();
		box1.store(new Fruiit());

		FruiitBox<Cherry> box2=new FruiitBox<Cherry>();
		box2.store(new Cherry());

		openAndShowFruiitBox(box1);
		openAndShowFruiitBox(box2);
	}
}