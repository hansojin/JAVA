package Num;

class BoxingUnboxing{	
	public static void main(String[] args){
		Integer iValue=Integer.valueOf(10);
		Double dValue=Double.valueOf(3.14);
		
		System.out.println(iValue);
		System.out.println(dValue);
		
		iValue=Integer.valueOf(iValue.intValue()+10);
		dValue=Double.valueOf(dValue.doubleValue()+1.2);
		
		System.out.println(iValue);
		System.out.println(dValue);		
	}
}
