package Num;

public class DoubleError {
	public static void main(String[] args){
		double e1=1.6;
		double e2=0.1;

		System.out.println("두 실수의 덧셈결과: "+ (e1+e2));
		System.out.println("두 실수의 곱셈결과: "+ (e1*e2));
		
		//실수는 기본적으로 어느정도 오차를 가지고 있음
		//두 실수의 덧셈결과: 1.7000000000000002
		//두 실수의 곱셈결과: 0.16000000000000003
	}
}
