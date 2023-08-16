package ExceptionEx;

public class ExceptionEx11 {
	public static void main(String[] args) {
		throw new RuntimeException();	
	}
}

/*
 이경우에는 Unchecked Exception인 java.lang.RuntimeException을 던지고 있기 때문에
 Unchecked Exception은 예외 처리를 강제하지 않으므로 컴파일러가 이를 감지하지 않아 빨간줄이 없음
*/