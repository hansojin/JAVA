package Num;

class IntWrapper{
	private int num;
	public IntWrapper(int data){
		num=data;
	}
	
	@Override
	public String toString(){
		return ""+num;
	}
	// if not,
	// Num.IntWrapper@372f7a8d 출력
	// packge.class@해시코드참조값
	}

class WrappingInteger{
	public static void showData(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args){
		IntWrapper intInst=new IntWrapper(3);
		showData(intInst);
		showData(new IntWrapper(7));		
	}
}
