## 바이트 스트림
 * OutputStream
 	* 하위 클래스
 		* FileOutputStream
 		* PrintStream
 		* BufferedOutputStream
 		* DataOutputStream
 	* 주요 메소드
 		* write(int b)
 			* 1byte 출력
 		* write(byte[] b)
 			* 배열 b의 모든 byte 출력
 		* write(byte[] b, int off, int len)
 			* b[off]부터 len개의 byte 출력
 		* flush()
 			* 출력 버퍼에 잔류하는 모든 byte 출력
 		* close()
 		
 * InputStream
 	* 하위 클래스
 		* FileInputStream
 		* BufferedInputStream
 		* DataInputStream		
 	*주요 메소드 
 		* read()
 			* 1byte를 읽은 후 읽은 byte 리턴(int)
 		* read(byte[] b)
 			* 읽은 byte를 주어진 배열 b에 저장후 읽은 byte 수를 리턴(int)
 		* close()
 		
## 문자 스트림
* Writer
	* 하위 클래스
		* FileWriter
		* BufferedWriter
		* PrintWriter
		* OutputStreamWriter	
	* 주요 메소드
		* write(int c)
			* 한 문자 출력
		* write(char[] cbuf)
			* 주어진 배열의 모든 문자 출력
		* write(char[] cbuf, int off, int len)
			* 배열에서 cbuf[off] 부터 len개까지 문자 출력
		* write(String str)
			* 주어진 문자열 출력
		* write(String str, int off, int len)
		* flush()
		* close()
	
* Reader
	* 하위 클래스
		* FileReader
		* BufferedReader
		* InputStreamReader		
	* 주요 메소드
		* read()
			* 문자 1개 읽고 리턴(int)
		* read(char[] cbuf)
			* 읽은 문자들을 주어진 배열에 저장하고, 읽은 문자 수를 리턴(int)
		* close()


---

| 보조 스트림 | 기능 |
| ------ | ----------- |
| InputStreamReader | 바이트 -> 문자 스트림으로 변환|
| BufferedXXX | 입출력 성능 향상|
| DataInputStream, DataOutputStream | 기본 타입 데이터 입출력|
| PrintStream, PrintWriter | 줄바꿈 처리 및 형식화된 문자열 출력|
| ObjectInputStream, ObjectOutputStream | 객체 입출력|




