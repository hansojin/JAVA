class InstCnt{
	static int instNum=0;
	
	public InstCnt(){
		instNum++;
		System.out.println("인스턴스 생성: "+instNum);
	}
}

class ClassVar{
	public static void main(String[] args){
		InstCnt cnt1=new InstCnt();	//인스턴스 생성:1
		InstCnt cnt2=new InstCnt();	//인스턴스 생성:2
		InstCnt cnt3=new InstCnt();	//인스턴스 생성:3
	}
}