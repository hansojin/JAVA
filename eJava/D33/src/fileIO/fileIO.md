1. I/O 모델의 핵심은 스트림을 이해하는데 있다. 본디 스트림이란 **데이터의 흐름** , 또는 **데이터의 흐름을 형성해 주는 통로** 를 의미한다.

2. 스트림을 크게 둘로 나누면?

* **입력 스트림(Input Stream)**		프로그램으로 데이터를 읽어 들이는 스트림
* **출력 스트림(Output Stream)** 	프로그램으로부터 데이터를 내보내는 스트림

3. (InputStream) 클래스는 바이트 단위로 데이터를 읽어 들이는 모든 입력 스트림이 상속하는 최상위 클래스이다(Object 클래스 다음으로).

4. 3번 클래스의 대표적인 메소드를 두개 꼽는다면?

>> public abstract int read() throws IOException
>> public void close() throws IOException

read 메소드는 1바이트의 데이터를 읽어서 반환하는 메소드이다. 그런데 이 메소드는 **abstract로 선언** 되어 있다. 

이유가 무엇이겠는가? 데이터를 읽어 들이는 기본 방식은 대상에 따라서 차이가 날 수 밖에 없다(read 메소드 내에서 해야 할 일들에 차이가 있음을 말하는 것이다). 

즉 하드 디스크에 저장되어 있는 파일로부터 데이터를 읽어 들이는 방식과 그래픽카드와 같은 멀티미디어 장치로부터 데이터를 읽어 들이는 방식은 동일할 수 없다. 

그래서 InputStream 클래스를 상속하는 하위 클래스에서 입력의 대상에 맞게 적절히 read 메소드를 정의하도록 하고 있다.

참고로 read 메소드가 실제로 반환하는 데이터는 1바이트짜리 데이터인데, read 메소드의 반환형 그리고 이 값을 저장하는변수의 자료형이 int인 이유가 궁금할 것이다. 

이는 read 메소드의 다음과 같은 특징 때문이다. "더 이상 읽어 들일 데이터가 존재하지 않으면 -1을 반환한다."

byte 형으로 표현할 수 있는 데이터의 수는 2진수로 00000000부터 11111111까지 총 256개이다. 

그리고 이들은 모두 파일에 존재할 수 있는 유효한 데이터들이다. 

따라서 더 이상 읽어 들일 데이터가 존재하지 않는 상황에서 반환되는 -1을 표현할 수가 없다. 

그래서 반환형과 반환되는 값의 저장을 위한 변수를 int형으로 선언한 것이다. 그래야 파일에 존재할 수 있는 유효한 데이터들과는 별도로 -1을 표현할 수 있기 때문이다. 

참고로 -1을 int형으로 표현하면 다음과 같다.

11111111 11111111 11111111 11111111 

반면 -1이 아닌 1바이트짜리 유효한 데이터들을 int형으로 변환해서 반환했을 때의 값의 범위는 다음과 같다.

00000000 00000000 00000000 00000000 ~ 00000000 00000000 00000000 11111111 

끝으로, 데이터를 읽어 들이는 과정이 끝났다면, **생성했던 스트림은 소멸** 해야 한다. 

그래야 가상머신이 할당했던 각종 리소스들이 메모리상에서 지워지기 때문이다. 그리고 바로 이러한 목적으로 정의된 메소드가 **close** 이다.


5. (read) 메소드는 1바이트의 데이터를 읽어서 반환하는 메소드이다.

```
			InputStream
				|
	------------------------------------------------
	|			|			|
FileInputStream						...
(File에 맞춰서 read	 
메소드 구현!)		
```

6. **read 메소드는 더 이상 읽어 들일 데이터가 존재하지 않으면 -1을 반환**

7. 입력 스트림의 형성을 위해 정의된 클래스와 출력 스트림의 형성을 위해 정의된 클래스는 서로 쌍(pair)을 이룬다.

