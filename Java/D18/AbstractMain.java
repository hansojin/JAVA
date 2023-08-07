abstract class Animal {
	String name;
	Animal(String name) {
		this.name = name;
	}
	public abstract void cry();
	public abstract void behavior();
}

class Tiger extends Animal {
	public Tiger(String name) {
		super(name);
	}

	@Override
	public void cry() {
		System.out.println("어흥");
	}

	@Override
	public void behavior() {
		System.out.println("우측으로 빠르게 움직인다.");
	}

}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
	@Override
	public void cry() {
		System.out.println("멍멍");
	}
	@Override
	public void behavior() {
		System.out.println("왼쪽으로 느리게 달린다");
	}

}

public class AbstractMain{
	public static void main(String [] ar){
		Tiger tiger = new Tiger("Hodol");
		tiger.cry();
		tiger.behavior();
		System.out.println("사자의 이름은 : " + tiger.name);
		
		Dog dog = new Dog("Bingo");
		dog.cry();
		dog.behavior();
		System.out.println("개의 이름은 : " + dog.name);
	}
	
}