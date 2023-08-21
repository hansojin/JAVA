package generic5;

class Boxxx<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class Unboxxer {
    public static <T> T openBox(Boxxx<T> box) {
        return box.get();
    }
    
    public static void peekBox(Boxxx<?> box) {	// 와일드카드 사용
        System.out.println(box);
    }
}

class WildcardUnboxer2 {
    public static void main(String[] args) {
        Boxxx<String> box = new Boxxx<>();
        box.set("So Simple String");
        Unboxxer.peekBox(box);
    }
}

/*
위 예제에서 보이듯이 물음표 기호로 표시되는 와일드카드를 이용해서 메소드의 매개변수를 다음과 같이 선언하면,

    public static void peekBox(Box<?> box) {	
        System.out.println(box);
    }

Box<T>를 기반으로 생성된, Box<Integer> 인스턴스나 Box<String> 인스턴스들을 인자로 받을 수 있다. 그렇다면 다음 두 메소드에는 어떠한 차이가 있을까? 위에서 제시한 두 예제에서 보인 결과를 보면 아무런 차이가 없다.

public static <T> void peekBox(Box<T> box){
        System.out.println(box);
}	// 제네릭 메소드의 정의

public static void peekBox(Box<?> box) {	
        System.out.println(box);
}	// 와일드 카드 기반 메소드 정의

사실 기능적인 측면에서 보면 위의 두 메소드는 완전히 동일하다. 
즉 제네릭 메소드와 와일드카드 기반 메소드는 상호 대체 가능한 측면이 있다. 
그러나 코드가 조금 더 간결하다는 이유로 와일드카드 기반 메소드의 정의를 선호한다.

참고 - 와일드 카드 기반 메소드 정의를 보다 간결하다고 한 이유는?

앞서 제시한 두 메소드를 보면 제네릭 메소드 정의에는 다음과 같이 <T>가 두 번 등장한다.
public static <T> void peekBox(Box<T> box)

반면 와일드 카드 기반 메소드 정의에는 <?>가 매개변수 선언에서 한 번만 등장한다.
public static void peekBox(Box<?> box)

지금은 이 차이가 별것 아닌 것 같지만 <T> 또는 <?>에 추가적인 선언이 들어가면 이러한 차이는 더 커진다. 
그리고 개인적인 취향과 상관 없이 이러한 보편적인 선호도를 따라서 코드를 작성하는 것도 중요하다.
*/
