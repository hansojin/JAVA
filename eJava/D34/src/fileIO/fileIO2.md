24. 자바는 (유니코드)를 기반으로 문자를 표현한다. 이렇듯 정해진 규칙을 기준으로 문자를 수(number)의 형태로 표현하는 것을 가리켜 '인코딩(encoding)'이라 한다. 예를 들어서 다음의 문장도 일종의 인코딩이다. 문자 A와 문자 B를 2바이트 유니코드 값으로 변환해서(인코딩 해서), 각각 ch1과 ch2에 저장하기 때문이다.
```
char ch1='A';
char ch2='B';
```
Windows는 문자의 종류에 따라서 다음과 같이 인코딩 한다.
* 영문과 특수문자 	1바이트 데이터로 인코딩
* 한글 		2바이트 데이터로 인코딩

Windows의 문자표현 방식을 기준으로 문자 A와 문자 B를 저장해 보자. 참고로 Windows에서는 문자 A를 1바이트 정수 65, 문자 B를 1바이트 정수 66으로 표현한다(인코딩 한다).
```
public static void main(String[] args) throws IOException{
	OutputStream out = new FileOutputStream("hyper.txt");
	out.write(65);
	out.write(66);
	out.close();
}
```
위의 코드에서는 파일의 출력 스트림에 정수 65와 66을 저장하고 있다. OutputStream의 write 메소드는 1바이트 단위로 데이터를 저장하므로, 1바이트 형태로 65와 66이 저장된다.(65와 66은 1바이트로 표현이 가능한 숫자이기 때문에 저장과정에서 상위 3바이트가 잘려나가도 문제가 없다).

25. 문자 스트림이 별도로 존재하는 이유 : 운영체제의 기본 인코딩 방식으로의 인코딩을 자동화하기 위해서

26. 문자 입력 스트림과 문자 출력 스트림의 최상위 클래스는 **Reader, Writer** 

27. 문자 단위 파일 입력 스트림과 출력 스트림은 **FileReader, FileWriter**


28. **Reader**의 대표적인 메소드는?

* public int read() throws IOException
* public abstract int read(char[] cbuf, int off, int len) throws IOException

첫 번째 메소드는 파일로부터 읽어 들인 **문자 하나를 반환**한다. 반면 두 번째 메소드는 **최대 len의 개수만큼 문자를 읽어 들여서, cbuf로 전달된 배열의 인덱스 위치 off에서부터 문자를 저장**한다. 그리고 실제로 읽어 들인 문자의 수를 반환한다. 물론 더 이상 **읽어 들일 문자가 존재하지 않는다면 두 메소드 모두 -1을 반환**한다. 

29. **Writer**의 대표적인 메소드는?

* public void write(int c) throws IOException
* public abstract void write(char[] cbuf, int off, int len) throws IOException

첫 번째 메소드는 **파일에 하나의 문자를 저장**한다. 자바 프로그램에서는 문자가 2바이트로 표현되므로, 인자로 전달된 4바이트 데이터 중에서(매개변수 형이 int이므로) 상위 2바이트는 무시가 된다. 그렇다고 파일에 2바이트가 저장된다고 판단하면 곤란하다. 그리고 두 번째 메소드는 **cbuf로 전달된 배열의 인덱스 위치 off에서부터 len개의 문자를(최대 len개가 아닌, 그냥 len개이다) 파일에 저장**한다.

30. hyper.txt라는 파일에 문자 'A'와 문자 'B'를 저장하자.
```
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class JavaIO24 {
	public static void main(String[] args) throws IOException{
		OutputStream out = new FileOutputStream("hyper.txt");
		out.write('A');
		out.write('B');
		out.close();
	}
}
```

위에 소스코드를 문자스트림을 이용하여 다시 짜면
```
import java.io.*;

class FileWriterStream{
	public static void main(String[] args) throws IOException	{
		char ch1='A';
		char ch2='B';
		
		Writer out=new FileWriter("hyper.txt");
		out.write(ch1);
		out.write(ch2);
		out.close();
	}
}
```

