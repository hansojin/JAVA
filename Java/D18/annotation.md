```
class AAA{
	public void sayHello(){
		System.out.println("Hello");
	}
}

class BBB extends AAA{
	public void sayhello(){
		System.out.println("안녕");
	}	
}
```
상위 클래스(AAA)의 메소드 sayHello를 메소드 오버라이딩 했다고 생각할 수 있으나,

실질적으로는 sayhello()라는 새로운 메소드가 추가가 되었다.

```
class BBB extends AAA{
	@Override
	public void sayhello(){
		System.out.println("안녕");
	}
}
```
그래서 만약 @Override annotation을 단다면, 상위 클래스(AAA)에 sayhello가 없어서 에러 발생

```
class AAA{
	@Deprecated
	public void sayHello(){
		System.out.println("Hello");
	}
```
@Deprecated 태그는 클래스나 메소드 등을 더 이상 사용이 권장하지 않는 경우에 사용한다. 

사용이 권장되지 않는다는 것은 사용을 불가능하다는 것은 아니다. 

다만 권장을 하지 않고 차후에 없어질 수도 있다는 것을 의미한다.


javac -Xlint MainClass.java시,  warning에 대해서 볼 수 있다.
```
> MainClass.java:18: warning: [deprecation] sayHello() in AAA has been deprecated
>                 aaa.sayHello();
>                   ^
> 1 warning
```

```
class MainClass{
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		AAA aaa = new AAA();
		aaa.sayHello();
	}
}
```

@SuppressWarnings 어노테이션은 컴파일 경고를 사용하지 않도록 설정해주는 것으로 , 두 가지의 종류를 같이 사용할 때는 @SuppressWarnings({"unused", "unchecked"})처럼 객체 형식으로 묶어서 사용
