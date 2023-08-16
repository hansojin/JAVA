## 정규식(Regular Expression) - java.util.regex  패키지
  
정규식이란 텍스트 데이터 중에서 원하는 조건(패턴, pettern)과 일치하는 문자열을 찾아내기 위해 사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한 문자열을 말한다. 
  
원래 Unix에서 사용하던 것이고 Perl의 강력한 기능이었는데 요즘은 Java를 비롯해 다양한 언어에서 지원하고 있다.
  
정규식을 정의하고 데이터를 비교하는 과정을 단계별로 설명하면 다음과 같다.
  
1.정규식을 매개변수로 Pettern 클래스의 static 메서드인 Pattern compile(String regex)을 호출하여 Pattern인스턴스를 얻는다.

> Pattern p = Pattern.compile("c[a-z]");

2.정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher(CharSequence input) 를 호출해서 Matcher인스턴스를 얻는다.

>  Matcher m = p.matcher(data[i]);

3.Matcher인스턴스에 boolean matchers()를 호출해서 정규식에 부합하는지 확인한다.
  
>  if(m.matcher())
  
  *[참고] CharSequence는 인터페이스로, 이를 구현한 클래스는 CharBuffer, String, StringBuffer가 있다.*

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a", "aa","aaa","abc", "A"};		
		Pattern p = Pattern.compile("a");	 //a 한 글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");		//a,
		}
	}

}
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a", "aa","aaa","abc", "A"};		
		Pattern p = Pattern.compile("aa");		 //aa 두 글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 //aa,
		}
	}

}
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a", "aa","aaa","abc", "A"};		
		Pattern p = Pattern.compile("aaa");		 //aaa 세 글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 //aaa,
		}
	}
}
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a", "aa","aaa","abc", "A"};		
		Pattern p = Pattern.compile("abc");			 //abc 세 글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 //abc,
		}
	}
}
```
**.** (온점) :  임의의 한 문자를 나타낸다.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "cde"};		
		Pattern p = Pattern.compile(".");		// .(온점)= 임의의 한 문자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,b,c,d,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "cde"};		
		Pattern p = Pattern.compile("..");			// 임의의 두 글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	//aa,ab,ac,bc,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "cde"};		
		Pattern p = Pattern.compile("...");			// 임의의 세 글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// abc,bcd,cde,
		}
	}
}
```

**| or 연산 **

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "cde"};		
		Pattern p = Pattern.compile("a|b");			

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,b,
		}
	}
}
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "cde"};		
		Pattern p = Pattern.compile("a|b|c");			
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,b,c,
		}
	}
}
```


  **[] **
  
  문자 집합 메타 문자.
  
  문자 집합 내에 포함된 문자는 **OR** 로 작동
  
  한 개의 문자를 의미한다.[abc]라면 a 또는 b 또는 c 중의 하나라는 뜻
  
  **문자의 범위** 를 나타낸다.
  
  문자 사이에 **-(하이픈) 기호** 가 있다면 다음 뜻으로 쓰인다.
  
  [a-z] 이면 a부터 z까지이고 만약에[^] 이런 식으로 **^기호** 가 들어가면 **not 연산** 을 의미한다.
 

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "bcde", "cd", "cde", "cdef"};		
		Pattern p = Pattern.compile("[a]");			

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "bcde", "cd", "cde", "cdef"};		
		Pattern p = Pattern.compile("[abc]");		// a, b, c 중에 한문자	

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,b,c,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "bc", "bcd", "bcde", "cd", "cde", "cdef"};		
		Pattern p = Pattern.compile("a[abc]");	
		//	 a로 시작하고 abc중에 한 글자로 끝나는 두글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// aa,ab,ac,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","abcd", "acb", "acc", "bc", "bcd", "bcde", "cd", "cde", "cdef"};		
		Pattern p = Pattern.compile("a[abc][abc]");	
		//	 a로 시작하고 abc중에 한 글자, abc중에 한글자. 총 3글자 문자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// abc,acb,acc,
		}
	}
}
```


