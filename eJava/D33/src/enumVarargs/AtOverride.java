package enumVarargs;

interface Viewable {
	public void showIt(String str);
	@Deprecated
	public void brShowIt(String str);
}

class Viewer implements Viewable {
	@Override
	public void showIt(String str) {
		System.out.println(str);

	}
	@Override
	public void brShowIt(String str) {
		System.out.println('[' + str + ']');
	}
};

class AtOverride {
	public static void main(String[] args) {
		Viewable view = new Viewer();
		view.showIt("Hello Annotations");
		view.brShowIt("Hello Annotations");
	}
}

/*
어노테이션 >> 자바 컴파일러에게 메시지를 전달하는 목적의 메모

어노테이션의 설명 범위
'어노테이션 타입(Annotation Types)' 세 가지는 다음과 같다.

@Override
@Deprecated		//컴파일러에게 이 메소드는 없어질거라는걸 알려주고 쓰지 말도록 경고하는 것
@SuppressWarnings	//컴파일 경고를 사용하지 않도록 설정해주는 것

@Override
"상위 클래스의 메소드 오버라이딩 또는 인터페이스에 선언된 추상 메소드의 구현입니다."
따라서 이에 어긋난 메소드 정의가 이뤄지면 컴파일 오류로 이어져서 우리로 하여금 잘못된 부분을 확인할 수 있게 해준다.

@Deprecated
문제의 발생 소지가 있거나 개선된 기능의 다른 것으로 대체되어서 더 이상 필요 없게 되었음을 뜻하는 단어가 Deprecated이다.
따라서 아직은 호환성 유지를 위해 존재하지만 이후에 사라질 수 있는 클래스 또는 메소드를 가리켜 Deprecated 되었다고 한다.
그리고 @Deprecated 선언을 통해서 우리가 작성한 코드의 일부에도 Deprecated 선언을 할 수 있다.

위의 컴파일 결과를 보면, 컴파일은 잘 되었으나 컴파일러는 다음 메시지를 전달한다.
Note: AtDeprecated.java uses or overrides a deprecated API.

이는 컴파일 된 코드에 deprecated 된 무언가를 사용했음을 알리는 메시지이다.
구체적으로 어느 부분에서 이러한 일이 발생했는지 확인하려면 위의 컴파일 결과에
나와 있듯이 다음과 같이 옵션을 추가하여 컴파일 하면 된다.(간단히 -Xlint만
추가해도 확인할 수 있다.)

C:\JavaStudy>javac -Xlint:deprecation AtDeprecated.java
 */