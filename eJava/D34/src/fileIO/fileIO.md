1. I/O 모델의 핵심은 스트림을 이해하는데 있다. 본디 스트림이란 **데이터의 흐름** , 또는 **데이터의 흐름을 형성해 주는 통로** 를 의미한다.

2. 스트림을 크게 둘로 나누면?

* **입력 스트림(Input Stream)**		프로그램으로 데이터를 읽어 들이는 스트림
* **출력 스트림(Output Stream)** 	프로그램으로부터 데이터를 내보내는 스트림

3. (InputStream) 클래스는 바이트 단위로 데이터를 읽어 들이는 모든 입력 스트림이 상속하는 최상위 클래스이다(Object 클래스 다음으로).

4. 3번 클래스의 대표적인 메소드를 두개 꼽는다면?

>> public abstract int **read()** throws IOException

>> public void **close()** throws IOException

read 메소드는 1바이트의 데이터를 읽어서 반환하는 메소드이다. 그런데 이 메소드는 **abstract로 선언** 되어 있다. 

이유가 무엇이겠는가? 데이터를 읽어 들이는 기본 방식은 대상에 따라서 차이가 날 수 밖에 없다(read 메소드 내에서 해야 할 일들에 차이가 있음을 말하는 것이다). 

그래서 InputStream 클래스를 상속하는 하위 클래스에서 입력의 대상에 맞게 적절히 read 메소드를 정의하도록 하고 있다.

끝으로, 데이터를 읽어 들이는 과정이 끝났다면, **생성했던 스트림은 소멸** 해야 한다. 

그래야 가상머신이 할당했던 각종 리소스들이 메모리상에서 지워지기 때문이다. 그리고 바로 이러한 목적으로 정의된 메소드가 **close()** 이다.


5. read()는 1바이트의 데이터를 읽어서 반환하는 메소드이다.

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

* (InputStream)			<--->		(OutPutStream)
* (FileInputStream)		<--->		(FileOutputStream)

InputStream에 대응하는 클래스는 OutputStream이다. 

즉 OutputStream은 모든 출력 스트림이 상속하는 최상위 클래스이다. 그리고 FileOutputStream은 이를 상속하는 클래스이다.

8. OutputStream의 대표적인 메소드 둘을 꼽는다면?

>> public abstract void **write(int b)** throws IOException

>> public void **close()** throws IOException

9. 파일을 1바이트씩 복사하는 프로그램을 짜시오. 그리고 복사된 바이트를 출력하시오.

* __자동 자원 반환 try-with-resources문__

JDK1.7 부터 try-with-resources문이라는 try-catch문의 변형이 새로 추가되었다.

try-with-resources문의 괄호()안에 객체를 생성하는 문장을 넣으면, 이 객체는 따로 close()를 호출하지 않아도 **try 블럭을 벗어나는 순간 자동적으로 close()가 호출** 된다. 

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

13. **'필터 스트림'** 은 ~~그 자체로 파일과 같은 소스로부터 데이터를 읽는 기능~~은 지니고 있지 않다. 다만 입력 스트림으로부터 읽혀진 데이터를 다양하게 **가공하는 기능** 만 있을 뿐이다. 

이러한 필터 스트림도 다음과 같이 두 부류로 나뉜다.

* 필터 입력 스트림	-> 입력 스트림에 연결하는 필터 스트림
* 필터 출력 스트림	-> 출력 스트림에 연결하는 필터 스트림

14. int, double과 같은 기본 자료형 데이터를 읽고 쓰는 게 생각만큼 간단한 일은 아니다. 

하지만 필터 스트림인 **DataInputStream** 과 **DataOutputStream** 을 각각 입력 스트림과 출력 스트림에 연결하면, **기본 자료형 데이터의 입출력** 은 생각만큼 간단한 일이 되어 버린다.

15. 정수와 실수를 파일에 저장하고 다시 읽어들여 출력해보자.

