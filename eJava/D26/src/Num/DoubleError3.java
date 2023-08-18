package Num;

import java.math.BigDecimal;

public class DoubleError3 {
	public static void main(String[] args){
		BigDecimal e1=new BigDecimal("0.1");
		BigDecimal e2=new BigDecimal("1.6");
		
		System.out.println("두 실수의 덧셈결과: "+ e1.add(e2));
		System.out.println("두 실수의 곱셈결과: "+ e1.multiply(e2));
		System.out.println("두 실수의 차에 대한 절대값 결과 : " + e1.subtract(e2).abs());
		
		//두 실수의 덧셈결과: 1.7
		//두 실수의 곱셈결과: 0.16
		//두 실수의 차에 대한 절대값 결과 : 1.5
		
		// bigDecimal은 math.abs()말고 D.abs()을 사용

	}
}
