package optionalTest;

//import java.util.Optional;
import java.util.OptionalInt;

public class Q21 {
	public static void main(String[] args) {
//		Optional<Integer> oi1 = Optional.of(3);
//        Optional<Integer> oi2 = Optional.empty();
        OptionalInt oi1 = OptionalInt.of(3);
        OptionalInt oi2 = OptionalInt.empty();
        
        System.out.print("[Step 1.] : ");
        oi1.ifPresent(i -> System.out.print(i + "\t"));
        oi2.ifPresent(i -> System.out.print(i));
        System.out.println();

        System.out.print("[Step 2.] : ");
        System.out.print(oi1.orElse(100) + "\t");
        System.out.print(oi2.orElse(100) + "\t");
        System.out.println();
    }
}
