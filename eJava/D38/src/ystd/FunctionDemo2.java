package ystd;

import java.util.function.Function;

class FunctionDemo2 {
    public static void main(String[] args) {
        Function<Double, Double> cti = n->n*0.01;
        Function<Double, Double> itc = n->n/100;

        System.out.println("1cm = " + cti.apply(1.0) + "inch");		// cm를 inch로
        System.out.println("1inch = " + itc.apply(1.0) + "cm");		// inch를 cm로
    }
}