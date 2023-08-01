class InstanceArray{
	public static void main(String[] args){
		String[] strArr=new String[3];
		// strArr[0]="Java"; 	랑 해도 출력은 같게 나옴
		strArr[0]=new String("Java");
		strArr[1]=new String("Flex");
		strArr[2]=new String("Ruby");
		
		for(int i=0; i<strArr.length; i++)
			System.out.println(strArr[i]);		
	}
}



/*

String 객체는 대부분 primitive type으로 취급하므로, new 키워드를 사용할 필요가 없음
다만, 그냥 String 리터럴로 표현할 경우, String Constant Pool 영역(힙 영역에 포함됨)에 존재한 후 해당 영역 값을 가리키게 됨
new 키워드를 사용할 경우에는 heap 영역에 String 객체를 생성

예를 들어, 
String str = new String("cat");
str = str+str;
해당 코드는, str이 cat이라는 문자열을 참조하고, str+str 연산 진행으로 인해 catcat이 만들어지는 코드인데, 이때 새로운 String 객체를 생성해서 거기에 catcat을 삽입하고, 기존 str 객체는 새로운 str String 객체를 참조하는 코드다
이처럼 String 연산은 계속적으로 객체를 만들어내기 때문에 비효율적임

그래서, 반복적으로 객체가 생성되는 것을 어느정도(같은 값 일때만) 방지하기 위한 새로운 메모리 영역을 String Constant pool 이라고 해.

String s1 = "Cat";	//String 리터럴 방식
String s2 = "Cat";	//String 리터럴 방식
String s3 = new String("Cat");    //heap 영역에 할당
s1 == s2;    //true
s1 == s3;    //false
// String Constant pool에 의해 str1과 str2는 같은 인스턴스를 참조해
// Cat은 String Constant pool 메모리 영역에 한 부분만 차지하기 때문임

*/