```
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {

	public static void main(String[] args){
		try {
			OutputStream out = new FileOutputStream("data.bin");
			DataOutputStream filterOut=new DataOutputStream(out);
			filterOut.writeInt(275);
			filterOut.writeDouble(45.79);
			filterOut.close();	
			
			InputStream in=new FileInputStream("data.bin");
			DataInputStream filterIn=new DataInputStream(in);
			int num1=filterIn.readInt();
			double num2=filterIn.readDouble();
			filterIn.close();
			
			System.out.println(num1);
			System.out.println(num2);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

16. **필터 스트림** 은 다음 클래스를 상속한다.

* 필터 입력 스트림 클래스 - (FilterInputStream) 클래스를 상속한다.
* 필터 출력 스트림 클래스 - (FilterOutputStream) 클래스를 상속한다.

FilterInputStream 클래스와 FilterOutputStream 클래스도 각각 InputStream과 OutputStream을 상속하나, 최상위 클래스는 아니다.

17. **버퍼링 기능** 을 제공하는 필터 스트림

* BufferedInputStream		버퍼 필터 입력 스트림
* BufferedOutputStream		버퍼 필터 출력 스트림

18. 버퍼 필터 스트림을 이용하여 파일 복사하는 프로그램 작성. 복사된 바이트도 출력해보자.

```
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaIO18 {

	public static void main(String[] args) {
		String inFileName = "Grit.txt";
		String outFileName = "cpy.txt";
		int readByte = 0;
		int byteCnt = 0;
		try{
			FileInputStream in = new FileInputStream(inFileName);
			BufferedInputStream bIn = new BufferedInputStream(in);
			
			FileOutputStream out = new FileOutputStream(outFileName);
			BufferedOutputStream bOut = new BufferedOutputStream(out);
			
			while( (readByte=bIn.read()) != -1){
				bOut.write(readByte);
				byteCnt++;
			}
			
			bIn.close();
			bOut.close();
			System.out.println(byteCnt+ "byte의 파일 복사가 완료되었습니다.");
		}
		catch(FileNotFoundException e){
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
```

위 예제에서는 버퍼의 크기를 지정하지 않았기 때문에 디폴트 크기의 버퍼( **디폴트 크기는 2MB** 이다)가 만들어지지만, 다음의 생성자들을 이용하면 버퍼의 크기도 여러분이 원하는 대로 지정할 수 있다.

>> public BufferedInputStream(InputStream in, int size)

>> public BufferedOutputStream(OuputStream out, int size)

19. BufferedInputStream 데이터를 읽어 들이는 메소드 두개는?

>> public int read() throws IOException

>> public int read(byte[] b, int off, int len) throws IOException

20. 데이터의 중요도가 높거나, 버퍼가 꽉차지 않아도 출력 스트림을 통해서 파일에 저장해야 할 데이터가 존재한다면 다음의 메소드를 호출해야 한다.

>> public void **flush()** throws IOException

*cf. flush()는 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.*

21. 파일에 275와 45.79를 저장하는데, 버퍼링 기능도 추가하자. 그리고 다시 저장한 것을 읽어 들이자.

```
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaIO21 {
	public static void main(String[] args) {
		String fileName="fbdTest.txt";
		try{
			FileOutputStream out = new FileOutputStream(fileName);
			BufferedOutputStream bOut = new BufferedOutputStream(out);
			DataOutputtStream dataOut = new DataOutputStream(bOut);
			dataOut.writeInt(275);
			dataOut.writeDouble(45.79);
			dataOut.close();
			
			FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream bIn = new BufferedInputStream(in);
			DataInputStream dataIn = new DataInputStream(bIn);
			int intData = dataIn.readInt();
			double dblData = dataIn.readDouble();
			System.out.println(intData + " " + dblData);	
			dataIn.close();
		}
		catch(FileNotFoundException e){
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
```

22. 성능차이를 체크해보자. 처음에는 12.345를 중첩된 반복문 100000000 번씩을 통해 저장하고, 두번째로는 같은 동작을 하는데 버퍼링 필터 스트림이 추가된 상태로 체크해보자. 그래서 두 개의 성능차이를 비교해보자.

```
import java.io.*;

class DataBufferedFilterPerformance{
	public static void performanceTest(DataOutputStream dataOut) throws IOException{
		long startTime=System.currentTimeMillis();
		for(int i=0; i<10000; i++)
			for(int j=0; j<10000; j++)
				dataOut.writeDouble(12.345);
		
		dataOut.flush();
		long endTime=System.currentTimeMillis();	
		System.out.println("경과시간: "+ (endTime-startTime));	
	}
	
	public static void main(String[] args) throws IOException{
		OutputStream out1=new FileOutputStream("data1.bin");
		DataOutputStream dataOut=new DataOutputStream(out1);
		performanceTest(dataOut);
		dataOut.close();
		
		OutputStream out2=new FileOutputStream("data2.bin");
		BufferedOutputStream bufFilterOut = new BufferedOutputStream(out2, 1024*10);
		DataOutputStream dataBufOut=new DataOutputStream(bufFilterOut);
		performanceTest(dataBufOut);
		dataBufOut.close();
	}
}
```

**System.out의 이해와 I/O의 응용**

이번에는 System.out에 대해서 지금까지 몰랐던 내용을 소개하면서, 더불어 I/O의 이해도를 점검하기 위한 문제를 제시하고자 한다. 

다음 예제에서는 우리가 지금까지 활용해온 System.out을 대상으로 하는 각종 메소드의 호출방법을 보이고 있다.

```
class MyInfo{
	String info;
	public MyInfo(String info) { this.info = info; }
	public String toString() { return info; }
}

class PrintlnPrintf{
	public static void main(String[] args){
		MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
		System.out.println("제 소개를 하겠습니다.");
		System.out.println(mInfo);
		System.out.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
	}
}

// 실행결과
>> 제 소개를 하겠습니다.
>> 저는 자바 프로그래머입니다.
>> 나이 24, 몸무게 72kg입니다.
```

그런데 여기서 사용된 System.out은 System 클래스에 다음과 같이 선언되어 있다.

```
public static final PrintStrem out;
// 즉 System.out은 PrintStream의 인스턴스를 참조하고 있다. 그런데 PrintStream 클래스가 직간접적으로 상속하는 클래스 둘은 다음과 같다.

>> java.io.OutputStream;
>> java.io.FilterOutputStream		// 필터 스트림임을 의미함!
```

즉 PrintStream도 출력 스트림에 연결할 수 있는 필터 스트림이다. 따라서 System.out은 모니터를 의미하는 출력 스트림에 PrintStream의 필터 스트림이 연결된 형태로 볼 수 있다. 

그렇다면 이 필터 스트림은 어떠한 특징을 지니고 있는가? 이미 println, printf 메소드를 사용해 왔기 때문에 대략적인 특징은 알고 있겠지만, 이는 다음과 같이 정리할 수 있다.

 "다양한 형태의 데이터를 문자열의 형태로 출력하거나(println), 문자열의 형태로 조합하여 출력한다(printf)."
 
이는 정수가, 있는 그대로 출력되는 것이 아니라, 문자열의 형태로 변환이 되어서 출력되는 것이다. 원래 콘솔은 문자열만 출력이 가능하다. 따라서 정수나 실수를 출력하려면 문자열로 변환해야 하는데, 이러한 변환을 PrintStream이 대신해 줬던 것이다. 그럼 문제를 제시하겠다. 위 예제에서 보이는 출력결과가 파일 println.txt에 문자열의 형태로 저장되도록 예제를 변경해 보자. 그리고 문자열의 형태로 저장이 되었다면, 메모장(notepad)을 통해서 확인이 가능하니 반드시 확인하기 바란다.

```
class PrintWriterStream{
	public static void main(String[] args) throws IOException{
		PrintWriter out= new PrintWriter(new FileWriter("printf.txt"));
		
		out.printf("제 나이는 %d살 입니다.", 24);
		out.println("");
		
		out.println("저는 자바가 좋습니다.");
		out.print("특히 I/O 부분에서 많은 매력을 느낍니다.");
		out.close();
	}
}
```