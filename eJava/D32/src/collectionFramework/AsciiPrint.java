package collectionFramework;

class AsciiPrint{
	public static void main(String[] args) {
		char ch = ' ';
		for(int i=0; i < 95; i++)  // 공백(' ')이후의 문자들을 출력한다.
			System.out.print(ch++);
	}
}


// [참고] 출력된 실행결과의 첫 번째 문자는 공백문자이다.
