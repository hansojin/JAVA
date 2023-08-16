package ExceptionEx;

public class ExceptionEx10 {

	public static void main(String[] args) throws Exception {
		throw new Exception();		// Exception을 고의로 발생시킨다.

	}

}

/* throws Exception을 달지 않으면 컴파일 오류가 발생.
  Checked Exception은 반드시 예외 처리를 해주어야 하지만, 
    예외 처리가 되어 있지 않기 때문임
 */