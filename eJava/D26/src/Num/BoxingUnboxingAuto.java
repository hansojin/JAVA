package Num;

class BoxingUnboxingAuto {
	public static void main(String[] args){
		Integer iValue=10;		// Integer.valueOf(10)
		Double dValue=3.14;		// Double.valueOf(3.14)

		System.out.println(iValue);
		System.out.println(dValue);

		int num1=iValue;		// iValue.intValue()
		double num2=dValue;		// dValue.doubleValue()
		System.out.println(num1);
		System.out.println(num2);
	}
}
