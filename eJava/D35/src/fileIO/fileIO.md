54. 파일 및 디렉터리 관련 연산을 위해서 자바는 **File** 클래스를 별도로 제공하고 있다.

* 디렉터리의 생성, 소멸
* 파일의 소멸
* 디렉터리 내에 존재하는 파일이름 출력

이렇듯 입출력이 아닌, 파일 및 디렉터리 관련 연산을 위해서 자바는 File이라는 이름의 클래스를 별도로 제공하고 있다. File 클래스는 데이터의 입출력 이외에, 파일 또는 디렉터리와 관련된 일의 처리를 위해 디자인 된 클래스이다.

"C 드라이브에 JavaDir이라는 이름의 디렉터리를 생성하고, C 드라이브에 저장되어 있는 파일 MyFile.dat를 이곳으로 옮기자!"

위의 상황을 연출하기 위해서는 '디렉터리의 생성'과 '파일의 이동'이 가능해야 한다. 이중에서 **디렉터리의 생성**에는 다음 두 메소드 중 하나를 사용하면 된다.

```
* public boolean mkdir()
* public boolean mkdirs()
```

그런데 위의 두 메소드를 호출하려면, 일단 File 인스턴스를 생성해야 한다. 즉 자바에서의 디렉터리 생성은 다음의 과정을 거쳐서 이뤄진다.

```
public static void main(String[] args){
	File myDir = new File("C:\\YourJava\\JavaDir");	// 디렉터리 위치 정보
	myDir.mkdir();	// 디렉터리 생성
	...
}
```

위 예제에서 보이듯이, File 인스턴스는 파일 또는 디렉터리 정보를 표현하는 용도로 사용된다. 그리고 파일의 실질적인 조작은 인스턴스 생성 이후에 호출되는 메소드를 통해서 이뤄진다. 

참고로 위 예제의 최종 목표는 JavaDir이라는 이름의 디렉터리 생성에 있다. 그런데 이 디렉터리는 C 드라이브에 존재하는 YourJava 디렉터리의 하위 디렉터리로 생성하려 하고  있다. 

만약에 C 드라이브에 YourJava라는 디렉터리가 존재하지 않으면, false를 return 한다. 하지만 mkdir 메소드를 대신해서 mkdirs 메소드를 호출하면 , C 드라이브에 YourJava라는 디렉터리까지 함께 생성된다. 

이제 mkdir과 mkdirs의 차이점이 이해되는가? 그럼 이번에는 **파일의 이동** 과 관련된 메소드를 소개하겠다.

>> public boolean renameTo(File dest)

사실 이 메소드는 파일의 **이름을 변경하는 메소드** 이다. 그런데 이 메소드는 파일을 이동시키는 용도로도 사용이 가능하다. 사용하는 방법은 다음과 같다.

```
public static void main(String[] args){
	File myFile = new File("C:\\MyJava\\my.bin");
	File reFile = new File("C:\\YourJava\\my.bin");
	myFile.renameTo(reFile);	// 파일의 이동
	...
}
```

위 코드에서는 두 개의 File 인스턴스를 생성하고 있다. 하나는 원본의 위치정보를 담고 있으며, 또 하나는 원본이 옮겨질 위치정보를 담고 있다. 

그리고 이어서 renameTo 메소드를 이용해서 myFile이 가리키는 파일이름을 reFile이 가리키는 파일이름으로 바꿔 놓았다. 

이는 사실 파일의 이름을 변경한 것인데, 여기서 말하는 파일이름에는 디렉터리의 경로정보가 포함되어 있다. 그리고 디렉터리의 경로정보 변경은 파일의 이동으로 이어진다.

55. 우선 문제를 풀기전에 직접 c에 MyJava라는 폴더와 그 안에 my.bin이라는 파일을 만들어 놓자. 밑에는 소스로 구현하자.
MyJava 폴더안에 my.bin 이라는 파일이 없으면 "원본 파일이 준비되어 있지 않습니다." 라고 출력한다.
c에 YourJava라는 폴더를 만든다. YourJava 안에 my.bin 파일을 복사해 넣는다. 그리고 파일이 복사에 성공하면 "파일 이동에 성공하였습니다." 실패하면 "파일 이동에 실패하였습니다." 라고 출력한다.

