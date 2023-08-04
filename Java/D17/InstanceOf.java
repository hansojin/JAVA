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

// instanceof 연산자는 본래 인스턴스의 형이 맞는지 여부를 체크하는 키워드로,
// 맞으면 true 아니면 false를 반환한다.

class InstanceOf{
	public static void wrapBox(Box box){
		if (box instanceof GoldPaperBox)
			((GoldPaperBox)box).goldWrap();
		else if (box instanceof PaperBox)
			((PaperBox)box).paperWrap();
		else
			box.simpleWrap();
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