** * ** : 없거나 한 개 이상을 의미한다.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","aaa", "aaaa", "acc", "bc", "bcd", "bcde", "cd", "cde", "cdef"};		
		Pattern p = Pattern.compile("a*");		// a로 시작하고 a가 없거나 한 개 이상

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,aa,aaa,aaaa,
		}
	}
}
```



** + ** : 한 개 이상을 의미한다.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a","b","c","d","aa","ab","ac","abc","aaa", "aaaa", "acc", "bc", "bcd", "bcde", "cd", "cde" , "cdef"};		
		Pattern p = Pattern.compile("a+");	//	 a로 시작하고 a가 한 개 이상을 의미한다.

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// a,aa,aaa,aaaa,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a", "b", "ab", "ba", "abc", "bac", "baa", "bbc", "baaa", "baaaa", "bbc", "bbca"};		
		Pattern p = Pattern.compile("ba*");	//	 b로 시작하고 a가 없거나 한 개 이상

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 //b,ba,baa,baaa,baaaa,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"a", "b", "ab", "ba", "abc", "bac", "baa", "bbc", "baaa", "baaaa", "bbc", "bbca"};		
		Pattern p = Pattern.compile("ba+");		// b로 시작하고 a가 한 개 이상

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 // ba,baa,baaa,baaaa,
		}
	}
}
```

범위 지정 메타 문자 마이너스(-)! 

왼쪽 문자를 시작으로 오른쪽 문자까지 순차적으로 문자를 증가! 

[A-Z] 는 [ABCDEGHIJKLMNOPQRSTUVWXYZ] 과 동일! 

문자 집합 내에서만 사용 가능 


```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "a", "b", "c", "0", "1", "2", "ab", "01"};		
		Pattern p = Pattern.compile("[A-Z]");		// A-Z 사이 한글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// A,B,C,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", "1", "2", "ab", "01"};		
		Pattern p = Pattern.compile("[A-Z][A-Z]");	//	 A-Z 사이 한글자 A-Z 사이 한글자 총 두글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// AB,BD,
		}
	}
}
```

[A-Za-z] 범위는 하나의 패턴으로 취급

모든 대문자 알파벳, 모든 소문자 알파벳을 의미.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", "1", "2", "ab", "01"};		
		Pattern p = Pattern.compile("[A-Za-z]");	//	 A-Za-z 사이 한글자

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	//	 A,B,C,a,b,c,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", "1", "2", "ab", "01"};		
		Pattern p = Pattern.compile("[A-Za-z][A-Za-z]");		// A-Za-z 사이 한글자 A-Za-z 사이 한글자 총 두글자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// AB,Bc,BD,ab,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", "1", "2", "ab", "01"};		
		Pattern p = Pattern.compile("[0-9]");	//	 0-9 사이 한글자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// 0,1,2,
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23"};		
		Pattern p = Pattern.compile("[0-9][0-9]");		// 0-9 사이 한글자 0-9 사이 한글자 총 두글자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// 01,23,
		}
	}
}
```

**\d** 	:	digit의 약자로 한 개의 숫자를 의미한다.

[0-9]_0에서 9까지 숫자 중의 하나 의 의미와 동일하다.


```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23"};		
		Pattern p = Pattern.compile("\\d");		// 0-9 사이 한글자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// 0,1,2,
		}
	}
}
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23", "012"};		
		Pattern p = Pattern.compile("\\d*");		 0-9 사이 없거나 한 개 이상
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// 0,1,2,01,23,012,
		}
	}
}
```

**\s** :	공백 문자를 의미한다.


```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"ABC", "A C", "123", "A1B"};		
		Pattern p = Pattern.compile("[A-Z]\\s[A-Z]");		// A-Z한자 공백문자 A-Z 한자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	//  A C,
		}
	}
}
```
**\w** :		한 개의 알파벳, 언더바(_), 숫자를 의미한다.

[a-zA-Z_0-9]와 같은 뜻이다.

이처럼 \ 기호가 붙으면 키워드(확장문자)처럼 쓰인다.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23", "012"};		
		Pattern p = Pattern.compile("\\w");		// [a-zA-Z_0-9]
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 //A,B,C,a,b,c,0,1,2,
		}
	}
}
```
**{N}** :		N개를 의미한다.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23", "012", "ABC", "A0E"};		
		Pattern p = Pattern.compile("\\w{2}");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 //AB,Bc,BD,ab,01,23,
		}
	}
}
```
**{n,}** :		n개 이상을 의미한다.


```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23", "012", "ABC", "A0E"};		
		Pattern p = Pattern.compile("\\w{2,}");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 
				// AB,Bc,BD,ab,01,23,012,ABC,A0E,
		}
	}
}
```
**{n, m}** :  n개부터 m개까지

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"A","B","C", "AB", "Bc", "BD", "a", "b", "c", "0", 
				"1", "2", "ab", "01", "23", "012", "ABC", "A0E"
				,"A1B", "ABcD", "a2G0", "abcDE", "12ASD"};		
		Pattern p = Pattern.compile("\\w{2,4}");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	 
				// AB,Bc,BD,ab,01,23,012,ABC,A0E,A1B,ABcD,a2G0,
		}
	}
}
```

 ** ?** :	없음 또는 한 개

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"abc", "abb", "abbb", "ab","a", "abbbb","abcd"};		
		Pattern p = Pattern.compile("ab?");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// ab,a,
		}
	}
}
```

  **() **	: 그룹핑. 소괄호 안의 문자를 하나로 인식.

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"abc", "abbc", "abbbc", "abac","aabc", "babc","abcd"};		
		Pattern p = Pattern.compile("\\w(abc)");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// aabc,babc,
		}
	}
}

```
  
