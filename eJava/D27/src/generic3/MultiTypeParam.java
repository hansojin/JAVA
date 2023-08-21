package generic3;

class DBox<L, R> {
    private L left;     // 왼쪽 수납 공간
    private R right;    // 오른쪽 수납 공간

    public void set(L o, R r) {
        left = o;
        right = r;
    } 
    
    @Override
    public String toString() {
        return left + " & " +right;
    }
}

class MultiTypeParam {
    public static void main(String[] args) {
        DBox<String, Integer> box = new DBox<String, Integer>();
        box.set("Apple", 25);
        System.out.println(box);
    }
}

/*
타입 매개변수의 이름은 짓기 나름이다. 그러나 일반적으로 다음 두 가지 규칙을 지켜서 이름을 짓는다.
1. 한 문자로 이름을 짓는다.
2. 대문자로 이름을 짓는다.

이렇게 이름을 지으면 다른 종류의 이름들과 구분이 된다. 
그리고 위 예제와 같이 한 글자로 이름을 짓더라도 가급적 의미를 두어 이름을 짓는 것이 좋다. 
보편적으로 자주 사용하는 타입 매개변수의 이름과 그 의미는 다음과 같다.

E 	Element
K	Key
N	Number
T	Type
V	Value

제네릭 클래스에 대하여 Box<Apple>과 같이 '매개변수화 타입'을 구성할 때 기본 자료형의 이름은 '타입 인자'로 쓸 수 없다. 
즉 다음과 같은 문장 구성은 불가능하다.

Box<int> box = new Box<int>();
	-> 타입 인자로 기본 자료형이 올 수 없으므로 컴파일 오류 발생

하지만 기본 자료형에 대한 래퍼 클래스가 존재하고, 또 필요한 상황에서 박싱과 언박싱이 자동으로 이뤄진다.	
*/
