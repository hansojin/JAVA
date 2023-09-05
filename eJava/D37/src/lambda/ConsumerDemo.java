package lambda;

import java.util.function.Consumer;

class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        
        c.accept("Pineapple");    // 출력이라는 결과를 보임
        c.accept("Strawberry");
    }
}


/*
Consumer<T> 인터페이스에는 다음 추상 메소드가 존재한다. 
Consumer라는 이름처럼 전달 인자를 소비하는 형태로 매개변수와 반환형이 선언되어 있다.(인자는 전달받지만 반환은 하지 않는다는 뜻이다.)
>> void accept(T t);	// 전달된 인자 기반으로 '반환'이외의 다른 결과를  보일 때
*/
