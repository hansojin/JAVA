package lambda;

@FunctionalInterface
interface Calculate2 <T> {
    T cal(T a, T b);
}

class LambdaGeneric {
    public static void main(String[] args) {
        Calculate2<Integer> ci = (a, b) -> a + b;
        System.out.println(ci.cal(4, 3));

        Calculate2<Double> cd = (a, b) -> a + b;
        System.out.println(cd.cal(4.32, 3.45));
    }
}