```
import java.io.File;

public class JavaIO55 {

	public static void main(String[] args) {
		File myFile=new File("C:\\MyJava\\my.bin");
		//  이동의 대상이 되는 파일정보를 File 인스턴스에 담고 있다.
		if(myFile.exists()==false){
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			return;
		}
		// exists 메소드는 해당 정보의 파일이 실제로 존재하는지 확인 할 때 호출하는 메소드.
		// 해당 파일이 실제로 존재하면 true를, 그렇지 않으면 false를 반환한다.

		File reDir=new File("C:\\YourJava");
		// 이동할 위치 정보를 File 인스턴스에 담고 있다. 여기서 중요한 사실은 디렉터리 정보만
		// 담았다는 것이다. 이렇듯 File 인스턴스에는 디렉터리 정보만 담는 것도 가능하다.
		if(reDir.mkdir())
			System.out.println("디렉토리 생성 성공");
		else
			System.out.println("디렉토리 생성 실패");
		// 이동할 위치에 해당하는 디렉토리를 생성하고 있다. 바로 이러한 목적으로 위에서 파일의
		// 이름정보를 제외한 디렉터리 정보만을 담은 것이다.
		File reFile=new File(reDir, "my.bin");
		// 이 문장에서는 정보의 추가 방법을 보이고 있다. 이렇듯 기존의 File 인스턴스를 대상으로
		// 디렉터리 이름이나 파일이름을 추가하여 새로운 File 인스턴스를 생성하는 것도 가능하다.
		// 이 문장에 의해서 reDir의 경로정보에 "my.bin"이라는 파일의 이름정보가 추가되어 새로운
		// File 인스턴스가 생성된다.
		if(myFile.renameTo(reFile))
			System.out.println("파일 이동 성공");
		else
			System.out.println("파일 이동 실패");
		// renameTo 메소드 호출을 통해서 파일의 위치를 이동시키고 있다.
	}
}
```

Windows 운영체제는 문자 '\'를 디렉터리 또는 파일이름의 구분자로 사용한다. 반면 Linux 운영체제는 문자 '/'를 구분자로 사용한다. 

때문에 앞서 작성한 예제는 Windows 기반에서만 제대로 동작한다. 그렇다면 어떻게 예제를 변경해야 **운영체제에 상관없이 실행** 이 가능할까? File 클래스에 선언된 다음 두 상수 중 하나를 활용하면 된다.

```
public static final String separator
public static fianl char separatorChar
```

static으로 선언된 이 두 상수에는 운영체제 별 구분자 정보가 문자열, 또는 문자의 형태로 저장되어 있다. 

즉 Windows 기반의 자바 환경에서는 이 두 상수에 Windows의 구분자 정보가 담겨있다. 반면 Linux 기반의 자바 환경에서는 이 두 멤버에 Linux의 구분자 정보가 담겨있다. 

때문에 이 값을 이용하면, 우리는 구분자에 신경을 쓰지 않아도 된다.

56. 위의 소스코드를 운영체제에 상관없이 실행될수 있도록 수정하자.

