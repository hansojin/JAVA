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

class BoxMain2{
	public static void wrapBox(Box box){
		box.wrap();
	}
	public static void main(String[] args){
		Box b1 = new Box();
		PaperBox b2 = new PaperBox();
		GoldPaperBox b3 = new GoldPaperBox();

		wrapBox(b1);
		wrapBox(b2);
		wrapBox(b3);
	}
}