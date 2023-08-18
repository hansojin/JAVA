package Num;

import java.math.BigDecimal;

class DoubleError2 {
	public static void main(String[] args){
		BigDecimal e1=new BigDecimal(1.6);
		BigDecimal e2=new BigDecimal(0.1);
		
		System.out.println("두 실수의 덧셈결과: "+ e1.add(e2));
		System.out.println("두 실수의 곱셈결과: "+ e1.multiply(e2));
		
		//두 실수의 덧셈결과: 1.7000000000000000943689570931383059360086917877197265625
		//두 실수의 곱셈결과: 0.1600000000000000177635683940025051398161724525855033823303533017413935457540219431393779814243316650390625

	}

}
