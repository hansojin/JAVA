try 블럭과 finally 블럭에서 모두 예외가 발생하면, **try블럭의 예외는 무시** 된다

```
public class ExceptionTest{
	public static void main(String[] args) {
		try {
			throw new RuntimeException("try Exception");
		}finally {
			throw new RuntimeException("finally Exception");
		}
	}
}
```
