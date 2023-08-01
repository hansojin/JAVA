class OverloadingTest{
	public void add(int num){
		System.out.println(num + num);
	}
	public void add(int num1, int num2){
		System.out.println(num1 + num2);
	}
	public void add(double num1, double num2){
		System.out.println(num1 + num2);
	}		
}

class OverloadingTestMain{
	public static void main(String[] args){
		OverloadingTest ol = new OverloadingTest();
		ol.add(5);
		ol.add(5, 10);
		ol.add(1.1, 2.2);
		ol.add('A', 'B');	// 자동형변환이 일어남 (integer로)
	}
}

/*

메소드 명과 매개변수를 합친걸 '메소드 시그니쳐' 라고 함
ex. add(int num) 을 통채로 method signature 라고 함

method 이름이 같고, 매개변수의 갯수/자료형이 다른걸 "overloading" 이라고 함

근데 반환형만 다른걸 가지고는 구분할 수 없어.
자바 컴파일러가, 메소드 시그니쳐로 구분하는데, 반환형만 다른, 예를들어 
public int add(int num) 은 public void add(int num) 과 메소드 시그니쳐가 같아서 
자바 컴파일러가 구분할 수 없다!

*/