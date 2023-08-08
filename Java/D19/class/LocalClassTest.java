interface Readable {
	public void read();
}

class OuterClass{
	private String myName;
	
	OuterClass(String name){
		myName=name;
	}
	
	public Readable createLocalClassInst(){		
		class LocalClass implements Readable{
			public void read(){
				System.out.println("Outer inst name: "+myName);
			}
		}
		return new LocalClass();
	}
}

/* 

LOCAL CLASS _ method 안에 선언되는 class
LocalClass 는 createLocalClassInst()안에서만 인식 가능 (= 외부에서 사용 불가)
반환형을 Readable로 두면, interface를 이용해서 "해당 객체를 반환"함으로써 
객체 주소를 참조할수 있으니까, local class 접근 문제 해결
---
반환형을 LocalClass라고 생각할 수 도 있지만, public LocalClass로 둔다면 
외부인 main에서 LocalClass를 참조변수로 쓸수 없음. 지역calss니까.

고로, 외부에서 local class를 접근하기 위해서, interface를 이용하기로 하자!
Readable 이라는 interface를 만들고,  Local class가 readable을 구현하게 하는거야.
그럼 interface의 참조변수로, interface를 구현한 객체주소를 참조하는거야
그래서 반환형이 Readable이고, main 에서도 참조변수를 Readable로 쓸 수 있는거

*/

class LocalClassTest{	
	public static void main(String[] args){
		OuterClass out1=new OuterClass("First");
		Readable localInst1=out1.createLocalClassInst();
		localInst1.read();
		
		OuterClass out2=new OuterClass("Second");	
		Readable localInst2=out2.createLocalClassInst();
		localInst2.read();
	}
}