** ^ ** : 문자열의 시작

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"http:www.naver.com", "hellohttp:www.daum.net", "goodhttp"};		
		Pattern p = Pattern.compile("^http.");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	
				 // http:www.naver.com,
		}
	}
}
```

**$** :  문자열의 종료지점

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"http:www.naver.com", "hellohttp:www.daum.net", "goodhttp"};		
		Pattern p = Pattern.compile(".http$");		 
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");	// goodhttp,
		}
	}
}
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"123","012", "3GT", "안녕", "Hello"};		
		Pattern p = Pattern.compile("^[0-9]+$");		 숫자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i] + " 숫자입니다.");	
			else
				System.out.println(data[i] + " 숫자가 아닙니다.");    
		}
	}
}
```

  실행 결과
```
> 123 숫자입니다.
> 012 숫자입니다.
> 3GT 숫자가 아닙니다.
> 안녕 숫자가 아닙니다.
> Hello 숫자가 아닙니다.
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"123","012", "3GT", "안녕", "Hello"};		
		Pattern p = Pattern.compile("^[a-zA-Z]+$");		 영문자
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i] + " 영문자입니다.");	
			else
				System.out.println(data[i] + " 영문자가 아닙니다.");    
		}
	}
}
```
  실행 결과
```
> 123 영문자가 아닙니다.
> 012 영문자가 아닙니다.
> 3GT 영문자가 아닙니다.
> 안녕 영문자가 아닙니다.
> Hello 영문자입니다.
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"123","012", "3GT", "안녕", "Hello"};		
		Pattern p = Pattern.compile("^[가-힣]+$");		 한글
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i] + " 한글입니다.");	
			else
				System.out.println(data[i] + " 한글이 아닙니다.");    
		}
	}
}
```
  실행 결과
```  
> 123 한글이 아닙니다.
> 012 한글이 아닙니다.
> 3GT 한글이 아닙니다.
> 안녕 한글입니다.
> Hello 한글이 아닙니다.
```
```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"ca", "cA", "c."};		
		Pattern p = Pattern.compile("c\\.");		 \. 점 문자를 의미
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i]);	 // c.
		}
	}
}
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"hello", "hello@", "hello@naver", "hello@naver.com", "good@good.co.kr"};		
		Pattern p = Pattern.compile("\\w+@\\w+\\.\\w+(\\.\\w+)?");		 이메일 주소
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i] + " 유효한 이메일 주소입니다.");	
			else
				System.out.println(data[i] + " 유효한 이메일 주소가 아닙니다.");    
		}
	}
}
```

   실행 결과
   
```
> hello 유효한 이메일 주소가 아닙니다.
> hello@ 유효한 이메일 주소가 아닙니다.
> hello@naver 유효한 이메일 주소가 아닙니다.
> hello@naver.com 유효한 이메일 주소입니다.
> good@good.co.kr 유효한 이메일 주소입니다.
```

