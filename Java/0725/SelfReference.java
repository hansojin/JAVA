class SimpleAdder{
	private int num;
	public SimpleAdder(){
		num=0;
	}
	
	public SimpleAdder add(int num){
		this.num+=num;
		return this;		// this = 자기 객체 자신 주소값
	}

	public void showResult(){
		System.out.println("add result: "+num);
	}
}

class SelfReference{
	public static void main(String[] args){
		SimpleAdder adder=new SimpleAdder();
		adder.add(1).add(3).add(5).showResult();	// add result : 9
	}
}


	/*

	해당 코드는 
	public void SimpleAdder add(int num){
		this.num+=num;
	}
	와 동일하지만, 위에는 "반환값"이 있기 때문에 자신의 "참조값을 리턴"시켜야 함


	해당 함수를 호출하고 끝내면 두 method에는 차이가 없음. 
	다만, return값을 가지고 다른 행위를 더 수행하고 싶다면, 자신의 참조값을 리턴시켜야함
	

	for example,
	Class Player {
		Player setName(String name){
		this.name = name;
		return this;
     		} 		//해당 함수로는 player.setName().getName(); 이 가능

		player void setName(String name){
		this.name = name;
     		}		//해당 함수로는 player.setName(); player.getName(); 만 가능	
	}


	같은 이유로, 
	adder.add(1).add(3).showResult().add(5).showResult(); 는 불가능
	-> ' . ' 앞에는 주소가 들어있어야하는데, showResult는 반환값이 없으니까

	만약 위와 같은 코드처럼 작성하고 싶다면, 

	public SimpleAdder showResult(){
		System.out.println("add result: "+num);
		return this;
	}

	로 코드를 수정하면 됌.	
	반환값이 SimpleAdder의 주소니까 void 대신 SimpleAdder 넣기

	
	*/