31. 30번에서 출력한 데이터를 읽어들여서 모니터에 출력해보자.
```
import java.io.*;

class FileReaderStream{
	public static void main(String[] args) throws IOException{
		char[] cbuf=new char[10];
		int readCnt;
		
		Reader in=new FileReader("hyper.txt");
		readCnt=in.read(cbuf, 0, cbuf.length);
		for(int i=0; i<readCnt; i++)
			System.out.println(cbuf[i]);
		
		in.close();
	}
}
```

32. 문자 스트림의 입출력 버퍼 필터 스트림은 **BufferedReader, BufferedWriter**

33. 버퍼 필터 스트림의 문자열 입출력 기능을 담당하는 클래스와 메소드는?
```
* 문자열의 입력
BufferedReader 클래스의 메소드
>> public String readLine() throws IOException

* 문자열의 출력
Writer 클래스의 메소드
>> public void write(String str) throws IOException
```
34. String.txt에 다가 다음 내용을 출력하시오.
```
/*
박지성 - 메시 멈추게 하는데 집중하겠다.
올 시즌은 나에게 있어 최고의 시즌이다.
팀이 승리하는 것을 돕기 위해 최선을다하겠다.
환상적인 결승전이 될 것이다.

기사 제보 및 보도자료
press@goodnews.co.kr
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test8 {
	public static void main(String[] args) {

		try(BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"))){
			out.write("박지성 - 메시 멈추게 하는데 집중하겠다.");
			out.newLine();
			out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
			out.newLine();
			out.write("팀이 승리하는 것을 돕기 위해 최선을다하겠다.");
			out.newLine();
			out.write("환상적인 결승전이 될 것이다.");
			out.newLine();
			out.newLine();
			out.write("기사 제보 및 보도자료");
			out.newLine();
			out.write("press@goodnews.co.kr");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```
35. 34번에서 만든 파일을 모니터에 출력해보자.
```
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaIO35 {
	public static void main(String[] args) {
		String fileName = "String.txt";
		String str = null;

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			
			while( (str = br.readLine()) != null){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```
36. **문자 필터 스트림 (PrintWriter)** 이 제공하는 기능

"다양한 형태의 데이터를 문자열의 형태로 출력하거나(println), 문자열의 형태로 조합하여 출력한다(printf)."

PrintStream 은 바이트 스트림이다. 그럼에도 불구하고 문자 단위로(문자열 단위로) 데이터를 출력한다.이러한 이유로 이후의 자바 버전에서는 PrintStream를 개선시커서 PrintWriter라는 클래스를 정의하였고, 이는 Writer 클래스를 상속하는 문자 필터 스트림으로 정의하였다.

* System.out이 PrintStream임을 기억하고, 이 이상으로 PrintStream을 활용하지 않는다.
* printf, println등 문자열 단위의 출력이 필요하다면 반드시 PrintWriter를 사용한다.

37. PrintWriter를 이용하여 다음 내용을 "printf.txt"에 출력하자

```
/*
제 나이는 %d살 입니다. 24
저는 자바가 좋습니다.
특히 I/O 부분에서 많은 매력을 느낍니다.
*/
import java.io.*;

class PrintWriterStream{
	public static void main(String[] args) {
		String fileName = "printf.txt";
		try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
			writer.printf("제 나이는 %d살입니다.", 24);
			writer.println();
			writer.println("저는 자바가 좋습니다.");
			writer.println("특히 I/O 부분에서 많은 매력을 느낍니다.");
		}
		catch(IOException e){
			e.printStackTrace();
		}				
		try(BufferedReader bReader = new BufferedReader(new FileReader(fileName))){
			String str = null;
			while( (str = bReader.readLine()) != null ){
				System.out.println(str);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
```

39. 인스턴스의 입출력에 사용되는 **ObjectInputStream** 클래스와 **ObjectOutputStream** 클래스는 사실상 바이트 스트림에 속한다. 그러나 일반적으로 이 둘은 '오브젝트 스트림'으로 구분 짓는 것이 보통이다. 무엇보다도 이 둘은 사용방법이 필터 스트림과 매우 흡사하다.그럼에도 불구하고 기술적으로 필터 스트림으로 분류하지 않는다. 필터 스트림이 상속하는 클래스를 상속하지 않기 때문이다.

40. 인스턴스의 저장을 위해서는 ObjectOutputStream 클래스에 정의되어 있는 다음 메소드를 호출하면 된다.