```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		String[] data = {"02", "02-123", "02-123-456", "02-123-4567", 
				"02-1234-4567", "031-1234-5678"};		
		Pattern p = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");		 전화번호
		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i] + " 유효한 전화번호입니다.");	
			else
				System.out.println(data[i] + " 유효한 전화번호가 아닙니다.");    
		}
	}
}
```

  실행 결과
 ``` 
> 02 유효한 전화번호가 아닙니다.
> 02-123 유효한 전화번호가 아닙니다.
> 02-123-456 유효한 전화번호가 아닙니다.
> 02-123-4567 유효한 전화번호입니다.
> 02-1234-4567 유효한 전화번호입니다.
> 031-1234-5678 유효한 전화번호입니다.
```


```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {

		String[] data = {"010", "010-1234-5678", "02-123-456", "02-123-4567", 
				"02-1234-4567", "031-1234-5678"};		
		Pattern p = Pattern.compile("^01(0|1|[6-9])-(\\d{3}|\\d{4})-\\d{4}$");		 핸드폰 번호

		
		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.println(data[i] + " 유효한 핸드폰 번호입니다.");	
			else
				System.out.println(data[i] + " 유효한 핸드폰 번호가 아닙니다.");    
		}
	}
}
```

실행 결과
```
> 010 유효한 핸드폰 번호가 아닙니다.
> 010-1234-5678 유효한 핸드폰 번호입니다.
> 02-123-456 유효한 핸드폰 번호가 아닙니다.
> 02-123-4567 유효한 핸드폰 번호가 아닙니다.
> 02-1234-4567 유효한 핸드폰 번호가 아닙니다.
> 031-1234-5678 유효한 핸드폰 번호가 아닙니다.
```


```
import java.util.regex.;	 Pattern과 Matcher가 속한 패키지

class RegularExpressionTest {
	public static void main(String[] args) 
	{
		String[] data = {"bat", "baby", "bonus",
				    "cA","ca", "co", "c.", "c0", "car","combat","count",
				    "date", "disc"};		
		Pattern p = Pattern.compile("c[a-z]*");	 c로 시작하는 소문자영단어

		for(int i=0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");
		}
	}
}
```
 실행 결과
 
```
 > ca,co,car,combat,count,
```

```
import java.util.regex.;	 Pattern과 Matcher가 속한 패키지

class RegularExpressionTest {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "c", "cA",
				        "ca", "co", "c.", "c0", "c#",
					"car","combat","count", "date", "disc"
						};		
		String[] pattern = {".*","c[a-z]*","c[a-z]", "c[a-zA-Z]",
                           "c[a-zA-Z0-9]","c.","c.*","c\\.","c\\w",
                            "c\\d","c.*t", "[b|c].*", ".*a.*", ".*a.+","[b|c].{2}"
                                         };

		for(int x=0; x < pattern.length; x++) {
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern : " + pattern[x] + "  결과: ");
			for(int i=0; i < data.length; i++) {
				Matcher m = p.matcher(data[i]);
				if(m.matches())
					System.out.print(data[i] + ",");
			}
			System.out.println();
		}
	}  public static void main(String[] args) 
}
```

실행 결과

```	
Pattern : .*  결과: bat,baby,bonus,c,cA,ca,co,c.,c0,c#,car,combat,count,date,disc,
Pattern : c[a-z]*  결과: c,ca,co,car,combat,count,
Pattern : c[a-z]  결과: ca,co,
Pattern : c[a-zA-Z]  결과: cA,ca,co,
Pattern : c[a-zA-Z0-9]  결과: cA,ca,co,c0,
Pattern : c.  결과: cA,ca,co,c.,c0,c#,
Pattern : c.*  결과: c,cA,ca,co,c.,c0,c#,car,combat,count,
Pattern : c\.  결과: c.,
Pattern : c\w  결과: cA,ca,co,c0,
Pattern : c\d  결과: c0,
Pattern : c.*t  결과: combat,count,
Pattern : [b|c].*  결과: bat,baby,bonus,c,cA,ca,co,c.,c0,c#,car,combat,count,
Pattern : .*a.*  결과: bat,baby,ca,car,combat,date,
Pattern : .*a.+  결과: bat,baby,car,combat,date,
Pattern : [b|c].{2}  결과: bat,car,
```

```
import java.util.regex.*;	 //Pattern과 Matcher가 속한 패키지

class RegularExpressionTest{
	public static void main(String[] args) {
		String source  = "HP:011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);

		int i=0;

		while(m.find()) {
			System.out.println( ++i + ": " + m.group() + " -> "+ m.group(1) +", "+ m.group(2)+", "+ m.group(3));		
		}
	}  main의 끝
}
```

