class Box{
	public void simpleWrap(){
		System.out.println("simple wrap");
	}
}

class PaperBox extends Box{
	public void paperWrap() {
		System.out.println("paper wrap");
	}
}

class GoldPaperBox extends PaperBox{
	public void goldWrap() {
		System.out.println("gold wrap");
	}
}

class BoxMain{
	public static void wrapBox(Box box){
		if(box instanceof GoldPaperBox)
			((GoldPaperBox)box).goldWrap();
		else if (box instanceof PaperBox)
			((PaperBox)box).paperWrap();
		else
			box.simpleWrap();
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