/*
InstanceOf.java를 instanceof 연산자를 사용하지 않는 형태로 변경하고자 한다. 
클래스의 상속관계를 그대로 유지하면서 동일한 실행결과를 보일 수 있어야 한다.
*/

class Box{
	public void simpleWrap(){
		System.out.println("simple wrap");
	}
	public void wrap(){
		simpleWrap();
	}
}

class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("paper wrap");
	}
	public void wrap(){
		paperWrap();
	}
}

class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("gold wrap");
	}
	public void wrap(){
		goldWrap();
	}
}

class InstanceOf2{
	public static void wrapBox(Box box){
		box.wrap();
	}
	
	public static void main(String[] args){
		Box box1=new Box();
		PaperBox box2=new PaperBox();
		GoldPaperBox box3=new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}
}