>> public final void **writeObject(Object obj)** throws IOException

41. 인스턴스의 복원을 위해서는 ObjectInputStream 클래스에 정의되어 있는 다음 메소드를 호출하면 된다.

>> public final Object **readObject()** throws IOException, ClassNotFoundException

42. 입출력의 대상이 되는 인스턴스의 클래스는 다음 인터페이스를 구현하거나, 다음 인터페이스를 구현하는 클래스를 상속해야 한다. 즉 직간접적으로 다음 인터페이스를 구현해야 한다.

>> java.io.Serializable

**인스턴스가 파일에 저장되는 과정**을 가리켜 **직렬화(serializable)** 라 하고, 파일로부터 인스턴스가 **복원되는 과정** 을 가리켜 **역직렬화(deserializable)** 라 하는데, Serializable 인터페이스는 "이 클래스의 인스턴스는 직렬화를 해도 괜찮습니다." 의 표시를 목적으로 사용된다. 때문에 추가로 정의해야 할 메소드도 존재하지 않는다. 

참고. 파일에 제한되지는 않는다. 직렬화, 역직렬화라는 단어는 파일에 제한적인 표현이 아니다. 파일이 아니더라도, 다양한 입출력 대상을 통해서 인스턴스의 이동이 이뤄지는 상황에서는 직렬화, 그리고 역직렬화가 발생한다고 표현한다.

43. 문제43 폴더에 있는 Circle 클래스를 이용하여 Circle 인스턴스 new Circle(1, 1, 2.4)와 Circle 인스턴스 new Circle(2, 2, 4.8)을 저장하고 "String implements Serializable" String 인스턴스를 파일로 저장하고, 다시 파일로 부터 읽어 들이자.

```
class Circle {
	int xPos;
	int yPos;
	double rad;
	
	public Circle(int x, int y, double r){
		xPos=x;
		yPos=y;
		rad=r;
	}
	public void showCircleInfo(){
		System.out.printf("[%d, %d] \n", xPos, yPos);
		System.out.println("rad: "+rad);
	}
}
```

인스턴스의 입출력은 리소스 소모가 많은 작업이다. 때문에 과도한 직렬화는 성능에 영향을 줄 수 있다. 하지만 빈번히, 연속적으로 입출력이 발생하는 상황이 아니라면, 그리고 시스템에 크게 영향을 주지 않는 상황이라면, 직렬화의 적절한 활용은 다양한 상황에서 프로그래머의 수고를 덜어주기도 한다.

```
import java.io.*;

class Circle implements Serializable{
	int xPos;
	int yPos;
	double rad;
	
	public Circle(int x, int y, double r){
		xPos=x;
		yPos=y;
		rad=r;
	}
	public void showCirlceInfo(){
		System.out.printf("[%d, %d] \n", xPos, yPos);
		System.out.println("rad: "+rad);
	}
}

class ObjectSerializable{
	public static void main(String[] args) 
					throws IOException, ClassNotFoundException{
		/* 인스턴스 저장 */
		ObjectOutputStream out= 
			new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));	
		out.writeObject(new String("String implements Serializable"));
		out.close();
		
		/* 인스턴스 복원 */
		ObjectInputStream in=
			new ObjectInputStream(new FileInputStream("Object.ser"));
		Circle cl1=(Circle)in.readObject();
		Circle cl2=(Circle)in.readObject();
		String message=(String)in.readObject();
		in.close();
		
		/* 복원된 정보 출력 */
		cl1.showCirlceInfo();
		cl2.showCirlceInfo();
		System.out.println(message);
	}
}
```

44. 43번의 Circle 클래스에 있는 인스턴스 변수 xPos와 yPos를 멤버변수로 하는 Point 클래스로 만들자. 그리고 다음 내용을 수행하자.

Circle 인스턴스 new Circle(1, 1, 2.4)와 Circle 인스턴스 new Circle(2, 2, 4.8)을 저장하고 "String implements Serializable" String 인스턴스를 파일로 저장하고, 다시 파일로 부터 읽어 들이자.