실행 결과
```
> 1: 011-1111-1111 -> 011, 1111, 1111
> 2: 02-999-9999 -> 02, 999, 9999
```



정규식의 일부를 괄호로 나누어 묶어서 그룹화(grouping)할 수 있다. 

그룹화된 부분은 하나의 단위로 묶이는 셈이 되어서 한 번 또는 그 이상의 반복을 의미하는 '+' 나 ''가 뒤에 오면 그룹화된 부분이 적용대상이 된다. 

그리고 그룹화된 부분은 group(int i)를 이용해서 나누어 얻을 수 있다.

위의 예제에서 '(0\\d{1,2})-(\\d{3,4})-(\\d{4})'은 괄호를 이용해서 정규식을 세 부분으로 나누었는데 예제와 결과에서 알 수 있듯이 매칭되는 문자열에서 첫 번째 그룹은 group(1)로 두 번째 그룹은 group(2)와 같이 호출함으로써 얻을 수 있다. 

group() 또는 group(0)은 그룹으로 매칭된 문자열을 전체를 나누어지지 않은 채로 반환한다.
	 
*[참고] group(int i)를 호출할 때 i가 실제 그룹의 수보다 많으면 java.lang.IndexOutOfBoundsException 이 발생한다.*
	 
|정규표현식|설명|
|---|---|
| 0\\d{1,2}|0으로 시작하는 최소 2자리 최대 3자리 숫자(0포함)|
| \\d{3,4}|최소 3자리 최대 4자리의 숫자|
| \\d{4}|4자리의 숫자|
	 
find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true를 반환하고 찾지 못하면 false를 반환한다. 

find()를 호출해서 패턴과 일치하는 부분을 찾아낸 다음, 다시 find()를 호출하면 이전에 발견한 패턴과 일치하는 부분의 다음부터 다시 패턴매칭을 시작한다.
	 
```
	 Matcher m = p.matcher(source);
	 
	 while(m.find()){		 find()는 일치하는 패턴이 없으면 false를 반환한다.
	 	System.out.println(m.group());
```

```
import java.util.regex.;	 //Pattern과 Matcher가 속한 패키지

class RegularExpressionTest {
	public static void main(String[] args) {
		String source  = "A broken hand works, but not a broken heart.";
		String pattern = "broken";

		StringBuffer sb = new StringBuffer();

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source:"+source);

		int i=0;

		while(m.find()) {
			System.out.println(++i + "번째 매칭:" + m.start() + "~"+ m.end());

             //broken을 drunken으로 치환하여 sb에 저장한다.
			m.appendReplacement(sb, "drunken");  
		}

		m.appendTail(sb);
		System.out.println("Replacement count : " + i);
		System.out.println("result:"+sb.toString());
	}
}
```

실행 결과

```
source:A broken hand works, but not a broken heart.
1번째 매칭:2~8
2번째 매칭:31~37
Replacement count : 2
result:A drunken hand works, but not a drunken heart.
```


**Matcher의 find()** 로 정규식과 일치하는 부분을 찾으면, 그 **위치를 start()와 end()** 로 알아낼 수 있고 appendReplacement(StringBuffer sb, String replacement)를 이용해서 원하는 문자열(replacement)로 치환할 수 있다. 치환된 결과는 StringBuffer인 sb에 저장되는데, sb에 저장되는 내용을 단계별로 살펴보면 이해하기 쉬울 것이다.

1. 문자열 source에서 "broken"을 m.find()로 찾은 후 처음으로 m.appendReplacement(sb, "drunken"); 가 호출되면 source의 시작부터 "broken"을 찾은 위치까지의 내용에 "drunken"을 더해서 저장한다.

	- sb에 저장된 내용 : "A drunken"

2. m.find()는 첫 번째로 발견된 위치의 끝에서부터 다시 검색을 시작하여 두 번째 "broken"을 찾게 된다. 다시 m.appendReplacement(sb, "drunken");가 호출

	- sb에 저장된 내용 : "A drunken hand works, but not a drunken"

3. m.appendTail(sb);이 호출되면 마지막으로 치환된 이후의 부분을 sb에 덧붙인다.

	- sb에 저장된 내용 : "A drunken hand works, but not a drunken heart."

