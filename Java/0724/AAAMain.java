// Object Reference Test

class AAA{
	public void show(){
		System.out.println("나는 AAA야");
	}
}

class AAAMain{
	public static void main(String[] args){
		AAA aaa = new AAA();
		aaa.show();		
		(new AAA()).show();
	}
}

/*

메모리 맵을 그리면, aaa가 1000번지의 AAA 객체를 만들고,
이후 new AAA()가 2000번지에 AAA 객체를 만듦.

근데, aaa라는 참조변수로 해당 객체를 참조할 수 있지만, 
아래와 같은 경우에는 이제 더이상 접근할 수 없음.
객체를 한번 쓰고 버릴꺼면, 저렇게 접근해도 되지만, 여러번 접근할거라면, 
반드시 참조변수를 이용해서 접근해야함
new AAA().메소드명 으로 접근했다면 곧 가비지콜랙터가 해당 공간을 없앰

*/