```
import java.io.*;

class Point implements Serializable{
	int x, y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class Circle implements Serializable{
	Point p;
	double rad;
	
	public Circle(int x, int y, double r){
		p=new Point(x, y);
		rad=r;
	}
	public void showCirlceInfo(){
		System.out.printf("[%d, %d] \n", p.x, p.y);
		System.out.println("rad: "+rad);
	}
}

class SerializableInstMember{
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException{
		/* 인스턴스 저장 */
		ObjectOutputStream out= 
			new ObjectOutputStream(new FileOutputStream("Object.ser"));
		
		out.writeObject(new Circle(1, 1, 2.4));
		out.writeObject(new Circle(2, 2, 4.8));	
		out.writeObject(new String("String implements Serializable"));
		out.close();
		
		/* 인스턴스 복원 */
		ObjectInputStream in=
			new ObjectInputStream(new FileInputStream("Object.ser"));
		Circle cl1=(Circle)in.readObject();
		Circle cl2=(Circle)in.readObject();
		String message=(String)in.readObject();
		in.close();
		
		/* 복원된 정보 출력 */
		cl1.showCirlceInfo();
		cl2.showCirlceInfo();
		System.out.println(message);
	}
}
```

"직렬화되는 인스턴스의 멤버 변수가 참조하는 인스턴스도 Serializable 인터페이스를 구현한다면, 이 역시도 함께 묶여서 직렬화된다."

```

	Serializable									Serializable

	--------------------------------			----------------
	|  Point p ---------------------|	------------->	| int x		|	
	|  double rad		|		| int y		|
	---------------------------------			-----------------
	
	Circle							Point



	Serializable			Serializable			Serializable
				
	----------------		----------------		----------------
	|  BBB b ------|------>	| CCC c	 ----|---->| int m3	|	
	|  int m1		 |			| int m2	 |		|			|
	-----------------		-----------------		-----------------
	
	AAA			BBB			CCC
```

45. 직렬화의 대상에서 제외시키겠다면, **transient** : Personalnfo 클래스의 String secretInfo와 int secretNum을 직렬화 대상에서 제외시키고 이것을 파일로 출력한 후 다시 입력받아 출력해보자.

```
import java.io.*;

class PersonalInfo implements Serializable{
	String name;
	transient String secretInfo;
	
	int age;
	transient int secretNum;

	public PersonalInfo(String name, String sInfo, int age, int sNum){
		this.name=name;
		secretInfo=sInfo;
		this.age=age;
		secretNum=sNum;
	}
	public void showCirlceInfo(){
		System.out.println("name: "+name);
		System.out.println("secret info: "+secretInfo);
		System.out.println("age: "+age);
		System.out.println("secret num: "+secretNum);
		System.out.println("");
	}
}

class TransientMembers{
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException{
		/* 인스턴스 저장 */
		ObjectOutputStream out= 
			new ObjectOutputStream(new FileOutputStream("Personal.ser"));
		
		PersonalInfo info=new PersonalInfo("John", "baby", 3, 42);
		info.showCirlceInfo();
		out.writeObject(info);
		out.close();
		
		/* 인스턴스 복원 */
		ObjectInputStream in=
			new ObjectInputStream(new FileInputStream("Personal.ser"));
		
		PersonalInfo recovInfo=(PersonalInfo)in.readObject();
		in.close();
		
		/* 복원된 정보 출력 */
		recovInfo.showCirlceInfo();
	}
}
```

46. transient로 선언된 변수는 **인스턴스 복원 시** 어떠한 값으로 초기화되는가?

**transient로 선언된 참조변수에는 null이, 그리고 int형 변수에는 0이 저장됨** 을 알수 있다. 그런데 이는 인스턴스 변수를 별도의 값으로 초기화하지 않을 경우에 자동으로 삽입되는 디폴트 값들이다. 이로써 transient로 선언된 변수들은 복원의 과정에서 별도의 초기화가 이뤄지지 않음을 확인하였다.

47. 다음과 같은 특징을 갖는 스트림 클래스는?  : **RandomAccessFile**

* 입력과 출력이 동시에 이뤄질 수 있다.
* 입출력 위치를 임의로 변경할 수 있다.
* 파일을 대상으로만 존재하는 스트림이다.