```
import java.io.File;

public class JavaIO56 {

	public static void main(String[] args) {
		File myFile=new File("C:" + File.separator + "MyJava" + File.separator + "my.bin");
		//  이동의 대상이 되는 파일정보를 File 인스턴스에 담고 있다.
		if(myFile.exists()==false){
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			return;
		}
		// exists 메소드는 해당 정보의 파일이 실제로 존재하는지 확인 할 때 호출하는 메소드.
		// 해당 파일이 실제로 존재하면 true를, 그렇지 않으면 false를 반환한다.

		File reDir=new File("C:" + File.separator + "YourJava");
		// 이동할 위치 정보를 File 인스턴스에 담고 있다. 여기서 중요한 사실은 디렉터리 정보만
		// 담았다는 것이다. 이렇듯 File 인스턴스에는 디렉터리 정보만 담는 것도 가능하다.
		if(reDir.mkdir())
			System.out.println("디렉토리 생성 성공");
		else
			System.out.println("디렉토리 생성 실패");
		// 이동할 위치에 해당하는 디렉토리를 생성하고 있다. 바로 이러한 목적으로 위에서 파일의
		// 이름정보를 제외한 디렉터리 정보만을 담은 것이다.
		File reFile=new File(reDir, "my.bin");
		// 이 문장에서는 정보의 추가 방법을 보이고 있다. 이렇듯 기존의 File 인스턴스를 대상으로
		// 디렉터리 이름이나 파일이름을 추가하여 새로운 File 인스턴스를 생성하는 것도 가능하다.
		// 이 문장에 의해서 reDir의 경로정보에 "my.bin"이라는 파일의 이름정보가 추가되어 새로운
		// File 인스턴스가 생성된다.
		if(myFile.renameTo(reFile))
			System.out.println("파일 이동 성공");
		else
			System.out.println("파일 이동 실패");
		// renameTo 메소드 호출을 통해서 파일의 위치를 이동시키고 있다.
	}
}
```

57. AAA 라는 폴더를 경로로 잡고 절대경로를 출력하자. AAA라는 폴더 밑에 BBB라는 폴더를 잡고 그것의 절대경로를 출력하자.

```
import java.io.File;

public class JavaIO57 {

	public static void main(String[] args) {
		File curDir=new File("AAA");
		System.out.println(curDir.getAbsolutePath());
		
		File subDir=new File("AAA"+File.separator+"BBB");
		System.out.println(subDir.getAbsolutePath());
	}
}
```

58. MyDir이라는 폴더를 경로로 잡고 그 경로에 있는 리스트를 출력하자.
파일이면 파일이라고 출력하고 디렉토리면 디렉토리라고 출력하도록 하자. 그리고 나서 다음 정보를 출력하자

```
/*
현재위치 절대경로
OS 이름
JAVA HOME
JAVA VERSION
*/
import java.io.File;

public class JavaIO58 {

	public static void main(String[] args) {
		File myDir=new File("c:\\JavaStudy");
		File[] list=myDir.listFiles();
		if(list == null){
			System.out.println("디렉토리가 존재하지 않음.");
			myDir.mkdir();
		}
		else{
			for(File file : list){
				System.out.print(file.getName());
				if(file.isDirectory())
					System.out.println("\t\tDIR");
				else
					System.out.println("\t\tFILE");
			}			
		}
		
		System.out.println("시스템 정보");
		String workingDir = System.getProperty("user.dir");
		System.out.println("현재위치 " + workingDir);
		String osName = System.getProperty("os.name");
		System.out.println("os " + osName);
		String javaHome = System.getProperty("java.home");
		System.out.println("JavaHome " + javaHome );
		String javaVersion = System.getProperty("java.version");
		System.out.println("javaVersion " + javaVersion);
	}
}
```

59. 현재 디렉터리와 상위 디렉터리의 정보 추출 (자바 api 참고)

프로그램이 실행중인 현재 디렉터리의 이름과 현재 디렉터리의 상위 디렉터리 이름을 출력하고, 각각의 디렉터리에 존재하는 모든 파일 또는 디렉터리의 이름을 출력하는 예제를 작성해 보려고 한다(파일인지 디렉터리인지에 대한 정보까지 출력).

* 현재 디렉터리의 절대경로를 얻는 방법 

	-> String workingDir = System.getProperty("user.dir");

현재 디렉터리의 이름은 시스템 정보에 해당이 된다. 그리고 시스템 정보를 얻기 위해서는 System.getProperty 메소드를 활용해야 한다. 이 메소드를 통해서 얻을 수 있는 정보들을 조금 정리해 보면 다음과 같다.

* os.name	운영체제의 이름
* java.home	자바가 설치된 경로정보
* user.dir	현재 디렉터리의 절대경로
* java.version	JRE(가상머신을 포함하는 자바의 실행환경)의 버전정보

왼편에 존재하는 것이 정보를 얻기 위한 Key이다. 따라서 Key를 문자열의 형태로 getProperty 메소드의 인자로 전달하면, Key에 해당하는 정보를 문자열의 형태로 얻을 수 있다.