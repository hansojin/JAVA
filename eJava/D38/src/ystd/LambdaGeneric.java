package ystd;

class LambdaGeneric {
	interface Calculat<T>{
		T cal(T a, T b);
	}
    public static void main(String[] args) {
        Calculat<Integer> ci = (a, b) -> a + b;
        System.out.println(ci.cal(4, 3));

        Calculat<Double> cd = (a, b) -> a + b;
        System.out.println(cd.cal(4.32, 3.45));
    }
}