class Friend{
	String myName;
	public Friend(String name){
		myName=name;
	}

	@Override
	public String toString(){
		return "나는 "+myName+"!";
	}
		
}

class StringToString{
	public static void main(String[] args){		
		Friend fnd1=new Friend("철수");
		Friend fnd2=new Friend("영희");
		
		System.out.println(fnd1);
		System.out.println(fnd2);
		System.out.println(fnd2.toString()); 	

		/*
		 참조변수를 println에 넣으면, toString() 메소드를 자동으로 호출함
		 참조변수 : 주소값을 담고 있는 변수 

		 만약, 객체에서 재정의(@override) 하지 않는다면, 
		 getClass().getName() + '@' + Integer.toHexString(hashCode())
		 형태의 'Friend@372f7a8d' 와 같은 '클래스명@해시코드값' 이 출력됌
		*/
		

	}
}