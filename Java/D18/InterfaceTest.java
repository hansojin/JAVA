interface OpenCloseIf {
	public void open();
	public void close();
}
interface PaintIf {
	public void Red();
	public void Blue();
}

/*
 Interface 는 implements 로 상속받으며
 extends 상속과는 다르게 다중 상속이 가능

 순수 abstract 으로만 이루어진 경우에 interface로 변경가능
 예를들어 위 openCloseIf는 
 abstract class OpenClose{
	public abstract void open();
	public abstract void close();
 } 와 동일
*/

class Door implements OpenCloseIf , PaintIf {

	@Override
	public void open() {
		System.out.println("Door Open");
	}
	
	@Override
	public void close() {
		System.out.println("Door Close");
	}
	
	@Override
	public void Red() {
		System.out.println("Paint the door red");
	}

	@Override
	public void Blue() {
		System.out.println("Paint the door blue");
	}
}

class Bottle implements OpenCloseIf {
	@Override
	public void open() {
		System.out.println("Bottle Open");
	}

	@Override
	public void close() {
		System.out.println("Bottle Close");
	}
}

public class InterfaceTest {
	public static void main(String[] ar) {
		Door door = new Door();
		door.open();
		door.close();
		door.Red();
		door.Blue();

		Bottle bottle = new Bottle();
		bottle.open();
		bottle.close();
	}
}