사실 스트림이라는 표현에는 **한쪽 방향으로만 형성되는 데이터의 흐름**이라는 의미가 담겨있다. 즉 스트림이라 부르기 위해서는 **데이터의 입력 및 출력이 순차적** 이어야 하고, **입력만 가능하거나 출력만 가능해야 한다.** 그래서 엄밀히 말하면 RandomAccessFile 클래스는 스트림 클래스가 아니다.

48. RandomAccessFile 클래스의 대표적인 입력 메소드는?

* public int read() throws IOException
* public int read(byte[] b, int off, int len) throws IOException
* public final int readInt() throws IOException
* public final double readDouble() throws IOException

49. RandomAccessFile 클래스의 대표적인 출력 메소드는?

* public void write(int b) throws IOException
* public void write(byte[] b, int off, int len) throws IOException
* public final void writeInt(int v) throws IOException
* public final void writeDouble(double v) throws IOException

50. RandomAccessFile 클래스의 **현재의 입출력 위치를 확인하거나 변경할 수 있는 메소드** 는?

* public long **getFilePointer()** throws IOException
* public void **seek(long pos)** throws IOException

위치 정보는 getFilePointer 메소드의 호출을 통해서 확인이 가능하다. 반면 seek 메소드의 호출을 통해서 입출력의 위치도 변경할 수도 있다.

51. RandomAccessFile 클래스의 생성자에 대해서 설명하시오.

>> public RandowmAccessFile(**String name, String mode**) throws FileNotFoundException

이 생성자의 첫 번째 인자를 통해서는 파일의 이름을전달한다. 그리고 두 번째 인자를 통해서는 파일의 용도 정보를 전달하는데, 전달할 수 있는 정보의 종류는 다음과 같다.

* **r** _ 읽기 위한 용도
* **rw** _ 읽고 쓰기 위한 용도

즉 두 번째 인자로 "r"을 전달하면 '읽기'만 가능하다. 때문에 생성자의 첫 번째 인자로 **전달한 이름의 파일이 존재하지 않으면 예외가 발생** 한다. 

반면 "rw"를 전달하면 '읽기'와 '쓰기'가 동시에 가능하다. 뿐만 아니라 **파일이 존재하지 않으면 새로운 이름의 파일을 생성** 하기도 한다.

52. 
```
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class JavaIO52 {
	public static void main(String[] args) {
		String fileName = "data.bin";
		RandomAccessFile rf = null;
		int rInt1 = 0, rInt2=0;
		double rDbl1 = 0, rDbl2 = 0;
		try{
			rf = new RandomAccessFile(fileName, "rw");
			System.out.println("Write..............");
			System.out.println("현재 포인터의 위치 " + rf.getFilePointer());
			rf.writeInt(200);
			rf.writeInt(500);
			System.out.println("현재 포인터의 위치 " + rf.getFilePointer());
			rf.writeDouble(48.65);
			rf.writeDouble(52.24);
			System.out.println("현재 포인터의 위치 " + rf.getFilePointer());
			System.out.println("Read..............");
			rf.seek(0);
			System.out.println("현재 포인터의 위치 " + rf.getFilePointer());
			rInt1 = rf.readInt();
			rInt2 = rf.readInt();
			System.out.println(rInt1 + " " + rInt2);
			System.out.println("현재 포인터의 위치 " + rf.getFilePointer());
			rDbl1 = rf.readDouble();
			rDbl2 = rf.readDouble();
			System.out.println(rDbl1 + " " + rDbl2);
			System.out.println("현재 포인터의 위치 " + rf.getFilePointer());
			rf.close();
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

53. [마지막에 저장된 데이터 Read!] 52번에서 생성한 파일의 마지막에는 8바이트 double형 데이터가 저장되어 있다. 파일을 열어서 이 부분의 데이터만 읽어서 출력하는 프로그램을 작성해 보자. 참고로 RandomAccessFile 클래스에 정의되어 있는 다음의 메소드를 활용하면 보다 쉽게 문제를 해결할 수 있다.
```
// public long length() throws IOException

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class JavaIO53 {
	public static void main(String[] args) {
		String fileName = "data.bin";
		try{
			RandomAccessFile rf = new RandomAccessFile(fileName, "r");
			rf.seek(rf.length()-8);
			double num1 = rf.readDouble();
			System.out.println(num1);
		}
		catch(FileNotFoundException e){
			System.out.println("파일이 없습니다.");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
```
