package ExceptionEx;

class ExceptionEx10 {
//	public static void main(String[] args) {
//		throw new Exception();		
//	}
	
//	F2 : Unhandled exception type Exception 오류
//  quick fix > add throws declaration
	
	public static void main(String[] args) throws Exception {
		throw new Exception();		// Exception을 고의로 발생시킨다.
	}
}