(InputStream)		<--->		(OutPutStream)
(FileInputStream)		<--->		(FileOutputStream)

InputStream에 대응하는 클래스는 OutputStream이다. 

즉 OutputStream은 모든 출력 스트림이 상속하는 최상위 클래스이다. 그리고 FileOutputStream은 이를 상속하는 클래스이다.

8. OutputStream의 대표적인 메소드 둘을 꼽는다면?

>> public abstract void write(int b) throws IOException
>> public void close() throws IOException

9. 파일을 1바이트씩 복사하는 프로그램을 짜시오. 그리고 복사된 바이트를 출력하시오.

```
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyTest {

	public static void main(String[] args) {
		int r = 0;
		int cnt = 0;
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream("Grit.txt");
			out = new FileOutputStream("GritCopy.txt");
			while((r=in.read()) != -1){
				cnt++;
				out.write(r);
			}
			System.out.println("복사된 byte는 " + cnt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
				if(out!=null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
```

* 자동 자원 반환 try-with-resources문

JDK1.7 부터 try-with-resources문이라는 try-catch문의 변형이 새로 추가되었다.

try-with-resources문의 괄호()안에 객체를 생성하는 문장을 넣으면, 이 객체는 따로 close()를 호출하지 않아도 try 블럭을 벗어나는 순간 자동적으로 close()가 호출된다. 

그 다음에 catch블럭 또는 finally 블럭이 수행된다.

```
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTestTryWithResources {

	public static void main(String[] args) {
		int r = 0;
		int cnt = 0;
		
		try(FileInputStream in = new FileInputStream("Grit.txt");
			FileOutputStream out = new FileOutputStream("GritCopy.txt")	) {

			while((r=in.read()) != -1){
				cnt++;
				out.write(r);
			}
			System.out.println("복사된 byte는 " + cnt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

10. 1KB 정도되는 byte 배열을 생성해서 1KB 단위의 복사를 진행해 보려고 한다. 그 때 필요한 InputStream의 메소드 아래와 같다. 

>> public int read(byte[] b) throws IOException

이 메소드의 인자로는 byte형 배열의 참조를 전달한다. 그러면 입력 스트림을 통해서 읽어 들여진 데이터들이 배열에 저장된다. 

그리고 위 메소드는 실제 읽어 들인 데이터의 크기를 반환한다. 더 이상 읽을 데이터가 존재하지 않으면 -1이 반환된다.

11. 1KB 단위의 복사를 진행하려면 OutputStream 클래스의 아래와 같은 메소드를 사용한다.

>> public void write(byte[] b, int off, int len) throws IOException

위 메소드는 매개변수 b로 전달된 배열을 대상으로 off의 인덱스 위치서부터 시작해서 len 바이트를 출력 스트림을 통해서 전송하는 메소드이다.

12. IKB 단위로 복사하는 파일 복사 프로그램을 완성하시오. 그리고 복사된 바이트를 출력하시오.

```
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest2 {

	public static void main(String[] args) {
		
		byte[] r = new byte[1024];
		int len = 0, total = 0;
		try {
			FileInputStream in = new FileInputStream("Grit.txt");
			FileOutputStream out = new FileOutputStream("GritCopy.txt");
			while( (len = in.read(r)) != -1){
				total += len;
				out.write(r, 0, len);
			}
			in.close();
			out.close();
			System.out.println(total + "바이트 배열 단위 파일 복사가 완료되었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```
```
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest2 {

	public static void main(String[] args) {
		
		byte[] r = new byte[1024];
		int len = 0, total = 0;
		try(FileInputStream in = new FileInputStream("Grit.txt");
			FileOutputStream out = new FileOutputStream("GritCopy.txt")) {
			while( (len = in.read(r)) != -1){
				total += len;
				out.write(r, 0, len);
			}
			System.out.println(total + "바이트 배열 단위 파일 복사가 완료되었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```