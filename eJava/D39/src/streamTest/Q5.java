package streamTest;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q5 {
	public static void main(String[] args) {
		Stream<String> str = Stream.of("This_is", "SHINEE_FIVE");
		
		Stream<String> spl = str.flatMap(n->Arrays.stream(n.split("_")));
		spl.forEach(System.out::println);
		
		str = Stream.of("This_is", "SHINEE_FIVE");
		/* 스트림은 데이터 소스로부터 요소를 한 번 소비하고 나면 사용할 수 없습니다. 
		 * 이것을 스트림의 소비(Consuming)라고 합니다. 
		 * flatMap 및 map과 같은 중간 연산을 수행한 후에는 스트림이 소비되므로, 
		 * 다시 사용하려면 원본 데이터 소스에서 새로운 스트림을 생성해야 합니다. */
		 
		str.map(n->n.split("_")).flatMap(Arrays::stream).forEach(System.out::println);
	}
}
