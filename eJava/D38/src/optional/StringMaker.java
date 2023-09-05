package optional;

interface SMaker {
    String make(char[] ar);
}

class StringMaker {
    public static String chsToString(char[] a, SMaker m) {
        return m.make(a);
    }

    public static void main(String[] args) {
        SMaker sm = (ar) -> {
            return new String(ar);
        };
        
        char[] src = {'R', 'o', 'b', 'o', 't'};        
        String str = chsToString(src, sm);
        System.out.println(str);	//Robot
    }
}


/*

Function<T, R>    R apply(T t)   >>  생성자 참조

람다식을 작성하다 보면 인스턴스를 생성하고 이의 참조 값을 반환해야 하는 경우가 있다. 그리고 이러한 경우에도 '메소드 참조' 방식을 쓸 수 있다.

위 예제에서는 String 클래스의 다음 생성자를 이용한 String 인스턴스의 생성을 보이고 있다.

>> public String(char[] value)

물론 이 예제에서 중요한 것은 위의 생성자가 아닌 다음 람다식이다.

Function<char[], String> f = ar ->{
	return new String(ar);
};

우선 이 람다식은 다음과 같이 줄일 수 있다.

>> Function<char[], String> f = ar -> new String(ar);

그리고 위의 문장은 다음과 같이 메소드 참조 방식으로 바꿀 수 있다. 

Function<char[], String> f = ar -> new String(ar);
	-> Function<char[], String> f = String::new;	// 생성자 참조 방식
	
정리하면, 람다식을 이루는 문장이 '단순히 인스턴스의 생성 및 참조 값의 반환'일 경우, 이를 다음 형태의 메소드 참조로 바꿀 수 있다.

ClassName::new

이번에도 이러한 줄임이 가능한 이유를 역으로 생각해보기 위해 다음 코드를 보자.

public static void main(String[] args){
	Function<char[], String> f = String::new;
	...
	String str = f.apply(src);
	...
}

위의 코드에서 f의 참조 대상이 String::new이므로, f는 String의 생성자를 참조하게 되는데,
참조변수 f의 자료형이 Function<char[], String>이므로 매개변수 형이 char[]인 다음 생성자를 참조하게 된다.

>> public String(char[] value)

따라서 이후에 다음 문장을 실행하게 되면,

>> String str = f.apply(src);

다음 내용으로 apply 메소드가 호출된다. (아래 코드는 메소드 정의가 아니다. apply가 호출될 때 실행되는 내용을 표현한 것이다.) 그리고 다시 한번 말하지만 이는 어디까지나 약속이다.

apply(src) {
	new String(src);
}

*/
