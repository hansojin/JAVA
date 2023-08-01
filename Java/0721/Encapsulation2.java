class SinivelCap{
	public void take(){
		System.out.println("콧물이 싹~ 납니다.");
	}
}

class SneezeCap{
	public void take() {
		System.out.println("재채기가 멎습니다.");
	}
}

class SnuffleCap{
	public void take() {
		System.out.println("코가 뻥 뚫립니다.");	
	}
}

class CONTAC600 {
	SinivelCap sin;
	SneezeCap sne;
	SnuffleCap snu;
	
	public CONTAC600(){
		sin=new SinivelCap();
		sne=new SneezeCap();
		snu=new SnuffleCap();
	}
	public void take(){
		sin.take();
		sne.take();
		snu.take();
	}
}

class ColdPatient{
	public void takeCONTAC600(CONTAC600 cap){
		cap.take();
	}
}

class Encapsulation2{
	public static void main(String args[]){
		ColdPatient sufferer = new ColdPatient();
		sufferer.takeCONTAC600(new CONTAC600());
	}
}